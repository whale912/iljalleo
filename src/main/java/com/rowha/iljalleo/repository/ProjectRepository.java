package com.rowha.iljalleo.repository;

import com.rowha.iljalleo.model.PrjtBasc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<PrjtBasc, Integer> {
}
