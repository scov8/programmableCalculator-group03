package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file SwapOperation.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to swap the top two elements of a stack.
 */
public class SwapOperation extends Operation {

    public SwapOperation() {
        super(2);
    }

    /**
     * @brief Swap the top two elements of the given stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        ComplexNumber element1 = stack.pop();
        ComplexNumber element2 = stack.pop();
        stack.push(element1);
        stack.push(element2);
    }
}
