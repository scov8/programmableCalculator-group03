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
 */
public class RestoreOperation extends VariableStorage {
    /**
     * @brief Update all the variables with the top value saved in the stack for
     *        each of them.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    @Override
    public void execute(Variables variables, VariablesStack varStack) {
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++)
            if (!varStack.isEmpty(alphabet))
                variables.set(alphabet, varStack.pop(alphabet));
    }
}
