package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file OverOperation.java
 * @author Luigi Scovotto
 * @date 30 Nov 2021
 */
public class OverOperation extends Operation{

    public OverOperation() {
        super(2);
    }
     /**
     * @brief Pushes a copy of the second last element.
     */
    @Override
    public void execute(Stack <ComplexNumber> stack) throws NotEnoughOperandsException{
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        ComplexNumber element1 = stack.pop();
        ComplexNumber element2 = stack.peek();
        stack.push(element1);
        stack.push(element2);
    }
}
