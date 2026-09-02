package com.cci.cafecomingles.alunos;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Aluno(String nome, LocalDate dataNascimento, String cpf, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = true;
    }

    public Aluno() {}

    public void atualizarInformacoes(DadosAtualizadosAluno dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        this.endereco.atualizarInformacoes(dados);
    }

    public void inativar(){
        this.ativo = false;
    }
}
