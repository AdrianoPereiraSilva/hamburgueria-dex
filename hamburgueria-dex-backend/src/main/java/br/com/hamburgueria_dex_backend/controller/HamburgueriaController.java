package br.com.hamburgueria_dex_backend.controller;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lanche")
@AllArgsConstructor
public class HamburgueriaController {

    private HamburgueriaService hamburgueriaService;

    @GetMapping
    public ResponseEntity<Cardapio> obterCardapio() {
        return ResponseEntity.ok(hamburgueriaService.obterCardapio());
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<Ingredientes>> obterTodosIngredientes() {
        return ResponseEntity.ok(hamburgueriaService.obterTodosIngredientes());
    }

    @PostMapping
    public ResponseEntity<Cardapio> calcaularValorTotalCardapio(@RequestBody Cardapio cardapio) {
        return ResponseEntity.ok(hamburgueriaService.calcularValorTotalCardapio(cardapio));
    }

}
