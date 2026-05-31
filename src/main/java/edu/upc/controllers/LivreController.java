package edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.upc.services.LivreService;

@Controller
@RequestMapping("/livres")
public class LivreController {
    
    @Autowired
    private LivreService livreService;
    
    @GetMapping("/liste")
    public String getLivres(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        
        model.addAttribute("motCle", keyword);
        model.addAttribute("livres", livreService.getLivres(keyword));
        
        return "livres";
    }
}