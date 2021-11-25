package src.main.java.resources;
/**
 * @file MyStack.java
 * @author Gerardo Rosa
 * @date 24 Nov 2021
 */

 /**
 * @brief Indicates a stack is full.
 *
 */
public class FullStackException extends RuntimeException {
    // no-argument constructor
    public FullStackException() {
        super("The stack is full");
    } // end no-argument FullStackException constructor

    // one-argument constructor
    public FullStackException(String exception) {
        super(exception);
    } // end one-argument FullStackException constructor
} // end class FullStackException
