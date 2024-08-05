package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Level;
import java.util.Map;

@Service
public class QuestionarioService {

    public Level calculateLevel(Map<String, Boolean> answers) {
        boolean knowsBasics = answers.getOrDefault("CRUD", false) || 
                              answers.getOrDefault("TDD/BDD", false) || 
                              answers.getOrDefault("Hibernate", false);
        
        boolean knowsIntermediate = answers.getOrDefault("CRUD", false) && 
                                    answers.getOrDefault("TDD/BDD", false) && 
                                    answers.getOrDefault("Hibernate", false) && 
                                    answers.getOrDefault("Docker", false) && 
                                    answers.getOrDefault("Kubernetes", false) && 
                                    answers.getOrDefault("Microservices", false);
        
        boolean knowsAll = answers.getOrDefault("CRUD", false) && 
                           answers.getOrDefault("Cloud", false) && 
                           answers.getOrDefault("TDD/BDD", false) && 
                           answers.getOrDefault("CI/CD", false) && 
                           answers.getOrDefault("Docker", false) && 
                           answers.getOrDefault("Kubernetes", false) && 
                           answers.getOrDefault("MonitoringTools", false) && 
                           answers.getOrDefault("Microservices", false) && 
                           answers.getOrDefault("Hibernate", false) && 
                           answers.getOrDefault("Kafka", false);

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

    public List<String> getRoadmap(String level) {
        List<String> roadmap = new ArrayList<>();
        switch (level.toUpperCase()) {
            case "SENIOR":
                roadmap.add("Continue with advanced projects.");
                roadmap.add("Contribute to open-source projects.");
                roadmap.add("Mentor junior and intermediate developers.");
                break;
            case "PLENO":
                roadmap.add("Learn advanced Docker and Kubernetes.");
                roadmap.add("Work on microservices architecture.");
                roadmap.add("Start contributing to larger projects.");
                break;
            case "JUNIOR":
            default:
                roadmap.add("Focus on learning CRUD operations.");
                roadmap.add("Understand the basics of Docker and Kubernetes.");
                roadmap.add("Learn about basic CI/CD concepts.");
                break;
        }
        return roadmap;
    }

    
}
