package br.com.hamburgueria_dex_backend.business;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import br.com.hamburgueria_dex_backend.enums.Promocao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LancheMuitoQueijo extends CalcularDescontoLanches {

    public LancheMuitoQueijo(CalcularDescontoLanches proximo) {
        super(proximo);
    }

    public Cardapio calcular(Cardapio cardapio) {

        for (Lanches lanche : cardapio.getLanches()) {
            List<Ingredientes> ingredientes = lanche.getIngredientes();

            for (Ingredientes ingrediente : ingredientes) {

                // Muito queijo se o lanche tiver mais do que 3 porcoes de queijo
                // A cada 3 porções o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante.
                if (ingrediente.getNome().equals("Queijo") && ingrediente.getQuantidade().compareTo(new BigDecimal("3")) >= 0) {

                    lanche.setPromocao(Promocao.MUITO_QUEIJO.name());

                    lanche.setValorAntigo(
                            ingredientes.stream().map(
                                    ingred -> ingred.getValorTotal()).reduce(BigDecimal.ZERO, BigDecimal::add)
                    );

                    BigDecimal novaQuantidade = (ingrediente.getQuantidade()
                            .divide(new BigDecimal("3"), RoundingMode.UP))
                            .subtract(ingrediente.getQuantidade()).abs();

                    ingrediente.setQuantidade(novaQuantidade);

                    ingrediente.setValorTotal(ingrediente.getQuantidade().multiply(ingrediente.getValorUnitario()));

                    lanche.setValor(
                            ingredientes.stream().map(
                                    ingred -> ingred.getValorTotal()).reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                }
            }
        }

        return proximo.calcular(cardapio);
    }
}
