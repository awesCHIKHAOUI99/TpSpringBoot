package com.example.skieur.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.skieur.entities.Couleur;
import com.example.skieur.entities.Cours;
import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.Piste;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.TypeAbonnement;
import com.example.skieur.repositories.CoursRepository;
import com.example.skieur.repositories.PisteRepository;
import com.example.skieur.repositories.SkieurRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SkieurService implements ISkieurService{

    SkieurRepository skieurRepository;
    PisteRepository pisteRepository;
    CoursRepository coursRepository;
    @Transactional
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        log.info("debut methode assignSkieurToPiste");
        Skieur skieur = skieurRepository.findByNumSkieur(numSkieur);
        Piste piste =pisteRepository.findByNumPiste(numPiste);
        log.info("skieur "+skieur.getNumSkieur());
        log.info("piste "+piste.getNomPiste());
        skieur.getPistes().add(piste);
        log.info("fin methode assignSkieurToPiste");

        return skieur;
    }

    @Transactional
    public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse) {
        log.info("debut methode addSkieurAndAssignToCourse");
        Skieur.builder().nomS("sahli").numSkieur(123L).build();
        // t1 = date systeme
        Cours cours = coursRepository.findByNumCours(numCourse);
        Skieur s = skieurRepository.save(skieur);
        Set<Inscription> inscriptions = new HashSet<>();
        inscriptions= s.getInscriptions();
        inscriptions.stream().forEach(
                inscription ->  {
                    inscription.setCours(cours);
                  //  inscription.setSkieur(s);
                }

        );
        log.info("fin methode addSkieurAndAssignToCourse");
      //  t2= date sys - t1
        return null;
    }

    @Override
    public List<Skieur> retrieveSkieursByTypeAbonnement(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }

    @Override
    public HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        log.info("debut methode nombreSkieursParCouleurPiste");
        HashMap<Couleur,Integer> nombreSkieursParCouleurPiste = new HashMap<>();
        Couleur couleurs[] = Couleur.values();
        for(Couleur c: couleurs) {
            nombreSkieursParCouleurPiste.put(c,skieurRepository.skieursByCouleurPiste(c).size());

        }
        log.info("fin methode nombreSkieursParCouleurPiste");

        return nombreSkieursParCouleurPiste;
    }
}
