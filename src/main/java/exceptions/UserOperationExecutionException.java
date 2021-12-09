package src.main.java.exceptions;

/**
 * @file UserOperationExecutionException.java
 * @author Marco Plaitano
 * @date 09 Dec 2021
 */

/**
 * @brief This exception is launched when an error occurs during the execution
 *        of a user-defined operation.
 */
public class UserOperationExecutionException extends RuntimeException {
    public UserOperationExecutionException() {

    }

    public UserOperationExecutionException(String msg) {
        super(msg);
    }
}
