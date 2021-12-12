package src.main.java.variables;

import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file VariableStorageOperationInterface.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This interface declares a method to execute an operation on the stack
 *        of variables' values.
 *
 *        This implementation follows the command design pattern.
 */
public interface VariableStorageOperationInterface {
    /**
     * @brief Execute an operation on the stack of variables' values.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    public void execute(Variables variables, VariablesStack varStack);
}
