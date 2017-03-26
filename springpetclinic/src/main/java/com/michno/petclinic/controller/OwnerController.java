package com.michno.petclinic.controller;

import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arkad on 23.03.2017.
 */
@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/list")
    public String listOwners(Model theModel) {

        List<Owner> theOwners = clinicService.getOwners();

        theModel.addAttribute("owners", theOwners);

        return "list-owners";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Owner theOwner = new Owner();

        theModel.addAttribute("owner", theOwner);

        return "owner-form";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner theOwner){

        clinicService.saveOwner(theOwner);

        return"redirect:/owner/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ownerId") int theId, Model theModel){

        Owner theOwner = clinicService.getOwnerById(theId);

        theModel.addAttribute("owner", theOwner);

        return "owner-form";
    }

    @GetMapping("/deleteOwner")
    public String deleteOwner(@RequestParam("ownerId") int theId){
        clinicService.deleteOwnerById(theId);

        return "redirect:/owner/list";
    }
}
