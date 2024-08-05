package com.example.demo.Data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Cargo;
import com.example.demo.model.Skill;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.SkillRepository;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CargoRepository cargoRepository;
    
    private final SkillRepository skillRepository;

    public DataInitializer(CargoRepository cargoRepository, SkillRepository skillRepository) {
        this.cargoRepository = cargoRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        cargoRepository.deleteAll();
        skillRepository.deleteAll();
        if (cargoRepository.count() > 0) {
            return; // Dados já foram inicializados, não faça nada.
        }

        Cargo java = new Cargo();
        java.setNome("Desenvolvedor Java");

        Skill javaSkill1 = new Skill();
        javaSkill1.setNome("Spring Boot");
        javaSkill1.setCargo(java);

        Skill javaSkill2 = new Skill();
        javaSkill2.setNome("Hibernate");
        javaSkill2.setCargo(java);

        java.setSkills(Arrays.asList(javaSkill1, javaSkill2));

        Cargo python = new Cargo();
        python.setNome("Desenvolvedor Python");

        Skill pythonSkill1 = new Skill();
        pythonSkill1.setNome("Django");
        pythonSkill1.setCargo(python);

        Skill pythonSkill2 = new Skill();
        pythonSkill2.setNome("Flask");
        pythonSkill2.setCargo(python);

        python.setSkills(Arrays.asList(pythonSkill1, pythonSkill2));

        Cargo react = new Cargo();
        react.setNome("Desenvolvedor React");

        Skill reactSkill1 = new Skill();
        reactSkill1.setNome("Hooks");
        reactSkill1.setCargo(react);

        Skill reactSkill2 = new Skill();
        reactSkill2.setNome("Redux");
        reactSkill2.setCargo(react);

        react.setSkills(Arrays.asList(reactSkill1, reactSkill2));

        Cargo angular = new Cargo();
        angular.setNome("Desenvolvedor Angular");

        Skill angularSkill1 = new Skill();
        angularSkill1.setNome("Components");
        angularSkill1.setCargo(angular);

        Skill angularSkill2 = new Skill();
        angularSkill2.setNome("Services");
        angularSkill2.setCargo(angular);


        Cargo eg = new Cargo();
        eg.setNome("Engennheiro de Dados");

        Skill egSkill1 = new Skill();
        egSkill1.setNome("SQL");
        egSkill1.setCargo(eg);

        Skill egSkill2 = new Skill();
        egSkill2.setNome("Python");
        egSkill2.setCargo(eg);

        Skill egSkill3 = new Skill();
        egSkill3.setNome("NoSql");
        egSkill3.setCargo(eg);

        eg.setSkills(Arrays.asList(egSkill1, egSkill2,egSkill3));

        // Save all to the database
        cargoRepository.saveAll(Arrays.asList(java, python, react, angular,eg));
    }
}
