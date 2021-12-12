package src.main.java.variables;

import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file VariableStorageOperation.java
 * @author Francesco Tortora
 * @date 01 Dic 2021
 */

/**
 * @brief This abstract class represents an operation to execute on the stack
 *        of variables' values.
 */
public abstract class VariableStorageOperation implements VariableStorageOperationInterface {
    /**
     * @brief Execute an operation on the stack of variables' values.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    @Override
    public abstract void execute(Variables variables, VariablesStack varStack);

}
