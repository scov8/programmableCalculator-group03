package src.main.java.controllers;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
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
import javafx.scene.layout.AnchorPane;

/**
 * @file FXMLController.java
 * @author Luigi Scovotto
 * @date 22 Nov 2021
 */

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

    @FXML // fx:id="stackListView"
    private ListView<ComplexNumber> stackListView; // Value injected by FXMLLoader

    @FXML // fx:id="textInput"
    private TextField textInput; // Value injected by FXMLLoader

    @FXML // fx:id="variableListView1"
    private ListView<String> variableListView1; // Value injected by FXMLLoader

    @FXML // fx:id="variableListView2"
    private ListView<String> variableListView2; // Value injected by FXMLLoader

    private ObservableList<ComplexNumber> stackList;

    private ObservableList<String> variablesList1;
    private ObservableList<String> variablesList2;

    /**
     * Class containing methods to recognize strings taken in input as either a
     * number or an operation.
     */
    private TextRecognizer textRecognizer;

    /**
     * Main stack containing the numbers given in input by the user and the
     * results of the operations.
     */
    private Stack<ComplexNumber> numbersStack;

    /**
     * Main instance of Calculator class that handles operations on the
     * numbersStack.
     */
    private Calculator calculator;

    /**
     * Instance of variables list.
     */
    private Variables variables;

    private VariablesStack varStack;

    /**
     * Number of items from the numbersStack to show in the GUI at any time.
     */
    private final int K = 15;

    /**
     * @brief Update the ListView containing the stack of complex numbers.
     */
    private void updateStackView() {
        // Only show the top K elements of the stack.
        int max = numbersStack.size();
        int min = max > K ? max - K : 0;

        stackList.clear();
        stackList.setAll(numbersStack.subList(min, max));
        Collections.reverse(stackList);

        if (stackList.size() > 0)
            resultLabel.setText(stackList.get(0).toString());
        else
            resultLabel.setText("Result here.");
    }

    /**
     * @brief Update the ListView containing the stack of variables.
     */
    private void updateVariablesView() {
        String alphabet1 = "abcdefghijklm";
        String alphabet2 = "nopqrstuvwxyz";

        variablesList1.clear();
        variablesList2.clear();

        // for every letter of the alphabet, get its name and its value. Only
        // variables having a non-null value will be displayed.
        for (int i = 0; i < alphabet1.length(); i++) {
            char letter1 = alphabet1.charAt(i);
            ComplexNumber value1 = variables.get(letter1);
            if (value1 != null) {
                String curr1 = letter1 + ":\t" + value1.toString();
                variablesList1.add(curr1);
            }

            char letter2 = alphabet2.charAt(i);
            ComplexNumber value2 = variables.get(letter2);
            if (value2 != null) {
                String curr2 = letter2 + ":\t" + value2.toString();
                variablesList2.add(curr2);
            }
        }
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
        String input = textInput.getText();
        textInput.clear();

        input = textRecognizer.formatText(input);
        if (input.length() == 0)
            return;

        // If input is an operation to execute on the Numbers stack.
        if (textRecognizer.isStackOperation(input)) {
            try {
                calculator.runStackOperation(numbersStack, input);
                updateStackView();
            } catch (NotEnoughOperandsException e) {
                showError("Not enough elements.",
                        "The stack does not contain enough values to execute the '" + input + "' operation.");
            } catch (IndeterminateFormException e) {
                showError("Invalid operation.", "The '" + input + "' operation resulted in an indeterminate form.");
            } catch (VariableWithoutValueException e) {
                showError("Variable without value.", "The variable has no value yet.");
            }
        }
        // If input is an operation to execute on the Variables.
        else if (textRecognizer.isVariableOperation(input)) {
            calculator.runVariablesOperation(variables, numbersStack, input);
            updateStackView();
            updateVariablesView();
        }
        // If input is an operation to execute on the stack storing multiple
        // values of Variables.
        else if (textRecognizer.isVariableStorageOperation(input)) {
            calculator.runVariableStorageOperation(variables, varStack, input);
            updateVariablesView();
        }
        // If input is a number.
        else {
            ComplexNumber number = textRecognizer.extractNumber(input);
            if (number == null) {
                showError("Invalid Input",
                        "Please provide a valid operation or a number.\nNumbers must be in the form 'a + bi' or 'a' or 'bi'");
                return;
            }
            numbersStack.push(number);
            updateStackView();
        }
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
        assert stackListView != null : "fx:id=\"stackListView\" was not injected: check your FXML file 'view.fxml'.";
        assert variableListView1 != null : "fx:id=\"variableListView1\" was not injected: check your FXML file 'view.fxml'.";
        assert variableListView2 != null : "fx:id=\"variableListView2\" was not injected: check your FXML file 'view.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'view.fxml'.";

        stackList = FXCollections.observableArrayList();
        variablesList1 = FXCollections.observableArrayList();
        variablesList2 = FXCollections.observableArrayList();

        stackListView.setItems(stackList);
        variableListView1.setItems(variablesList1);
        variableListView2.setItems(variablesList2);

        numbersStack = new Stack<>();
        textRecognizer = new TextRecognizer();
        calculator = new Calculator();
        variables = new Variables();
        varStack = new VariablesStack();

        resultLabel.setText("Result here.");
        updateVariablesView();
    }
}
