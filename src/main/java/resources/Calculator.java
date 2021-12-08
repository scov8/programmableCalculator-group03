package src.main.java.resources;

import java.io.Serializable;
import java.util.Stack;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedInputException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.*;
import src.main.java.variables.*;
import src.main.java.operations.Operation;

/**
 * @file Calculator.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */

/**
 * @brief This class handles the operation and the operands in the stack.
 */
public class Calculator implements Serializable {
    private OperationsMap operationsMap;
    private Stack<ComplexNumber> numbersStack;
    private Variables variables;
    private VariablesStack varStack;

    /**
     * @brief Constructor.
     * @param operationsMap All the supported operations.
     * @param numbersStack  The stack of complex numbers.
     * @param variables     The calculator variables.
     * @param varStack      Map associating a stack to each variable.
     */
    public Calculator(OperationsMap operationsMap, Stack<ComplexNumber> numbersStack,
            Variables variables, VariablesStack varStack) {
        this.operationsMap = operationsMap;
        this.numbersStack = numbersStack;
        this.variables = variables;
        this.varStack = varStack;
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
    public void run(String input, TextRecognizer textRecognizer)
            throws UnrecognizedInputException, NotEnoughOperandsException,
            IndeterminateFormException, VariableWithoutValueException {
        if (textRecognizer.isStackOperation(input)) {
            runStackOperation(input);
        } else if (textRecognizer.isVariableOperation(input)) {
            runVariablesOperation(input);
        } else if (textRecognizer.isVariableStorageOperation(input)) {
            runVariableStorageOperation(input);
        } else {
            ComplexNumber number = textRecognizer.extractNumber(input);
            if (number == null)
                throw new UnrecognizedInputException();
            else
                numbersStack.push(number);
        }
    }

    /**
     * @brief Run the given operation on the elements of the stack.
     * @param opString String representing the operation to execute.
     * @throws NotEnoughOperandsException
     * @throws IndeterminateFormException
     */
    private void runStackOperation(String opString)
            throws NotEnoughOperandsException, IndeterminateFormException {
        Operation op = operationsMap.getStackOperation(opString);
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

        VariableOperation op = operationsMap.getVariableOperation(opChar);
        op.execute(variables, numbersStack, variable);
    }

    /**
     * @brief Run the given operation on the stack of variables.
     * @param opString String representing the operation to execute.
     */
    private void runVariableStorageOperation(String opString) {
        VariableStorage op = operationsMap.getVariableStorageOperation(opString);
        op.execute(variables, varStack);
    }
}
