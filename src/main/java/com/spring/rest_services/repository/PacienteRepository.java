package com.spring.rest_services.repository;

import com.spring.rest_services.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
