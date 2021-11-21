package br.com.hamburgueria_dex_backend.entity;

import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class IngredienteEntity {

    private String nome;
    private BigDecimal valor;

    public IngredienteEntity(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }
}
