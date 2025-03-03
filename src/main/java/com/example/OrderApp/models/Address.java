package com.example.OrderApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Direccion")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer id;
    /* id user fk */

    @Column(name = "calle", nullable = false)
    private String street;

    @Column(name = "ciudad", length = 100, nullable = false)
    private String city;

    @Column(name = "codigo_postal", length = 20, nullable = false)
    private String postCode;

    @Column(name = "pais", length = 50, nullable = false)
    private String country;

    public Address() {
    }

    public Address(Integer id, String street, String city, String postCode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
