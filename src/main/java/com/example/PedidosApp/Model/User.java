package com.example.PedidosApp.Model;

import com.example.PedidosApp.helpers.enums.UserEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String userName;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String userEmail;

    @Column(name = "contraseña", nullable = false)
    private String userPassword;

    @Column(name = "telefono", length = 20)
    private String userPhone;

    @Column(name = "tipo_usuario", nullable = false)
    private UserEnum userType;

    public void Usuario(){

    }

    public User(){

    }
    public User(Integer id, String userName, String userEmail, String userPassword, String userPhone, UserEnum userType) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = User.this.userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public UserEnum getUserType() {
        return userType;
    }

    public void setUserType(UserEnum userType) {
        this.userType = userType;
    }
}
