package com.example.OrderApp.models;

import com.example.OrderApp.helpers.enums.PaymentMethodEnum;
import com.example.OrderApp.helpers.enums.StatusPayEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Pago")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id;

    @Column(name = "metodo_pago", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @Column(name = "estado", columnDefinition = "VARCHAR(10) DEFAULT 'PENDIENTE'")
    @Enumerated(EnumType.STRING)
    private StatusPayEnum statusPayment;

    @Column(name = "fecha_pago", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateOfPayment;

    @OneToMany(mappedBy = "pay")
    @JsonManagedReference
    private List<Order> orders;



    public Pay(){

    }

    public Pay(Integer id, PaymentMethodEnum paymentMethod, StatusPayEnum statusPayment, LocalDateTime dateOfPayment) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.statusPayment = statusPayment;
        this.dateOfPayment = dateOfPayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public StatusPayEnum getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayEnum statusPayment) {
        this.statusPayment = statusPayment;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}
