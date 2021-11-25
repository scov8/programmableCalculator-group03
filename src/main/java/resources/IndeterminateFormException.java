package src.main.java.resources;
/**
 * @file MyStack.java
 * @author Francesco Tortora
 * @date 25 Nov 2021
 */

 /**
 * @brief Indicates an indeterminate form
 *
 */
public class IndeterminateFormException extends RuntimeException {
    public IndeterminateFormException() {
        super("You have generated an indeterminate form");
    }
}
