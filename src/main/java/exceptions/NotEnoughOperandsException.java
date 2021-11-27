package src.main.java.exceptions;

/**
 * @file NotEnoughOperandsException.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */

/**
 * @brief Indicates that not enough operands are in the stack for an operation.
 *
 */
public class NotEnoughOperandsException extends RuntimeException {
    public NotEnoughOperandsException() {

    }

    public NotEnoughOperandsException(String msg) {
        super(msg);
    }
}
