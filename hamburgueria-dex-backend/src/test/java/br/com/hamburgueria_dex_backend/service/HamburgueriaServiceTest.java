package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.StartupApplication;
import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StartupApplication.class)
public class HamburgueriaServiceTest {

    @Autowired
    private HamburgueriaService service;

    @Test
    void quandoEnviarUmlancheComAlfaceEsemBaconDeveraRetornarPromocaoLigth (){

        List<Ingredientes> ingredientesXBacon = Arrays.asList(
                new Ingredientes("Bacon", new BigDecimal("3"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Queijo",new BigDecimal("1"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXSalada = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Alface", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Lanches> LancheEntity = Arrays.asList(
                new Lanches("X-Salada", ingredientesXSalada),
                new Lanches("X-Bacon", ingredientesXBacon)
        );

        Cardapio cardapio = new Cardapio(LancheEntity);

        service.calcularValorTotalCardapio(cardapio);
    }

}
