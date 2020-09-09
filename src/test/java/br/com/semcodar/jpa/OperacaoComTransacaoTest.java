package br.com.semcodar.jpa;

import br.com.semcodar.jpa.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

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

    @Test
    public void incluirPrimeiroObjetoComMerge(){

        final Produto produto = Produto.builder()
                .id(4)
                .nome("Câmera Canon")
                .descricao("A melhor definição das suas fotos")
                .preco(new BigDecimal(5000))
                .build();

        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();

        manager.clear();

        final Produto produtoVerificacao = manager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjeto(){

        final Produto produto = Produto.builder()
                .id(1)
                .nome("Câmera Canon 2 geração")
                .descricao("A melhor definição das suas fotos")
                .preco(new BigDecimal(5000))
                .build();

        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();

        manager.clear();

        final Produto produtoVerificacao = manager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
        assertEquals("Câmera Canon 2 geração", produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjetoGerenciado(){

        final Produto produto = manager.find(Produto.class, 3);

        //manager.merge(produto);
        produto.setNome("Kindle 2");

        manager.getTransaction().begin();
        manager.getTransaction().commit();

        manager.clear();

        final Produto produtoVerificacao = manager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
        assertEquals("Kindle 2", produtoVerificacao.getNome());
    }


    @Test
    public void removerObjeto(){

        final Produto produto = manager.find(Produto.class, 3);

        manager.getTransaction().begin();
        manager.remove(produto);
        manager.getTransaction().commit();

        final Produto produtoVerificacao = manager.find(Produto.class, produto.getId());
        assertNull(produtoVerificacao);
    }
}