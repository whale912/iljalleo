package com.rowha.iljalleo.project.service;

import com.rowha.iljalleo.project.model.ProjectEntity;
import com.rowha.iljalleo.project.model.ProjectSearchDTO;
import com.rowha.iljalleo.project.repository.ProjectSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProjectService {
    public Specification<ProjectEntity> getProjectSpecification(ProjectSearchDTO projectSearchDTO){
        Specification<ProjectEntity> spec = null;
        if(projectSearchDTO.getSrchPrjtName()!=null){
            spec = Specification.where(ProjectSpecification.likePrjtName("%"+projectSearchDTO.getSrchPrjtName()+"%"));
        }

        if(projectSearchDTO.getSrchStrtDate()!=null && projectSearchDTO.getSrchEndDate()!=null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDateTime srchStrtDate = LocalDateTime.parse(projectSearchDTO.getSrchStrtDate().replace("-",""), formatter);
            LocalDateTime srchEndDate = LocalDateTime.parse(projectSearchDTO.getSrchEndDate().replace("-",""), formatter);
            spec = searchWhereAnd(spec, ProjectSpecification.betweenStrtDate(srchStrtDate, srchEndDate));
        }

        if(projectSearchDTO.getSrchPrjtSttsCode()!=null){
            spec = searchWhereAnd(spec, ProjectSpecification.equalPrjtSttsCode(projectSearchDTO.getSrchPrjtSttsCode()));
        }

        if(projectSearchDTO.getSrchPrjtTypeCode()!=null){
            spec = searchWhereAnd(spec, ProjectSpecification.equalPrjtTypeCode(projectSearchDTO.getSrchPrjtTypeCode()));
        }

        if(projectSearchDTO.getSrchMngrId()!=null){
            spec = searchWhereAnd(spec, ProjectSpecification.equalMngrId(projectSearchDTO.getSrchMngrId()));
        }

        if(projectSearchDTO.getSrchRmks()!=null){
            spec = searchWhereAnd(spec, ProjectSpecification.likeRmks("%"+projectSearchDTO.getSrchRmks()+"%"));
        }
        return spec;
    }

    private Specification<ProjectEntity> searchWhereAnd(Specification<ProjectEntity> spec, Specification<ProjectEntity> where){
        if(spec==null){
            return Specification.where(where);
        }else{
            return spec.and(where);
        }
    }
}
