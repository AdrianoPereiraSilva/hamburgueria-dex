package br.com.hamburgueria_dex_backend.repository;

import br.com.hamburgueria_dex_backend.entity.CardapioEntity;
import br.com.hamburgueria_dex_backend.entity.IngredienteEntity;
import br.com.hamburgueria_dex_backend.entity.LancheEntity;
import br.com.hamburgueria_dex_backend.enums.Promocao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class HamburgueriaRepository {

    public CardapioEntity obterCardapio() {

        List<IngredienteEntity> ingredientesXBacon = Arrays.asList(
                new IngredienteEntity("Bacon", new BigDecimal("2.0")),
                new IngredienteEntity("Hambúrguer de carne", new BigDecimal("3.0")),
                new IngredienteEntity("Queijo", new BigDecimal("1.50"))
        );

        List<IngredienteEntity> ingredientesXEgg = Arrays.asList(
                new IngredienteEntity("Hambúrguer de carne", new BigDecimal("3.0")),
                new IngredienteEntity("Ovo", new BigDecimal("0.80")),
                new IngredienteEntity("Queijo", new BigDecimal("1.50"))
        );

        List<IngredienteEntity> ingredientesMisto = Arrays.asList(
                new IngredienteEntity("Alface", new BigDecimal("0.40")),
                new IngredienteEntity("Bacon", new BigDecimal("2.0")),
                new IngredienteEntity("Hambúrguer de carne", new BigDecimal("3.0")),
                new IngredienteEntity("Queijo", new BigDecimal("1.50"))
        );

        List<IngredienteEntity> ingredientesXtudo = Arrays.asList(
                new IngredienteEntity("Alface", new BigDecimal("0.40")),
                new IngredienteEntity("Bacon", new BigDecimal("2.0")),
                new IngredienteEntity("Hambúrguer de carne", new BigDecimal("3.0")),
                new IngredienteEntity("Ovo", new BigDecimal("0.80")),
                new IngredienteEntity("Queijo", new BigDecimal("1.50"))
        );


        List<LancheEntity> LancheEntity = Arrays.asList(
                new LancheEntity("X-Bacon", Promocao.MUITA_CARNE, ingredientesXBacon),
                new LancheEntity("X-Egg", Promocao.LIGHT, ingredientesXEgg),
                new LancheEntity("Misto", Promocao.MUITO_QUEIJO, ingredientesMisto),
                new LancheEntity("X-Tudo", Promocao.INFLACAO, ingredientesXtudo)
        );

        return new CardapioEntity(LancheEntity);

    }

    public List<IngredienteEntity> obterTodosIngredientes() {

        List<IngredienteEntity> ingredientes = Arrays.asList(
                new IngredienteEntity("Alface", new BigDecimal("0.40")),
                new IngredienteEntity("Bacon", new BigDecimal("2.0")),
                new IngredienteEntity("Hambúrguer de carne", new BigDecimal("3.0")),
                new IngredienteEntity("Ovo", new BigDecimal("0.80")),
                new IngredienteEntity("Queijo", new BigDecimal("1.50"))
        );

        return ingredientes;
    }
}
