package com.cci.cafecomingles.alunos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
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
}
