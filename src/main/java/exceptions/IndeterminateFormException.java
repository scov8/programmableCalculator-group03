package src.main.java.exceptions;
/**
 * @file IndeterminateFormException.java
 * @author Francesco Tortora
 * @date 25 Nov 2021
 */

/**
 * @brief This exception is launched when an operation can not be performed
 *        because it creates an indeterminate form like 0/0.
 */
public class IndeterminateFormException extends RuntimeException {
    public IndeterminateFormException() {
        super();
    }

    public IndeterminateFormException(String msg) {
        super(msg);
    }
}
