package src.main.java.resources;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @file MyStack.java
 * @author Gerardo Rosa
 * @date 22 Nov 2021
 */

 /**
 * @brief This class represents a Stack data structure.
 *
 */
public class MyStack<T> {

    private static final int MAXIMUM_SIZE = 256;
    private T[] data; // store elements of stack
    private int top; // represent top of stack
    private int capacity; // total capacity of the stack

    /**
     * @brief Stack data structure constructor.
     *
     */
    public MyStack() {
        this.data = (T[]) new Object[MAXIMUM_SIZE];
        this.capacity = MAXIMUM_SIZE;
        this.top = -1;
    }
    /**
     * @brief Pushes an element on the top of the stack..
     * @throws FullStackException if stack is full.
     */
    public void push(T value) throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        this.data[++this.top] = value;
    }
    /**
     * @brief Removes and returns the top element of the stack.
     * @throws EmptyStackException if stack is empty.
     * @return The object at the top of this stack
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = this.data[this.top];
        this.data[this.top--] = null;
        return element;
    }
    /**
     * @brief  Returns the element on the top of the stack but does not remove it.
     * @throws EmptyStackException if stack is empty.
     * @return The object at the top of this stack
     */
    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return this.data[this.top];
    }
    /**
     * @brief Returns the size of stack.
     * @return The size of stack
     *
     */
    public int getSize() {
        return this.top + 1;
    }
    /**
     * @brief Tests if this stack is empty.
     * @return True if and only if this stack contains no elements; false otherwise.
     *
     */
    public Boolean isEmpty() {
        return this.top == -1;
    }
    /**
     * @brief Tests if this stack is full.
     * @return True if and only if this stack contains elements equal to the capacity; false otherwise.
     *
     */
    public Boolean isFull() {
        return this.top == capacity - 1;
    }
    /**
     * @brief Print the stack data structure and value of top.
     * @return Stack print string with current top.
     */
    @Override
    public String toString() {
        return "Stack [array=" + Arrays.toString(this.data) + ", top=" + this.top + "]";
    }
    /**
     * @brief Removes all the elements.
     * @throws EmptyStackException if stack is empty.
     */
    public void clear() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        for (int i = this.top; i >= 0; i--) {
            this.pop();
        }
    }
    /**
     * @brief Removes the last element.
     * @throws EmptyStackException if stack is empty.
     */
    public void drop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        this.pop();
    }
    /**
     * @brief Pushes a copy of the last element;.
     * @throws FullStackException if stack is full.
     */
    public void dup() throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        this.push(this.top());
    }

    /**
     * @brief Exchanges the last two elements.
     * @throws FullStackException if stack is full.
     */
    public void swap() throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        T element1 = this.pop();
        T element2 = this.pop();
        this.push(element1);
        this.push(element2);
    }
    /**
     * @brief Pushes a copy of the second last element.
     * @throws FullStackException if stack is full.
     */
    public void over() throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        T element1 = this.pop();
        T element2 = this.top();
        this.push(element1);
        this.push(element2);
    }
}
