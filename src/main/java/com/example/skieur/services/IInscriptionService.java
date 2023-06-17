package com.example.skieur.services;

import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.Support;
import com.example.skieur.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IInscriptionService {
    Set<Inscription> getSubscriptionByType(TypeAbonnement typeAbonnement);

    Inscription assignInscriptionToCours(Long numInscription, Long numCours);

    Inscription addInscriptionAndAssignToSkieurAndCourse(Inscription inscription, Long numSkieur, Long numCours);

    List<Integer> numWeeksCoursOfMoniteurBySupport(Long numInstructor, Support support);

}
