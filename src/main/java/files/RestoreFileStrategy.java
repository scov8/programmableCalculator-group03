package src.main.java.files;

import javafx.stage.Window;
import src.main.java.userOperations.UserOperation;

/**
 * @file RestoreFileStrategy.java
 * @author Francesco Tortora
 * @date 10 Dec 2021
 */

/**
 * This interface declares a method to load a collection of user-defined
 * operations from a generic file.
 */
public interface RestoreFileStrategy {
    /**
     * @brief Load the collection of user-defined operations in a file.
     * @param window     Main application window.
     * @param operations Collection of operations.
     */
    public UserOperation[] execute(Window window);
}
