package com.michno.petclinic.controller;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Pet;
import com.michno.petclinic.entity.Vet;
import com.michno.petclinic.entity.Visit;
import com.michno.petclinic.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Controller
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/list")
    public String listVisits(Model theModel) {

        List<Visit> theVisits = clinicService.getVisits();


        theModel.addAttribute("visits", theVisits);


        return "list-visits";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Visit theVisit = new Visit();

        List<Pet> thePets = clinicService.getPets();
        List<Vet> theVets = clinicService.getVets();
        theModel.addAttribute("visit", theVisit);
        theModel.addAttribute("pets", thePets);
        theModel.addAttribute("vets", theVets);
        return "visit-form";
    }

    @PostMapping("/saveVisit")
    public String saveVisit(@ModelAttribute("visit") Visit theVisit) {

        Pet thePet = clinicService.getPetByName(theVisit.getPetName());
        Vet theVet = clinicService.getVetByLastName(theVisit.getVetName());
        theVisit.setLocalDate(LocalDate.now());
        theVisit.setPet(thePet);
        theVisit.setVet(theVet);
        clinicService.saveVisit(theVisit);

        return "redirect:/visit/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("visitId") int theId, Model theModel) {

        Visit theVisit = clinicService.getVisitById(theId);
        List<Pet> thePets = clinicService.getPets();
        List<Vet> theVets = clinicService.getVets();
        theModel.addAttribute("visit", theVisit);
        theModel.addAttribute("pets", thePets);
        theModel.addAttribute("vets", theVets);

        return "visit-form";
    }

    @GetMapping("/deleteVisit")
    public String deleteVisit(@RequestParam("visitId") int theId) {
        clinicService.deleteVisitById(theId);

        return "redirect:/visit/list";
    }

}
