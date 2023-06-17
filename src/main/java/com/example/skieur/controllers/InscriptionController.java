package com.example.skieur.controllers;

import com.example.skieur.entities.Inscription;

import com.example.skieur.entities.Support;
import com.example.skieur.services.IInscriptionService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
 @AllArgsConstructor
@RequestMapping("/inscription")

public class InscriptionController {
    IInscriptionService inscriptionService;


    
    @PostMapping("/addInscriptionAndAssignToSkieurAndCourse/{numSkieur}/{numCours}")
    public Inscription addSkieurAndAssignToCourse(@RequestBody Inscription inscription,
    @PathVariable("numSkieur")Long numSkieur,
     @PathVariable("numCours")Long numCours) {
        Inscription ins = inscriptionService.addInscriptionAndAssignToSkieurAndCourse(inscription,numSkieur,numCours);
        return ins;
    }

    
    @PutMapping("/assignInscriptionToCours/{numInscription}/{numCours}")
    public Inscription assignInscriptionToCours(@PathVariable("numInscription") Long numInscription,@PathVariable("numCours") Long numCours)
    {
        return  inscriptionService.assignInscriptionToCours(numInscription,numCours);
    }

    @GetMapping("/numWeeksCoursOfMoniteurBySupport/{numMoniteur}/{support}")
    public List<Integer> numWeeksCoursOfMoniteurBySupport
    (@PathVariable("numMoniteur")Long numMoniteur,
    @PathVariable("support") Support support) {
        return inscriptionService.numWeeksCoursOfMoniteurBySupport(numMoniteur,support);
    }
}
