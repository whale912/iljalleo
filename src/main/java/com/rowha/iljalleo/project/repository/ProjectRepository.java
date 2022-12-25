package com.rowha.iljalleo.project.repository;

import com.rowha.iljalleo.project.model.ProjectEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer>, JpaSpecificationExecutor<ProjectEntity> {

    public static Specification<ProjectEntity> likePrjtName(String srchPrjtName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("prjtName"), srchPrjtName);
    }

    public static Specification<ProjectEntity> equalPrjtSttsCode(String srchPrjtSttsCode) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("prjtSttsCode"), srchPrjtSttsCode);
    }

    public static Specification<ProjectEntity> equalPrjtTypeCode(String srchPrjtName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("prjtTypeCode"), srchPrjtName);
    }

    public static Specification<ProjectEntity> betweenStrtDate(LocalDateTime srchStrtDate, LocalDateTime srchEndDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("prjtTypeCode"), srchStrtDate, srchEndDate);
    }

    public static Specification<ProjectEntity> equalMngrId(String srchMngrId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("mngrId"), srchMngrId);
    }

    public static Specification<ProjectEntity> likeRmks(String srchRmks) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("rmks"), srchRmks);
    }
}
