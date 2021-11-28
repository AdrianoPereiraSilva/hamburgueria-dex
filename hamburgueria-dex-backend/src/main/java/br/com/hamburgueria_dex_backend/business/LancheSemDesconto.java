package br.com.hamburgueria_dex_backend.business;

import br.com.hamburgueria_dex_backend.entity.Cardapio;

public class LancheSemDesconto extends CalcularDescontoLanches {

    public LancheSemDesconto(){
        super(null);
    }

    public Cardapio calcular(Cardapio cardapio) {
        return cardapio;
    }
}
