package com.cci.cafecomingles.alunos;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Aluno detalhar(@PathVariable UUID id){
        return repository.findById(id).get();
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody DadosAtualizadosAluno dados){
        Aluno aluno = repository.findById(dados.id()).get();
        aluno.atualizarInformacoes(dados);
    }
}
