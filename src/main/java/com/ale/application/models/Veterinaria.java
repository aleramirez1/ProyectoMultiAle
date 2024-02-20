package com.ale.application.models;

import java.util.ArrayList;

public class Veterinaria {
    private ArrayList<Citas> listaCitas = new ArrayList<>();
    private ArrayList<Cliente> clients = new ArrayList<>();

    public boolean addCita(Citas cita){
        return listaCitas.add(cita);
    }
    public boolean updateCitas(Citas cita){return true;}
    public boolean addClient(Cliente client){
        return clients.add(client);
    }
    //public ArrayList<Citas> listCitasForDay(LocalDate date){}
    //public ArrayList<Citas> searchCitasForClient(String name){}

}
