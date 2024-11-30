package com.example.trabalhotalles;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usarnameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {
        if (!usarnameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Por favor, coloque o usuário e a senha!");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE Usarname = ? AND Password = ?";

        try {
            var preparedStatement = connectionDB.prepareStatement(verifyLogin);
            preparedStatement.setString(1, usarnameTextField.getText());
            preparedStatement.setString(2, passwordPasswordField.getText());
            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next() && queryResult.getInt(1) == 1) {
                loginMessageLabel.setText("Bem-vindo! ");

                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> {
                    try {
                        Stage stage = (Stage) loginMessageLabel.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("Ifood.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                pause.play(); // Inicia o atraso
            } else {
                loginMessageLabel.setText("Login inválido. Tente novamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            loginMessageLabel.setText("Erro ao conectar ao banco.");
        }
    }
}
