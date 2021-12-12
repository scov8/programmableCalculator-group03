package src.main.java.exceptions;

/**
 * @file NotEnoughOperandsException.java
 * @author Gerardo Rosa
 * @date 25 Nov 2021
 */

/**
 * @brief This exception is launched when not enough operands can be taken from
 *        the stack to execute an operation.
 */
public class NotEnoughOperandsException extends RuntimeException {
    public NotEnoughOperandsException() {
        super();
    }

    public NotEnoughOperandsException(String msg) {
        super(msg);
    }
}
