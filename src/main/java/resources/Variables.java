package src.main.java.resources;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import src.main.java.exceptions.InvalidVariableName;

/**
 * @file Variables.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */

/**
 * @brief This class represents variables.
 */
public class Variables {
    Map <Character, Stack<ComplexNumber>> variables;

    /**
     * @brief Variables constructor.
     */
    public Variables() {
        this.variables = new HashMap<Character, Stack<ComplexNumber>>();

        for (char alphabet = 'a'; alphabet <='z'; alphabet++ ){
            this.variables.put(alphabet,new Stack<ComplexNumber>());
        }
    }

    /**
     * @brief Push a complex number into desidered stack.
     * @param variable Name of the variable's stack.
     * @param number Complex number to insert into stack.
     * @throws EmptyStackException if stack is empty.
     */
    public void push(char variable, ComplexNumber number) throws InvalidVariableName{
        if(variable>='a' && variable<='z')
            this.variables.get(variable).push(number);
        else
            throw new InvalidVariableName();
    }

    /**
     * @brief Pop a complex number from a variable's stack.
     * @param variable Name of the variable's stack.
     * @return the top element of the variable's stack.
     * @throws EmptyStackException if stack is empty.
     * @throws InvalidVariableName if variable name is invalid.
     */
    public ComplexNumber pop(char variable) throws EmptyStackException,InvalidVariableName{
        if(variable<'a' || variable>'z')
            throw new InvalidVariableName();
        if(this.variables.get(variable).isEmpty())
            throw new EmptyStackException();
        return this.variables.get(variable).pop();
    }

}
