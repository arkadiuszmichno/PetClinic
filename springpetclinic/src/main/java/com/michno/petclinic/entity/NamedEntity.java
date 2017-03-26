package com.michno.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by arkad on 23.03.2017.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @Column(name="name")
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
