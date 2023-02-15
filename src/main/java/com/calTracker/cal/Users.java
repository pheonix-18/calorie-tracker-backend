package com.calTracker.cal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    private int id;

    private String email;
    private String password;

    public Users() {
    }
    //constructor with email and password
    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    //Generate Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // toString method
    @Override
    public String toString() {
        return "Users [email=" + email + ", id=" + id + ", password=" + password + "]";
    }
    
}
