package com.michno.petclinic.services;

import com.michno.petclinic.entity.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arkad on 25.03.2017.
 */
@Service
public class MailManagerImpl implements MailManager {

    @Autowired
    private MailSender mailSender;


    public MailManagerImpl() {
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWarningMail(Long vacancies, List<Vet> vets) {
        SimpleMailMessage message = new SimpleMailMessage();

        int size = 0;
        for (Vet tempVet : vets)
            if (tempVet.getEmail() != null)
                size += 1;

        if (size == 0)
            return;

        String[] address = new String[size];

        int j = 0;

        for (int i = 0; i < vets.size(); i++) {
            if (vets.get(i).getEmail() != null) {
                address[j] = vets.get(i).getEmail();
                j++;
            }
        }


        message.setFrom("petclinic.owner@gmail.com");
        message.setTo(address);
        message.setSubject("Close to place limit warning");
        message.setText("There are just " + vacancies + "vacancies in clinic.");
        mailSender.send(message);
    }

    @Async
    public void sendMail(List<Vet> theVets, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        int size = 0;
        for (Vet tempVet : theVets)
            if (tempVet.getEmail() != null)
                size += 1;

        if (size == 0)
            return;

        String[] address = new String[size];

        int j = 0;

        for (int i = 0; i < theVets.size(); i++) {
            if (theVets.get(i).getEmail() != null) {
                address[j] = theVets.get(i).getEmail();
                j++;
            }
        }


        message.setFrom("petclinic.owner@gmail.com");
        message.setTo(address);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public MailSender getMailSender() {
        return mailSender;
    }


}
