package com.library.webapp.controller;

import com.library.webapp.domain.Publisher;
import com.library.webapp.service.PublisherServiceInterface;
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
public class PublisherController {

    @Autowired
    PublisherServiceInterface publisherServiceInterface;

    @GetMapping("/publishers")
    public String savePage(Model model) {
        model.addAttribute("publisher", new Publisher());
        model.addAttribute("allPublishers", (ArrayList<Publisher>)publisherServiceInterface.getAllPublishers());
        return "searchPublisher";
    }

    @PostMapping("/publisher/save")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher,
                               final RedirectAttributes redirectAttributes) {

        if(publisherServiceInterface.savePublisher(publisher)!=null) {
            redirectAttributes.addFlashAttribute("savePublisher", "success");
        } else {
            redirectAttributes.addFlashAttribute("savePublisher", "unsuccess");
        }

        return "redirect:/publishers";
    }

    @RequestMapping(value = "/publisher/{operation}/{pubId}", method = RequestMethod.GET)
    public String editRemovePublisher(@PathVariable("operation") String operation,
                                     @PathVariable("pubId") String pubId, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(publisherServiceInterface.deletePublisher(pubId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Publisher editPublisher = publisherServiceInterface.findPublisher(pubId);
            if(editPublisher!=null) {
                model.addAttribute("editPublisher", editPublisher);
                return "editPublisher";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }

        return "redirect:/publishers";
    }

    @RequestMapping(value = "/publisher/update", method = RequestMethod.POST)
    public String updatePublisher(@ModelAttribute("editPublisher") Publisher editPublisher,
                                 final RedirectAttributes redirectAttributes) {
        if(publisherServiceInterface.editPublisher(editPublisher)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
//		return "redirect:/savepage";
        return "redirect:/publishers";
    }

    @RequestMapping(value = "/publisher/findByName/{publisherName}", method = RequestMethod.GET)
    public String findByPublisherName(@PathVariable("publisherName") String publisherName,
                                     final RedirectAttributes redirectAttributes) {
        List<Publisher> publishers = publisherServiceInterface.getPublishersByName(publisherName);
        return "redirect:/";
    }
}
