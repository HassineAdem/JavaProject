package com.offProject.ProjetJava.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity

@Table(name = "demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer demande_id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "debut")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp debut;
    @Column(name = "reponse")
    private String reponse;
    @Column(name = "description")
    private String description;
    @Column(name = "fin")
    private Timestamp fin;
    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employee_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "motif_id", referencedColumnName = "motif_id")

    private MotifDemande motifdemande;

    public Demande() {
    }

    public Demande(Integer demande_id, String titre, Timestamp debut, String reponse, String description, Timestamp fin, Integer employee_id, Employee employee, MotifDemande motifdemande) {
        this.demande_id = demande_id;
        this.titre = titre;
        this.debut = debut;
        this.reponse = reponse;
        this.description = description;
        this.fin = fin;
        this.employee_id = employee_id;
        this.employee = employee;
        this.motifdemande = motifdemande;
    }

    public Integer getDemande_id() {
        return demande_id;
    }

    public void setDemande_id(Integer demande_id) {
        this.demande_id = demande_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Timestamp getDebut() {
        return debut;
    }

    public void setDebut(Timestamp debut) {
        this.debut = debut;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MotifDemande getMotifdemande() {
        return motifdemande;
    }

    public void setMotifdemande(MotifDemande motifdemande) {
        this.motifdemande = motifdemande;
    }
}
