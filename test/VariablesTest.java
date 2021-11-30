package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.exceptions.InvalidVariableName;
import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Variables;

import java.util.EmptyStackException;

import org.junit.Assert;

public class VariablesTest {
    private static ComplexNumber number0;
    private static ComplexNumber number1;
    private static ComplexNumber number2;
    private static Variables variables;

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(4,5);
        number1 = new ComplexNumber(-2,1);
        number2 = new ComplexNumber(7,-8);
        variables = new Variables();
    }

    @Test
    public void testAddNumbersToAllStacks() {
        variables.push('a',number0);
        variables.push('a',number1);
        Assert.assertEquals(number1, variables.pop('a'));
        variables.push('a',number2);
        Assert.assertEquals(number2, variables.pop('a'));
        Assert.assertEquals(number0, variables.pop('a'));

        variables.push('b',number0);
        variables.push('b',number1);
        Assert.assertEquals(number1, variables.pop('b'));
        variables.push('b',number2);
        Assert.assertEquals(number2, variables.pop('b'));
        Assert.assertEquals(number0, variables.pop('b'));

        variables.push('c',number0);
        variables.push('c',number1);
        Assert.assertEquals(number1, variables.pop('c'));
        variables.push('c',number2);
        Assert.assertEquals(number2, variables.pop('c'));
        Assert.assertEquals(number0, variables.pop('c'));

        variables.push('d',number0);
        variables.push('d',number1);
        Assert.assertEquals(number1, variables.pop('d'));
        variables.push('d',number2);
        Assert.assertEquals(number2, variables.pop('d'));
        Assert.assertEquals(number0, variables.pop('d'));

        variables.push('e',number0);
        variables.push('e',number1);
        Assert.assertEquals(number1, variables.pop('e'));
        variables.push('e',number2);
        Assert.assertEquals(number2, variables.pop('e'));
        Assert.assertEquals(number0, variables.pop('e'));

        variables.push('f',number0);
        variables.push('f',number1);
        Assert.assertEquals(number1, variables.pop('f'));
        variables.push('f',number2);
        Assert.assertEquals(number2, variables.pop('f'));
        Assert.assertEquals(number0, variables.pop('f'));

        variables.push('g',number0);
        variables.push('g',number1);
        Assert.assertEquals(number1, variables.pop('g'));
        variables.push('g',number2);
        Assert.assertEquals(number2, variables.pop('g'));
        Assert.assertEquals(number0, variables.pop('g'));

        variables.push('h',number0);
        variables.push('h',number1);
        Assert.assertEquals(number1, variables.pop('h'));
        variables.push('h',number2);
        Assert.assertEquals(number2, variables.pop('h'));
        Assert.assertEquals(number0, variables.pop('h'));

        variables.push('i',number0);
        variables.push('i',number1);
        Assert.assertEquals(number1, variables.pop('i'));
        variables.push('i',number2);
        Assert.assertEquals(number2, variables.pop('i'));
        Assert.assertEquals(number0, variables.pop('i'));

        variables.push('j',number0);
        variables.push('j',number1);
        Assert.assertEquals(number1, variables.pop('j'));
        variables.push('j',number2);
        Assert.assertEquals(number2, variables.pop('j'));
        Assert.assertEquals(number0, variables.pop('j'));

        variables.push('k',number0);
        variables.push('k',number1);
        Assert.assertEquals(number1, variables.pop('k'));
        variables.push('k',number2);
        Assert.assertEquals(number2, variables.pop('k'));
        Assert.assertEquals(number0, variables.pop('k'));

        variables.push('l',number0);
        variables.push('l',number1);
        Assert.assertEquals(number1, variables.pop('l'));
        variables.push('l',number2);
        Assert.assertEquals(number2, variables.pop('l'));
        Assert.assertEquals(number0, variables.pop('l'));

        variables.push('m',number0);
        variables.push('m',number1);
        Assert.assertEquals(number1, variables.pop('m'));
        variables.push('m',number2);
        Assert.assertEquals(number2, variables.pop('m'));
        Assert.assertEquals(number0, variables.pop('m'));

        variables.push('n',number0);
        variables.push('n',number1);
        Assert.assertEquals(number1, variables.pop('n'));
        variables.push('n',number2);
        Assert.assertEquals(number2, variables.pop('n'));
        Assert.assertEquals(number0, variables.pop('n'));

        variables.push('o',number0);
        variables.push('o',number1);
        Assert.assertEquals(number1, variables.pop('o'));
        variables.push('o',number2);
        Assert.assertEquals(number2, variables.pop('o'));
        Assert.assertEquals(number0, variables.pop('o'));

        variables.push('p',number0);
        variables.push('p',number1);
        Assert.assertEquals(number1, variables.pop('p'));
        variables.push('p',number2);
        Assert.assertEquals(number2, variables.pop('p'));
        Assert.assertEquals(number0, variables.pop('p'));

        variables.push('q',number0);
        variables.push('q',number1);
        Assert.assertEquals(number1, variables.pop('q'));
        variables.push('q',number2);
        Assert.assertEquals(number2, variables.pop('q'));
        Assert.assertEquals(number0, variables.pop('q'));

        variables.push('r',number0);
        variables.push('r',number1);
        Assert.assertEquals(number1, variables.pop('r'));
        variables.push('r',number2);
        Assert.assertEquals(number2, variables.pop('r'));
        Assert.assertEquals(number0, variables.pop('r'));

        variables.push('s',number0);
        variables.push('s',number1);
        Assert.assertEquals(number1, variables.pop('s'));
        variables.push('s',number2);
        Assert.assertEquals(number2, variables.pop('s'));
        Assert.assertEquals(number0, variables.pop('s'));

        variables.push('t',number0);
        variables.push('t',number1);
        Assert.assertEquals(number1, variables.pop('t'));
        variables.push('t',number2);
        Assert.assertEquals(number2, variables.pop('t'));
        Assert.assertEquals(number0, variables.pop('t'));

        variables.push('u',number0);
        variables.push('u',number1);
        Assert.assertEquals(number1, variables.pop('u'));
        variables.push('u',number2);
        Assert.assertEquals(number2, variables.pop('u'));
        Assert.assertEquals(number0, variables.pop('u'));

        variables.push('v',number0);
        variables.push('v',number1);
        Assert.assertEquals(number1, variables.pop('v'));
        variables.push('v',number2);
        Assert.assertEquals(number2, variables.pop('v'));
        Assert.assertEquals(number0, variables.pop('v'));

        variables.push('w',number0);
        variables.push('w',number1);
        Assert.assertEquals(number1, variables.pop('w'));
        variables.push('w',number2);
        Assert.assertEquals(number2, variables.pop('w'));
        Assert.assertEquals(number0, variables.pop('w'));

        variables.push('x',number0);
        variables.push('x',number1);
        Assert.assertEquals(number1, variables.pop('x'));
        variables.push('x',number2);
        Assert.assertEquals(number2, variables.pop('x'));
        Assert.assertEquals(number0, variables.pop('x'));

        variables.push('y',number0);
        variables.push('y',number1);
        Assert.assertEquals(number1, variables.pop('y'));
        variables.push('y',number2);
        Assert.assertEquals(number2, variables.pop('y'));
        Assert.assertEquals(number0, variables.pop('y'));

        variables.push('z',number0);
        variables.push('z',number1);
        Assert.assertEquals(number1, variables.pop('z'));
        variables.push('z',number2);
        Assert.assertEquals(number2, variables.pop('z'));
        Assert.assertEquals(number0, variables.pop('z'));
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackException() {
        variables.pop('a');
    }

    @Test(expected = InvalidVariableName.class)
    public void testInvalidVariableNamePush() {
        variables.push('?',number0);
    }

    @Test(expected = InvalidVariableName.class)
    public void testInvalidVariableNamePop() {
        variables.push('?',number0);
    }

}
