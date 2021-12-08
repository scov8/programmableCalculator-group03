package src.main.java.controllers;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.OperationsMap;
import src.main.java.resources.*;
import src.main.java.userOperations.UserOperation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneRoot"
    private AnchorPane paneRoot; // Value injected by FXMLLoader

    @FXML // fx:id="mainPane"
    private Pane mainPane; // Value injected by FXMLLoader

    @FXML // fx:id="textInput"
    private TextField textInput; // Value injected by FXMLLoader

    @FXML // fx:id="enter"
    private Button enter; // Value injected by FXMLLoader

    @FXML // fx:id="resultLabel"
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML // fx:id="stackListLabel"
    private Label stackListLabel; // Value injected by FXMLLoader

    @FXML // fx:id="numbersStackSelector"
    private Button numbersStackSelector; // Value injected by FXMLLoader

    @FXML // fx:id="variablesStackSelector"
    private Button variablesStackSelector; // Value injected by FXMLLoader

    @FXML // fx:id="stackListView"
    private ListView<String> stackListView; // Value injected by FXMLLoader

    private boolean stackShowsNumbers;

    private ObservableList<String> stackList;
    private ObservableList<UserOperation> operationsList;

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

    private OperationsMap operationsMap;

    /**
     * Number of items from the numbersStack to show in the GUI at any time.
     */
    private final int K = 15;

    /**
     * @brief Update the ListView containing the stack of complex numbers.
     */
    private void updateNumbersStackView() {
        // Only show the top K elements of the stack.
        int max = numbersStack.size();
        int min = max > K ? max - K : 0;

        stackList.clear();
        for (ComplexNumber n : numbersStack.subList(min, max))
            stackList.add(n.toString());
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
        stackList.clear();

        // for every letter of the alphabet, get its name and its value. Only
        // variables having a non-null value will be displayed.
        for (char letter = 'a'; letter <= 'z'; letter++) {
            ComplexNumber value = variables.get(letter);
            if (value != null) {
                String s = letter + ":\t" + value.toString();
                stackList.add(s);
            }
        }
    }

    private void updateStackView() {
        if (stackShowsNumbers)
            updateNumbersStackView();
        else
            updateVariablesView();
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
                selectedNumbersStack(null);
            } catch (NotEnoughOperandsException e) {
                showError("Not enough elements.",
                        "The stack does not contain enough values to execute the '" + input + "' operation.");
            } catch (IndeterminateFormException e) {
                showError("Invalid operation.", "The '" + input + "' operation resulted in an indeterminate form.");
            }
        }
        // If input is an operation to execute on the Variables.
        else if (textRecognizer.isVariableOperation(input)) {
            try {
                calculator.runVariablesOperation(variables, numbersStack, input);
                selectedVariablesStack(null);
            } catch (NotEnoughOperandsException e) {
                showError("Not enough elements.",
                        "The stack does not contain enough values to execute the '" + input + "' operation.");
            } catch (VariableWithoutValueException e) {
                showError("Variable without value.", "The variable has no value yet.");
            }
        }
        // If input is an operation to execute on the stack storing multiple
        // values of Variables.
        else if (textRecognizer.isVariableStorageOperation(input)) {
            try {
                calculator.runVariableStorageOperation(variables, varStack, input);
                selectedVariablesStack(null);
            } catch (NotEnoughOperandsException e) {
                showError("Not enough elements.",
                        "The stack does not contain enough values to execute the '" + input + "' operation.");
            } catch (VariableWithoutValueException e) {
                showError("Variable without value.", "The variable has no value yet.");
            }
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
            selectedNumbersStack(null);
        }
    }

    /**
     * @brief When ENTER key is pressed, read user input, parse it and execute
     *        associated functions based on the input type.
     * @param event The pressing of the button.
     */
    @FXML
    private void onEnterKeyClick(ActionEvent event) {
        getUserInput();
    }

    /**
     * @brief When ENTER button is clicked, read user input, parse it and execute
     *        associated functions based on the input type.
     * @param event The pressing of the button.
     */
    @FXML
    private void onEnterButtonClick(ActionEvent event) {
        getUserInput();
    }

    @FXML
    private void selectedNumbersStack(ActionEvent event) {
        if (!stackShowsNumbers) {
            variablesStackSelector.setOpacity(0.6);
            numbersStackSelector.setOpacity(1);
            stackShowsNumbers = true;
            stackListLabel.setText("Numbers Stack");
        }
        updateStackView();
    }

    @FXML
    private void selectedVariablesStack(ActionEvent event) {
        if (stackShowsNumbers) {
            variablesStackSelector.setOpacity(1);
            numbersStackSelector.setOpacity(0.6);
            stackShowsNumbers = false;
            stackListLabel.setText("Variables Stack");
        }
        updateStackView();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    private void initialize() {
        assert paneRoot != null : "fx:id=\"paneRoot\" was not injected: check your FXML file 'view.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'view.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'view.fxml'.";
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'view.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'view.fxml'.";
        assert stackListLabel != null : "fx:id=\"stackListLabel\" was not injected: check your FXML file 'view.fxml'.";
        assert numbersStackSelector != null
                : "fx:id=\"numbersStackSelector\" was not injected: check your FXML file 'view.fxml'.";
        assert variablesStackSelector != null
                : "fx:id=\"variablesStackSelector\" was not injected: check your FXML file 'view.fxml'.";
        assert stackListView != null : "fx:id=\"stackListView\" was not injected: check your FXML file 'view.fxml'.";

        stackList = FXCollections.observableArrayList();
        operationsList = FXCollections.observableArrayList();
        // can't perform some menu actions if the list is empty
        SimpleListProperty<UserOperation> s = new SimpleListProperty<>(operationsList);

        stackListView.setItems(stackList);

        operationsMap = new OperationsMap();
        numbersStack = new Stack<>();
        textRecognizer = new TextRecognizer(operationsMap);
        calculator = new Calculator(operationsMap);
        variables = new Variables();
        varStack = new VariablesStack();

        resultLabel.setText("Result here.");

        selectedNumbersStack(null);
    }
}
