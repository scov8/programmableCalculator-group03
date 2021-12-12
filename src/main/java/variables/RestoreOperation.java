package src.main.java.variables;

import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file RestoreOperation.java
 * @author Marco Plaitano
 * @date 01 Dic 2021
 */

/**
 * @brief This class lets the user execute the 'restore' operation.
 *
 *        All the variables will be updated to the last value saved for each of
 *        them in the VariablesStack.
 */
public class RestoreOperation extends VariableStorageOperation {
    /**
     * @brief Update all the variables with the top value saved in the stack for
     *        each of them.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    @Override
    public void execute(Variables variables, VariablesStack varStack) {
        for (char letter = 'a'; letter <= 'z'; letter++)
            if (!varStack.isEmpty(letter))
                variables.set(letter, varStack.pop(letter));
    }
}
