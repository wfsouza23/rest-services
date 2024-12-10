package com.spring.rest_services.domain.consulta;

import com.spring.rest_services.domain.consulta.strategy.ValidadorAgendamentoConsulta;
import com.spring.rest_services.domain.medico.Medico;
import com.spring.rest_services.infra.exception.ValidacaoException;
import com.spring.rest_services.repository.MedicoRepository;
import com.spring.rest_services.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private final List<ValidadorAgendamentoConsulta> validadorAgendamentoConsulta;

//    @Autowired
//    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente nao existe");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico nao existe");
        }

        validadorAgendamentoConsulta.forEach(validador -> validador.validar(dados));

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoException("Nao há medico livre nessa data.");
        }
        var consulta = new Consulta(null, medico, paciente, dados.dataConsulta());

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

//    public void cancelar(DadosCancelamentoConsulta dados) {
//        if (!consultaRepository.existsById(dados.idConsulta())) {
//            throw new ValidacaoException("Id da consulta informado não existe!");
//        }
//
//        validadoresCancelamento.forEach(v -> v.validar(dados));
//
//        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
//        consulta.cancelar(dados.motivo());
//    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatoria quando um medico nao for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.dataConsulta());
        
    }

}
