/**
 * @file Controller.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */
package src.main.java.controllers;

import src.main.java.resources.*;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="enter"
    private Button enter; // Value injected by FXMLLoader

    @FXML // fx:id="paneRoot"
    private AnchorPane paneRoot; // Value injected by FXMLLoader

    @FXML // fx:id="resultLabel"
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML // fx:id="stack"
    private ListView<ComplexNumber> stack; // Value injected by FXMLLoader

    @FXML // fx:id="textInput"
    private TextField textInput; // Value injected by FXMLLoader

    private ObservableList<ComplexNumber> stackValue;
    private MyStack<ComplexNumber> numberStack;

    /**
     * @brief Show error alert dialog box.
     * @param header  Header text to display.
     * @param content Content text to display.
     */
    private void showError(String header, String content) {
        Alert alert = new Alert(AlertType.ERROR, "ERROR!", ButtonType.OK);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setResizable(false);
        alert.showAndWait();
    }

    /**
     * @brief When ENTER button is pressed, read user input, parse it and execute
     *        associated functions based on the input type.
     * @param event The pressing of the button.
     */
    @FXML
    void submitEnter(ActionEvent event) {
        String input = textInput.getText();
        textInput.clear();
        if (InputParser.isOperation(input)) {
            // TODO: execute operation.
        } else {
            ComplexNumber number = InputParser.parseNumber(input);
            if (number == null) {
                showError("Invalid Input",
                        "Please provide a valid operation or a number.\nNumbers must be in the form 'a + bi' or 'a' or 'bi'");
            } else {
                numberStack.push(number);
                stackValue.add(number);
            }
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert paneRoot != null : "fx:id=\"paneRoot\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert stack != null : "fx:id=\"stack\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";

        stackValue = FXCollections.observableArrayList();
        numberStack = new MyStack<>();
        stack.setItems(stackValue);
    }

}
