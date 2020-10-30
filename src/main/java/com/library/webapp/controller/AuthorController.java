package com.library.webapp.controller;

import com.library.webapp.domain.Author;
import com.library.webapp.service.AuthorServiceInterface;
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
public class AuthorController {

    @Autowired
    AuthorServiceInterface authorServiceInterface;

    @GetMapping("/authors")
    public String savePage(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("allAuthors", (ArrayList<Author>)authorServiceInterface.getAllAuthors());
        return "searchAuthor";
    }

    @PostMapping("/author/save")
    public String saveAuthor(@ModelAttribute("author") Author author,
                               final RedirectAttributes redirectAttributes) {

        if(authorServiceInterface.saveAuthor(author)!=null) {
            redirectAttributes.addFlashAttribute("saveAuthor", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveAuthor", "unsuccess");
        }

        return "redirect:/authors";
    }

    @RequestMapping(value = "/author/{operation}/{autId}", method = RequestMethod.GET)
    public String editRemoveAuthor(@PathVariable("operation") String operation,
                                     @PathVariable("autId") String autId, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(authorServiceInterface.deleteAuthor(autId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Author editAuthor = authorServiceInterface.findAuthor(autId);
            if(editAuthor!=null) {
                model.addAttribute("editAuthor", editAuthor);
                return "editAuthor";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }

        return "redirect:/authors";
    }

    @RequestMapping(value = "/author/update", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute("editAuthor") Author editAuthor,
                                 final RedirectAttributes redirectAttributes) {
        if(authorServiceInterface.editAuthor(editAuthor)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
//		return "redirect:/savepage";
        return "redirect:/authors";
    }

    @RequestMapping(value = "/author/findByName/{authorName}", method = RequestMethod.GET)
    public String findByAuthorName(@PathVariable("authorName") String authorName,
                                     final RedirectAttributes redirectAttributes) {
        List<Author> author = authorServiceInterface.getAuthorsByName(authorName);
        return "redirect:/";
    }
}