package com.spring.rest_services.controller;

import com.spring.rest_services.domain.paciente.DadosAtualizarPaciente;
import com.spring.rest_services.domain.paciente.DadosCadastroPaciente;
import com.spring.rest_services.domain.paciente.DadosListagemPaciente;
import com.spring.rest_services.domain.paciente.Paciente;
import com.spring.rest_services.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    public void alterar(@RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
