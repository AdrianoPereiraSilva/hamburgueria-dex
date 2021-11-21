package br.com.hamburgueria_dex_backend.dto;

import br.com.hamburgueria_dex_backend.entity.IngredienteEntity;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class IngredienteResponseDTO {

    private String nome;
    private BigDecimal valor;

    public IngredienteResponseDTO(IngredienteEntity ingrediente) {
        this.nome = ingrediente.getNome();
        this.valor = ingrediente.getValor();
    }

    public static List<IngredienteResponseDTO> entityListToDtoList(List<IngredienteEntity> ingredienteEntities) {
        return ingredienteEntities.stream().map(IngredienteResponseDTO::new).collect(Collectors.toList());
    }

}
