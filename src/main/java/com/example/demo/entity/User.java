package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "BiceUser")
public class User extends  Auditable{


    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column
    private String name;

    @Setter
    @Getter
    @Column
    @Pattern(regexp = "^[a-zA-Z]+@dominio\\.cl$", message = "Correo electrónico no válido")
    private String email;

    @Column
    private String password;

    @Setter
    @Getter
    @Column(name = "lastLogin")
    private java.time.LocalDateTime lastLogin;

    @Setter
    @Getter
    @Column(name = "token")
    private String token;

    @Setter
    @Getter
    private Boolean isActive;

    @Setter
    @Getter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Phone> phones = new ArrayList<Phone>();


    public User(List<Phone> phones) {
        this.phones = phones;
    }

    public User(Long id, String name, String email, String password, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(List<Phone> phones, String name, String email) {
        this.email = email;
        this.name = name;
        this.phones = phones;


    }

    public User() {

    }
}
