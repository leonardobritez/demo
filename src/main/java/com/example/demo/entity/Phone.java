package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;


@Entity
public class Phone {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private String cityCode;

    @Column
    private String contryCode;

    public Phone() {
    }



    public Phone(String number, String cityCode, String contryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.contryCode = contryCode;
    }
}
