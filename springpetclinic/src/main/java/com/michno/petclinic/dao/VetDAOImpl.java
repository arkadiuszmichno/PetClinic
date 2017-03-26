package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Vet;
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
public class VetDAOImpl implements VetDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Vet> getVets() {

        Session currentSession = sessionFactory.getCurrentSession();

        List<Vet> theVets = currentSession.createQuery("from Vet", Vet.class).getResultList();

        return theVets;
    }

    public void saveVet(Vet theVet) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theVet);
    }

    public Vet getVetById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Vet theVet = currentSession.get(Vet.class, theId);

        return theVet;
    }

    public void deleteVetById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Vet v where v.id=:theId");
        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();
    }

    public Vet getVetByLastName(String vetName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Vet v where v.lastName=:vetName");
        theQuery.setParameter("vetName", vetName);
        Vet theVet = (Vet) theQuery.getSingleResult();

        return theVet;
    }
}
