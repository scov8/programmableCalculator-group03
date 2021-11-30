/**
 * @file Controller.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */
package src.main.java.controllers;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.*;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Stack;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
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

    @FXML // fx:id="variableList"
    private ListView<?> variableList; // Value injected by FXMLLoader

    private ObservableList<ComplexNumber> stackValue;


    /**
     * Main stack containing the numbers given in input by the user and the
     * results of the operations.
     */
    private Stack<ComplexNumber> numberStack;


    /**
     * Main instance of Calculator class that handles operations on the
     * numberStack.
     */
    private Calculator calculator;

    /**
     * Number of items from the numberStack to show in the GUI at any time.
     */
    private final int K = 15;

    /**
     * @brief Update the ListView items list.
     * @param newNumber number to push to the stack. It can be `null` to avoid
     *                  adding a new item.
     */
    private void updateStackView(ComplexNumber newNumber) {
        if (newNumber != null)
            numberStack.push(newNumber);

        // Only show the top K elements of the stack.
        int max = numberStack.size();
        int min = max > K ? K : max;
        if (min < 0)
            min = 0;

        stackValue.clear();
        stackValue.setAll(numberStack.subList(max - min, max));
        Collections.reverse(stackValue);

        if (stackValue.size() > 0)
            resultLabel.setText(stackValue.get(0).toString());
        else
            resultLabel.setText("Result here.");
    }

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
     * @brief Read user input, parse it and execute associated functions based
     *        on the input type.
     */
    private void getUserInput() {
        String input = textInput.getText().strip().toLowerCase();
        textInput.clear();
        if (input.length() == 0)
            return;

        ComplexNumber number = null;

        // input is an operation
        if (InputParser.isOperation(input)) {
            try {
                calculator.runOperation(numberStack, input);
                updateStackView(null);
            } catch (NotEnoughOperandsException e) {
                showError("Not enough elements.",
                        "The stack does not contain enough values to execute the '" + input + "' operation.");
            } catch (Exception e) {
                showError("Invalid operation", "Something went wrong...");
            }
        }
        // input is a number
        else {
            number = InputParser.parseNumber(input);
            if (number == null) {
                showError("Invalid Input",
                        "Please provide a valid operation or a number.\nNumbers must be in the form 'a + bi' or 'a' or 'bi'");
                return;
            }
        }
        updateStackView(number);
    }

    /**
     * @brief When ENTER key is pressed, read user input, parse it and execute
     *        associated functions based on the input type.
     * @param event The pressing of the button.
     */
    @FXML
    void onEnterKeyClick(ActionEvent event) {
        getUserInput();
    }

    /**
     * @brief When ENTER button is clicked, read user input, parse it and execute
     *        associated functions based on the input type.
     * @param event The pressing of the button.
     */
    @FXML
    void onEnterButtonClick(ActionEvent event) {
        getUserInput();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'view.fxml'.";
        assert paneRoot != null : "fx:id=\"paneRoot\" was not injected: check your FXML file 'view.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'view.fxml'.";
        assert stack != null : "fx:id=\"stack\" was not injected: check your FXML file 'view.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'view.fxml'.";
        assert variableList != null : "fx:id=\"variableList\" was not injected: check your FXML file 'view.fxml'.";



        stackValue = FXCollections.observableArrayList();   //for the observable List
        numberStack = new Stack<>();                        //for the number of the stak
        stack.setItems(stackValue);
        calculator = new Calculator();
        resultLabel.setText("Result here.");
    }
}
