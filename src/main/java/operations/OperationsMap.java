package src.main.java.operations;

import src.main.java.userOperations.UserOperation;
import src.main.java.variables.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @file OperationsMap.java
 * @author Francesco Tortora
 * @date 7 Dic 2021
 */

/**
 * @brief This class contains different maps in which the keys are names of
 *        various operations and the values are actual instances of the
 *        operations.
 *
 *        Each map contains a different type of operation.
 */
public class OperationsMap {
    /** This class is instantiated using the singleton design pattern. */
    private static OperationsMap INSTANCE;

    /** Operations to execute on the stack of numbers. */
    private Map<String, Operation> stackOperations;

    /** Operations to execute on the variables. */
    private Map<Character, VariableOperation> variableOperations;

    /** Operations to run on the variables stack. */
    private Map<String, VariableStorageOperation> variableStorageOperations;

    /** User-defined operations. */
    private Map<String, UserOperation> userDefinedOperations;

    /**
     * @brief Private Constructor.
     */
    private OperationsMap() {
        stackOperations = new HashMap<>();
        stackOperations.put("+", new SumOperation());
        stackOperations.put("-", new DifferenceOperation());
        stackOperations.put("*", new MultiplicationOperation());
        stackOperations.put("/", new DivisionOperation());
        stackOperations.put("+-", new SignInversionOperation());
        stackOperations.put("sqrt", new SquareRootOperation());
        stackOperations.put("clear", new ClearOperation());
        stackOperations.put("drop", new DropOperation());
        stackOperations.put("dup", new DupOperation());
        stackOperations.put("over", new OverOperation());
        stackOperations.put("swap", new SwapOperation());
        stackOperations.put("mod", new ModOperation());

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
     * @brief Public method to return the only instance of OperationsMap that
     *        can exist inside this application.
     * @return Instance of `OperationsMap`.
     */
    public static OperationsMap getInstance() {
        if (INSTANCE == null)
            INSTANCE = new OperationsMap();
        return INSTANCE;
    }

    /**
     * @brief Get a stack operation given its name.
     * @param name Operation's name.
     * @return The operation.
     */
    public Operation getStackOperation(String name) {
        return stackOperations.get(name);
    }

    /**
     * @brief Get a variable operation given its name.
     * @param name Operation's name.
     * @return The operation.
     */
    public VariableOperation getVariableOperation(Character name) {
        return variableOperations.get(name);
    }

    /**
     * @brief Get a variable storage operation given its name.
     * @param name Operation's name.
     * @return The operation.
     */
    public VariableStorageOperation getVariableStorageOperation(String name) {
        return variableStorageOperations.get(name);
    }

    /**
     * @brief Get a user-defined operation given its name.
     * @param name Operation's name.
     * @return The operation.
     */
    public UserOperation getUserDefinedOperation(String name) {
        return userDefinedOperations.get(name);
    }

    /**
     * @brief Add a new user-defined operation to the map.
     * @param op The user-defined operation to add.
     */
    public void addUserDefinedOperation(UserOperation op) {
        userDefinedOperations.put(op.getName(), op);
    }

    /**
     * @brief Remove a user-defined operation from the map.
     * @param op The user-defined operation to remove.
     */
    public void deleteUserDefinedOperation(UserOperation op) {
        userDefinedOperations.remove(op.getName());
    }

    /**
     * @brief Get all user-defined operations.
     * @return Array containing all the user-defined operations.
     */
    public UserOperation[] getAllUserDefinedOperations() {
        return userDefinedOperations.values().toArray(new UserOperation[0]);
    }

    /**
     * @brief Set all the user-defined operations.
     * @param operations Array of user-operations.
     */
    public void setAllUserDefinedOperations(UserOperation[] operations) {
        userDefinedOperations.clear();
        for (UserOperation op : operations) {
            userDefinedOperations.put(op.getName(), op);
        }
    }
}
