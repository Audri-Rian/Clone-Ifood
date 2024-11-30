package com.example.trabalhotalles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IfoodController {

    public void Restaurant(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Restaurant.fxml"));
            Parent novoLayout = loader.load();


            Stage novoStage = new Stage();
            novoStage.setTitle("Novo Layout");
            novoStage.setScene(new Scene(novoLayout));
            novoStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
