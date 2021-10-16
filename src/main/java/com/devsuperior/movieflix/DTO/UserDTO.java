package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
