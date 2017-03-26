package com.michno.petclinic.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by arkad on 23.03.2017.
 */
@Entity
@Table(name="visit")
public class Visit extends BaseEntity {

    @Column(name="date")
    private String date;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="vet_id")
    private Vet vet;

    @Column(name="pet_name")
    private String petName;

    @Column(name="vet_name")
    private String vetName;

    public Visit() {
    }

    public Visit(String date, String description, Pet pet, Vet vet, String petName, String vetName) {
        this.date = date;
        this.description = description;
        this.pet = pet;
        this.vet = vet;
        this.petName = petName;
        this.vetName = vetName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
}
