package br.com.hamburgueria_dex_backend.repository;

import br.com.hamburgueria_dex_backend.business.*;
import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class HamburgueriaRepository {

    public Cardapio obterCardapio() {

        List<Ingredientes> ingredientesXBacon = Arrays.asList(
                new Ingredientes("Bacon", new BigDecimal("3"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Queijo",new BigDecimal("1"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXEgg = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXSalada = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Alface", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesMisto = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("2"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Queijo", new BigDecimal("3"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXtudo = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("1"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("2"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Lanches> LancheEntity = Arrays.asList(
                new Lanches("X-Bacon", ingredientesXBacon),
                new Lanches("X-Egg", ingredientesXEgg),
                new Lanches("Misto", ingredientesMisto),
                new Lanches("X-Tudo", ingredientesXtudo),
                new Lanches("X-Salada", ingredientesXSalada)
        );

        return new Cardapio(LancheEntity);

    }

    public List<Ingredientes> obterTodosIngredientes() {

        List<Ingredientes> ingredientes = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("1"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("1"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("1"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("1"), new BigDecimal("1.50"))
        );

        return ingredientes;
    }

    public Cardapio calcularValorTotalCardapio(Cardapio cardapio) {

        CalcularDescontoLanches cardapioResponse =
                new LancheLight(
                    new LancheMuitaCarne(
                        new LancheMuitoQueijo(
                                new LancheSemDesconto())));

        return new Cardapio(cardapioResponse.calcular(cardapio).getLanches());
    }

}
