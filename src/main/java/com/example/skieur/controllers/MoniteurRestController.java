package com.example.skieur.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skieur.entities.Moniteur;
import com.example.skieur.services.IMoniteurService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")

public class MoniteurRestController {

    IMoniteurService moniteurService;
    
  
    @GetMapping("/retrieve-all-moniteurs")
    public List<Moniteur> getAbonnements() {
        List<Moniteur> listMoniteurs = moniteurService.retrieveAllMoniteurs();
        return listMoniteurs;
    }

    
    
    @GetMapping("/retrieve-moniteur/{moniteur-id}")
    public Moniteur retrieveMoniteur
                                       (  @PathVariable("moniteur-id") Integer moniteurId) {
            return moniteurService.retrieveMoniteur(moniteurId);
}



  
    @PostMapping("/add-moniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteur(m);
        return moniteur;
    }
    
    @DeleteMapping("/remove-moniteur/{moniteur-id}")
    public void removeMoniteur(@PathVariable("moniteur-id") Integer moniteurId) {
        moniteurService.deleteMoniteur(moniteurId);
    }

    
    @PutMapping("/update-moniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur= moniteurService.updateMoniteur(m);
        return moniteur;
    }

    
    @PostMapping("/addMoniteurAndAssignToCourse")
    public Moniteur addMoniteurAndAssignToCourse(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteurAndAssignToCourse(m);
        return moniteur;
    }

    
    @GetMapping("/bestMoniteur")
    public Moniteur bestMoniteur() {
        return moniteurService.bestMoniteur();
    }
}
