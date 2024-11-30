package com.example.trabalhotalles;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantController implements Initializable {

    @FXML
    private ListView<String> myListView;

    String[] restaurantes ={"TallesTapiocaria", "AudriChurrascaria","PedroFelixRestaurantLGBT"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(restaurantes);

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    openNewWindow(newValue);
                }
            }
        });
    }

    private void openNewWindow(String selectedItem) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            String fxmlFile = getFXMLFile(selectedItem);
            if (fxmlFile != null) {
                Parent root = fxmlLoader.load(getClass().getResource(fxmlFile).openStream());
                Stage stage = new Stage();
                stage.setTitle("Detalhes - " + selectedItem);
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFXMLFile(String selectedItem) {

        switch (selectedItem) {
            case "TallesTapiocaria":
                return "TallesTapiocaria.fxml";
            case "AudriChurrascaria":
                return "AudriChurrascaria.fxml";
            case "PedroFelixRestaurantLGBT":
                return "PedroFelixRestaurantLGBT.fxml";
            default:
                return null;
        }
    }


}
