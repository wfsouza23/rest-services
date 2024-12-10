package com.spring.rest_services.domain.consulta.validacoes.agendamento;

import com.spring.rest_services.domain.consulta.DadosAgendamentoConsulta;
import com.spring.rest_services.domain.consulta.strategy.ValidadorAgendamentoConsulta;
import com.spring.rest_services.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.dataConsulta();
        var now = LocalDateTime.now();
        var diferenceEmMinutos = Duration.between(now, dataConsulta).toMinutes();

        if(diferenceEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }
    }

}
