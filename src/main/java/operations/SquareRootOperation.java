package src.main.java.operations;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.resources.ComplexNumber;

/**
 * @file SquareRootOperation.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

public class SquareRootOperation extends MathOperation {
    public SquareRootOperation() {
        super(1);
    }

    /**
     * @brief Performs the modoulus of a complex numbers.
     * @param operand complex number for which you want to perform the modoulus
     *                operation.
     * @return complex number which represent the modoulus of operand number.
     */
    private ComplexNumber absolute(ComplexNumber operand) {
        return new ComplexNumber(
                Math.sqrt(Math.pow(operand.getReal(), 2) + Math.pow(operand.getImaginary(), 2)),
                0);
    }

    /**
     * @brief Perform the given operation on the two numbers: a, b.
     * @param a  First operand.
     * @param b  Second operand.
     * @param op Operation to perform.
     * @return result of operation.
     */
    private ComplexNumber operate(ComplexNumber a, ComplexNumber b, MathOperation op) {
        Stack<ComplexNumber> stack = new Stack<>();
        stack.push(a);
        stack.push(b);
        op.execute(stack);
        return stack.peek();
    }

    @Override
    public void execute(Stack<ComplexNumber> stack) throws NotEnoughOperandsException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();

        ComplexNumber num = stack.pop();
        ComplexNumber abs = absolute(num);
        ComplexNumber result;
        if (abs.getReal() == 0)
            result = new ComplexNumber(0, 0);
        else {
            ComplexNumber squareRootAbs = new ComplexNumber(Math.sqrt(abs.getReal()), 0);
            ComplexNumber sumAbsOperand = operate(num, abs, new SumOperation());
            ComplexNumber AbsSumAbsOperand = absolute(sumAbsOperand);
            result = operate(squareRootAbs, operate(sumAbsOperand, AbsSumAbsOperand, new DivisionOperation()),new MultiplicationOperation());
        }
        stack.push(result);
    }
}
