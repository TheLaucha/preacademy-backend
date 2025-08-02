package com.segunda_evaluacion.segunda_evaluacion.repository;

import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepo extends JpaRepository<Professional, Long> {
}
