package com.offProject.ProjetJava.controller;

import com.offProject.ProjetJava.model.Demande;
import com.offProject.ProjetJava.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/demande")


public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @PostMapping

    public void savedemande(@RequestBody Demande demande, @RequestParam(value = "employee_id") Integer employee_id, @RequestParam(value = "motif_id") Integer motif_id) {
        demandeService.saveDemande(demande, employee_id, motif_id);
    }


    @GetMapping()
    public List<Demande> getalldemande() {
        return demandeService.getAllDemande();
    }


    @DeleteMapping("/delete")
    public void deletedemande(@RequestParam Integer id) {
        demandeService.deleteDemande(id);
    }

    @PutMapping("/update")
    public void updatedemande(@RequestBody Demande demande, @RequestParam(value = "id") Integer id, @RequestParam(value = "employee_id") Integer employee_id, @RequestParam(value = "motif_id") Integer Motif_id) {
        demandeService.updatedemande(demande, id, employee_id, Motif_id);
    }

    @RequestMapping("/search")
    public Demande getdemande(@RequestParam(value = "id") Integer id) {
        return demandeService.getDemandeById(id);
    }
}
