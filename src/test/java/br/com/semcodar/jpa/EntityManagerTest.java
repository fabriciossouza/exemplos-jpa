package br.com.semcodar.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class EntityManagerTest {

    protected static EntityManagerFactory factory;

    protected  EntityManager manager;

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

}
