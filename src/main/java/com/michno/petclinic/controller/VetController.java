package com.michno.petclinic.controller;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Vet;
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
@RequestMapping("/vet")
public class VetController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/list")
    public String listVets(Model theModel){

        List<Vet> theVets = clinicService.getVets();

        theModel.addAttribute("vets", theVets);

        return "vet-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Vet theVet = new Vet();

        theModel.addAttribute("vet", theVet);

        return "vet-form";
    }

    @PostMapping("/saveVet")
    public String saveVet(@ModelAttribute("vet") Vet theVet){

        theVet.setLocalDate(LocalDate.now());
        clinicService.saveVet(theVet);

        return"redirect:/vet/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("vetId") int theId, Model theModel){

        Vet theVet = clinicService.getVetById(theId);

        theModel.addAttribute("vet", theVet);

        return "vet-form";
    }

    @GetMapping("/deleteVet")
    public String deleteVet(@RequestParam("vetId") int theId){
        clinicService.deleteVetById(theId);

        return "redirect:/vet/list";
    }
}
