package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cargo;
import com.example.demo.model.Skill;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.SkillRepository;

import java.util.Optional;

@Service
public class CargoService {

    private final SkillRepository skillRepository;
    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(SkillRepository skillRepository, CargoRepository cargoRepository) {
        this.skillRepository = skillRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<Skill> getSkillsByCargoId(Long id) {
        return skillRepository.findByCargoId(id);
    }

    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    public List<Skill> getSkillsForSelectedCargo(Cargo cargo) {
        if (cargo.getNome() == null || cargo.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da linguagem deve ser fornecido");
        }

        Optional<Cargo> cargoOptional = cargoRepository.findByNome(cargo.getNome());
        if (cargoOptional.isPresent()) {
            return skillRepository.findByCargoId(cargoOptional.get().getId());
        } else {
            throw new IllegalArgumentException("Linguagem não encontrada");
        }
    }

}
