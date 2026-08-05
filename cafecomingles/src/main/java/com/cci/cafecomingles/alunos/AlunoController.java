package com.cci.cafecomingles.alunos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public void cadastrar(@RequestBody AlunoDTO dados){
        Endereco endereco = new Endereco(dados.cidade(), dados.estado(), dados.pais());
        Aluno aluno = new Aluno(dados.nome(), dados.dataNascimento(), dados.cpf(), endereco);

        repository.save(aluno);
    }
}
