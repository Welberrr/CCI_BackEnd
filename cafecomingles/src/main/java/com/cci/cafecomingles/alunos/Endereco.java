package com.cci.cafecomingles.alunos;

import jakarta.persistence.Embeddable;

@Embeddable
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
}
