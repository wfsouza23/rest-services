package com.spring.rest_services.paciente;

import com.spring.rest_services.medico.Medico;

public record DadosListagemPaciente(Long id, String nome, String email){

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }

}
