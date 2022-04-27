package com.disney.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class UserDTO {
    
    private Long id;
    @Email(message = "must be a valid email")
    private String username;
    @Size(min = 8, message = "the minium characters are eight")
    private String password;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
