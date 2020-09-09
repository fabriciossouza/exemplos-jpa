package br.com.semcodar.jpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Produto {

    @Id
    private Integer id;

    private String nome;

    private BigDecimal preco;

    private String descricao;
}
