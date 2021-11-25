package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.resources.ComplexNumber;
import src.main.java.resources.Operations;

import org.junit.Assert;

/**
 * @file OperationsTest.java
 * @author Francesco Tortora
 * @date 23 Nov 2021
 */

public class OperationsTest {
    //numbers for which we will perform the operations
    private static ComplexNumber number0; //number with both parts 0
    private static ComplexNumber number1; //number with both parts positive
    private static ComplexNumber number2; //number with both parts negative
    private static ComplexNumber number3; //number with real part positive and imaginary part negative
    private static ComplexNumber number4; //number with real part negative and imaginary part positive

    //results of the sign invertion operation
    private static ComplexNumber resultSignInvertion0; //sign invertion of number 0
    private static ComplexNumber resultSignInvertion1; //sign invertion of number 1
    private static ComplexNumber resultSignInvertion2; //sign invertion of number 2
    private static ComplexNumber resultSignInvertion3; //sign invertion of number 3
    private static ComplexNumber resultSignInvertion4; //sign invertion of number 4

    //results of the sum operation
    private static ComplexNumber resultSum01; //sum result of number 0 and 1
    private static ComplexNumber resultSum02; //sum result of number 0 and 2
    private static ComplexNumber resultSum03; //sum result of number 0 and 3
    private static ComplexNumber resultSum04; //sum result of number 0 and 4
    private static ComplexNumber resultSum12; //sum result of number 1 and 2
    private static ComplexNumber resultSum13; //sum result of number 1 and 3
    private static ComplexNumber resultSum14; //sum result of number 1 and 4
    private static ComplexNumber resultSum23; //sum result of number 2 and 3
    private static ComplexNumber resultSum24; //sum result of number 2 and 4
    private static ComplexNumber resultSum34; //sum result of number 3 and 4

    //results of the difference operation
    private static ComplexNumber resultDifference01; //difference result of number 0 and 1
    private static ComplexNumber resultDifference02; //difference result of number 0 and 2
    private static ComplexNumber resultDifference03; //difference result of number 0 and 3
    private static ComplexNumber resultDifference04; //difference result of number 0 and 4
    private static ComplexNumber resultDifference12; //difference result of number 1 and 2
    private static ComplexNumber resultDifference13; //difference result of number 1 and 3
    private static ComplexNumber resultDifference14; //difference result of number 1 and 4
    private static ComplexNumber resultDifference23; //difference result of number 2 and 3
    private static ComplexNumber resultDifference24; //difference result of number 2 and 4
    private static ComplexNumber resultDifference34; //difference result of number 3 and 4
    private static ComplexNumber resultDifference10; //difference result of number 1 and 0
    private static ComplexNumber resultDifference20; //difference result of number 2 and 0
    private static ComplexNumber resultDifference30; //difference result of number 3 and 0
    private static ComplexNumber resultDifference40; //difference result of number 4 and 0
    private static ComplexNumber resultDifference21; //difference result of number 2 and 1
    private static ComplexNumber resultDifference31; //difference result of number 3 and 1
    private static ComplexNumber resultDifference41; //difference result of number 4 and 1
    private static ComplexNumber resultDifference32; //difference result of number 3 and 2
    private static ComplexNumber resultDifference42; //difference result of number 4 and 2
    private static ComplexNumber resultDifference43; //difference result of number 4 and 3

    //results of the multiplication operation
    private static ComplexNumber resultMultiplication01; //multiplication result of number 0 and 1
    private static ComplexNumber resultMultiplication02; //multiplication result of number 0 and 2
    private static ComplexNumber resultMultiplication03; //multiplication result of number 0 and 3
    private static ComplexNumber resultMultiplication04; //multiplication result of number 0 and 4
    private static ComplexNumber resultMultiplication12; //multiplication result of number 1 and 2
    private static ComplexNumber resultMultiplication13; //multiplication result of number 1 and 3
    private static ComplexNumber resultMultiplication14; //multiplication result of number 1 and 4
    private static ComplexNumber resultMultiplication23; //multiplication result of number 2 and 3
    private static ComplexNumber resultMultiplication24; //multiplication result of number 2 and 4
    private static ComplexNumber resultMultiplication34; //multiplication result of number 3 and 4

     //results of the division operation
     private static ComplexNumber resultDivision01; //division result of number 0 and 1
     private static ComplexNumber resultDivision02; //division result of number 0 and 2
     private static ComplexNumber resultDivision03; //division result of number 0 and 3
     private static ComplexNumber resultDivision04; //division result of number 0 and 4
     private static ComplexNumber resultDivision12; //division result of number 1 and 2
     private static ComplexNumber resultDivision13; //division result of number 1 and 3
     private static ComplexNumber resultDivision14; //division result of number 1 and 4
     private static ComplexNumber resultDivision23; //division result of number 2 and 3
     private static ComplexNumber resultDivision24; //division result of number 2 and 4
     private static ComplexNumber resultDivision34; //division result of number 3 and 4
     private static ComplexNumber resultDivision10; //division result of number 1 and 0
     private static ComplexNumber resultDivision20; //division result of number 2 and 0
     private static ComplexNumber resultDivision30; //division result of number 3 and 0
     private static ComplexNumber resultDivision40; //division result of number 4 and 0
     private static ComplexNumber resultDivision21; //division result of number 2 and 1
     private static ComplexNumber resultDivision31; //division result of number 3 and 1
     private static ComplexNumber resultDivision41; //division result of number 4 and 1
     private static ComplexNumber resultDivision32; //division result of number 3 and 2
     private static ComplexNumber resultDivision42; //division result of number 4 and 2
     private static ComplexNumber resultDivision43; //division result of number 4 and 3

    //results of the absolute operation
    private static ComplexNumber resultAbsolute0; //absolute of number 0
    private static ComplexNumber resultAbsolute1; //absolute of number 1
    private static ComplexNumber resultAbsolute2; //absolute of number 2
    private static ComplexNumber resultAbsolute3; //absolute of number 3
    private static ComplexNumber resultAbsolute4; //absolute of number 4

    //results of the square root operation
    private static ComplexNumber resultSquareRoot0; //square root of number 0
    private static ComplexNumber resultSquareRoot1; //square root of number 1
    private static ComplexNumber resultSquareRoot2; //square root of number 2
    private static ComplexNumber resultSquareRoot3; //square root of number 3
    private static ComplexNumber resultSquareRoot4; //square root of number 4

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0,0);
        number1 = new ComplexNumber(3,4);
        number2 = new ComplexNumber(-2,-1);
        number3 = new ComplexNumber(7,-8);
        number4 = new ComplexNumber(-10,11);

        resultSignInvertion0 = new ComplexNumber(0,0);
        resultSignInvertion1 = new ComplexNumber(-3,-4);
        resultSignInvertion2 = new ComplexNumber(2,1);
        resultSignInvertion3 = new ComplexNumber(-7,8);
        resultSignInvertion4 = new ComplexNumber(10,-11);

        resultSum01 = new ComplexNumber(3,4);
        resultSum02 = new ComplexNumber(-2,-1);
        resultSum03 = new ComplexNumber(7,-8);
        resultSum04 = new ComplexNumber(-10,11);
        resultSum12 = new ComplexNumber(1,3);
        resultSum13 = new ComplexNumber(10,-4);
        resultSum14 = new ComplexNumber(-7,15);
        resultSum23 = new ComplexNumber(5,-9);
        resultSum24 = new ComplexNumber(-12,10);
        resultSum34 = new ComplexNumber(-3,3);

        resultDifference01 = new ComplexNumber(-3,-4);
        resultDifference02 = new ComplexNumber(2,1);
        resultDifference03 = new ComplexNumber(-7,8);
        resultDifference04 = new ComplexNumber(10,-11);
        resultDifference12 = new ComplexNumber(5,5);
        resultDifference13 = new ComplexNumber(-4,12);
        resultDifference14 = new ComplexNumber(13,-7);
        resultDifference23 = new ComplexNumber(-9,7);
        resultDifference24 = new ComplexNumber(8,-12);
        resultDifference34 = new ComplexNumber(17,-19);
        resultDifference10 = new ComplexNumber(3,4);
        resultDifference20 = new ComplexNumber(-2,-1);
        resultDifference30 = new ComplexNumber(7,-8);
        resultDifference40 = new ComplexNumber(-10,11);
        resultDifference21 = new ComplexNumber(-5,-5);
        resultDifference31 = new ComplexNumber(4,-12);
        resultDifference41 = new ComplexNumber(-13,7);
        resultDifference32 = new ComplexNumber(9,-7);
        resultDifference42 = new ComplexNumber(-8,12);
        resultDifference43 = new ComplexNumber(-17,19);

        resultMultiplication01 = new ComplexNumber(0,0);
        resultMultiplication02 = new ComplexNumber(0,0);
        resultMultiplication03 = new ComplexNumber(0,0);
        resultMultiplication04 = new ComplexNumber(0,0);
        resultMultiplication12 = new ComplexNumber(-2,-11);
        resultMultiplication13 = new ComplexNumber(53,4);
        resultMultiplication14 = new ComplexNumber(-74,-7);
        resultMultiplication23 = new ComplexNumber(-22,9);
        resultMultiplication24 = new ComplexNumber(31,-12);
        resultMultiplication34 = new ComplexNumber(18,157);

        resultDivision01 = new ComplexNumber(0,0);
        resultDivision02 = new ComplexNumber(0,0);
        resultDivision03 = new ComplexNumber(0,0);
        resultDivision04 = new ComplexNumber(0,0);
        resultDivision12 = new ComplexNumber(-2,-1);
        resultDivision13 = new ComplexNumber(-0.09734513274336283185840707964601769911504424778761061946902654867256,0.46017699115044247787610619469026548672566371681415929203539823008849);
        resultDivision14 = new ComplexNumber(0.06334841628959276018099547511312217194570135746606334841628959276018,-0.33031674208144796380090497737556561085972850678733031674208144796380);
        resultDivision23 = new ComplexNumber(-0.05309734513274336283185840707964601769911504424778761061946902,-0.2035398230088495575221238938053097345132743362831858407079646);
        resultDivision24 = new ComplexNumber(0.040723981900452488687782805429864253393665158371040723981900452,0.14479638009049773755656108597285067873303167420814479638009049);
        resultDivision34 = new ComplexNumber(-0.7149321266968325791855203619909502262443438914027149321266968,0.01357466063348416289592760180995475113122171945701357466063348);
        resultDivision10 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision20 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision30 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision40 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision21 = new ComplexNumber(-0.4,+0.2);
        resultDivision31 = new ComplexNumber(-0.44,-2.08);
        resultDivision41 = new ComplexNumber(0.56,2.92);
        resultDivision32 = new ComplexNumber(-1.2,4.6);
        resultDivision42 = new ComplexNumber(1.8,-6.4);
        resultDivision43 = new ComplexNumber(-1.398230088495575221238938053097345132743362831858407079646017,-0.02654867256637168141592920353982300884955752212389380530973451);

        resultAbsolute0 = new ComplexNumber(0,0);
        resultAbsolute1 = new ComplexNumber(5,0);
        resultAbsolute2 = new ComplexNumber(2.23606797749979,0);
        resultAbsolute3 = new ComplexNumber(10.63014581273465,0);
        resultAbsolute4 = new ComplexNumber(14.866068747318506,0);

        resultSquareRoot0 = new ComplexNumber(0,0);
        resultSquareRoot1 = new ComplexNumber(2,1);
        resultSquareRoot2 = new ComplexNumber(0.343560749722512464138565743914558568472714676815569873720051985,-1.45534669022535480812266183970969706985483030680964399687535344);
        resultSquareRoot3 = new ComplexNumber(2.969018845741354,-1.347246416349780);
        resultSquareRoot4 = new ComplexNumber(1.559818698970894104631180906820401465448871379118212298874671552,3.526050818360287438882878441300650242479183111088852428113379185);
    }

    @Test
    public void testSignInvertion() {
        Assert.assertEquals("Sign Invertion of number0 works",resultSignInvertion0, Operations.signInvertion(number0));
        Assert.assertEquals("Sign Invertion of number1 works",resultSignInvertion1, Operations.signInvertion(number1));
        Assert.assertEquals("Sign Invertion of number2 works",resultSignInvertion2, Operations.signInvertion(number2));
        Assert.assertEquals("Sign Invertion of number3 works",resultSignInvertion3, Operations.signInvertion(number3));
        Assert.assertEquals("Sign Invertion of number4 works",resultSignInvertion4, Operations.signInvertion(number4));
    }

    @Test
    public void testSum() {
        Assert.assertEquals("Sum of number0 and number1 works",resultSum01, Operations.sum(number0,number1));
        Assert.assertEquals("Sum of number0 and number2 works",resultSum02, Operations.sum(number0,number2));
        Assert.assertEquals("Sum of number0 and number3 works",resultSum03, Operations.sum(number0,number3));
        Assert.assertEquals("Sum of number0 and number4 works",resultSum04, Operations.sum(number0,number4));
        Assert.assertEquals("Sum of number1 and number2 works",resultSum12, Operations.sum(number1,number2));
        Assert.assertEquals("Sum of number1 and number3 works",resultSum13, Operations.sum(number1,number3));
        Assert.assertEquals("Sum of number1 and number4 works",resultSum14, Operations.sum(number1,number4));
        Assert.assertEquals("Sum of number2 and number3 works",resultSum23, Operations.sum(number2,number3));
        Assert.assertEquals("Sum of number2 and number4 works",resultSum24, Operations.sum(number2,number4));
        Assert.assertEquals("Sum of number3 and number4 works",resultSum34, Operations.sum(number3,number4));
        Assert.assertEquals("Sum of number1 and number0 works",resultSum01, Operations.sum(number1,number0));
        Assert.assertEquals("Sum of number2 and number0 works",resultSum02, Operations.sum(number2,number0));
        Assert.assertEquals("Sum of number3 and number0 works",resultSum03, Operations.sum(number3,number0));
        Assert.assertEquals("Sum of number4 and number0 works",resultSum04, Operations.sum(number4,number0));
        Assert.assertEquals("Sum of number2 and number1 works",resultSum12, Operations.sum(number2,number1));
        Assert.assertEquals("Sum of number3 and number1 works",resultSum13, Operations.sum(number3,number1));
        Assert.assertEquals("Sum of number4 and number1 works",resultSum14, Operations.sum(number4,number1));
        Assert.assertEquals("Sum of number3 and number2 works",resultSum23, Operations.sum(number3,number2));
        Assert.assertEquals("Sum of number4 and number2 works",resultSum24, Operations.sum(number4,number2));
        Assert.assertEquals("Sum of number4 and number3 works",resultSum34, Operations.sum(number4,number3));
    }

    @Test
    public void testDifference() {
        Assert.assertEquals("Difference of number0 and number1 works",resultDifference01, Operations.difference(number0,number1));
        Assert.assertEquals("Difference of number0 and number2 works",resultDifference02, Operations.difference(number0,number2));
        Assert.assertEquals("Difference of number0 and number3 works",resultDifference03, Operations.difference(number0,number3));
        Assert.assertEquals("Difference of number0 and number4 works",resultDifference04, Operations.difference(number0,number4));
        Assert.assertEquals("Difference of number1 and number2 works",resultDifference12, Operations.difference(number1,number2));
        Assert.assertEquals("Difference of number1 and number3 works",resultDifference13, Operations.difference(number1,number3));
        Assert.assertEquals("Difference of number1 and number4 works",resultDifference14, Operations.difference(number1,number4));
        Assert.assertEquals("Difference of number2 and number3 works",resultDifference23, Operations.difference(number2,number3));
        Assert.assertEquals("Difference of number2 and number4 works",resultDifference24, Operations.difference(number2,number4));
        Assert.assertEquals("Difference of number3 and number4 works",resultDifference34, Operations.difference(number3,number4));
        Assert.assertEquals("Difference of number1 and number0 works",resultDifference10, Operations.difference(number1,number0));
        Assert.assertEquals("Difference of number2 and number0 works",resultDifference20, Operations.difference(number2,number0));
        Assert.assertEquals("Difference of number3 and number0 works",resultDifference30, Operations.difference(number3,number0));
        Assert.assertEquals("Difference of number4 and number0 works",resultDifference40, Operations.difference(number4,number0));
        Assert.assertEquals("Difference of number2 and number1 works",resultDifference21, Operations.difference(number2,number1));
        Assert.assertEquals("Difference of number3 and number1 works",resultDifference31, Operations.difference(number3,number1));
        Assert.assertEquals("Difference of number4 and number1 works",resultDifference41, Operations.difference(number4,number1));
        Assert.assertEquals("Difference of number3 and number2 works",resultDifference32, Operations.difference(number3,number2));
        Assert.assertEquals("Difference of number4 and number2 works",resultDifference42, Operations.difference(number4,number2));
        Assert.assertEquals("Difference of number4 and number3 works",resultDifference43, Operations.difference(number4,number3));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("Multiplication of number0 and number1 works",resultMultiplication01, Operations.multiplication(number0,number1));
        Assert.assertEquals("Multiplication of number0 and number2 works",resultMultiplication02, Operations.multiplication(number0,number2));
        Assert.assertEquals("Multiplication of number0 and number3 works",resultMultiplication03, Operations.multiplication(number0,number3));
        Assert.assertEquals("Multiplication of number0 and number4 works",resultMultiplication04, Operations.multiplication(number0,number4));
        Assert.assertEquals("Multiplication of number1 and number2 works",resultMultiplication12, Operations.multiplication(number1,number2));
        Assert.assertEquals("Multiplication of number1 and number3 works",resultMultiplication13, Operations.multiplication(number1,number3));
        Assert.assertEquals("Multiplication of number1 and number4 works",resultMultiplication14, Operations.multiplication(number1,number4));
        Assert.assertEquals("Multiplication of number2 and number3 works",resultMultiplication23, Operations.multiplication(number2,number3));
        Assert.assertEquals("Multiplication of number2 and number4 works",resultMultiplication24, Operations.multiplication(number2,number4));
        Assert.assertEquals("Multiplication of number3 and number4 works",resultMultiplication34, Operations.multiplication(number3,number4));
        Assert.assertEquals("Multiplication of number1 and number0 works",resultMultiplication01, Operations.multiplication(number1,number0));
        Assert.assertEquals("Multiplication of number2 and number0 works",resultMultiplication02, Operations.multiplication(number2,number0));
        Assert.assertEquals("Multiplication of number3 and number0 works",resultMultiplication03, Operations.multiplication(number3,number0));
        Assert.assertEquals("Multiplication of number4 and number0 works",resultMultiplication04, Operations.multiplication(number4,number0));
        Assert.assertEquals("Multiplication of number2 and number1 works",resultMultiplication12, Operations.multiplication(number2,number1));
        Assert.assertEquals("Multiplication of number3 and number1 works",resultMultiplication13, Operations.multiplication(number3,number1));
        Assert.assertEquals("Multiplication of number4 and number1 works",resultMultiplication14, Operations.multiplication(number4,number1));
        Assert.assertEquals("Multiplication of number3 and number2 works",resultMultiplication23, Operations.multiplication(number3,number2));
        Assert.assertEquals("Multiplication of number4 and number2 works",resultMultiplication24, Operations.multiplication(number4,number2));
        Assert.assertEquals("Multiplication of number4 and number3 works",resultMultiplication34, Operations.multiplication(number4,number3));
    }

    @Test
    public void testDivision() {
        Assert.assertEquals("Division of number0 and number1 works",resultDivision01, Operations.division(number0,number1));
        Assert.assertEquals("Division of number0 and number2 works",resultDivision02, Operations.division(number0,number2));
        Assert.assertEquals("Division of number0 and number3 works",resultDivision03, Operations.division(number0,number3));
        Assert.assertEquals("Division of number0 and number4 works",resultDivision04, Operations.division(number0,number4));
        Assert.assertEquals("Division of number1 and number2 works",resultDivision12, Operations.division(number1,number2));
        Assert.assertEquals("Division of number1 and number3 works",resultDivision13, Operations.division(number1,number3));
        Assert.assertEquals("Division of number1 and number4 works",resultDivision14, Operations.division(number1,number4));
        Assert.assertEquals("Division of number2 and number3 works",resultDivision23, Operations.division(number2,number3));
        Assert.assertEquals("Division of number2 and number4 works",resultDivision24, Operations.division(number2,number4));
        Assert.assertEquals("Division of number3 and number4 works",resultDivision34, Operations.division(number3,number4));
        Assert.assertEquals("Division of number1 and number0 works",resultDivision10, Operations.division(number1,number0));
        Assert.assertEquals("Division of number2 and number0 works",resultDivision20, Operations.division(number2,number0));
        Assert.assertEquals("Division of number3 and number0 works",resultDivision30, Operations.division(number3,number0));
        Assert.assertEquals("Division of number4 and number0 works",resultDivision40, Operations.division(number4,number0));
        Assert.assertEquals("Division of number2 and number1 works",resultDivision21, Operations.division(number2,number1));
        Assert.assertEquals("Division of number3 and number1 works",resultDivision31, Operations.division(number3,number1));
        Assert.assertEquals("Division of number4 and number1 works",resultDivision41, Operations.division(number4,number1));
        Assert.assertEquals("Division of number3 and number2 works",resultDivision32, Operations.division(number3,number2));
        Assert.assertEquals("Division of number4 and number2 works",resultDivision42, Operations.division(number4,number2));
        Assert.assertEquals("Division of number4 and number3 works",resultDivision43, Operations.division(number4,number3));
    }

    @Test
    public void testAbsolute() {
        Assert.assertEquals("Absolute of number0 works",resultAbsolute0, Operations.absolute(number0));
        Assert.assertEquals("Absolute of number1 works",resultAbsolute1, Operations.absolute(number1));
        Assert.assertEquals("Absolute of number2 works",resultAbsolute2, Operations.absolute(number2));
        Assert.assertEquals("Absolute of number3 works",resultAbsolute3, Operations.absolute(number3));
        Assert.assertEquals("Absolute of number4 works",resultAbsolute4, Operations.absolute(number4));
    }

    @Test
    public void testSquareRoot() {
        Assert.assertEquals("Square Root of number0 works",resultSquareRoot0, Operations.squareRoot(number0));
        Assert.assertEquals("Square Root of number1 works",resultSquareRoot1, Operations.squareRoot(number1));
        Assert.assertEquals("Square Root of number2 works",resultSquareRoot2, Operations.squareRoot(number2));
        Assert.assertEquals("Square Root of number3 works",resultSquareRoot3, Operations.squareRoot(number3));
        Assert.assertEquals("Square Root of number4 works",resultSquareRoot4, Operations.squareRoot(number4));
    }
}
