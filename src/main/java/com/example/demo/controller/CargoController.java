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

    private final CargoService linguagemService;

    @Autowired
    public CargoController(CargoService linguagemService) {
        this.linguagemService = linguagemService;
    }

    @GetMapping("/{id}/skills")
    public List<Skill> getSkillsByCargoId(@PathVariable Long id) {
        // Para esta rota, se a funcionalidade estiver fora do LinguagemService, pode ser adicionado aqui se necessário
        // Por exemplo: return linguagemService.getSkillsByLinguagemId(id);
        return linguagemService.getSkillsByCargoId(id);
    }

    @GetMapping("/all")
    public List<Cargo> getAllCargos() {
        return linguagemService.getAllCargos();
    }

    @PostMapping("/selected")
    public List<Skill> getSkillsForSelectedCargo(@RequestBody Cargo linguagem) {
        return linguagemService.getSkillsForSelectedCargo(linguagem);
    }
  
}
