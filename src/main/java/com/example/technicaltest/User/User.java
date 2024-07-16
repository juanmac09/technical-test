package com.example.technicaltest.User;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;
import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.*;
import jakarta.validation.constraints.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.Date;


@Validated
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @Past
    @NotNull
    @Column(nullable = false)
    private Date bornDate;

    protected User(){ }

    public User(String name, String email, Date bornDate) {
        this.setName(name);
        this.setEmail(email);
        this.setBornDate(bornDate);
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
    public Date getBornDate() {
        return this.bornDate;
    }


    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }


}



