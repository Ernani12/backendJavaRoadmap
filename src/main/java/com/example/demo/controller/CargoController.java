package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Cargo;
import com.example.demo.model.Skill;
import com.example.demo.services.CargoService;

import java.util.List;

@RestController
@RequestMapping("/api/linguagens")
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
  
}
