package br.com.hamburgueria_dex_backend.repository;

import br.com.hamburgueria_dex_backend.entity.Cardapio;
import br.com.hamburgueria_dex_backend.entity.Ingredientes;
import br.com.hamburgueria_dex_backend.entity.Lanches;
import br.com.hamburgueria_dex_backend.enums.Promocao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class HamburgueriaRepository {

    public Cardapio obterCardapio() {

        List<Ingredientes> ingredientesXBacon = Arrays.asList(
                new Ingredientes("Bacon", new BigDecimal("3"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Queijo",new BigDecimal("1"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXEgg = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXSalada = Arrays.asList(
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Alface", new BigDecimal("3"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesMisto = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("2"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Queijo", new BigDecimal("3"), new BigDecimal("1.50"))
        );

        List<Ingredientes> ingredientesXtudo = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("1"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("2"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("2"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("2"), new BigDecimal("1.50"))
        );

        List<Lanches> LancheEntity = Arrays.asList(
                new Lanches("X-Bacon", ingredientesXBacon),
                new Lanches("X-Egg", ingredientesXEgg),
                new Lanches("Misto", ingredientesMisto),
                new Lanches("X-Tudo", ingredientesXtudo),
                new Lanches("X-Salada", ingredientesXSalada)
        );

        return new Cardapio(LancheEntity);

    }

    public List<Ingredientes> obterTodosIngredientes() {

        List<Ingredientes> ingredientes = Arrays.asList(
                new Ingredientes("Alface", new BigDecimal("1"), new BigDecimal("0.40")),
                new Ingredientes("Bacon", new BigDecimal("1"), new BigDecimal("2.0")),
                new Ingredientes("Hambúrguer de carne", new BigDecimal("1"), new BigDecimal("3.0")),
                new Ingredientes("Ovo", new BigDecimal("1"), new BigDecimal("0.80")),
                new Ingredientes("Queijo", new BigDecimal("1"), new BigDecimal("1.50"))
        );

        return ingredientes;
    }

    public Cardapio calcularValorTotalCardapio(Cardapio cardapio) {

        for (Lanches lanche : cardapio.getLanches()) {
            lanche.setPromocao(calculaTipoPromocaoLanche(lanche.getIngrediente()));
        }

        Cardapio cardapioRetorno = new Cardapio(cardapio.getLanches());

        return cardapioRetorno;
    }

    private String calculaTipoPromocaoLanche(List<Ingredientes> ingredientes) {

        for (Ingredientes ingrediente : ingredientes) {
            // Light se o Lanche tem alface e nao tem bacon -> desconto de 10%
            if ((ingredientes.stream().filter(i -> i.getNome().equals("Alface")).count() > 0)
                    && (ingredientes.stream().filter(i -> i.getNome().equals("Bacon")).count() == 0)) {
                return Promocao.MUITA_CARNE.name();
            }

            // Muita carne se o lanche tiver mais do que 3 porcoes de carne
            // A cada 3 porções o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante
            if (ingrediente.getNome().equals("Bacon") && ingrediente.getQuantidade().compareTo(new BigDecimal("3")) >= 0) {
                return Promocao.MUITA_CARNE.name();
            }

            // Muito queijo se o lanche tiver mais do que 3 porcoes de queijo
            // A cada 3 porções o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante.
            if (ingrediente.getNome().equals("Queijo") && ingrediente.getQuantidade().compareTo(new BigDecimal("3")) >= 0) {
                return Promocao.MUITO_QUEIJO.name();
            }

        }
        return Promocao.SEM_PROMOCAO.name();
    }

}
