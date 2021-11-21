package br.com.hamburgueria_dex_backend.dto;

import br.com.hamburgueria_dex_backend.entity.LancheEntity;
import br.com.hamburgueria_dex_backend.enums.Promocao;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LancheResponseDTO {

    private String nome;
    private BigDecimal valor;
    private Promocao promocao;
    private List<IngredienteResponseDTO> ingrediente;

    public LancheResponseDTO(LancheEntity lanche) {
        this.nome = lanche.getNome();
        this.promocao = lanche.getPromocao();
        this.valor = lanche.getValor();
        this.ingrediente = lanche.getIngrediente().stream().map(IngredienteResponseDTO::new).collect(Collectors.toList());
    }
}
