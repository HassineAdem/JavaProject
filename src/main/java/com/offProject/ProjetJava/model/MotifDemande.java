package com.offProject.ProjetJava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Motif_demande")
public class MotifDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer motif_id;
    @Column(name = "motif")
    private String libMotif;
    @OneToMany(mappedBy = "motifdemande", orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Demande> demandes;

    public MotifDemande() {
    }

    public MotifDemande(String libMotif) {
        this.libMotif = libMotif;
    }

    @JsonIgnore
    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public Integer getMotif_id() {
        return motif_id;
    }

    public void setMotif_id(Integer motif_id) {
        this.motif_id = motif_id;
    }

    public String getLibMotif() {
        return libMotif;
    }

    public void setLibMotif(String libMotif) {
        this.libMotif = libMotif;
    }
}
