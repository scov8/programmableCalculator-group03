package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file OverOperation.java
 * @author Luigi Scovotto
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to push a copy of the second to last
 *        element over the top.
 */
public class OverOperation extends Operation {

    public OverOperation() {
        super(2);
    }

    /**
     * @brief Pushes a copy of the second to last element over the top.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber element1 = stack.pop();
        ComplexNumber element2 = stack.peek();
        stack.push(element1);
        stack.push(element2);
    }
}
