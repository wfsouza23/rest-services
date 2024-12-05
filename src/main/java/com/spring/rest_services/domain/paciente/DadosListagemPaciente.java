package com.spring.rest_services.domain.paciente;

public record DadosListagemPaciente(Long id, String nome, String email){

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }

}
