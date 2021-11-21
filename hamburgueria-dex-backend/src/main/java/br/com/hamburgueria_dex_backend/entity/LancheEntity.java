package br.com.hamburgueria_dex_backend.entity;

import br.com.hamburgueria_dex_backend.enums.Promocao;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class LancheEntity {

    private String nome;
    private BigDecimal valor;
    private Promocao promocao;
    private List<IngredienteEntity> ingrediente;

    public LancheEntity(String nome, Promocao promocao, List<IngredienteEntity> ingrediente) {
        this.nome = nome;
        this.promocao = promocao;
        this.ingrediente = ingrediente;
        this.valor = BigDecimal.valueOf(this.ingrediente.stream().mapToInt(i -> i.getValor().intValue()).sum());
    }
}
