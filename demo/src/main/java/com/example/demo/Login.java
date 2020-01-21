package com.example.demo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Login")

public class Login {

    @Id
 
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;



    private String username;

    private String password;



    public Login() {  }



    public Login(String username, String password) {

        this.setUsername(username);

        this.setPassword(password);

    }



    public Login(int id, String username, String password) {

        this.setId(id);

        this.setUsername(username);

        this.setPassword(password);

    }



    public int getId() {

        return id;

    }



    public void setId(int id) {

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



    @Override

    public String toString() {

        return "Login{" +

                "id=" + id +

                ", username='" + username + '\'' +

                ", password='" + password + '\'' +

                '}';

    }

}