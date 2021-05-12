package com.offProject.ProjetJava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    @Column
    private Integer age;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email")

    private String email;
    @OneToMany(mappedBy = "employee", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Demande> demandes;

    public Employee() {
    }


    public Employee(Integer age, String firstname, String lastname, String email) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    /*    @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn (name = "employee_id", referencedColumnName = "employee_id")*/
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonIgnore
    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String setFirstname(String firstname) {
        this.firstname = firstname;
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

