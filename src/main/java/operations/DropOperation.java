package src.main.java.operations;

import java.util.EmptyStackException;
import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DropOperation.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021
 */

public class DropOperation extends Operation {

    public DropOperation() {
        super(1);
    }

    /**
     * @brief Removes the last element.
     * @throws EmptyStackException if stack is empty.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException{
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        stack.pop();
    }
}
