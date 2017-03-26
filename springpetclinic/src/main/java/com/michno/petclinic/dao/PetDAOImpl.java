package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Repository
public class PetDAOImpl implements PetDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Pet> getPets() {

        Session currentSession = sessionFactory.getCurrentSession();

        List<Pet> thePets = currentSession.createQuery("from Pet", Pet.class).getResultList();

        return thePets;
    }

    public void savePet(Pet thePet) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(thePet);
    }

    public Pet getPetById(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Pet thePet = currentSession.get(Pet.class, theId);

        return thePet;
    }

    public void deletePetById(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete Pet p where p.id=:theId");
        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();
    }

    public Pet getPetByName(String petName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Pet p where p.name=:petName");
        theQuery.setParameter("petName", petName);

        Pet thePet = (Pet) theQuery.getSingleResult();

        return thePet;
    }

    public Long getVacancies() {

        Session currentSession = sessionFactory.getCurrentSession();

        Long count = ((Long) currentSession.createQuery("select count(*) from Pet").uniqueResult());
        Integer totalBooks = count.intValue();

        return (20-count);

    }
}
