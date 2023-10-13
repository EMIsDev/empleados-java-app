package com.example.empleados;

import auxClasses.ListItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditWindowController {
    @FXML
    private TextField idField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField clientInfoField;

    private ListItem selectedItem;
    private HelloController mainController;

    public void initData(ListItem item, HelloController mainController) {
        this.selectedItem = item;
        this.mainController = mainController;

        // Populate the fields with the selected item's information
        idField.setText(String.valueOf(item.getId()));
        stateField.setText(item.getState());
        clientInfoField.setText(item.getClientInfo());
    }

    @FXML
    private void handleSave() {
        // Update the selected item with the edited information
        selectedItem.setId(Integer.parseInt(idField.getText()));
        selectedItem.setState(stateField.getText());
        selectedItem.setClientInfo(clientInfoField.getText());

        // Close the edit window
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCancel() {
        // Close the edit window without saving
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }
}
