package src.main.java.exceptions;

/**
 * @file UnrecognizedInputException.java
 * @author Marco Plaitano
 * @date 30 Nov 2021
 */

/**
 * @brief This exception is launched when the input given by the user is not
 *        recognized by the application.
 */
public class UnrecognizedInputException extends RuntimeException {
    public UnrecognizedInputException() {

    }

    public UnrecognizedInputException(String msg) {
        super(msg);
    }
}
