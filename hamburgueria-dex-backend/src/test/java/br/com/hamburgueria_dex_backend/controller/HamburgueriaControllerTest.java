package br.com.hamburgueria_dex_backend.controller;

import br.com.hamburgueria_dex_backend.StartupApplication;
import br.com.hamburgueria_dex_backend.dto.CardapioResponseDTO;
import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StartupApplication.class)
public class HamburgueriaControllerTest {


}
