package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Level;
import com.example.demo.services.QuestionarioService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/questionario")
public class QuestionarioController {

    private final QuestionarioService questionarioService;

    public QuestionarioController(QuestionarioService questionarioService) {
        this.questionarioService = questionarioService;
    }

    @PostMapping("/submit")
    public String submitQuestionnaire(@RequestBody Map<String, Boolean> answers) {
        Level level = questionarioService.calculateLevel(answers);
        return level.name(); // Return the level as a string
    }

    @GetMapping("/roadmap/{level}")
    public List<String> getRoadmap(@PathVariable String level) {
        return questionarioService.getRoadmap(level);
    }
}
