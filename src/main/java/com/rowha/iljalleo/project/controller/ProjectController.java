package com.rowha.iljalleo.project.controller;

import com.rowha.iljalleo.project.model.ProjectEntity;
import com.rowha.iljalleo.project.model.ProjectSearchDTO;
import com.rowha.iljalleo.project.repository.ProjectRepository;
import com.rowha.iljalleo.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    private final ProjectService projectService;

    @PostMapping(value = "/create")
    public Optional<ProjectEntity> createProject(@RequestBody ProjectEntity projectEntity){
        int insertId = projectRepository.save(projectEntity).getPrjtId();
        projectRepository.flush();
        return projectRepository.findById(insertId);
    }

    /**
     *
     * @Method Name : getAllProejct
     * @작성일 : 2022/12/25
     * @작성자 : iyunbae
     * @변경이력 :
     * @Method 설명 : 모든 프로젝트 목록 조회
     * {@param }
     * {@return }
     * {@throws }
    */
    @GetMapping
    public List<ProjectEntity> getAllProejct(){
        return projectRepository.findAll();
    }

    @GetMapping(value="/search")
    public List<ProjectEntity> searchProject(@RequestBody ProjectSearchDTO projectSearchDTO){
        Specification<ProjectEntity> spec = projectService.getProjectSpecification(projectSearchDTO);
        return projectRepository.findAll(spec);
    }

    /**
     *
     * @Method Name : getProjectByID
     * @작성일 : 2022/12/25
     * @작성자 : iyunbae
     * @변경이력 :
     * @Method 설명 : ID로 프로젝트 단건 조회
     * {@param id}
     * {@return }
     * {@throws }
    */
    @GetMapping("/{prjtId}")
    public Optional<ProjectEntity> getProjectByID(@PathVariable("prjtId") int id){
        return projectRepository.findById(id);
    }
}
