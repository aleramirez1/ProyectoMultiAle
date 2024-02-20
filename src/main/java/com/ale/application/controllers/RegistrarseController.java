package com.ale.application.controllers;

import com.ale.application.App;
import com.ale.application.models.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.net.URL;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

public class RegistrarseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField casillaCorreo;

    @FXML
    private TextField casillaMatricula;

    @FXML
    private TextField casillaNombre;

    @FXML
    private PasswordField casillacontra1;

    @FXML
    private PasswordField casillacontra2;

    @FXML
    private ComboBox<Integer> cuatrimestrocombo;

    @FXML
    private Button exitButton;

    @FXML
    private Button exitButton1;

    private HashSet<String> matriculasRegistradas = new HashSet<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>(); // Lista para almacenar instancias de Usuario

    @FXML
    void onclickcerrarboton(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void onclickdarsedealtaboton(MouseEvent event) {
        if (casillaCorreo.getText().isEmpty() ||
                casillaMatricula.getText().isEmpty() ||
                casillaNombre.getText().isEmpty() ||
                casillacontra1.getText().isEmpty() ||
                casillacontra2.getText().isEmpty()) {
            showAlert("Error", "Por favor, complete todos los campos.");
            return;
        }

        if (!casillacontra1.getText().equals(casillacontra2.getText())) {
            showAlert("Error", "Las contraseñas no coinciden.");
            return;
        }

        String matricula = casillaMatricula.getText();

        if (matriculasRegistradas.contains(matricula)) {
            showAlert("Error", "La matrícula ya está registrada. Por favor, use otra.");
            return;
        } else {
            matriculasRegistradas.add(matricula);
        }

        String correo = casillaCorreo.getText();
        String nombre = casillaNombre.getText();
        Integer cuatrimestre = cuatrimestrocombo.getValue();
        String contrasenaOculta = ".".repeat(casillacontra1.getText().length());

        Usuario usuario = new Usuario(nombre, correo, matricula, cuatrimestre, contrasenaOculta);
        usuarios.add(usuario);

        System.out.println(usuario);

        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Registro exitoso");
        successAlert.setHeaderText(null);
        successAlert.setContentText(usuario.toString());

        successAlert.setOnHidden(e -> {
            try {
                App.newStage("home-view", "Home");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        successAlert.showAndWait();
    }

    @FXML
    void onclickrecordarme(MouseEvent event) {
        String matricula = casillaMatricula.getText();

        if (matriculasRegistradas.contains(matricula)) {
            showAlert("Advertencia", "La matrícula ya ha sido ingresada anteriormente.");
        } else {
            showAlert("Información", "Esta matrícula no ha sido ingresada antes.");
        }
    }

    @FXML
    void onguardarCuatri(ActionEvent event) {
        // Lógica para guardar cuatrimestre
    }

    @FXML
    void onguardarMatricula(ActionEvent event) {
        // Lógica para guardar matrícula
    }

    @FXML
    void onguardarNombre(ActionEvent event) {
        // Lógica para guardar nombre
    }

    @FXML
    void initialize() {
        assert casillaCorreo != null : "fx:id=\"casillaCorreo\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert casillaMatricula != null : "fx:id=\"casillaMatricula\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert casillaNombre != null : "fx:id=\"casillaNombre\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert casillacontra1 != null : "fx:id=\"casillacontra1\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert casillacontra2 != null : "fx:id=\"casillacontra2\" was not injected: check your FXML file 'registrarse-view.fxml'.";

        for (int i = 1; i <= 10; i++) {
            cuatrimestrocombo.getItems().add(i);
        }

        casillaMatricula.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!Character.isDigit(e.getCharacter().charAt(0)) || casillaMatricula.getText().length() >= 6) {
                e.consume();
            }
        });

        casillaNombre.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (Character.isDigit(e.getCharacter().charAt(0))) {
                e.consume();
            }
        });

        casillaCorreo.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!casillaCorreo.getText().endsWith("@ids.upchiapas.edu.mx")) {
                    showAlert("Error", "El correo debe terminar en @ids.upchiapas.edu.mx");
                    casillaCorreo.clear();
                }
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
