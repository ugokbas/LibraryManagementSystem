package com.library.webapp.controller;

import com.library.webapp.domain.Author;
import com.library.webapp.domain.Book;
import com.library.webapp.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@ComponentScan
public class BookController {

    @Autowired
    BookServiceInterface bookServiceInterface;

    @GetMapping("/books")
    public String listBookPage(Model model, String keyword) {
        model.addAttribute("book", new Book());

        if(keyword != null){
            model.addAttribute("allBooks", bookServiceInterface.findByKeyword(keyword.toUpperCase()));
        }
        else {
            model.addAttribute("allBooks", (ArrayList<Book>) bookServiceInterface.getAllBooks());
        }
        return "searchBook";
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute("book") Book book,
                               final RedirectAttributes redirectAttributes) {

        if(bookServiceInterface.saveBook(book)!=null) {
            redirectAttributes.addFlashAttribute("saveBook", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveBook", "unsuccess");
        }

        return "redirect:/books";
    }

    @RequestMapping(value = "/book/{operation}/{bookId}", method = RequestMethod.GET)
    public String editRemoveBook(@PathVariable("operation") String operation,
                                     @PathVariable("bookId") String bookId, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(bookServiceInterface.deleteBook(bookId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Book editBook = bookServiceInterface.findBook(bookId);
            if(editBook!=null) {
                model.addAttribute("editBook", editBook);
                return "editBook";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }

        return "redirect:/books";
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("editBook") Book editBook,
                                 final RedirectAttributes redirectAttributes) {
        if(bookServiceInterface.editBook(editBook)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "/book/findByName/{bookName}", method = RequestMethod.GET)
    public String findByBookName(@PathVariable("bookName") String bookName,
                                     final RedirectAttributes redirectAttributes) {
        List<Book> books = bookServiceInterface.getBooksByName(bookName);
        return "redirect:/";
    }
}
