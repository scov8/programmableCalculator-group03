package src.main.java.resources;

import java.util.List;
import java.util.Stack;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedInputException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.*;
import src.main.java.variables.*;
import src.main.java.operations.Operation;
import src.main.java.userOperations.UserOperation;

/**
 * @file Calculator.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */

/**
 * @brief This class handles all the operations supported by this calculator
 *        application.
 */
public class Calculator {
    /**
     * Main stack containing the numbers given in input by the user and the
     * results of the operations.
     */
    private Stack<ComplexNumber> numbersStack;
    private Stack<ComplexNumber> numbersStackCopy;

    /**
     * Map of 26 ComplexNumber variables, one for each letter of the alphabet.
     */
    private Variables variables;
    private Variables variablesCopy;

    /**
     * Map associating a stack to each variable to save multiple instances of
     * their values.
     */
    private VariablesStack varStack;
    private VariablesStack varStackCopy;

    private TextRecognizer textRecognizer;

    /**
     * @brief Constructor.
     */
    public Calculator() {
        this.numbersStack = new Stack<>();
        this.variables = new Variables();
        this.varStack = new VariablesStack();
        this.textRecognizer = new TextRecognizer();
    }

    /**
     * @brief Retrieve the top K elements from the stack.
     * @param k Number of elements to retrieve.
     * @return List containing the elements.
     */
    public List<ComplexNumber> getTopKNumbers(int k) {
        int max = numbersStack.size();
        int min = max > k ? max - k : 0;
        return numbersStack.subList(min, max);
    }

    /**
     * @brief Retrieve the value of the variable named `name`.
     * @param name Name of the variable.
     * @return ComplexNumber value associated to the variable.
     */
    public ComplexNumber getVariable(char name) {
        return variables.get(name);
    }

    /**
     * @brief Run the operation associated to the user input.
     * @param input          User input.
     * @param textRecognizer object containing methods to recognize and parse text.
     * @throws UnrecognizedInputException
     * @throws NotEnoughOperandsException
     * @throws IndeterminateFormException
     * @throws VariableWithoutValueException
     */
    public void run(String input)
            throws UnrecognizedInputException, NotEnoughOperandsException,
            IndeterminateFormException, VariableWithoutValueException {
        if (textRecognizer.isStackOperation(input))
            runStackOperation(input);
        else if (textRecognizer.isVariableOperation(input))
            runVariablesOperation(input);
        else if (textRecognizer.isVariableStorageOperation(input))
            runVariableStorageOperation(input);
        else if (textRecognizer.isUserDefinedOperation(input))
            runUserDefinedOperation(input);
        else if (textRecognizer.isComplexNumber(input))
            numbersStack.push(new ComplexNumber(input));
        else
            throw new UnrecognizedInputException();
    }

    /**
     * @brief Run the given operation on the elements of the stack.
     * @param opString String representing the operation to execute.
     * @throws NotEnoughOperandsException
     * @throws IndeterminateFormException
     */
    private void runStackOperation(String opString)
            throws NotEnoughOperandsException, IndeterminateFormException {
        Operation op = OperationsMap.getInstance().getStackOperation(opString);
        op.execute(numbersStack);
    }

    /**
     * @brief Run the given operation on one of the variables.
     * @param opString String representing the operation to execute.
     * @throws NotEnoughOperandsException
     * @throws VariableWithoutValueException
     */
    private void runVariablesOperation(String opString)
            throws NotEnoughOperandsException, VariableWithoutValueException {
        // The opString is in the form 'ov' where 'o' is the operation to execute
        // and 'v' is the variable on which to execute 'o'.
        char opChar = opString.charAt(0);
        char variable = opString.charAt(1);

        VariableOperation op = OperationsMap.getInstance().getVariableOperation(opChar);
        op.execute(variables, numbersStack, variable);
    }

    /**
     * @brief Run the given operation on the stack of variables.
     * @param opString String representing the operation to execute.
     */
    private void runVariableStorageOperation(String opString) {
        VariableStorage op = OperationsMap.getInstance().getVariableStorageOperation(opString);
        op.execute(variables, varStack);
    }

    /**
     * @brief Run the given user-defined operation.
     * @param name Name of the operation.
     * @throws UserOperationExecutionException
     */
    private void runUserDefinedOperation(String name)
            throws UnrecognizedInputException, NotEnoughOperandsException,
            IndeterminateFormException, VariableWithoutValueException {
        UserOperation op = OperationsMap.getInstance().getUserDefinedOperation(name);

        saveBackup();

        for (String next : op.getAlgorithm()) {
            try {
                run(next);
            } catch (Exception e) {
                restoreBackup();
                throw e;
            }
        }
    }

    /**
     * @brief Save a backup copy of the core calculator's objects.
     * @throws CloneNotSupportedException
     */
    private void saveBackup() {
        try {
            numbersStackCopy = (Stack<ComplexNumber>) numbersStack.clone();
            variablesCopy = (Variables) variables.clone();
            varStackCopy = (VariablesStack) varStack.clone();
        } catch (CloneNotSupportedException e) {

        }
    }

    /**
     * @brief Restore the backup copy of the core calculator's objects.
     * @throws CloneNotSupportedException
     */
    private void restoreBackup() {
        try {
            numbersStack = (Stack<ComplexNumber>) numbersStackCopy.clone();
            variables = (Variables) variablesCopy.clone();
            varStack = (VariablesStack) varStackCopy.clone();
        } catch (CloneNotSupportedException e) {

        }
    }
}
