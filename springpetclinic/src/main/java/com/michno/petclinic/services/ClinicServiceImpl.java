package com.michno.petclinic.services;


import com.mchange.net.MailSender;
import com.michno.petclinic.dao.OwnerDAO;
import com.michno.petclinic.dao.PetDAO;
import com.michno.petclinic.dao.VetDAO;
import com.michno.petclinic.dao.VisitDAO;
import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Pet;
import com.michno.petclinic.entity.Vet;
import com.michno.petclinic.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private VetDAO vetDAO;

    @Autowired
    private VisitDAO visitDAO;

    @Transactional
    public List<Owner> getOwners() {
        return ownerDAO.getOwners();
    }

    @Transactional
    public void saveOwner(Owner theOwner) {
        ownerDAO.saveOwner(theOwner);
    }

    @Transactional
    public Owner getOwnerById(int theId) {
        return ownerDAO.getOwnerById(theId);
    }

    @Transactional
    public void deleteOwnerById(int theId) {
        ownerDAO.deleteOwnerById(theId);
    }

    @Transactional
    public List<Pet> getPets() {
        return petDAO.getPets();
    }

    @Transactional
    public void savePet(Pet thePet) {
        petDAO.savePet(thePet);
    }

    @Transactional
    public Owner getOwnerByLastName(String ownerName) {
        return ownerDAO.getOwnerByLastName(ownerName);
    }

    @Transactional
    public Pet getPetById(int theId) {
        return petDAO.getPetById(theId);
    }

    @Transactional
    public void deletePetById(int theId) {
        petDAO.deletePetById(theId);
    }

    @Transactional
    public List<Vet> getVets() {
        return vetDAO.getVets();
    }

    @Transactional
    public void saveVet(Vet theVet) {
        vetDAO.saveVet(theVet);
    }

    @Transactional
    public Vet getVetById(int theId) {
        return vetDAO.getVetById(theId);
    }

    @Transactional
    public void deleteVetById(int theId) {
        vetDAO.deleteVetById(theId);
    }

    @Transactional
    public List<Visit> getVisits() {
        return visitDAO.getVisits();
    }

    @Transactional
    public void saveVisit(Visit theVisit) {
        visitDAO.saveVisit(theVisit);
    }

    @Transactional
    public Visit getVisitById(int theId) {
        return visitDAO.getVisitById(theId);
    }

    @Transactional
    public void deleteVisitById(int theId) {
        visitDAO.deleteVisitById(theId);
    }

    @Transactional
    public Vet getVetByLastName(String vetName) {
        return vetDAO.getVetByLastName(vetName);
    }

    @Transactional
    public Pet getPetByName(String petName) {
        return petDAO.getPetByName(petName);
    }

    @Transactional
    public Long getVacancies() {
        return petDAO.getVacancies();
    }
}
