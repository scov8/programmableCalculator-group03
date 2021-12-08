package src.main.java.operations;

import src.main.java.userOperations.UserOperation;
import src.main.java.variables.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @file OperationsMap.java
 * @author Francesco Tortora
 * @date 7 Dic 2021
 */

public class OperationsMap implements Serializable {
    private Map<String, Operation> operations;
    private Map<Character, VariableOperation> variableOperations;
    private Map<String, VariableStorage> variableStorageOperations;
    private Map<String, UserOperation> userDefinedOperations;

    public OperationsMap() {
        operations = new HashMap<>();
        operations.put("+", new SumOperation());
        operations.put("-", new DifferenceOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("/", new DivisionOperation());
        operations.put("+-", new SignInversionOperation());
        operations.put("sqrt", new SquareRootOperation());
        operations.put("clear", new ClearOperation());
        operations.put("drop", new DropOperation());
        operations.put("dup", new DupOperation());
        operations.put("over", new OverOperation());
        operations.put("swap", new SwapOperation());

        variableOperations = new HashMap<>();
        variableOperations.put('>', new SaveIntoVariable());
        variableOperations.put('<', new SaveIntoStack());
        variableOperations.put('+', new PlusVariable());
        variableOperations.put('-', new MinusVariable());

        variableStorageOperations = new HashMap<>();
        variableStorageOperations.put("save", new SaveOperation());
        variableStorageOperations.put("restore", new RestoreOperation());

        userDefinedOperations = new HashMap<>();
    }

    /**
     * @return the operation
     */
    public Operation getOperation(String opString) {
        return operations.get(opString);
    }

    /**
     * @return the variable operation
     */
    public VariableOperation getVariableOperation(Character opChar) {
        return variableOperations.get(opChar);
    }

    /**
     * @return the variable storage operation
     */
    public VariableStorage getVariableStorageOperation(String opString) {
        return variableStorageOperations.get(opString);
    }

    /**
     * @return the user defined operation
     */
    public UserOperation getUserDefinedOperation(String name) {
        return userDefinedOperations.get(name);
    }

    /**
     * @param op the user defined operation to add
     */
    public void addUserDefinedOperation(UserOperation op) {
        userDefinedOperations.put(op.getName(), op);
    }

    /**
     * @param op the user defined operation to remove
     */
    public void deleteUserDefinedOperation(UserOperation op) {
        userDefinedOperations.remove(op);
    }
}
