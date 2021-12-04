package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DupOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class lets the user execute the Dup operation.
 */
public class DupOperation extends Operation {

    public DupOperation() {
        super(1);
    }

    /**
     * @brief Push a copy of the last element on top of the stack.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        stack.push(stack.peek());
    }
}
