package com.spring.rest_services.medico;

import com.spring.rest_services.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String crm, String email, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade(), medico.getEndereco());
    }
}
