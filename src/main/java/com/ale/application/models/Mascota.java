package com.ale.application.models;

import java.time.LocalDate;

public class Mascota {
    protected String name;
    protected LocalDate birthDate;

    public Mascota() {
    }

    public Mascota(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String dormir(){
        return "Estoy durmiendo";
    }
}
