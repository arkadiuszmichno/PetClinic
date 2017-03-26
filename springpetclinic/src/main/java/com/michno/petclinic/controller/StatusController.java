package com.michno.petclinic.controller;

import com.michno.petclinic.entity.MailData;
import com.michno.petclinic.entity.Vet;
import com.michno.petclinic.services.ClinicService;
import com.michno.petclinic.services.MailManager;
import com.michno.petclinic.services.MailManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
