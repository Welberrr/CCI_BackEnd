package com.cci.cafecomingles.alunos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    List<Aluno> findAllByAtivoTrue();
    List<Aluno> findAllByAtivoFalse();
}
