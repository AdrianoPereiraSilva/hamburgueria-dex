package br.com.hamburgueria_dex_backend.service;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;

import java.util.List;

public interface HamburgueriaService {
    Cardapio obterCardapio ();
    List<Ingredientes> obterTodosIngredientes();
    Cardapio calcularValorTotalCardapio(Cardapio cardapio);
}
