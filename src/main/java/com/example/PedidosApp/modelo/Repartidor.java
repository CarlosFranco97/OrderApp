package com.example.PedidosApp.modelo;

import jakarta.persistence.criteria.CriteriaBuilder;

public class Repartidor {
    private Integer id;
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private String vehiculo;

    public Repartidor(){

    }

    public Repartidor(Integer id, String nombre, String telefono, String correoElectronico, String vehiculo){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.vehiculo = vehiculo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}

