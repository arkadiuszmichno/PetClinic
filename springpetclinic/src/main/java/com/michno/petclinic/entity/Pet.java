package com.michno.petclinic.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arkad on 23.03.2017.
 */
@Entity
@Table(name="pet")
public class Pet extends NamedEntity {

    @Column(name="age")
    private String age;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="owner_name")
    private String ownerName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits;

    public Pet() {
    }

    public Pet(String age, String type, Owner owner, String ownerName) {
        this.age = age;
        this.type = type;
        this.owner = owner;
        this.ownerName = ownerName;
    }

    public Pet(String name, String age, String type, Owner owner, String ownerName) {
        super(name);
        this.age = age;
        this.type = type;
        this.owner = owner;
        this.ownerName = ownerName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Visit> getVisits() {
        if(visits==null)
            visits = new HashSet<Visit>();
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
