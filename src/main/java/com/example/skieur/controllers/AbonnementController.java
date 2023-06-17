package com.example.skieur.controllers;

import com.example.skieur.entities.Abonnement;
import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.Moniteur;
import com.example.skieur.entities.TypeAbonnement;
import com.example.skieur.services.IAbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/abonnement")
public class AbonnementController {
    IAbonnementService abonnementService;
    
    @GetMapping("/retrieve-all-abonnementBytype/{typeAbonnement}")
    public Set<Abonnement> getAbonnementsBytype(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement) {
        Set<Abonnement> listAbonnement = abonnementService.getAbonnementByType(typeAbonnement);
        return listAbonnement;
    }

    
    @GetMapping("/getAbonnementsByDates/{date1}/{date2}")
    public List<Abonnement> getAbonnementsByDates(@PathVariable("date1") @DateTimeFormat(pattern= "yyyy-MM-dd")  LocalDate startDate,
    @PathVariable("date2") @DateTimeFormat(pattern= "yyyy-MM-dd")  LocalDate endDate){
        return abonnementService.retrieveAbonnementByDates(startDate, endDate);
    }
}
