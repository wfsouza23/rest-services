package com.spring.rest_services.domain.consulta.validacoes.cancelamento;

import com.spring.rest_services.domain.consulta.ConsultaRepository;
import com.spring.rest_services.domain.consulta.strategy.ValidadorCancelamentoConsultas;
import com.spring.rest_services.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoConsultas {

    @Autowired
    private ConsultaRepository repository;

//    @Override
//    public void validar(DadosCancelamentoConsulta dados) {
//        var consulta = repository.getReferenceById(dados.idConsulta());
//        var agora = LocalDateTime.now();
//        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();
//
//        if (diferencaEmHoras < 24) {
//            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
//        }
//    }
}