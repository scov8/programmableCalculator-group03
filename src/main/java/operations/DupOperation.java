package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DupOperation.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to duplicate the top element of the stack.
 */
public class DupOperation extends Operation {

    public DupOperation() {
        super(1);
    }

    /**
     * @brief Push a copy of the top element of the stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if stack is empty.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        stack.push(stack.peek());
    }
}
