package com.rowha.iljalleo.controller;

import com.rowha.iljalleo.model.PrjtBasc;
import com.rowha.iljalleo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @PostMapping(value = "create")
    public Optional<PrjtBasc> createUser(@RequestBody PrjtBasc prjtBasc){
        int insertId = projectRepository.save(prjtBasc).getPrjtId();
        projectRepository.flush();
        return projectRepository.findById(insertId);
    }

    //ReadAll
    @GetMapping("/list")
    public List<PrjtBasc> readAll(){
        return projectRepository.findAll();
    }
}
