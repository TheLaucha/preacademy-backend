package com.votaciones.api.repository;

import com.votaciones.api.model.PartidoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Long> {

}