package src.main.java.variables;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file VariableOperationInterface.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This interface declares a single method to execute an operation on one
 *        of the variables.
 */
public interface VariableOperationInterface {
    /**
     * @brief Execute the operation on the given variable.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     */
    public void execute(Variables variables, Stack<ComplexNumber> stack, char varName);
}
