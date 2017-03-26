package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Vet;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
public interface VetDAO {
    List<Vet> getVets();

    void saveVet(Vet theVet);

    Vet getVetById(int theId);

    void deleteVetById(int theId);

    Vet getVetByLastName(String vetName);
}
