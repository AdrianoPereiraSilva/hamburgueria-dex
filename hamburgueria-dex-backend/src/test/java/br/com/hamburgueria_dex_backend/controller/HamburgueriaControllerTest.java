package br.com.hamburgueria_dex_backend.controller;

import br.com.hamburgueria_dex_backend.StartupApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StartupApplication.class)
public class HamburgueriaControllerTest {


}
