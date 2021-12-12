package src.main.java.operations;

import java.util.Stack;

import src.main.java.resources.ComplexNumber;

/**
 * @file ClearOperation.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to delete all elements from the stack.
 */
public class ClearOperation extends Operation {

    public ClearOperation() {
        super(0);
    }

    /**
     * @brief Remove all the elements from the stack.
     * @param stack The stack on which to execute the operation.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        stack.clear();
    }
}
