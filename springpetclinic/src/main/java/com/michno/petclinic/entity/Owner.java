package com.michno.petclinic.entity;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets;

    public Owner() {
    }

    public Owner(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Owner(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    @Override
    public String toString() {
        return "Owner{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", pets=" + pets +
                '}';
    }
}
