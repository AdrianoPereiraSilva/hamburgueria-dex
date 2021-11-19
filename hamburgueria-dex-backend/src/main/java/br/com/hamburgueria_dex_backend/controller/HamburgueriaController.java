package br.com.hamburgueria_dex_backend.controller;

import br.com.hamburgueria_dex_backend.dto.LancheResponseDTO;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lanche")
@AllArgsConstructor
public class HamburgueriaController {

    @Autowired
    private HamburgueriaService hamburgueriaService;

    @GetMapping
    public ResponseEntity<List<LancheResponseDTO>> listarTodosLanches() {
        return ResponseEntity.ok(hamburgueriaService.listarTodosLanches());
    }
}
