package src.main.java.variables;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file SaveIntoVariable.java
 * @author Luigi Scovotto
 * @date 01 Dic 2021
 */

/**
 * @brief This class lets the user execute the '>x' operation.
 */
public class SaveIntoVariable extends VariableOperation {

    public SaveIntoVariable() {
        super(1);
    }

    /**
     * @brief Save the top element of the numbers stack into the given variable.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     */
    @Override
    public void execute(Variables variables, Stack<ComplexNumber> stack, char varName)
            throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        variables.set(varName, stack.peek());
    }
}
