package br.com.hamburgueria_dex_backend.business;

import br.com.hamburgueria_dex_backend.entity.Cardapio;

public abstract class CalcularDescontoLanches {

    protected CalcularDescontoLanches proximo;

    public CalcularDescontoLanches(CalcularDescontoLanches proximo) {
        this.proximo = proximo;
    }

    public abstract Cardapio calcular(Cardapio cardapio);
}
