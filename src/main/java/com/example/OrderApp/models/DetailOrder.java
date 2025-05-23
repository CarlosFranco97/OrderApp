package com.example.OrderApp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DetallePedido")
public class DetailOrder {
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Integer quantityOrder;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subTotalOrder;

    @OneToMany(mappedBy = "detailOrder")
    @JsonManagedReference(value = "detailOrder-orders")
    private List<Order> orders;

    @OneToMany(mappedBy = "detailOrder")
    @JsonManagedReference(value = "detailOrder-products")
    private List<Product> products;


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
