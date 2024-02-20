package com.ale.application.models;

import java.time.LocalDate;

public class Perro extends Mascota{
    private String raza;

    public Perro(String name, LocalDate birthDate, String raza) {
        super(name, birthDate);
        this.raza = raza;
        super.dormir();
    }
}
