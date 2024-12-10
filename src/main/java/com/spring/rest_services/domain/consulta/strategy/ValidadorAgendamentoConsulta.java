package com.spring.rest_services.domain.consulta.strategy;

import com.spring.rest_services.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
