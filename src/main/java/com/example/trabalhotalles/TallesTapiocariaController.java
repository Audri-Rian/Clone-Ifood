package com.example.trabalhotalles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TallesTapiocariaController {

    @FXML
    private Spinner<Integer> mySpinner;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Item> myTableView;

    @FXML
    private TableColumn<Item, String> productNameColumn;

    @FXML
    private TableColumn<Item, Integer> quantityColumn;

    @FXML
    private TableColumn<Item, Double> priceColumn;

    @FXML
    private Label productLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Button removeButton;

    private final ObservableList<Item> tableData = FXCollections.observableArrayList();

    private final double unitPrice = 12.00; // Preço unitário

    @FXML
    public void initialize() {
        // Configurar o Spinner
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        mySpinner.setValueFactory(valueFactory);

        // Configurar as colunas da tabela
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Configurar os dados da tabela
        myTableView.setItems(tableData);


        // Configurar a ação do botão
        addButton.setOnAction(event -> {
            String productName = abbreviateName(productLabel.getText()); // Obtém e possivelmente abrevia o nome
            int spinnerValue = mySpinner.getValue();
            double totalPrice = spinnerValue * unitPrice;
            tableData.add(new Item(productName, spinnerValue, totalPrice));
            calculateTotal(); // Atualiza o total após adicionar um item
        });
    }

    private String abbreviateName(String name) {
        // Abrevia nomes com mais de 20 caracteres
        return name.length() > 20 ? name.substring(0, 17) + "..." : name;
    }

    private void calculateTotal() {
        double total = tableData.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        totalLabel.setText(String.format("R$ %.2f", total));
    }

    // Classe interna Item
    public static class Item {
        private final String productName;
        private final Integer quantity;
        private final Double price;

        public Item(String productName, Integer quantity, Double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Double getPrice() {
            return price;
        }
    }
}
