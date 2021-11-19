package br.com.hamburgueria_dex_backend.dto;

import br.com.hamburgueria_dex_backend.entity.IngredientesEntity;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class LancheRequestDTO {

    private String nome;
    private BigDecimal valor;
    private List<IngredientesEntity> ingrediente;

    public LancheRequestDTO(String nome, List<IngredientesEntity> ingrediente) {
        this.nome = nome;
        this.ingrediente = ingrediente;
        total();
    }

    public void total() {
        this.valor = BigDecimal.valueOf(this.ingrediente.stream().mapToInt(i -> i.getValor().intValue()).sum());
    }


}
