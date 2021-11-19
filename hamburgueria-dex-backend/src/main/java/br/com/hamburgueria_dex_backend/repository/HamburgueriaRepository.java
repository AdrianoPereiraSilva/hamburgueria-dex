package br.com.hamburgueria_dex_backend.repository;

import br.com.hamburgueria_dex_backend.dto.LancheResponseDTO;
import br.com.hamburgueria_dex_backend.entity.IngredientesEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HamburgueriaRepository {

    public List<LancheResponseDTO> listarTodosLanches () {

        List<IngredientesEntity> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredientesEntity("cebola", new BigDecimal("10.0")));
        ingredientes.add(new IngredientesEntity("carne", new BigDecimal("50.0")));
        ingredientes.add(new IngredientesEntity("bacon", new BigDecimal("50.0")));

        List<LancheResponseDTO> lancheResponse =new ArrayList<>();

        lancheResponse.add(new LancheResponseDTO("X-Bacon", ingredientes));

        return lancheResponse;

    }
}
