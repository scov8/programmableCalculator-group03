package src.main.java.variables;

import java.util.Stack;

import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file SaveIntoStack.java
 * @author Francesco Tortora
 * @date 02 Dic 2021
 */

/**
 * @brief This class lets the user execute the '<x' operation.
 */
public class SaveIntoStack extends VariableOperation {

    public SaveIntoStack() {
        super();
    }

    /**
     * @brief Save the value of the variable into the numbers stack.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     * @throws VariableWithoutValueException if the variable has no value yet.
     */
    @Override
    public void execute(Variables variables, Stack<ComplexNumber> stack, char varName)
            throws VariableWithoutValueException {
        ComplexNumber element = variables.get(varName);
        if (element == null)
            throw new VariableWithoutValueException();
        else
            stack.push(variables.get(varName));
    }
}
