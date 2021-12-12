package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file ModOperation.java
 * @author Francesco Tortora
 * @date 10 Dec 2021
 */

/**
 * @brief This class presents a method to execute the Mod operation of a complex
 *        number contained in the stack.
 */
public class ModOperation extends Operation {
    public ModOperation() {
        super(1);
    }

    /**
     * @brief Perform the modoulus of a complex numbers.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        ComplexNumber top = stack.pop();
        ComplexNumber num = new ComplexNumber(
                Math.sqrt(Math.pow(top.getReal(), 2) + Math.pow(top.getImaginary(), 2)),
                0);
        stack.push(num);
    }
}
