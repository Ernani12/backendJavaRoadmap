package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Cargo;
import com.example.demo.model.Skill;
import com.example.demo.services.CargoService;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin
public class CargoController {

    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/{id}/skills")
    public List<Skill> getSkillsByCargoId(@PathVariable Long id) {
        // Para esta rota, se a funcionalidade estiver fora do cargoService, pode ser adicionado aqui se necessário
        // Por exemplo: return cargoService.getSkillsByLinguagemId(id);
        return cargoService.getSkillsByCargoId(id);
    }

    @GetMapping("/all")
    public List<Cargo> getAllCargos() {
        return cargoService.getAllCargos();
    }

    @PostMapping("/selected")
    public List<Skill> getSkillsForSelectedCargo(@RequestBody Cargo linguagem) {
        return cargoService.getSkillsForSelectedCargo(linguagem);
    }

    @PostMapping("/addc")
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoService.createCargo(cargo);
    }

    @DeleteMapping("/remover/{id}")
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Long id, @RequestBody Cargo cargoDetails) {
        Cargo updatedCargo = cargoService.updateCargo(id, cargoDetails);
        if (updatedCargo != null) {
            return ResponseEntity.ok(updatedCargo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  
}
