package src.main.java.resources;

import java.io.Serializable;
import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
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

    /**
     * @brief Constructor.
     */
    public Calculator(OperationsMap operationsMap) {
        // Instantiate all the maps.
        this.operationsMap = operationsMap;
    }

    /**
     * @brief Run the given operation on the elements of the stack.
     * @param stack    The stack of complex numbers.
     * @param opString String representing the operation to execute.
     */
    public void runStackOperation(Stack<ComplexNumber> stack, String opString) throws NotEnoughOperandsException {
        Operation op = operationsMap.getOperation(opString);
        op.execute(stack);
    }

    /**
     * @brief Run the given operation on one of the variables.
     * @param variables Map containing all the calculator's variables.
     * @param stack     The stack of complex numbers.
     * @param opString  String representing the operation to execute.
     */
    public void runVariablesOperation(Variables variables, Stack<ComplexNumber> stack, String opString)
            throws VariableWithoutValueException, NotEnoughOperandsException {
        // The opString is in the form 'ov' where 'o' is the operation to execute
        // and 'v' is the variable on which to execute 'o'.
        char opChar = opString.charAt(0);
        char variable = opString.charAt(1);

        VariableOperation op = operationsMap.getVariableOperation(opChar);
        op.execute(variables, stack, variable);
    }

    /**
     * @brief Run the given operation on the stack of variables.
     * @param variables Map containing all the calculator's variables.
     * @param varStack  Stack storing multiple values for each variable.
     * @param opString  String representing the operation to execute.
     */
    public void runVariableStorageOperation(Variables variable, VariablesStack varStack, String opString) {
        VariableStorage op = operationsMap.getVariableStorageOperation(opString);
        op.execute(variable, varStack);
    }
}
