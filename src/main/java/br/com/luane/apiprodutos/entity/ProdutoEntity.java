package br.com.luane.apiprodutos.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table (name="tb_produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idProduto")
    private Long id;
    @Column (name = "nome")
    private String nomeProduto;
    @Column (name = "modelo")
    private String modeloProduto;
    @Column (name = "fabricante")
    private String fabricanteProduto;
    @Column (name = "preco")
    private BigDecimal precoProduto;


}
