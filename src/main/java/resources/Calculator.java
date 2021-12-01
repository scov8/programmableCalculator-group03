package src.main.java.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.*;
import src.main.java.variables.*;

/**
 * @file Calculator.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */

/**
 * @brief This class handles the operation and the operands in the stack.
 */
public class Calculator {
    private Map<String, Operation> operations;
    private Map<Character, VariableOperation> variableOperations;
    private Map<String, VariableStorage> variableStorageOperations;

    /**
     * @brief Constructor.
     */
    public Calculator() {
        // Instantiate all the maps.
        // Each map associates a string representing an operation to a class
        // that implements that operation via an execute method.

        operations = new HashMap<>();
        operations.put("+", new SumOperation());
        operations.put("-", new DifferenceOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("/", new DivisionOperation());
        operations.put("+-", new SignInversionOperation());
        operations.put("sqrt", new SquareRootOperation());
        operations.put("clear", new ClearOperation());
        operations.put("drop", new DropOperation());
        operations.put("dup", new DupOperation());
        operations.put("over", new OverOperation());
        operations.put("swap", new SwapOperation());

        variableOperations = new HashMap<>();
        variableOperations.put('>', new SaveIntoVariable());
        variableOperations.put('<', new SaveIntoStack());
        variableOperations.put('+', new PlusVariable());
        variableOperations.put('-', new MinusVariable());

        variableStorageOperations = new HashMap<>();
        variableStorageOperations.put("save", new SaveOperation());
        variableStorageOperations.put("restore", new RestoreOperation());
    }

    /**
     * @brief Run the given operation on the elements of the stack.
     * @param stack    The stack of complex numbers.
     * @param opString String representing the operation to execute.
     */
    public void runStackOperation(Stack<ComplexNumber> stack, String opString) throws NotEnoughOperandsException {
        Operation op = operations.get(opString);
        op.execute(stack);
    }

    /**
     * @brief Run the given operation on one of the variables.
     * @param variables Map containing all the calculator's variables.
     * @param stack     The stack of complex numbers.
     * @param opString  String representing the operation to execute.
     */
    public void runVariablesOperation(Variables variables, Stack<ComplexNumber> stack, String opString)
            throws VariableWithoutValueException {
        // The opString is in the form 'ov' where 'o' is the operation to execute
        // and 'v' is the variable on which to execute 'o'.
        char opChar = opString.charAt(0);
        char variable = opString.charAt(1);

        VariableOperation op = variableOperations.get(opChar);
        op.execute(variables, stack, variable);
    }

    /**
     * @brief Run the given operation on the stack of variables.
     * @param variables Map containing all the calculator's variables.
     * @param varStack  Stack storing multiple values for each variable.
     * @param opString  String representing the operation to execute.
     */
    public void runVariableStorageOperation(Variables variable, VariablesStack varStack, String opString) {
        VariableStorage op = variableStorageOperations.get(opString);
        op.execute(variable, varStack);
    }
}
