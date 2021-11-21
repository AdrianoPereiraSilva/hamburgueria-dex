package br.com.hamburgueria_dex_backend.dto;

import br.com.hamburgueria_dex_backend.entity.IngredienteEntity;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class LancheRequestDTO {

    private String nome;
    private BigDecimal valor;
    private List<IngredienteEntity> ingrediente;

    public LancheRequestDTO(String nome, List<IngredienteEntity> ingrediente) {
        this.nome = nome;
        this.ingrediente = ingrediente;
    }
}
