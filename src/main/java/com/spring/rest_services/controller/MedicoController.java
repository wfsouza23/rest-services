package com.spring.rest_services.controller;


import com.spring.rest_services.medico.DadosCadastroMedico;
import com.spring.rest_services.medico.DadosListagemMedico;
import com.spring.rest_services.medico.Medico;
import com.spring.rest_services.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositoryMedico;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repositoryMedico.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repositoryMedico.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
