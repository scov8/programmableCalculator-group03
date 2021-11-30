package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file MathOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class represents a Mathematical operation to execute on the
 *        numbers contained in a stack data structure.
 */
public abstract class MathOperation implements Operation {
    /** Number of operands needed for the operations. */
    private int numOperands;

    /**
     * @brief Constructor.
     *
     *        Default number of operands is 2.
     */
    public MathOperation() {
        this.numOperands = 2;
    }

    /**
     * @brief Constructor.
     * @param numOperands Number of operands needed to execute the operation.
     */
    public MathOperation(int numOperands) {
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
     * @brief Execute a mathematical operation on the given stack.
     * @param stack The stack on which to execute the operation.
     */
    @Override
    public abstract void execute(Stack<ComplexNumber> stack);

}
