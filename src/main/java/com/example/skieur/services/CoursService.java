package com.example.skieur.services;

import com.example.skieur.entities.Support;
import com.example.skieur.repositories.CoursRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CoursService implements   ICoursService{
    CoursRepository coursRepository;
   @Scheduled(cron = "*/15 * * * * *")
 public void listeCoursSnowBoard() {

        coursRepository.findBySupport(Support.SNOWBOARD).stream().forEach(
                cours ->
                {
                  log.info("cours "+ cours.getNumCours()+" prix :"+cours.getPrix());
                }
        );

    }
}
