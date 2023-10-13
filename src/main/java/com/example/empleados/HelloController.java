package com.example.empleados;

import auxClasses.ListItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button searchButton;
    @FXML
    private Pagination pagination;

    @FXML
    private TableView<ListItem> tableView;
    private ObservableList<ListItem> itemList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<ListItem, Integer>  idColumn;
    @FXML
    private TableColumn<ListItem, String> stateColumn;
    @FXML
    private TableColumn<ListItem, String> clientInfoColumn;
    @FXML
    private TableColumn<ListItem, Void> actionsColumn;

    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onClickSearchButton() {
       // welcomeText.setText("Welcome to JavaFX Application!");
    }



    private static final int ITEMS_PER_PAGE = 10; // Adjust as needed



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize your TableView columns
        idColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2)); // 20% of TableView's width
        stateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3)); // 30% of TableView's width
        clientInfoColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3)); // 50% of TableView's width
        actionsColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2)); // 50% of TableView
        // Initialize your TableView columns
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        clientInfoColumn.setCellValueFactory(cellData -> cellData.getValue().clientInfoProperty());

        // Add a button for each row in the actions column
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");

            {
                editButton.setOnAction(event -> handleEdit(getTableRow().getItem()));
                deleteButton.setOnAction(event -> handleDelete(getTableRow().getItem()));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new HBox(editButton, deleteButton));
                }
            }
        });

        // Initialize your data and add it to the TableView
        tableView.getItems().addAll(
                new ListItem(1, "Active", "Client 1"),
                new ListItem(2, "Inactive", "Client 2"),
                new ListItem(3, "Active", "Client 3")
        );
    }

    @FXML
    private void handleEdit(ListItem item) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditWindow.fxml"));
            Parent root = loader.load();

            EditWindowController editController = loader.getController();
            editController.initData(item, this);

            Stage editStage = new Stage();
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.setTitle("Edit Info");
            editStage.setScene(new Scene(root));
            editStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDelete(ListItem item) {
        System.out.println("Delete: " + item.clientInfoProperty());
    }
}
