package com.example.demotp.controller;

import com.example.demotp.model.Produit;
import com.example.demotp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {
	@Autowired
	private ProduitService produitService;

	// GET: Récupérer tous les produits
	@GetMapping
	public ResponseEntity<List<Produit>> getAllProduits() {
		List<Produit> produits = produitService.findAll();
		return new ResponseEntity<>(produits, HttpStatus.OK);
	}

	// GET: Récupérer un produit par ID
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
		Produit produit = produitService.findById(id);
		if (produit != null) {
			return new ResponseEntity<>(produit, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// POST: Créer un nouveau produit
	@PostMapping
	public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
		Produit newProduit = produitService.save(produit);
		return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
	}

	


}
