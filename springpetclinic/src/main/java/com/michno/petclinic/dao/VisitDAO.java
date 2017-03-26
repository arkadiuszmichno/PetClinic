package com.michno.petclinic.dao;

import com.michno.petclinic.entity.Visit;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
public interface VisitDAO {
    List<Visit> getVisits();

    void saveVisit(Visit theVisit);

    Visit getVisitById(int theId);

    void deleteVisitById(int theId);
}
