package com.cci.cafecomingles.alunos;

import java.time.LocalDate;

public record AlunoDTO(String nome, LocalDate dataNascimento, String cpf, String cidade, String estado, String pais) {
}
