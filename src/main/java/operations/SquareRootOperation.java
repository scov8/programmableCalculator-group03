package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file SquareRootOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This class presents a method to execute the Square Root of a complex
 *        number contained in a stack.
 */
public class SquareRootOperation extends Operation {
    public SquareRootOperation() {
        super(1);
    }

    /**
     * @brief Perform the given operation on the two numbers: a, b.
     * @param a  First operand.
     * @param b  Second operand.
     * @param op Operation to perform.
     * @return result of operation.
     */
    private ComplexNumber operate(ComplexNumber a, ComplexNumber b, Operation op) {
        Stack<ComplexNumber> stack = new Stack<>();
        if (a != null)
            stack.push(a);
        if (b != null)
            stack.push(b);
        op.execute(stack);
        return stack.peek();
    }

    /**
     * @brief Execute the square root operation on the given stack.
     * @param stack The stack on which to execute the operation.
     * @throws NotEnoughOperandsException if the stack does not contain enough
     *                                    elements.
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber num = stack.peek();
        ComplexNumber modNum = operate(num, null, new ModOperation());
        ComplexNumber result;
        if (modNum.getReal() == 0)
            result = new ComplexNumber(0, 0);
        else {
            ComplexNumber squareRootMod = new ComplexNumber(Math.sqrt(modNum.getReal()), 0);
            ComplexNumber sumModOperand = operate(num, modNum, new SumOperation());
            ComplexNumber modSumModOperand = operate(sumModOperand, null, new ModOperation());
            result = operate(squareRootMod, operate(sumModOperand, modSumModOperand, new DivisionOperation()),
                    new MultiplicationOperation());
        }
        stack.push(result);
    }
}
