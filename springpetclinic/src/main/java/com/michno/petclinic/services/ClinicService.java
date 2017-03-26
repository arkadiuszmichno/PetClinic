package com.michno.petclinic.services;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Pet;
import com.michno.petclinic.entity.Vet;
import com.michno.petclinic.entity.Visit;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */

public interface ClinicService {

    List<Owner> getOwners();

    void saveOwner(Owner theOwner);

    Owner getOwnerById(int theId);

    void deleteOwnerById(int theId);

    List<Pet> getPets();

    void savePet(Pet thePet);

    Owner getOwnerByLastName(String ownerName);

    Pet getPetById(int theId);

    void deletePetById(int theId);

    List<Vet> getVets();

    void saveVet(Vet theVet);

    Vet getVetById(int theId);

    void deleteVetById(int theId);

    List<Visit> getVisits();

    void saveVisit(Visit theVisit);

    Visit getVisitById(int theId);

    void deleteVisitById(int theId);

    Vet getVetByLastName(String vetName);

    Pet getPetByName(String petName);

    Long getVacancies();
}
