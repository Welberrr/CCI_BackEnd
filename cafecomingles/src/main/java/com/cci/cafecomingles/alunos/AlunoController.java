package com.cci.cafecomingles.alunos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Aluno> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno detalhar(@RequestBody AlunoDTO dados){
        Endereco endereco = new Endereco(dados.cidade(), dados.estado(), dados.pais());
        Aluno aluno = new Aluno(dados.nome(), dados.dataNascimento(), dados.cpf(), endereco);

        aluno.getAtivo();
        aluno.getCpf();
        aluno.getDataNascimento();
        aluno.getId();
        aluno.getNome();
        aluno.getEndereco();

        return aluno;
    }
}
