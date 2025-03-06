package com.example.OrderApp.models;

import com.example.OrderApp.helpers.enums.OrderEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    /* id_user FK*/

    /* id_store FK */

    @Column(name = "estado", columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    @Enumerated(EnumType.STRING)
    private OrderEnum orderStatus;

    @Column(name = "fecha_pedido", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private BigDecimal total;

    public Order(){

    }

    public Order(Integer id, BigDecimal total, LocalDateTime orderDate, OrderEnum orderStatus) {
        this.id = id;
        this.total = total;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
