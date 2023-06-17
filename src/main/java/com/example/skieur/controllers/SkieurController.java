package com.example.skieur.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skieur.entities.Couleur;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.TypeAbonnement;
import com.example.skieur.services.ISkieurService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/skieur")
public class SkieurController {
    ISkieurService skieurService;
    
    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur")Long numSkieur,
                                        @PathVariable("numPiste")Long numPiste) {
        Skieur skieur = skieurService.assignSkieurToPiste(numSkieur,numPiste);
        return skieur;
    }

    
    @PostMapping("/addSkieurAndAssignToCourse/{numCours}")
    public Skieur addSkieurAndAssignToCourse(@RequestBody Skieur skieur,
        @PathVariable("numCours")Long numCours) {
        Skieur s = skieurService.addSkieurAndAssignToCourse(skieur,numCours);
        return s;
    }


    
    @GetMapping("/retrieveSkieursByTypeAbonnement/{typeAbonnement}")
    public List<Skieur> retrieveSkieursByTypeAbonnement(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement) {
        List<Skieur> listSkieurs = skieurService.retrieveSkieursByTypeAbonnement(typeAbonnement);
        return listSkieurs;
    }

    
    @GetMapping("/nombreSkieursParCouleurPiste")
    public  HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        HashMap<Couleur,Integer> nombreSkieursParCouleurPiste = skieurService.nombreSkieursParCouleurPiste();
        return nombreSkieursParCouleurPiste;
    }

}
