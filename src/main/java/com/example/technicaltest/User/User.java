package com.example.technicaltest.User;

import java.io.Serializable;

import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.*;


@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String bornDate;

    protected User(){ }

    public User(String name, String email, String bornDate) {

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
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBornDate() {
        return this.bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

}



