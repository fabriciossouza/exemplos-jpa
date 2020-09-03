package br.com.semcodar.jpa.util;

import br.com.semcodar.jpa.model.Produto;

import static java.lang.System.out;
import static javax.persistence.Persistence.createEntityManagerFactory;

public class UnidadeDePersistencia {

    public static void main(String...args) {

        final var entityManagerFactory = createEntityManagerFactory("JPA-EDU");
        final var entityManager = entityManagerFactory.createEntityManager();

        final var produto = entityManager.find(Produto.class, 1);
        out.println(produto.getNome());

        entityManager.close();
        entityManagerFactory.close();
    }
}
