package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.FullStackException;
import src.main.java.resources.MyStack;

public class FullStackExceptionTest {
    private static final int MAXIMUM_SIZE = 256;
    private static MyStack<ComplexNumber> data;
    private static ComplexNumber number0; //number with real part negative and imaginary part positive

    @BeforeClass
    public static void setUp() {
        data = new MyStack<>();
        number0 = new ComplexNumber(-2,1);
        for (int i = 0; i < MAXIMUM_SIZE; i++)
            data.push(number0);
    }

    @Test(expected = FullStackException.class)
    public void testFullStackExceptionOnPush() {
        Assert.assertTrue(data.isFull());
        data.push(number0);
    }

    @Test(expected = FullStackException.class)
    public void testFullStackExceptionOnDup() {
        Assert.assertTrue(data.isFull());
        data.dup();
    }

    @Test(expected = FullStackException.class)
    public void testFullStackExceptionOnSwap() {
        Assert.assertTrue(data.isFull());
        data.swap();
    }

    @Test(expected = FullStackException.class)
    public void testFullStackExceptionOnOver() {
        Assert.assertTrue(data.isFull());
        data.over();
    }
}
