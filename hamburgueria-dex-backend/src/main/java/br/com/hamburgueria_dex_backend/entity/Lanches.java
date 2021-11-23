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
    private String promocao;
    private List<Ingredientes> ingrediente;

    public Lanches(String nome, List<Ingredientes> ingrediente) {
        this.nome = nome;
        this.ingrediente = ingrediente;
        this.valor = BigDecimal.valueOf(this.ingrediente.stream().mapToInt(i -> i.getValor().intValue()).sum());
    }
}
