package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.StartupApplication;
import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import br.com.hamburgueria_dex_backend.enums.Promocao;
import br.com.hamburgueria_dex_backend.repository.HamburgueriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StartupApplication.class)
public class HamburgueriaServiceTest {

    @Autowired
    private HamburgueriaService service;

    @MockBean
    private HamburgueriaRepository repository;

    @Test
    void quandoEnviarUmlancheComAlfaceSemBaconDeveraRetornarPromocaoLight (){

        List<Ingredientes> ingredientesXSalada = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Alface", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Lanches> lanches = Arrays.asList(
                new Lanches("X-Salada", ingredientesXSalada)
        );

        Lanches lancheExpected = new Lanches("X-Salada", ingredientesXSalada);
        lancheExpected.setPromocao(Promocao.LIGHT.name());

        List<Lanches> lanchesExpected = Arrays.asList(lancheExpected);

        Cardapio request = new Cardapio(lanches);
        Cardapio expected = new Cardapio(lanchesExpected);

        when(repository.calcularValorTotalCardapio(request)).thenReturn(expected);

        assertEquals(
                expected.getLanches().get(0).getPromocao(),
                service.calcularValorTotalCardapio(request).getLanches().get(0).getPromocao()
        );

    }

    @Test
    void quandoEnviarUmlancheComTresPorcoesDeBaconDeveraRetornarPromocaoMuitaCarne() {

        List<Ingredientes> ingredientesXBacon = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Bacon", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Lanches> lanches = Arrays.asList(
                new Lanches("X-Salada", ingredientesXBacon)
        );

        Lanches lancheExpected = new Lanches("X-Bacon", ingredientesXBacon);
        lancheExpected.setPromocao(Promocao.MUITA_CARNE.name());

        List<Lanches> lanchesExpected = Arrays.asList(lancheExpected);

        Cardapio request = new Cardapio(lanches);
        Cardapio expected = new Cardapio(lanchesExpected);

        when(repository.calcularValorTotalCardapio(request)).thenReturn(expected);

        assertEquals(
                expected.getLanches().get(0).getPromocao(),
                service.calcularValorTotalCardapio(request).getLanches().get(0).getPromocao()
        );

    }

}
