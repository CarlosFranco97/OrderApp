package com.example.OrderApp.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DetallePedido")
public class DetailOrder {
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /* detalle pedido fk */
    /* detalle producto fk */

    @Column(name = "cantidad", nullable = false)
    private Integer quantityOrder;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subTotalOrder;

    public DetailOrder(){

    }

    public DetailOrder(Integer id, Integer quantityOrder, BigDecimal subTotalOrder){
        this.id = id;
        this.quantityOrder = quantityOrder;
        this.subTotalOrder = subTotalOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public BigDecimal getSubTotalOrder() {
        return subTotalOrder;
    }

    public void setSubTotalOrder(BigDecimal subTotalOrder) {
        this.subTotalOrder = subTotalOrder;
    }
}
