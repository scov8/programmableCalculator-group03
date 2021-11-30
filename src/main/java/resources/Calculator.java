package src.main.java.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.UnrecognizedOperationException;
import src.main.java.operations.DifferenceOperation;
import src.main.java.operations.DivisionOperation;
import src.main.java.operations.MultiplicationOperation;
import src.main.java.operations.Operation;
import src.main.java.operations.SignInversionOperation;
import src.main.java.operations.SquareRootOperation;
import src.main.java.operations.SumOperation;

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

    public Calculator() {
        operations = new HashMap<>();
        operations.put("+", new SumOperation());
        operations.put("-", new DifferenceOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("/", new DivisionOperation());
        operations.put("+-", new SignInversionOperation());
        operations.put("sqrt", new SquareRootOperation());
    }

    /**
     * @brief Run the given operation on the elements of the stack.
     * @param stack The stack of complex numbers.
     * @param op    String representing the operation to execute.
     */
    public void runOperation(Stack<ComplexNumber> stack, String opString) throws Exception {
        Operation op = operations.get(opString);
        if (op == null)
            throw new UnrecognizedOperationException();
        op.execute(stack);
    }
}
