package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file DropOperation.java
 * @author Gerardo Rosa
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to remove the last element from the
 *        stack.
 */
public class DropOperation extends Operation {

    public DropOperation() {
        super(1);
    }

    /**
     * @brief Removes the last element.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if stack is empty.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        stack.pop();
    }
}
