package com.offProject.ProjetJava.service;

import com.offProject.ProjetJava.model.Demande;
import com.offProject.ProjetJava.model.Employee;
import com.offProject.ProjetJava.model.MotifDemande;
import com.offProject.ProjetJava.repository.DemandeRepo;
import com.offProject.ProjetJava.repository.EmployeeRepo;
import com.offProject.ProjetJava.repository.MotifDemandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepo demandeRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private MotifDemandeRepo motifDemandeRepo;


    public void saveDemande(Demande demande, Integer employee_id, Integer Motif_id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employee_id);
        Employee employee = employeeOptional.get();
        demande.setEmployee(employee);
        Optional<MotifDemande> motifDemandeOptional = motifDemandeRepo.findById(Motif_id);
        MotifDemande motifDemande = motifDemandeOptional.get();
        demande.setMotifdemande(motifDemande);
        demandeRepo.save(demande);


    }

    public List<Demande> getAllDemande() {
        return demandeRepo.findAll();
    }

    public Demande getDemandeById(Integer id) {
        Optional<Demande> optionalDemande = demandeRepo.findById(id);
        Demande demande = optionalDemande.get();
        return demande;
    }

    public void updatedemande(Demande currentDemande, Integer id, Integer employee_id, Integer Motif_id) {
        Optional<Demande> demandeOptional = demandeRepo.findById(id);
        Demande demande1 = demandeOptional.get();
        demande1.setDebut(currentDemande.getDebut());
        demande1.setFin(currentDemande.getFin());
        demande1.setReponse(currentDemande.getReponse());
        demande1.setDescription(currentDemande.getDescription());
        demande1.setTitre(currentDemande.getTitre());
        Optional<Employee> employeeOptional = employeeRepo.findById(employee_id);
        Employee employee = employeeOptional.get();
        demande1.setEmployee(employee);
        Optional<MotifDemande> motifDemandeOptional = motifDemandeRepo.findById(Motif_id);
        MotifDemande motifDemande = motifDemandeOptional.get();
        demande1.setMotifdemande(motifDemande);

        saveDemande(demande1, employee_id, Motif_id);
    }

    public void deleteDemande(Integer id) {
        demandeRepo.deleteById(id);
    }
}
