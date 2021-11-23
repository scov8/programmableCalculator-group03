/**
 * @file Controller.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */
package src.main.java.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private ListView<?> stack; // Value injected by FXMLLoader

    @FXML // fx:id="textInput"
    private TextField textInput; // Value injected by FXMLLoader

    @FXML
    void submitEnter(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert paneRoot != null : "fx:id=\"paneRoot\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert stack != null : "fx:id=\"stack\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'FXMLDocumentController.fxml'.";

    }

}