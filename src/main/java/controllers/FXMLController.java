package src.main.java.controllers;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedInputException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.OperationsMap;
import src.main.java.resources.*;
import src.main.java.userOperations.UserOperation;

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

    @FXML // fx:id="menuEditOperationButton"
    private MenuItem menuEditOperationButton; // Value injected by FXMLLoader

    @FXML // fx:id="menuDeleteOperationButton"
    private MenuItem menuDeleteOperationButton; // Value injected by FXMLLoader

    @FXML // fx:id="menuSaveOperationsButton"
    private MenuItem menuSaveOperationsButton; // Value injected by FXMLLoader

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

    @FXML // fx:id="tableLabel"
    private Label tableLabel; // Value injected by FXMLLoader

    @FXML // fx:id="operationsTable"
    private TableView<UserOperation> operationsTable; // Value injected by FXMLLoader

    @FXML // fx:id="opNameClmn"
    private TableColumn<UserOperation, String> opNameClmn; // Value injected by FXMLLoader

    @FXML // fx:id="opSeqClmn"
    private TableColumn<UserOperation, String> opSeqClmn; // Value injected by FXMLLoader

    @FXML // fx:id="tableContextMenuEdit"
    private MenuItem tableContextMenuEdit; // Value injected by FXMLLoader

    @FXML // fx:id="tableContextMenuDelete"
    private MenuItem tableContextMenuDelete; // Value injected by FXMLLoader

    @FXML // fx:id="newOperationPane"
    private TitledPane newOperationPane; // Value injected by FXMLLoader

    @FXML // fx:id="newOpNameField"
    private TextField newOpNameField; // Value injected by FXMLLoader

    @FXML // fx:id="newOpSeqField"
    private TextField newOpSeqField; // Value injected by FXMLLoader

    @FXML // fx:id="newOpConfirmButton"
    private Button newOpConfirmButton; // Value injected by FXMLLoader

    @FXML // fx:id="newOpCancelButton"
    private Button newOpCancelButton; // Value injected by FXMLLoader

    /**
     * `true` if the stackListView is currently showing the numbersStack;
     * `false` if it is showing the variables.
     */
    private boolean stackShowsNumbers;

    /**
     * ObservableList linked to the ListView for the numbers and the variables.
     */
    private ObservableList<String> stackList;
    /**
     * ObservableList linked to the TableView for the user-defined operations.
     */
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

    /**
     * @brief Update the list of elements displayed in the stack ListView.
     */
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
     * @brief Read user input and format it.
     */
    private String getUserInput() {
        String input = textRecognizer.formatText(textInput.getText());
        textInput.clear();
        return input;
    }

    /**
     * @brief Execute calculator function associated to the given input.
     * @param input The input string.
     */
    private void runUserInput(String input) {
        try {
            calculator.run(input, textRecognizer);
        } catch (UnrecognizedInputException e) {
            showError("Invalid Input",
                    "Please provide a valid OPERATION or a NUMBER.\n" +
                            "Numbers must be in the form 'a+bi', 'a' or 'bi'");
        } catch (NotEnoughOperandsException e) {
            showError("Not enough elements.",
                    "The stack does not contain enough values to execute the '" +
                            input + "' operation.");
        } catch (IndeterminateFormException e) {
            showError("Invalid operation.", "The '" + input + "' operation " +
                    "resulted in an indeterminate form.");
        } catch (VariableWithoutValueException e) {
            showError("Variable without value.", "The variable has no value yet.");
        } finally {
            updateStackView();
        }
    }

    /**
     * @brief This function gets called when new text input is given by the user.
     */
    private void newUserInput() {
        String input = getUserInput();
        if (input.length() == 0)
            return;
        runUserInput(input);
    }

    /**
     * @brief Read user input, parse it and execute associated functions.
     * @param event The pressing of the ENTER key.
     */
    @FXML
    private void onEnterKeyClick(ActionEvent event) {
        newUserInput();
    }

    /**
     * @brief Read user input, parse it and execute associated functions.
     * @param event The pressing of the "Enter" button.
     */
    @FXML
    private void onEnterButtonClick(ActionEvent event) {
        newUserInput();
    }

    /**
     * @brief Switch the ListView back to the stack of numbers.
     * @param event The pressing of the "Numbers" selector button.
     */
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

    /**
     * @brief Switch the ListView back to the list of variables.
     * @param event The pressing of the "Variables" selector button.
     */
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

    /**
     * @brief Close the application.
     * @param event The pressing of the "File.Close" button.
     */
    @FXML
    private void menuCloseApplication(ActionEvent event) {
        Platform.exit();
    }

    /**
     * @brief Save all the user-defined operations on a file.
     * @param event The pressing of the "File.Save Operations" button.
     */
    @FXML
    private void menuSaveOperations(ActionEvent event) {
        // TODO: save operations.
    }

    /**
     * @brief Restore all the user-defined operations from a file.
     * @param event The pressing of the "File.Restore Operations" button.
     */
    @FXML
    private void menuRestoreOperations(ActionEvent event) {
        // TODO: restore operations.
    }

    /**
     * @brief Abort the creation of a new User-defined operation.
     * @param event Click on the "Cancel" button.
     */
    @FXML
    private void cancelNewOp(ActionEvent event) {
        newOpNameField.clear();
        newOpSeqField.clear();
        newOperationPane.setVisible(false);
        mainPane.setVisible(true);
    }

    /**
     * @brief Confirm the creation of a new User-defined operation.
     * @param event Click on the "Confirm" button.
     */
    @FXML
    private void confirmNewOp(ActionEvent event) {
        // get name and sequence.
        String name = textRecognizer.formatText(newOpNameField.getText());
        String seq = textRecognizer.formatText(newOpSeqField.getText());
        newOpNameField.clear();
        newOpSeqField.clear();

        // check both values are valid.
        if (operationsMap.getUserDefinedOperation(name) != null) {
            showError("Invalid User-Defined Operation",
                    "User-Defined operation with this name already exists");
            return;
        }
        if (!textRecognizer.isValidUserDefinedOperationName(name)) {
            showError("Invalid Name",
                    "'" + name + "' is not a valid name.\nYou can only use letters.");
            return;
        }
        if (!textRecognizer.isValidUserDefinedOperationSequence(seq)) {
            showError("Invalid Sequence",
                    "'" + seq + "' is not recognized as a valid sequence of operations.");
            return;
        }

        // create new operation and add it to the collections.
        UserOperation op = new UserOperation(name, seq, operationsMap);
        operationsMap.addUserDefinedOperation(op);
        operationsList.add(op);

        // switch back to the main pane.
        newOperationPane.setVisible(false);
        mainPane.setVisible(true);
    }

    /**
     * @brief Open pane to create a new User-defined operation.
     * @param event The pressing of the "New" button in the table's context menu.
     */
    @FXML
    private void newUserOperation(ActionEvent event) {
        mainPane.setVisible(false);
        newOperationPane.setVisible(true);
    }

    /**
     * @brief Modify a User-Defined Operation's name.
     * @param event Double click on the Name column of the operations table.
     */
    @FXML
    private void editUserOperationName(TableColumn.CellEditEvent<UserOperation, String> event) {
        String newName = textRecognizer.formatText(event.getNewValue());
        String oldName = event.getOldValue();
        UserOperation op = operationsTable.getSelectionModel().getSelectedItem();

        if (operationsMap.getUserDefinedOperation(newName) != null) {
            op.setName(oldName);
            showError("Invalid Name",
                    "A user-defined operation with this name already exists.");
        } else if (!textRecognizer.isValidUserDefinedOperationName(newName)) {
            op.setName(oldName);
            showError("Invalid Name",
                    "'" + newName + "' is not a valid name.\nYou can only use letters.");
        } else
            op.setName(newName);

        operationsTable.setItems(null);
        operationsTable.setItems(operationsList);
    }

    /**
     * @brief Modify a User-Defined Operation's sequence.
     * @param event Double click on the Sequence column of the operations table.
     */
    @FXML
    private void editUserOperationSeq(TableColumn.CellEditEvent<UserOperation, String> event) {
        String newSeq = textRecognizer.formatText(event.getNewValue());
        String oldSeq = event.getOldValue();
        UserOperation op = operationsTable.getSelectionModel().getSelectedItem();

        if (!textRecognizer.isValidUserDefinedOperationSequence(newSeq)) {
            op.setSequence(oldSeq);
            showError("Invalid Sequence",
                    "'" + newSeq + "' is not recognized as a valid sequence of operations.");
        } else
            op.setSequence(newSeq);

        operationsTable.setItems(null);
        operationsTable.setItems(operationsList);
    }

    /**
     * @brief Modify the selected User-Defined Operation.
     * @param event The pressing of the "Edit" button in the table's context menu.
     */
    @FXML
    private void editUserOperation2(ActionEvent event) {
        // TODO: edit sequence via context menu.
    }

    /**
     * @brief Delete the selected User-Defined Operation.
     * @param event The pressing of the "Delete" button in the table's context menu.
     */
    @FXML
    private void deleteUserOperation(ActionEvent event) {
        UserOperation op = operationsTable.getSelectionModel().getSelectedItem();
        operationsList.remove(op);
        operationsMap.deleteUserDefinedOperation(op);
    }

    /**
     * @brief Inizialize the Controller.
     */
    @FXML
    private void initialize() {
        stackList = FXCollections.observableArrayList();
        operationsList = FXCollections.observableArrayList();
        // can't perform some menu actions if the list of operations is empty.
        SimpleListProperty<UserOperation> s = new SimpleListProperty<>(operationsList);

        stackListView.setItems(stackList);

        operationsTable.setItems(operationsList);
        opNameClmn.setCellValueFactory(new PropertyValueFactory<UserOperation, String>("name"));
        opSeqClmn.setCellValueFactory(new PropertyValueFactory<UserOperation, String>("sequence"));
        // To be able to edit these columns.
        opNameClmn.setCellFactory(TextFieldTableCell.forTableColumn());
        opSeqClmn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Instantiate all the needed core objects.
        operationsMap = new OperationsMap();
        numbersStack = new Stack<>();
        textRecognizer = new TextRecognizer(operationsMap);
        variables = new Variables();
        varStack = new VariablesStack();
        calculator = new Calculator(operationsMap, numbersStack, variables, varStack);

        resultLabel.setText("Result here.");

        // Disable Confirm button for the creation of a new Operation if the
        // name has less than 2 characters or the sequence is empty.
        newOpConfirmButton.disableProperty().bind(Bindings.lessThan(newOpNameField.textProperty().length(), 2)
                .or(newOpSeqField.textProperty().isEmpty()));
        // Disable context menu in table if no items are stored in it.
        tableContextMenuDelete.disableProperty().bind(Bindings.isEmpty(operationsList));
        tableContextMenuEdit.disableProperty().bind(Bindings.isEmpty(operationsList));

        menuSaveOperationsButton.disableProperty().bind(s.emptyProperty());

        selectedNumbersStack(null);
    }
}
