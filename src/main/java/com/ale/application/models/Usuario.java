package com.ale.application.models;

import com.ale.application.controllers.RegistrarseController;

public class Usuario {
    private String nombre;
    private String correo;
    private String matricula;
    private Integer cuatrimestre;
    private String contrasenaOculta;
    private RegistrarseController registrarseController;

    public Usuario(String nombre, String correo, String matricula, Integer cuatrimestre, String contrasenaOculta) {
        this.nombre = nombre;
        this.correo = correo;
        this.matricula = matricula;
        this.cuatrimestre = cuatrimestre;
        this.contrasenaOculta = contrasenaOculta;
        this.registrarseController = registrarseController;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getCuatrimestre() {
        return cuatrimestre;
    }

    public String getContrasenaOculta() {
        return contrasenaOculta;
    }

    public RegistrarseController getRegistrarseController() {
        return registrarseController; // Método para acceder al controlador
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario registrado exitosamente.\n\n" +
                        "Nombre: %s\n" +
                        "Correo: %s\n" +
                        "Matrícula: %s\n" +
                        "Cuatrimestre: %s\n" +
                        "Contraseña: %s",
                nombre,
                correo,
                matricula,
                cuatrimestre,
                contrasenaOculta
        );
    }
}
