package com.esprit.examen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CareerResourcess")
public class CareerResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ressourceId;
    private String name;
    private String url;
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    Goal goal;

}
