package src.main.java.variables;

import java.util.Stack;

import src.main.java.exceptions.NotEnoughOperandsException;
import src.main.java.exceptions.VariableWithoutValueException;
import src.main.java.operations.DupOperation;
import src.main.java.operations.SumOperation;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

/**
 * @file PlusVariable.java
 * @author Luigi Scovotto
 * @date 02 Dic 2021
 */

/**
 * @brief This class lets the user execute the '+x' operation.
 */
public class PlusVariable extends VariableOperation {

    public PlusVariable() {
        super(1);
    }

    /**
     * @brief Sum the top element of the stack to the variable and save the
     *        result in the variable itself.
     * @param variables All the variables.
     * @param stack     Stack of complex numbers.
     * @param varName   Name of the variable to execute the operation on.
     */
    @Override
    public void execute(Variables variables, Stack<ComplexNumber> stack, char varName)
            throws NotEnoughOperandsException, VariableWithoutValueException {
        if (!super.enoughOperandsInStack(stack.size()))
            throw new NotEnoughOperandsException();
        ComplexNumber value = variables.get(varName);
        if (value == null)
            throw new VariableWithoutValueException();
        DupOperation dup = new DupOperation();
        SumOperation sum = new SumOperation();
        dup.execute(stack);
        stack.push(value);
        sum.execute(stack);
        variables.set(varName, stack.pop());
    }
}
