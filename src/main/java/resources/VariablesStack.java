package src.main.java.resources;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @file VariablesStack.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */

/**
 * @brief This class implements a Stack containing multiple values for each
 *        variable.
 */
public class VariablesStack implements Cloneable {
    /** This map associates a stack to every letter (variable). */
    Map<Character, Stack<ComplexNumber>> map;

    /**
     * @brief Constructor.
     */
    public VariablesStack() {
        map = new HashMap<Character, Stack<ComplexNumber>>();

        for (char letter = 'a'; letter <= 'z'; letter++) {
            map.put(letter, new Stack<ComplexNumber>());
        }
    }

    /**
     * @brief Push a complex number into the stack of the given variable.
     * @param variable Name of the variable.
     * @param number   Complex number to insert into the stack stack.
     */
    public void push(char variable, ComplexNumber number) {
        map.get(variable).push(number);
    }

    /**
     * @brief Remove and return last value from the stack of the given variable.
     * @param variable Name of the variable.
     * @return The top element of the variable's stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public ComplexNumber pop(char variable) throws EmptyStackException {
        if (map.get(variable).empty())
            throw new EmptyStackException();
        return map.get(variable).pop();
    }

    /**
     * @brief Return the top value from the stack of the given variable.
     * @param variable Name of the variable.
     * @return The top element of the variable's stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public ComplexNumber peek(char variable) throws EmptyStackException {
        if (map.get(variable).empty())
            throw new EmptyStackException();
        return map.get(variable).peek();
    }

    /**
     * @brief Check whether the stack of the given variable is empty.
     * @param variable Name of the variable.
     * @return `true` if the stack is empty; `false` otherwise.
     */
    public Boolean isEmpty(char variable) {
        return map.get(variable).empty();
    }

    /**
     * @brief Clear all variables in the map.
     */
    public void clearAll() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            map.get(letter).clear();
        }
    }

    /**
     * @brief Clear a variable in the map.
     * @param variable Name of the variable.
     */
    public void clear(char variable) {
        map.get(variable).clear();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
