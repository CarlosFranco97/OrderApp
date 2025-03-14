package com.example.OrderApp.models;

import com.example.OrderApp.helpers.enums.StatusDeliveryEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Entrega")
public class Delivery {

    @Id
    @Column(name = "id_entrega")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_entrega", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateDelivery;

    @Column(name = "estado_entrega", columnDefinition = "VARCHAR(10) DEFAULT 'ASSIGNED'")
    @Enumerated(EnumType.STRING)
    private StatusDeliveryEnum deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "fk_deliveryperson", referencedColumnName = "id")
    @JsonBackReference
    private DeliveryPerson deliveryPerson;

    public Delivery() {
    }

    public Delivery(Integer id, LocalDateTime dateDelivery, StatusDeliveryEnum deliveryStatus) {
        this.id = id;
        this.dateDelivery = dateDelivery;
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDateTime dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public StatusDeliveryEnum getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(StatusDeliveryEnum deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
