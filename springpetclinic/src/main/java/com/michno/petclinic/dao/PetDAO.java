package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Pet;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
public interface PetDAO {
    List<Pet> getPets();

    void savePet(Pet thePet);

    Pet getPetById(int theId);

    void deletePetById(int theId);

    Pet getPetByName(String petName);

    Long getVacancies();
}
