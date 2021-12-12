package src.main.java.variables;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;
import src.main.java.resources.VariablesStack;

/**
 * @file SaveOperation.java
 * @author Gerardo Rosa
 * @date 01 Dic 2021
 */

/**
 * @brief This class lets the user execute the 'save' operation.
 */
public class SaveOperation extends VariableStorageOperation {

    public SaveOperation() {
    }

    /**
     * @brief For each variable, save a copy of its value into the variable stack.
     * @param variables All the variables.
     * @param varStack  The stack storing multiple values for each variable.
     */
    @Override
    public void execute(Variables variables, VariablesStack varStack) {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            ComplexNumber numbertToSave = variables.get(letter);
            if (numbertToSave != null)
                varStack.push(letter, numbertToSave);
        }
    }
}
