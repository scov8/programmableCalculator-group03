package src.main.java.exceptions;

/**
 * @file VariableWithoutValueException.java
 * @author Francesco Tortora
 * @date 02 Dic 2021
 */

/**
 * @brief This exception is launched when an operation tries to take the value
 *        of a variable but the value does not have any.
 */
public class VariableWithoutValueException extends RuntimeException {
    public VariableWithoutValueException() {

    }

    public VariableWithoutValueException(String msg) {
        super(msg);
    }
}
