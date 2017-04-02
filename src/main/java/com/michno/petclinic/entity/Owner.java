package com.michno.petclinic.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arkad on 23.03.2017.
 */
@Entity
@Table(name="owner")
public class Owner extends Person {

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="add_date")
    private LocalDate localDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets;

    public Owner() {
    }

    public Owner(String phoneNumber, String email, LocalDate localDate, Set<Pet> pets) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.localDate = localDate;
        this.pets = pets;
    }

    public Owner(String firstName, String lastName, String phoneNumber, String email, LocalDate localDate, Set<Pet> pets) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.localDate = localDate;
        this.pets = pets;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Pet> getPets() {
        if(pets == null)
            pets = new HashSet<Pet>();
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate now) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", pets=" + pets +
                '}';
    }
}
