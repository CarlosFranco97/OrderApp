package com.example.PedidosApp.modelo;

import com.example.PedidosApp.ayudas.enums.UsuarioEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nombre", length = 100, unique = true, nullable = false)
    private String name;
    private String email;
    @Column(name = "contraseña")
    private String password;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "tipo_usuario")
    private UsuarioEnum type;

    public void Usuario(){

    }

    public User(){

    }
    public User(Integer id, String nombre, String correoElectronico, String contraseña, String telefono, UsuarioEnum tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
