package com.example.skieur.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.skieur.customFunction.UtilityFonction;
import com.example.skieur.entities.Cours;
import com.example.skieur.entities.Inscription;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.Support;
import com.example.skieur.entities.TypeAbonnement;
import com.example.skieur.entities.TypeCours;
import com.example.skieur.repositories.CoursRepository;
import com.example.skieur.repositories.InscriptionRepository;
import com.example.skieur.repositories.SkieurRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class InscriptionService implements IInscriptionService{
    InscriptionRepository inscriptionRepository;
    SkieurRepository skieurRepository;
    CoursRepository coursRepository;
    @Override
    public Set<Inscription> getSubscriptionByType(TypeAbonnement typeAbonnement) {
        return null;
    }

    @Override
    public Inscription assignInscriptionToCours(Long numInscription, Long numCours) {
        Inscription inscription=inscriptionRepository.findByNumInscription(numInscription);
        Cours cours=coursRepository.findByNumCours(numCours);
        inscription.setCours(cours);
        inscriptionRepository.save(inscription);
        return inscription;
    }

    @Transactional
    public Inscription addInscriptionAndAssignToSkieurAndCourse(Inscription inscription, Long numSkieur, Long numCours) {

        Cours cours = coursRepository.findByNumCours(numCours);
        Skieur skieur = skieurRepository.findByNumSkieur(numSkieur);
        int ageSkieur = UtilityFonction.calculateAge(skieur.getDateNaissance());
        log.info("age skieur : "+ageSkieur);
        if(cours.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) & ageSkieur>18) {
            if (cours.getInscriptions().size() < 6) {
                Inscription ins = inscriptionRepository.save(inscription);
                ins.setSkieur(skieur);
                log.info("le nombre d inscriptions en cours est " + cours.getInscriptions().size());
                ins.setCours(cours);
            }
        }
         else if (cours.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT) & ageSkieur<18) {
            if (cours.getInscriptions().size() < 6) {
                Inscription ins = inscriptionRepository.save(inscription);
                ins.setSkieur(skieur);
                log.info("le nombre d inscriptions en cours est " + cours.getInscriptions().size());
                ins.setCours(cours);
            }
        }
            else {
                log.info("le nombre d'inscription maximal à ce cours est atteint ou age incompatible" +
                        " avec le cours");
            }
        return inscription;
    }

    @Override
    public List<Integer> numWeeksCoursOfMoniteurBySupport(Long numInstructor, Support support) {
        return inscriptionRepository.numWeeksCoursOfMoniteurBySupport(numInstructor, support);

    }


}
