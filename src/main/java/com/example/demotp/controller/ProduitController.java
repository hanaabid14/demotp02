package com.example.demotp.controller;

import com.example.demotp.model.Produit;
import com.example.demotp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public String getAllProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits"; // Name of the Thymeleaf view
    }

    @PostMapping("/add")
    public String addProduit(Produit produit) {
        produitService.save(produit);
        return "redirect:/produits"; // Redirect to the list of products after saving
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            model.addAttribute("produit", produit);
            return "updateProduit"; // A separate view to update the product
        }
        return "redirect:/produits"; // If product not found, redirect back
    }

    @PostMapping("/update/{id}")
    public String updateProduit(@PathVariable("id") Long id, Produit produit) {
        produit.setId(id); // Set the product ID before saving
        produitService.save(produit);
        return "redirect:/produits"; // Redirect to product list after update
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Long id) {
        produitService.delete(id);
        return "redirect:/produits"; // Redirect back to product list after deletion
    }
}
