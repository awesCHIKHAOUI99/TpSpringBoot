package com.example.skieur.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skieur.entities.Cours;
import com.example.skieur.entities.Support;

public interface CoursRepository extends JpaRepository<Cours,Integer> {
    Cours findByNumCours(Long numCours);
    List<Cours> findBySupport(Support s);
}
