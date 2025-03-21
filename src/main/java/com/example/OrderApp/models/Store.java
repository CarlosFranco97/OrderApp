package com.example.OrderApp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tienda")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String storeName;

    @Column(name = "direccion", nullable = false)
    private String storeAddress;

    @Column(name = "telefono", length = 20, nullable = false)
    private String storePhone;

    @Column(name = "categoria", length = 50)
    private String storeCategory;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference
    private List<Order> orders;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference
    private List<Product> products;

    public Store() {
    }

    public Store(Integer id, String storeName, String storeAddress, String storePhone, String storeCategory) {
        this.id = id;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.storeCategory = storeCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = Store.this.storePhone;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = Store.this.storeCategory;
    }
}
