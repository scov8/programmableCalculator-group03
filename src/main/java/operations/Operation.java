package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file Operation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class represents an operation to execute on the elements
 *        contained in a stack.
 */
public abstract class Operation implements OperationInterface {
    /** Number of operands in the stack needed to execute the operation. */
    private int numOperands;

    /**
     * @brief Constructor.
     *
     *        Default number of operands is 2.
     */
    public Operation() {
        this.numOperands = 2;
    }

    /**
     * @brief Constructor.
     * @param numOperands Number of operands needed to execute the operation.
     */
    public Operation(int numOperands) {
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

    @Override
    public abstract void execute(Stack<ComplexNumber> stack);

}
