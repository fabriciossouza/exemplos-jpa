package br.com.semcodar.jpa;

import br.com.semcodar.jpa.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConsultandoRegistroTest {

    private static EntityManagerFactory factory;

    private  EntityManager manager;

    @BeforeClass
    public static void setUpBeforeClass(){
        factory = createEntityManagerFactory("JPA-EDU");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        factory.close();
    }

    @Before
    public  void setUpBefore(){
        manager =  factory.createEntityManager();
    }

    @After
    public void tearDownAfter(){
        manager.close();
    }

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
