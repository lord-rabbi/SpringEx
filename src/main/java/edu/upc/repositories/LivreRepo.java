package edu.upc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.upc.models.Livre;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Integer> {
    
    List<Livre> findByTitreContainingOrAuteurContaining(String titre, String auteur);
}