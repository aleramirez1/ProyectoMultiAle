package com.ale.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Citas {
    private int id;
    private LocalDate date;
    private LocalTime hour;
    private Mascota namePet;
    private Cliente client;

    public Citas(LocalDate date, LocalTime hour, Mascota namePet, Cliente client) {
        //this.id = ?
        this.date = date;
        this.hour = hour;
        this.namePet = namePet;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "id=" + id +
                ", date=" + date +
                ", hour=" + hour +
                ", pet=" + namePet.getName() +
                ", client=" + client.getName() +
                '}';
    }
}
