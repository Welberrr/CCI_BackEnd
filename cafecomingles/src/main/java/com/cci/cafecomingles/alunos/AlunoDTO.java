package com.cci.cafecomingles.alunos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoDTO(@NotBlank String nome, @NotNull LocalDate dataNascimento, @NotBlank String cpf, String cidade, String estado, String pais) {
}
