package br.com.hamburgueria_dex_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class CardapioEntity {
    private List<LancheEntity> lanches;
    private BigDecimal valor;

    public CardapioEntity (List<LancheEntity> lanches) {
        this.lanches = lanches;
        this.valor = BigDecimal.valueOf(lanches.stream().mapToInt(i -> i.getValor().intValue()).sum());
    }
}
