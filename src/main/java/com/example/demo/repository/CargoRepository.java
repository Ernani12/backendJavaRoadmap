package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Optional<Cargo> findByNome(String nome);
}