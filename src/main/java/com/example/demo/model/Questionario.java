package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Questionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean crud;
    private boolean cloud;
    private boolean tddBdd;
    private boolean ciCd;
    private boolean docker;
    private boolean kubernetes;
    private boolean monitoringTools;
    private boolean microservices;
    private boolean hibernate;
    private boolean kafka;

    @ManyToOne
    private User user;

    // Getters and Setters

    public Level calculateLevel() {
        boolean knowsBasics = crud || tddBdd || hibernate;
        boolean knowsIntermediate = crud && tddBdd && hibernate && docker && kubernetes && microservices;
        boolean knowsAll = crud && cloud && tddBdd && ciCd && docker && kubernetes && monitoringTools && microservices && hibernate && kafka;

        if (knowsAll) {
            return Level.SENIOR;
        } else if (knowsIntermediate) {
            return Level.PLENO;
        } else if (knowsBasics) {
            return Level.JUNIOR;
        } else {
            return Level.JUNIOR; // Default to JUNIOR if none of the conditions are met
        }
    }

   
}
