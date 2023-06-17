package com.example.skieur.services;

import java.util.HashMap;
import java.util.List;

import com.example.skieur.entities.Couleur;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.TypeAbonnement;

public interface ISkieurService {

    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);

    Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse);

    List<Skieur> retrieveSkieursByTypeAbonnement(TypeAbonnement typeAbonnement);

    HashMap<Couleur,Integer>  nombreSkieursParCouleurPiste();


}
