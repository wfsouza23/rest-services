package com.spring.rest_services.domain.consulta.validacoes.agendamento;

import com.spring.rest_services.domain.consulta.DadosAgendamentoConsulta;
import com.spring.rest_services.domain.consulta.strategy.ValidadorAgendamentoConsulta;
import com.spring.rest_services.infra.exception.ValidacaoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Component("ValidadorHorarioAntecedenciaCancelamento")
@RequiredArgsConstructor
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        final List<String> erros = new ArrayList<>();

        var dataConsulta = dados.dataConsulta();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
