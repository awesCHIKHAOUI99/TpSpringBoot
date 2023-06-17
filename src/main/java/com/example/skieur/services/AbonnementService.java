package com.example.skieur.services;

import com.example.skieur.entities.Abonnement;
import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.TypeAbonnement;
import com.example.skieur.repositories.AbonnementRepository;
import com.example.skieur.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.*;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AbonnementService implements IAbonnementService{

    AbonnementRepository abonnementRepository;
    SkieurRepository skieurRepository;
    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbon(type);
    }

    @Override
    public List<Abonnement> retrieveAbonnementByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.getAbonnementsByDateDebutBetween(startDate, endDate);

    }

 

   @Scheduled(cron = "* 0 9 1 * *") 
  @Scheduled(cron = "*/30 * * * * *") 
   public void showMonthlyRecurringRevenue() {
        Float revenue = abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.MENSUEL)
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.SEMESTRIEL)/6
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.ANNUEL)/12;
        log.info("Monthly Revenue = " + revenue);
    }
}
