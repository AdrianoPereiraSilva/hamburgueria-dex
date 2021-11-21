package br.com.hamburgueria_dex_backend.dto;

import br.com.hamburgueria_dex_backend.entity.LancheEntity;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CardapioResponseDTO {

    private List<LancheResponseDTO> lanches;
    private BigDecimal valor;

    public CardapioResponseDTO(List<LancheEntity> lanches) {
        this.lanches = lanches.stream().map(LancheResponseDTO::new).collect(Collectors.toList());
        this.valor = BigDecimal.valueOf(lanches.stream().mapToInt(i -> i.getValor().intValue()).sum());
    }
}
