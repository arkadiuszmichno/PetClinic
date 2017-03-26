package com.michno.petclinic.services;

import com.michno.petclinic.entity.Vet;

import java.util.List;

/**
 * Created by arkad on 25.03.2017.
 */
public interface MailManager {
    void sendWarningMail(Long vacancies, List<Vet> theVets);

    void sendMail(List<Vet> theVets, String subject, String text);
}
