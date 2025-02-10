package com.esprit.examen.repositories;

import com.esprit.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposirory extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

}
