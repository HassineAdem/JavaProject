package com.offProject.ProjetJava.service;

import com.offProject.ProjetJava.model.MotifDemande;
import com.offProject.ProjetJava.repository.MotifDemandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotifDemandeService {
    @Autowired
    private MotifDemandeRepo motifDemandeRepo;


    public List<MotifDemande> getAllMotif() {
        return motifDemandeRepo.findAll();
    }


    public MotifDemande getMotifById(Integer id) {
        Optional<MotifDemande> optionalMotifDemande = motifDemandeRepo.findById(id);
        MotifDemande motifDemande = optionalMotifDemande.get();
        return motifDemande;
    }

    public void deleteMotifDemande(Integer id) {
        motifDemandeRepo.deleteById(id);
    }

    public void saveMotifDemande(MotifDemande motifDemande) {
        motifDemandeRepo.save(motifDemande);
    }

    public void updateMotifDemande(MotifDemande motifDemande, Integer id) {
        Optional<MotifDemande> motifDemande1 = motifDemandeRepo.findById(id);
        MotifDemande motifDemande2 = motifDemande1.get();
        motifDemande2.setLibMotif(motifDemande.getLibMotif());
        motifDemandeRepo.save(motifDemande2);
    }

}
