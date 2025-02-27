package com.example.PedidosApp.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    /*id_restaurante FK*/

    @Column(name = "nombre", length = 100, nullable = false)
    private String productName;

    @Column(name = "precio", nullable = false)
    private BigDecimal productPrice;

    @Column(name = "descripcion")
    private String description;

    public Product() {
    }

    public Product(Integer id, String productName, BigDecimal productPrice, String description) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
