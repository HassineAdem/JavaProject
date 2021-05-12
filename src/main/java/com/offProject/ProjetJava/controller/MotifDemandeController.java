package com.offProject.ProjetJava.controller;

import com.offProject.ProjetJava.model.MotifDemande;
import com.offProject.ProjetJava.service.MotifDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motif")
public class MotifDemandeController {
    @Autowired
    private MotifDemandeService motifDemandeService;

    @PostMapping
    public void savemotif(@RequestBody MotifDemande motifDemande) {
        motifDemandeService.saveMotifDemande(motifDemande);

    }

    @GetMapping()
    public List<MotifDemande> getallmotif() {
        return motifDemandeService.getAllMotif();
    }

    @RequestMapping("/search")
    public MotifDemande getMotifById(@RequestParam(value = "id") Integer id) {
        return motifDemandeService.getMotifById(id);
    }

    @DeleteMapping("/delete")
    public void deleteMotif(@RequestParam(value = "id") Integer id) {
        motifDemandeService.deleteMotifDemande(id);
    }

    @PutMapping("/update")
    public void updatemotif(@RequestBody MotifDemande motifDemande, @RequestParam Integer id) {
        motifDemandeService.updateMotifDemande(motifDemande, id);
    }
}
