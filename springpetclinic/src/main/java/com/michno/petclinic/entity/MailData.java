package com.michno.petclinic.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

/**
 * Created by arkad on 26.03.2017.
 */
public class MailData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private List<Vet> theVets;

    private List<Vet> theMailVets;
    private String subject;

    private String text;

    public MailData() {
    }

    public MailData(List<Vet> theVets, String subject, String text) {
        this.theVets = theVets;
        this.subject = subject;
        this.text = text;
    }

    public List<Vet> getTheVets() {
        return theVets;
    }

    public void setTheVets(List<Vet> theVets) {
        this.theVets = theVets;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vet> getTheMailVets() {
        return theMailVets;
    }

    public void setTheMailVets(List<Vet> theMailVets) {
        this.theMailVets = theMailVets;
    }
}
