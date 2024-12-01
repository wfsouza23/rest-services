package com.spring.rest_services.paciente;

import com.spring.rest_services.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){

}
