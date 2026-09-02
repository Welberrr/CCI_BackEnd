package com.cci.cafecomingles.alunos;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Endereco {

    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco() {}

    public void atualizarInformacoes(DadosAtualizadosAluno dados){
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }

        if (dados.estado() != null){
            this.estado = dados.estado();
        }

        if (dados.pais() != null){
            this.pais = dados.pais();
        }
    }
}
