package src.main.java.exceptions;

/**
 * @file UnrecognizedOperationException.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This exception is launched when an operation to execute is not
 *        recognized by the application.
 */
public class UnrecognizedOperationException extends RuntimeException {
    public UnrecognizedOperationException() {

    }

    public UnrecognizedOperationException(String msg) {
        super(msg);
    }
}
