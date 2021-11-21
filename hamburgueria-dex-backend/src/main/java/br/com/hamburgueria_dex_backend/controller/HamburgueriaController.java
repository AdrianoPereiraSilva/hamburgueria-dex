package br.com.hamburgueria_dex_backend.controller;

import br.com.hamburgueria_dex_backend.dto.CardapioResponseDTO;
import br.com.hamburgueria_dex_backend.dto.IngredienteResponseDTO;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lanche")
@AllArgsConstructor
public class HamburgueriaController {

    private HamburgueriaService hamburgueriaService;

    @GetMapping
    public ResponseEntity<CardapioResponseDTO> obterCardapio() {
        return ResponseEntity.ok(hamburgueriaService.obterCardapio());
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredienteResponseDTO>> obterTodosIngredientes() {
        return ResponseEntity.ok(hamburgueriaService.obterTodosIngredientes());
    }

}
