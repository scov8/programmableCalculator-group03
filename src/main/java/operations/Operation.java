package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file Operation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This interface declares a single method to execute a generic
 *        operation.
 */
public interface Operation {
    /**
     * @brief Execute an operation on the given stack.
     * @param stack The stack on which to execute the operation.
     */
    public void execute(Stack<ComplexNumber> stack);
}
