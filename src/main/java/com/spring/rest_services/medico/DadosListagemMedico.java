package com.spring.rest_services.medico;

public record DadosListagemMedico(String nome, String crm, String email, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }
}
