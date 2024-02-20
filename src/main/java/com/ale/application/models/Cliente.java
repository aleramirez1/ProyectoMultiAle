package com.ale.application.models;

public class Cliente {
    private int id;
    private String name;
    private String lastName;

    public Cliente(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
