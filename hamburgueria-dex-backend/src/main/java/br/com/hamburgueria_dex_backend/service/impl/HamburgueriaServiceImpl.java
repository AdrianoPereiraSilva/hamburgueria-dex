package br.com.hamburgueria_dex_backend.service.impl;

import br.com.hamburgueria_dex_backend.dto.LancheResponseDTO;
import br.com.hamburgueria_dex_backend.repository.HamburgueriaRepository;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HamburgueriaServiceImpl implements HamburgueriaService {

    @Autowired
    private HamburgueriaRepository repository;

    public List<LancheResponseDTO> listarTodosLanches () {
        return repository.listarTodosLanches();
    }
}
