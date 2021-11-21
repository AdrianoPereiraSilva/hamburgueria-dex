package br.com.hamburgueria_dex_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class CardapioRequestDTO {
    private List<LancheRequestDTO> lanches;
    private BigDecimal valor;
}
