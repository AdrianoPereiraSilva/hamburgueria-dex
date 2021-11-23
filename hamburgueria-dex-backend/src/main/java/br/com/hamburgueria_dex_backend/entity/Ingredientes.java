package br.com.hamburgueria_dex_backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ingredientes {

    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;

    public Ingredientes(String nome, BigDecimal quantidade, BigDecimal valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor.multiply(quantidade);
    }
}
