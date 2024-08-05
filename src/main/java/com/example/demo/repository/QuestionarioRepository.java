package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    
}
