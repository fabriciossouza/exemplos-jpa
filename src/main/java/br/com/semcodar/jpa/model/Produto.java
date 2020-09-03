package br.com.semcodar.jpa.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String nome;

    private BigDecimal preco;

    private String descricao;
}
