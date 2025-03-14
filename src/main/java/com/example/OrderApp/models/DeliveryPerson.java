package com.example.OrderApp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Repartidor")
public class DeliveryPerson {
    @Id
    @Column(name = "id_repartidor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String deliveryPersonName;

    @Column(name = "telefono", length = 20, nullable = false)
    private String deliveryPersonPhone;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String deliveryPersonEmail;

    @Column(name = "vehiculo", length = 50)
    private String vehicle;

    @OneToMany(mappedBy = "deliveryPerson")
    @JsonManagedReference
    private List<Delivery> deliveries;

    public DeliveryPerson(){

    }

    public DeliveryPerson(Integer id, String deliveryPersonName, String deliveryPersonPhone, String deliveryPersonEmail, String vehicle){
        this.id = id;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryPersonPhone = deliveryPersonPhone;
        this.deliveryPersonEmail = deliveryPersonEmail;
        this.vehicle = vehicle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public String getDeliveryPersonPhone() {
        return deliveryPersonPhone;
    }

    public void setDeliveryPersonPhone(String deliveryPersonPhone) {
        this.deliveryPersonPhone = deliveryPersonPhone;
    }

    public String getDeliveryPersonEmail() {
        return deliveryPersonEmail;
    }

    public void setDeliveryPersonEmail(String deliveryPersonEmail) {
        this.deliveryPersonEmail = deliveryPersonEmail;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}

