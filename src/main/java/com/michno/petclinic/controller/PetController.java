package com.michno.petclinic.controller;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Pet;
import com.michno.petclinic.entity.Vet;
import com.michno.petclinic.services.ClinicService;
import com.michno.petclinic.services.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private MailManager mailManager;

    @GetMapping("/list")
    public String listPets(Model theModel) {

        List<Pet> thePets = clinicService.getPets();

        theModel.addAttribute("pets", thePets);

        return "list-pets";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Pet thePet = new Pet();
        List<Owner> theOwners = clinicService.getOwners();

        theModel.addAttribute("pet", thePet);
        theModel.addAttribute("owners", theOwners);

        return "pet-form";
    }

    @PostMapping("savePet")
    public String savePet(@ModelAttribute("pet") Pet thePet) {

        Long vacancies = clinicService.getVacancies();
        if (vacancies == 0) {
            return "place-limit";
        }
        Owner theOwner = clinicService.getOwnerByLastName(thePet.getOwnerName());
        List<Vet> theVets = clinicService.getVets();
        thePet.setOwner(theOwner);
        thePet.setLocalDate(LocalDate.now());
        clinicService.savePet(thePet);
        if (vacancies <= 20)
            mailManager.sendWarningMail(vacancies, theVets);


        return "redirect:/pet/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("petId") int theId, Model theModel) {

        Pet thePet = clinicService.getPetById(theId);
        List<Owner> theOwners = clinicService.getOwners();

        theModel.addAttribute("pet", thePet);
        theModel.addAttribute("owners", theOwners);

        return "pet-form";
    }

    @GetMapping("/deletePet")
    public String deletePet(@RequestParam("petId") int theId) {

        clinicService.deletePetById(theId);

        return "redirect:/pet/list";
    }
}
