package br.com.hamburgueria_dex_backend.service.impl;

import br.com.hamburgueria_dex_backend.dto.CardapioResponseDTO;
import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import br.com.hamburgueria_dex_backend.entity.IngredienteEntity;
import br.com.hamburgueria_dex_backend.repository.HamburgueriaRepository;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HamburgueriaServiceImpl implements HamburgueriaService {

    @Autowired
    private HamburgueriaRepository repository;

    public CardapioResponseDTO obterCardapio () {
        return new CardapioResponseDTO(repository.obterCardapio().getLanches());
    }

    public List<IngredienteResponseDTO> obterTodosIngredientes() {
        return IngredienteResponseDTO.entityListToDtoList(repository.obterTodosIngredientes());
    }
}
