package com.example.OrderApp.services;

import com.example.OrderApp.models.User;
import com.example.OrderApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    //Listar los metodos que activaran
    //Las consultas en la BD

    //Guardar
    public User createUser(User user) throws Exception {
        try {
            //validar los datos de entrada
            return this.repository.save(user);
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //buscar todos los registros
    public List<User> getAllUsers() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public User getUserById(Integer id) throws Exception {
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()) {
                return searchedUser.get();
            } else {
                throw new Exception("El usuario no fue encontrado en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public User modifyUser(Integer id, User updatedUser) throws Exception{
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if(searchedUser.isPresent()){
                searchedUser.get().setUserPhone(updatedUser.getUserPhone());
                searchedUser.get().setUserEmail(updatedUser.getUserEmail());
                return this.repository.save(searchedUser.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id

    public boolean deleteUserById(Integer id) throws Exception{
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if(searchedUser.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
