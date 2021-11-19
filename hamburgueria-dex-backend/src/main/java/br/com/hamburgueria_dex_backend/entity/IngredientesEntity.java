package br.com.hamburgueria_dex_backend.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientesEntity {
    private String nome;
    private BigDecimal valor;

    public IngredientesEntity(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
