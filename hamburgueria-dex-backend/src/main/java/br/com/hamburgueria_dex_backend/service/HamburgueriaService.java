package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.dto.LancheResponseDTO;

import java.util.List;

public interface HamburgueriaService {
    List<LancheResponseDTO> listarTodosLanches ();
}
