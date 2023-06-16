package com.example.skieur.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skieur.entities.Piste;

public interface PisteRepository extends JpaRepository<Piste,Integer> {
    Piste findByNumPiste(Long numPiste);


}
