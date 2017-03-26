package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Owner;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
public interface OwnerDAO {
    List<Owner> getOwners();

    void saveOwner(Owner theOwner);

    Owner getOwnerById(int theId);

    void deleteOwnerById(int theId);

    Owner getOwnerByLastName(String ownerName);
}
