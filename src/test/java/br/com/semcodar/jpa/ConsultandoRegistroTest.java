package br.com.semcodar.jpa;

import br.com.semcodar.jpa.model.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConsultandoRegistroTest extends EntityManagerTest {

    @Test
    public void buscarProdutoPorIdentificador(){

        //var produto = manager.find(Produto.class, 1);
        var produto = manager.getReference(Produto.class, 1);

        assertNotNull(produto);
        assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarProdutoPorIdentificador(){

        var produto = manager.find(Produto.class, 1);

        produto.setNome("Android");

        manager.refresh(produto);

        assertEquals("Kindle", produto.getNome());
    }
}
