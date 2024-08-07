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


    public Cargo createCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(Long id) {
        cargoRepository.deleteById(id);
    }

    public Cargo updateCargo(Long id, Cargo cargoDetails) {
        Optional<Cargo> optionalCargo = cargoRepository.findById(id);
        if (optionalCargo.isPresent()) {
            Cargo cargo = optionalCargo.get();
            cargo.setNome(cargoDetails.getNome());
            return cargoRepository.save(cargo);
        } else {
            // Handle the case where cargo is not found
            return null;
        }
    }

    public Cargo addNewSkillToCargo(Long cargoId, String skillName) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(cargoId);
        if (!cargoOptional.isPresent()) {
            return null; // Ou lance uma exceção personalizada
        }

        String cleanedSkillName = skillName.replaceAll("\"", "").trim();

        Cargo cargo = cargoOptional.get();

        boolean skillExists = cargo.getSkills().stream()
                .anyMatch(skill -> skill.getNome().equalsIgnoreCase(cleanedSkillName));
        
        if (!skillExists) {
            Skill newSkill = new Skill();
            newSkill.setNome(cleanedSkillName);
            newSkill.setCargo(cargo);

            skillRepository.save(newSkill);
            cargo.getSkills().add(newSkill);
            cargoRepository.save(cargo);
        }

        return cargo;
    }


    
}
