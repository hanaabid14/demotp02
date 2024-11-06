package com.example.demotp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotp.model.Produit;
import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByLibelleContainingIgnoreCase(String libelle);


}
