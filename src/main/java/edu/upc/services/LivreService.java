package edu.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.upc.models.Livre;
import edu.upc.repositories.LivreRepo;
import java.util.List;

@Service
public class LivreService {
    
    @Autowired
    private LivreRepo livreRepo;
    
    public List<Livre> getAllLivres() {
        return livreRepo.findAll();
    }
    
    public Livre saveLivre(Livre livre) {
        return livreRepo.save(livre);
    }
    
    public List<Livre> getLivres(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return livreRepo.findByTitreContainingOrAuteurContaining(keyword, keyword);
        }
        return livreRepo.findAll();
    }
}