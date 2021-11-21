package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.StartupApplication;
import br.com.hamburgueria_dex_backend.dto.CardapioResponseDTO;
import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StartupApplication.class)
public class HamburgueriaServiceTest {

    @Test
    void quandoLancheTiverCebolaPaoHamburguerBaconValorDoLancheDeveraXX (){

    }

}
