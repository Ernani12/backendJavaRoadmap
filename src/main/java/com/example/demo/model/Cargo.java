package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Cargo() {
    }

    private String nome;

  
  
    public Cargo(String nome, List<Skill> skills) {
        this.nome = nome;
        this.skills = skills;
    }

    // Getters and setters
    @JsonIgnore
    public List<Skill> getSkills() {
        return skills;
    } 

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Skill> skills;
}
