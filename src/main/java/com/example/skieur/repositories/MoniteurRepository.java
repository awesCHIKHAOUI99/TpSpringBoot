package com.example.skieur.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skieur.entities.Moniteur;

public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {
    
}
