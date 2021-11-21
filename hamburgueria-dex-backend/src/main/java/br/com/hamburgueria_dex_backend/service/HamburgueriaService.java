package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.dto.CardapioResponseDTO;
import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import br.com.hamburgueria_dex_backend.entity.IngredienteEntity;

import java.util.List;

public interface HamburgueriaService {
    CardapioResponseDTO obterCardapio ();
    List<IngredienteResponseDTO> obterTodosIngredientes();
}
