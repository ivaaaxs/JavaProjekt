package com.example.skladiste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label infoLabel;

    @FXML
    void onLoginClicked(ActionEvent event) throws IOException{
        if (username.getText().equalsIgnoreCase("ulaz") && password.getText().equalsIgnoreCase("ulaz")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } else {
            infoLabel.setText("Krivo korisnicko ime ili lozinka");
        }
    }
}


