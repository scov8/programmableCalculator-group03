package src.main.java.exceptions;
/**
 * @file InvalidVariableName.java
 * @author Francesco Tortora
 * @date 30 Nov 2021
 */

/**
 * @brief This exception is launched when the variable's name isn't an alphabet character
 */
public class InvalidVariableName extends RuntimeException{
    public InvalidVariableName() {
        super("The name of a variable is an alphabet character, from a to z");
    }
}
