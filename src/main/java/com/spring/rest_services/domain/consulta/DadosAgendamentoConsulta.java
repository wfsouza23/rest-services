package com.spring.rest_services.domain.consulta;

import com.spring.rest_services.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico, @NotNull Long idPaciente, @NotNull @Future LocalDateTime dataConsulta, Especialidade especialidade) {
}
