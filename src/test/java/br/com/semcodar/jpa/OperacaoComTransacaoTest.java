package br.com.semcodar.jpa;

import br.com.semcodar.jpa.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void incluirPrimeiroObjeto(){

        final Produto produto = Produto.builder()
                .id(2)
                .nome("Câmera Canon")
                .descricao("A melhor definição das suas fotos")
                .preco(new BigDecimal(5000))
                .build();

        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();

        manager.clear();

        final Produto produtoVerificacao = manager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
    }
}