package com.ale.application.controllers;

import com.ale.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox ClickRecordarmr;

    @FXML
    private Button IngresarButtonIniciarSes;

    @FXML
    private Button atrasButtonIniciarSes;

    @FXML
    private Button closeButton;

    @FXML
    private PasswordField contra1Casilla;

    @FXML
    private TextField matriculaCasilla;

    private Map<String, String> usuariosRegistrados = new HashMap<>(); // Matrícula-Contraseña

    @FXML
    void onClickCerrar(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void onClickClAtras(MouseEvent event) {
        // Implementar lógica para volver a la pantalla anterior
    }

    @FXML
    void onClickClIngresar(MouseEvent event) {
        String matricula = matriculaCasilla.getText();
        String contrasena = contra1Casilla.getText();

        if (usuariosRegistrados.containsKey(matricula) &&
                usuariosRegistrados.get(matricula).equals(contrasena)) {
            try {
                // Redirigir a menu-view.fxml
                App.newStage("home-view", "Menú");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Error", "Matrícula o contraseña incorrecta");
            matriculaCasilla.clear();
            contra1Casilla.clear();
        }
    }

    @FXML
    void onGuardarContra(ActionEvent event) {
        // Lógica para guardar contraseña
    }

    @FXML
    void onGuardarMatricula(ActionEvent event) {
        // Lógica para guardar matrícula
    }

    @FXML
    void initialize() {
        assert ClickRecordarmr != null;
        assert IngresarButtonIniciarSes != null;
        assert atrasButtonIniciarSes != null;
        assert closeButton != null;
        assert contra1Casilla != null;
        assert matriculaCasilla != null;

        // Evitar caracteres no numéricos y limitar a 6 dígitos
        matriculaCasilla.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!Character.isDigit(e.getCharacter().charAt(0)) || matriculaCasilla.getText().length() >= 6) {
                e.consume();
            }
        });

        // Población de usuarios registrados con datos ficticios para pruebas
        usuariosRegistrados.put("123456", "password123"); // Ejemplo
        usuariosRegistrados.put("654321", "password456"); // Ejemplo
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
