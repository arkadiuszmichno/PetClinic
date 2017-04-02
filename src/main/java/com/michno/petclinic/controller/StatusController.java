package com.michno.petclinic.controller;

import com.michno.petclinic.entity.*;
import com.michno.petclinic.services.ClinicService;
import com.michno.petclinic.services.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkad on 25.03.2017.
 */
@Controller
@EnableAsync
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private MailManager mailManager;

    @GetMapping("/showStatus")
    public String showStatus(Model theModel){

        Long vacancies = clinicService.getVacancies();

        MailData mailData = new MailData();
        mailData.setTheVets(clinicService.getVets());

        theModel.addAttribute("mailData", mailData);

        theModel.addAttribute("vacancies", vacancies);

        return "status";
    }

    @PostMapping("/sendMail")
    public String sendMail(@ModelAttribute("mailData") MailData mailData){


        mailManager.sendMail(mailData.getTheMailVets(), mailData.getSubject(), mailData.getText());

        return "redirect:/status/showStatus";
    }

    @RequestMapping(value = "/generatePDF", method = RequestMethod.GET)
    public String generatePdf(Model theModel){
        List<Pet> thePets = clinicService.getPets();
        List<Vet> theVets = clinicService.getVets();
        List<Owner> theOwners = clinicService.getOwners();
        List<Visit> theVisits = clinicService.getVisits();



        theModel.addAttribute("owners", theOwners);
        theModel.addAttribute("pets", thePets);
        theModel.addAttribute("vets", theVets);
        theModel.addAttribute("visits", theVisits);

        return "pdf-view";
    }
}
