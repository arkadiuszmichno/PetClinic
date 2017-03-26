package com.michno.petclinic.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arkad on 24.03.2017.
 */
@Entity
@Table(name="vet")
public class Vet extends Person {

    @Column(name="experience")
    private String experience;

    @Column(name="email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet", fetch = FetchType.EAGER)
    private Set<Visit> visits;


    public Vet() {
    }

    public Vet(String firstName, String lastName, String experience, String email, Set<Visit> visits) {
        super(firstName, lastName);
        this.experience = experience;
        this.email = email;
        this.visits = visits;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
