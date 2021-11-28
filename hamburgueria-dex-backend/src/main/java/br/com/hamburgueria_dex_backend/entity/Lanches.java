package br.com.hamburgueria_dex_backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
public class Lanches {

    private String nome;
    private BigDecimal valor;
    private BigDecimal valorAntigo;
    private String promocao;
    private List<Ingredientes> ingredientes;

    public Lanches(String nome, List<Ingredientes> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;

        // Usa-se .reduce do Stream para Somar todos os valores do tipo BigDecimal
        this.valor = this.ingredientes.stream().map(i -> i.getValorTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
