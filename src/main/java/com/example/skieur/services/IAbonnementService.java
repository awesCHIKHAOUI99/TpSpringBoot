package com.example.skieur.services;

import com.example.skieur.entities.Abonnement;
import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService  {
    Set<Abonnement> getAbonnementByType(TypeAbonnement type);

    List<Abonnement> retrieveAbonnementByDates(LocalDate startDate, LocalDate endDate);

 //   public void retrieveAbonnements();
}
