package src.main.java.variables;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.DifferenceOperation;
import src.main.java.operations.DupOperation;
import src.main.java.operations.SwapOperation;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file MinusVariable.java
 * @author Francesco Tortora
 * @date 02 Dic 2021
 */

/**
 * @brief This class lets the user execute the '-x' operation.
 */
public class MinusVariable extends VariableOperation {

    public MinusVariable() {
        super(1);
    }

    /**
     * @brief Take the top element from the stack and subtract it from the value
     *        of the variable.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     */
    @Override
    public void execute(Variables variables, Stack<ComplexNumber> stack, char varName)
            throws NotEnoughOperandsException, VariableWithoutValueException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        ComplexNumber value = variables.get(varName);
        if (value == null)
            throw new VariableWithoutValueException();
        DupOperation dup = new DupOperation();
        DifferenceOperation difference = new DifferenceOperation();
        SwapOperation swap = new SwapOperation();
        dup.execute(stack);
        stack.push(value);
        swap.execute(stack);
        difference.execute(stack);
        variables.set(varName, stack.pop());
    }
}
