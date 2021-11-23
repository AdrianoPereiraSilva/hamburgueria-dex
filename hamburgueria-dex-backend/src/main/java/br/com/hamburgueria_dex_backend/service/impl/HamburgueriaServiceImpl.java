package br.com.hamburgueria_dex_backend.service.impl;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.repository.HamburgueriaRepository;
import br.com.hamburgueria_dex_backend.service.HamburgueriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HamburgueriaServiceImpl implements HamburgueriaService {

    @Autowired
    private HamburgueriaRepository repository;

    public Cardapio obterCardapio () {
        return repository.obterCardapio();
    }

    public List<Ingredientes> obterTodosIngredientes() {
        return repository.obterTodosIngredientes();
    }

    public Cardapio calcularValorTotalCardapio(Cardapio cardapio){
        return repository.calcularValorTotalCardapio(cardapio);
    }
}
