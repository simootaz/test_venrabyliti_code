package com.esprit.examen.entities;

import com.esprit.examen.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;
    private String name;
    private String description;
    private LocalDate lastUpdated;
    private LocalDate dueDate;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="goal")
    private List<CareerResources> CareerResourcess;

    @Enumerated(EnumType.STRING)
    private Status status ;



}
