package com.example.skieur.repositories;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.skieur.entities.Abonnement;
import com.example.skieur.entities.Skieur;
import com.example.skieur.entities.TypeAbonnement;
public interface SkieurRepository extends JpaRepository<Abonnement,Integer>  {
    Skieur findByNumSkieur(Long numSkieur);


Skieur findByAbonnement(Abonnement abonnement);
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);

    List<Abonnement> getAbonnementsByDateDebutBetween(LocalDate date1, LocalDate date2);

    @Query("select distinct a from Abonnement a where a.dateFin >= CURRENT_TIME and a.dateFin <= :dateExpiration order by a.dateFin")
    List<Abonnement> findDistinctOrderByDateFinAsc(@Param("dateExpiration") LocalDate dateExpiration);
    @Query("select (sum(i.prixAbon))/(count(i)) from Abonnement i where i.typeAbon = ?1")
    Float recurringRevenueByTypeSubEquals(TypeAbonnement typeAbonnement);
    
}
