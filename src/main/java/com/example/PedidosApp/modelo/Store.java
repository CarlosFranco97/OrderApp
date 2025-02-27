package com.example.PedidosApp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Tienda")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String name;

    @Column(name = "direccion", nullable = false)
    private String address;

    @Column(name = "telefono", length = 20, nullable = false)
    private String phone;

    @Column(name = "categoria", length = 50)
    private String category;

    public Store() {
    }

    public Store(Integer id, String name, String address, String phone, String category) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Store.this.category;
    }
}
