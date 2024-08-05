package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCargoId(Long cargoId);
}

