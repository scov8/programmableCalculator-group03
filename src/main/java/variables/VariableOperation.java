package src.main.java.variables;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file VariableOperation.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This class represents a generic operation to execute on a variable.
 */
public abstract class VariableOperation implements VariableOperationInterface {
    /**
     * Number of operands needed in the stack of numbers to execute the
     * operation.
     */
    private int numOperands;

    /**
     * @brief Constructor.
     *
     *        Default number of operands is 0.
     */
    public VariableOperation() {
        this.numOperands = 0;
    }

    /**
     * @brief Constructor.
     * @param numOperands Number of operands needed to execute the operation.
     */
    public VariableOperation(int numOperands) {
        this.numOperands = numOperands;
    }

    /**
     * @brief Check that the stack contains enough elements for the operation to
     *        be executed.
     * @param size Number of elements in the stack.
     * @return `true` if size is at least as big as the number of operands;
     *         `false` otherwise.
     */
    protected boolean enoughOperandsInStack(int size) {
        return size >= numOperands;
    }

    /**
     * @brief Execute the operation on the given variable.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     */
    @Override
    public abstract void execute(Variables variables, Stack<ComplexNumber> stack, char varName);
}
