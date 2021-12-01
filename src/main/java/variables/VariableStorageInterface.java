package src.main.java.variables;

import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file VariableStorageInterface.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This interface declares a method to execute an operation on the stack
 *        of variables' values.
 */
public interface VariableStorageInterface {
    /**
     * @brief Execute an operation on the stack of variables' values.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    public void execute(Variables variables, VariablesStack varStack);
}
