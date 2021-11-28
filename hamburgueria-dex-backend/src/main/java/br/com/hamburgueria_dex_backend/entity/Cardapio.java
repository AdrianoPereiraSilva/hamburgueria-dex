package br.com.hamburgueria_dex_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class Cardapio {
    private List<Lanches> lanches;
    private BigDecimal valor;

    public Cardapio(List<Lanches> lanches) {
        this.lanches = lanches;

        // Usa-se .reduce do Stream para Somar todos os valores do tipo BigDecimal
        this.valor = lanches.stream().map(i -> i.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
