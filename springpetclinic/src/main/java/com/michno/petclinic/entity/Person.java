package com.michno.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by arkad on 23.03.2017.
 */
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name="first_name")
    protected String firstName;

    @Column(name="last_name")
    protected String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
