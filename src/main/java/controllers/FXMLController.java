package src.main.java.controllers;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedInputException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.files.SaveRestoreObjFile;
import src.main.java.files.SaveRestoreTextFile;
import src.main.java.operations.OperationsMap;
import src.main.java.resources.*;
import src.main.java.userOperations.UserOperation;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Menu;
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

    @FXML
    private AnchorPane paneRoot; // Value injected by FXMLLoader

    @FXML
    private Pane mainPane; // Value injected by FXMLLoader

    @FXML
    private TitledPane guidePane; // Value injected by FXMLLoader

    @FXML
    private Menu saveOperationsButton; // Value injected by FXMLLoader

    @FXML
    private MenuItem saveTextOperationsButton; // Value injected by FXMLLoader

    @FXML
    private MenuItem saveObjOperationsButton; // Value injected by FXMLLoader

    @FXML
    private MenuItem restoreTextOperationsButton; // Value injected by FXMLLoader

    @FXML
    private MenuItem restoreObjOperationsButton; // Value injected by FXMLLoader

    @FXML
    private TextField textInput; // Value injected by FXMLLoader

    @FXML
    private Button enter; // Value injected by FXMLLoader

    @FXML
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML
    private Label stackListLabel; // Value injected by FXMLLoader

    @FXML
    private Button numbersStackSelector; // Value injected by FXMLLoader

    @FXML
    private Button variablesStackSelector; // Value injected by FXMLLoader

    @FXML
    private ListView<String> stackListView; // Value injected by FXMLLoader

    @FXML
    private Label tableLabel; // Value injected by FXMLLoader

    @FXML
    private TableView<UserOperation> operationsTable; // Value injected by FXMLLoader

    @FXML
    private TableColumn<UserOperation, String> opNameClmn; // Value injected by FXMLLoader

    @FXML
    private TableColumn<UserOperation, String> opSeqClmn; // Value injected by FXMLLoader

    @FXML
    private MenuItem tableContextMenuEdit; // Value injected by FXMLLoader

    @FXML
    private MenuItem tableContextMenuDelete; // Value injected by FXMLLoader

    @FXML
    private TitledPane newOperationPane; // Value injected by FXMLLoader

    @FXML
    private TextField newOpNameField; // Value injected by FXMLLoader

    @FXML
    private TextField newOpSeqField; // Value injected by FXMLLoader

    @FXML
    private Button newOpConfirmButton; // Value injected by FXMLLoader

    @FXML
    private Button newOpCancelButton; // Value injected by FXMLLoader

    /**
     * `true` if the stackListView is currently showing the stack of numbers;
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
     * Main instance of Calculator class that handles all the operations.
     */
    private Calculator calculator;

    /** Maps containing all the operations supported by this application. */
    private OperationsMap operationsMap;

    /** Object used to handle reading/writing operations on text files. */
    private SaveRestoreTextFile handleTextFiles;

    /** Object used to handle reading/writing operations on object files. */
    private SaveRestoreObjFile handleObjFiles;

    /**
     * Number of items from the stack of numbers to show in the GUI at any time.
     */
    private final int K = 15;

    /**
     * @brief Update the ListView containing the stack of complex numbers.
     */
    private void updateNumbersStackView() {
        List<ComplexNumber> topKnumbers = calculator.getTopKNumbers(K);

        stackList.clear();
        for (ComplexNumber n : topKnumbers)
            stackList.add(n.toString());

        // reverse the list to show the top element in the upmost position.
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
            ComplexNumber value = calculator.getVariable(letter);
            if (value != null)
                stackList.add(letter + ":\t" + value.toString());
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
     * @return The formatted version of the input.
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
            calculator.run(input);
        } catch (UnrecognizedInputException e) {
            showError("INVALID INPUT.",
                    "Please provide a valid operation or a number.\nOpen the " +
                    "GUIDE to know more.");
        } catch (NotEnoughOperandsException e) {
            showError("NOT ENOUGH ELEMENTS.",
                    "The stack does not contain enough values to execute the '" +
                            input + "' operation.");
        } catch (IndeterminateFormException e) {
            showError("INVALID FORM.", "The '" + input + "' operation " +
                    "resulted in an indeterminate form.");
        } catch (VariableWithoutValueException e) {
            showError("VARIABLE WITHOUT VALUE.", "The variable has no value yet.");
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
     * @brief Save the collection of user-defined operations to a text file.
     * @param event Pressing of the "Save Operations -> Text File" button in menu.
     */
    @FXML
    private void saveTextFile(ActionEvent event) {
        handleTextFiles.executeSave(paneRoot.getScene().getWindow(), operationsMap.getAllUserDefinedOperations());
    }

    /**
     * @brief Save the collection of user-defined operations to an object file.
     * @param event Pressing of the "Save Operations -> Obj File" button in menu.
     */
    @FXML
    private void saveObjFile(ActionEvent event) {
        handleObjFiles.executeSave(paneRoot.getScene().getWindow(), operationsMap.getAllUserDefinedOperations());
    }

    /**
     * @brief Load the collection of user-defined operations from a text file.
     * @param event Pressing of the "Load Operations -> Text File" button in menu.
     */
    @FXML
    private void restoreTextFile(ActionEvent event) {
        UserOperation[] operations = handleTextFiles.executeRestore(paneRoot.getScene().getWindow());
        if (operations == null)
            return;
        operationsMap.setAllUserDefinedOperations(operations);
        operationsList.clear();
        operationsList.addAll(operations);
    }

    /**
     * @brief Load the collection of user-defined operations from an object file.
     * @param event Pressing of the "Load Operations -> Obj File" button in menu.
     */
    @FXML
    private void restoreObjFile(ActionEvent event) {
        UserOperation[] operations = handleObjFiles.executeRestore(paneRoot.getScene().getWindow());
        if (operations == null)
            return;
        operationsMap.setAllUserDefinedOperations(operations);
        operationsList.clear();
        operationsList.addAll(operations);
    }

    /**
     * @brief Show the Guide Pane.
     * @param event Pressing of the "Help -> Guide" button in menu.
     */
    @FXML
    void showGuide(ActionEvent event) {
        mainPane.setDisable(true);
        newOperationPane.setVisible(false);
        guidePane.setVisible(true);
    }

    /**
     * @brief Hide the Guide Pane.
     * @param event Pressing of the "Ok" button in the Guide Pane.
     */
    @FXML
    void closeGuide(ActionEvent event) {
        mainPane.setDisable(false);
        newOperationPane.setVisible(false);
        guidePane.setVisible(false);
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
        guidePane.setVisible(false);
        mainPane.setDisable(false);
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
            showError("INVALID OPERATION NAME.",
                    "User-Defined operation with this name already exists");
            return;
        }
        if (!textRecognizer.isValidUserDefinedOperationName(name)) {
            showError("INVALID OPERATION NAME.",
                    "'" + name + "' is not a valid name.\nYou can only use letters, numbers and '_'.");
            return;
        }
        if (!textRecognizer.isValidUserDefinedOperationSequence(name, seq)) {
            showError("INVALID OPERATION SEQUENCE.",
                    "'" + seq + "' is not recognized as a valid sequence of operations.");
            return;
        }

        // create new operation and add it to the collections.
        UserOperation op = new UserOperation(name, seq);
        operationsMap.addUserDefinedOperation(op);
        operationsList.add(op);

        // switch back to the main pane.
        newOperationPane.setVisible(false);
        mainPane.setDisable(false);
    }

    /**
     * @brief Open pane to create a new User-defined operation.
     * @param event The pressing of the "New" button in the table's context menu.
     */
    @FXML
    private void newUserOperation(ActionEvent event) {
        mainPane.setDisable(true);
        guidePane.setVisible(false);
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

        if (newName.equals(oldName))
            return;

        if (operationsMap.getUserDefinedOperation(newName) != null) {
            op.setName(oldName);
            showError("INVALID OPERATION NAME.",
                    "User-Defined operation with this name already exists");
        } else if (!textRecognizer.isValidUserDefinedOperationName(newName)) {
            op.setName(oldName);
            showError("INVALID OPERATION NAME.",
                    "'" + newName + "' is not a valid name.\nYou can only use letters, numbers and '_'.");
        } else
            op.setName(newName);

        operationsList.remove(op);
        operationsList.add(op);
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

        if (!textRecognizer.isValidUserDefinedOperationSequence(op.getName(), newSeq)) {
            op.setSequence(oldSeq);
            showError("Invalid Sequence",
                    "'" + newSeq + "' is not recognized as a valid sequence of operations.");
        } else
            op.setSequence(newSeq);

        operationsList.remove(op);
        operationsList.add(op);
    }

    /**
     * @brief Start modifying the selected User-Defined Operation's sequence.
     * @param event The pressing of the "Edit" button in the table's context menu.
     */
    @FXML
    private void editUserOperation(ActionEvent event) {
        int index = operationsTable.getSelectionModel().getSelectedIndex();
        operationsTable.edit(index, opSeqClmn);
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

        // Instantiate all the needed core objects.
        operationsMap = OperationsMap.getInstance();
        textRecognizer = new TextRecognizer();
        calculator = new Calculator();

        handleTextFiles = new SaveRestoreTextFile();
        handleObjFiles = new SaveRestoreObjFile();

        stackListView.setItems(stackList);

        operationsTable.setItems(operationsList);
        opNameClmn.setCellValueFactory(new PropertyValueFactory<UserOperation, String>("name"));
        opSeqClmn.setCellValueFactory(new PropertyValueFactory<UserOperation, String>("sequence"));
        // To be able to edit these columns.
        opNameClmn.setCellFactory(TextFieldTableCell.forTableColumn());
        opSeqClmn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Disable Confirm button for the creation of a new Operation if the
        // name has less than 2 characters or the sequence is empty.
        newOpConfirmButton.disableProperty().bind(Bindings.lessThan(newOpNameField.textProperty().length(), 2)
                .or(newOpSeqField.textProperty().isEmpty()));
        // Disable context menu in table if no items are stored in it or if none
        // is selected.
        tableContextMenuDelete.disableProperty().bind(Bindings.isEmpty(operationsList)
                .or(operationsTable.getSelectionModel().selectedItemProperty().isNull()));
        tableContextMenuEdit.disableProperty().bind(Bindings.isEmpty(operationsList)
                .or(operationsTable.getSelectionModel().selectedItemProperty().isNull()));

        // can't save list of user operations if it is empty.
        SimpleListProperty<UserOperation> s = new SimpleListProperty<>(operationsList);
        saveOperationsButton.disableProperty().bind(s.emptyProperty());
        saveTextOperationsButton.disableProperty().bind(s.emptyProperty());
        saveObjOperationsButton.disableProperty().bind(s.emptyProperty());

        selectedNumbersStack(null);
    }
}
