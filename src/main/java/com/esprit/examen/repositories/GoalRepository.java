package com.esprit.examen.repositories;

import com.esprit.examen.entities.Goal;
import com.esprit.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByLastUpdatedBefore(LocalDate date);

}
