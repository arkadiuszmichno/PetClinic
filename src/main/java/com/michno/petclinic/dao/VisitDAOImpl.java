package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Repository
public class VisitDAOImpl implements VisitDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Visit> getVisits() {

        Session currentSession = sessionFactory.getCurrentSession();

        List<Visit> theVisits = currentSession.createQuery("from Visit", Visit.class).getResultList();

        return theVisits;
    }

    public void saveVisit(Visit theVisit) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theVisit);
    }

    public Visit getVisitById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Visit theVisit = currentSession.get(Visit.class, theId);

        return theVisit;
    }

    public void deleteVisitById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Visit v where v.id=:theId");
        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();
    }


}
