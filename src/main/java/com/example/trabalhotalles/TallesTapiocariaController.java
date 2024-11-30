package com.example.trabalhotalles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TallesTapiocariaController {

    @FXML
    private TableView<?> myTableView;

    @FXML
    private TableColumn<?, ?> menu_col_name;

    @FXML
    private TableColumn<?, ?> menu_col_quantity;

    @FXML
    private TableColumn<?, ?> menu_col_price;

    @FXML
    private Label menu_total;

    @FXML
    private Label menu_troco;

    @FXML
    private TextField menu_payment;

    @FXML
    private Button menu_carrinho;

    @FXML
    private Button menu_removeBTN;

    @FXML
    private ScrollPane menu_scrollPane;

    @FXML
    private GridPane menu_gridPane;

}
