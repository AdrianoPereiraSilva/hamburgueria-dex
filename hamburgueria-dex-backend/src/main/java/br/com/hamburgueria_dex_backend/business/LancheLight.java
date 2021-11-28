package br.com.hamburgueria_dex_backend.business;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import br.com.hamburgueria_dex_backend.enums.Promocao;

import java.math.BigDecimal;
import java.util.List;

public class LancheLight extends CalcularDescontoLanches {

    public LancheLight(CalcularDescontoLanches proximo) {
        super(proximo);
    }

    public Cardapio calcular(Cardapio cardapio) {

        for (Lanches lanche : cardapio.getLanches()) {

            List<Ingredientes> ingredientes = lanche.getIngredientes();

            // Light se o Lanche tem alface e nao tem bacon -> desconto de 10%
            if ((ingredientes.stream().filter(i -> i.getNome().equals("Alface")).count() > 0)
                    && (ingredientes.stream().filter(i -> i.getNome().equals("Bacon")).count() == 0)) {

                lanche.setPromocao(Promocao.LIGHT.name());

                BigDecimal novoValor = lanche.getValor().subtract(lanche.getValor().multiply(new BigDecimal("0.1")));
                lanche.setValorAntigo(lanche.getValor());
                lanche.setValor(novoValor);
            }
        }

        return proximo.calcular(cardapio);
    }

}
