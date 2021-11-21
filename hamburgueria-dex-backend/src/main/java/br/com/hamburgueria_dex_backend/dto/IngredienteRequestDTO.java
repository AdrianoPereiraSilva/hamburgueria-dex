package br.com.hamburgueria_dex_backend.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class IngredienteRequestDTO {

    private String nome;
    private BigDecimal valor;

    public IngredienteRequestDTO(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }
}
