package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Owner;
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
public class OwnerDAOImpl implements OwnerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Owner> getOwners() {

        Session currentSession = sessionFactory.getCurrentSession();

        List<Owner> theOwners = currentSession.createQuery("from Owner", Owner.class).getResultList();


        return theOwners;
    }

    public void saveOwner(Owner theOwner) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theOwner);
    }

    public Owner getOwnerById(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Owner theOwner = currentSession.get(Owner.class, theId);

        return theOwner;
    }

    public void deleteOwnerById(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Owner o where o.id=:theId");
        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();
    }

    public Owner getOwnerByLastName(String ownerName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Owner o where o.lastName=:ownerName");
        theQuery.setParameter("ownerName", ownerName);

        List<Owner> theOwners = theQuery.getResultList();

        if(theOwners.isEmpty())
            return null;
        else {
            return theOwners.get(0);
        }

    }
}
