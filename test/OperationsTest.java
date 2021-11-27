package test;

import org.junit.BeforeClass;
import org.junit.Test;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.operations.Operations;
import src.main.java.resources.ComplexNumber;

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
    private static ComplexNumber number5; //number with only real part
    private static ComplexNumber number6; //number with only imaginary part

    //results of the sign invertion operation
    private static ComplexNumber resultSignInvertion0; //sign invertion of number 0
    private static ComplexNumber resultSignInvertion1; //sign invertion of number 1
    private static ComplexNumber resultSignInvertion2; //sign invertion of number 2
    private static ComplexNumber resultSignInvertion3; //sign invertion of number 3
    private static ComplexNumber resultSignInvertion4; //sign invertion of number 4
    private static ComplexNumber resultSignInvertion5; //sign invertion of number 5
    private static ComplexNumber resultSignInvertion6; //sign invertion of number 6


    //results of the sum operation
    private static ComplexNumber resultSum00; //sum result of number 0 and 0
    private static ComplexNumber resultSum01; //sum result of number 0 and 1
    private static ComplexNumber resultSum02; //sum result of number 0 and 2
    private static ComplexNumber resultSum03; //sum result of number 0 and 3
    private static ComplexNumber resultSum04; //sum result of number 0 and 4
    private static ComplexNumber resultSum05; //sum result of number 0 and 5
    private static ComplexNumber resultSum06; //sum result of number 0 and 6
    private static ComplexNumber resultSum11; //sum result of number 1 and 1
    private static ComplexNumber resultSum12; //sum result of number 1 and 2
    private static ComplexNumber resultSum13; //sum result of number 1 and 3
    private static ComplexNumber resultSum14; //sum result of number 1 and 4
    private static ComplexNumber resultSum15; //sum result of number 1 and 5
    private static ComplexNumber resultSum16; //sum result of number 1 and 6
    private static ComplexNumber resultSum22; //sum result of number 2 and 2
    private static ComplexNumber resultSum23; //sum result of number 2 and 3
    private static ComplexNumber resultSum24; //sum result of number 2 and 4
    private static ComplexNumber resultSum25; //sum result of number 2 and 5
    private static ComplexNumber resultSum26; //sum result of number 2 and 6
    private static ComplexNumber resultSum33; //sum result of number 3 and 3
    private static ComplexNumber resultSum34; //sum result of number 3 and 4
    private static ComplexNumber resultSum35; //sum result of number 3 and 5
    private static ComplexNumber resultSum36; //sum result of number 3 and 6
    private static ComplexNumber resultSum44; //sum result of number 4 and 4
    private static ComplexNumber resultSum45; //sum result of number 4 and 5
    private static ComplexNumber resultSum46; //sum result of number 4 and 6
    private static ComplexNumber resultSum55; //sum result of number 5 and 5
    private static ComplexNumber resultSum56; //sum result of number 5 and 6
    private static ComplexNumber resultSum66; //sum result of number 6 and 6

    //results of the difference operation
    private static ComplexNumber resultDifference00; //difference result of number 0 and 0
    private static ComplexNumber resultDifference01; //difference result of number 0 and 1
    private static ComplexNumber resultDifference02; //difference result of number 0 and 2
    private static ComplexNumber resultDifference03; //difference result of number 0 and 3
    private static ComplexNumber resultDifference04; //difference result of number 0 and 4
    private static ComplexNumber resultDifference05; //difference result of number 0 and 5
    private static ComplexNumber resultDifference06; //difference result of number 0 and 6
    private static ComplexNumber resultDifference11; //difference result of number 1 and 1
    private static ComplexNumber resultDifference12; //difference result of number 1 and 2
    private static ComplexNumber resultDifference13; //difference result of number 1 and 3
    private static ComplexNumber resultDifference14; //difference result of number 1 and 4
    private static ComplexNumber resultDifference15; //difference result of number 1 and 5
    private static ComplexNumber resultDifference16; //difference result of number 1 and 6
    private static ComplexNumber resultDifference22; //difference result of number 2 and 2
    private static ComplexNumber resultDifference23; //difference result of number 2 and 3
    private static ComplexNumber resultDifference24; //difference result of number 2 and 4
    private static ComplexNumber resultDifference25; //difference result of number 2 and 5
    private static ComplexNumber resultDifference26; //difference result of number 2 and 6
    private static ComplexNumber resultDifference33; //difference result of number 3 and 3
    private static ComplexNumber resultDifference34; //difference result of number 3 and 4
    private static ComplexNumber resultDifference35; //difference result of number 3 and 5
    private static ComplexNumber resultDifference36; //difference result of number 3 and 6
    private static ComplexNumber resultDifference44; //difference result of number 4 and 4
    private static ComplexNumber resultDifference45; //difference result of number 4 and 5
    private static ComplexNumber resultDifference46; //difference result of number 4 and 6
    private static ComplexNumber resultDifference55; //difference result of number 5 and 5
    private static ComplexNumber resultDifference56; //difference result of number 5 and 6
    private static ComplexNumber resultDifference66; //difference result of number 6 and 6
    private static ComplexNumber resultDifference10; //difference result of number 1 and 0
    private static ComplexNumber resultDifference20; //difference result of number 2 and 0
    private static ComplexNumber resultDifference30; //difference result of number 3 and 0
    private static ComplexNumber resultDifference40; //difference result of number 4 and 0
    private static ComplexNumber resultDifference50; //difference result of number 5 and 0
    private static ComplexNumber resultDifference60; //difference result of number 6 and 0
    private static ComplexNumber resultDifference21; //difference result of number 2 and 1
    private static ComplexNumber resultDifference31; //difference result of number 3 and 1
    private static ComplexNumber resultDifference41; //difference result of number 4 and 1
    private static ComplexNumber resultDifference51; //difference result of number 5 and 1
    private static ComplexNumber resultDifference61; //difference result of number 6 and 1
    private static ComplexNumber resultDifference32; //difference result of number 3 and 2
    private static ComplexNumber resultDifference42; //difference result of number 4 and 2
    private static ComplexNumber resultDifference52; //difference result of number 5 and 2
    private static ComplexNumber resultDifference62; //difference result of number 6 and 2
    private static ComplexNumber resultDifference43; //difference result of number 4 and 3
    private static ComplexNumber resultDifference53; //difference result of number 5 and 3
    private static ComplexNumber resultDifference63; //difference result of number 6 and 3
    private static ComplexNumber resultDifference54; //difference result of number 5 and 4
    private static ComplexNumber resultDifference64; //difference result of number 6 and 4
    private static ComplexNumber resultDifference65; //difference result of number 6 and 5

    //results of the multiplication operation
    private static ComplexNumber resultMultiplication00; //multiplication result of number 0 and 0
    private static ComplexNumber resultMultiplication01; //multiplication result of number 0 and 1
    private static ComplexNumber resultMultiplication02; //multiplication result of number 0 and 2
    private static ComplexNumber resultMultiplication03; //multiplication result of number 0 and 3
    private static ComplexNumber resultMultiplication04; //multiplication result of number 0 and 4
    private static ComplexNumber resultMultiplication05; //multiplication result of number 0 and 5
    private static ComplexNumber resultMultiplication06; //multiplication result of number 0 and 6
    private static ComplexNumber resultMultiplication11; //multiplication result of number 1 and 1
    private static ComplexNumber resultMultiplication12; //multiplication result of number 1 and 2
    private static ComplexNumber resultMultiplication13; //multiplication result of number 1 and 3
    private static ComplexNumber resultMultiplication14; //multiplication result of number 1 and 4
    private static ComplexNumber resultMultiplication15; //multiplication result of number 1 and 5
    private static ComplexNumber resultMultiplication16; //multiplication result of number 1 and 6
    private static ComplexNumber resultMultiplication22; //multiplication result of number 2 and 2
    private static ComplexNumber resultMultiplication23; //multiplication result of number 2 and 3
    private static ComplexNumber resultMultiplication24; //multiplication result of number 2 and 4
    private static ComplexNumber resultMultiplication25; //multiplication result of number 2 and 5
    private static ComplexNumber resultMultiplication26; //multiplication result of number 2 and 6
    private static ComplexNumber resultMultiplication33; //multiplication result of number 3 and 3
    private static ComplexNumber resultMultiplication34; //multiplication result of number 3 and 4
    private static ComplexNumber resultMultiplication35; //multiplication result of number 3 and 5
    private static ComplexNumber resultMultiplication36; //multiplication result of number 3 and 6
    private static ComplexNumber resultMultiplication44; //multiplication result of number 4 and 4
    private static ComplexNumber resultMultiplication45; //multiplication result of number 4 and 5
    private static ComplexNumber resultMultiplication46; //multiplication result of number 4 and 6
    private static ComplexNumber resultMultiplication55; //multiplication result of number 5 and 5
    private static ComplexNumber resultMultiplication56; //multiplication result of number 5 and 6
    private static ComplexNumber resultMultiplication66; //multiplication result of number 6 and 6



     //results of the division operation
     private static ComplexNumber resultDivision01; //division result of number 0 and 1
     private static ComplexNumber resultDivision02; //division result of number 0 and 2
     private static ComplexNumber resultDivision03; //division result of number 0 and 3
     private static ComplexNumber resultDivision04; //division result of number 0 and 4
     private static ComplexNumber resultDivision05; //division result of number 0 and 5
     private static ComplexNumber resultDivision06; //division result of number 0 and 6
     private static ComplexNumber resultDivision11; //division result of number 1 and 1
     private static ComplexNumber resultDivision12; //division result of number 1 and 2
     private static ComplexNumber resultDivision13; //division result of number 1 and 3
     private static ComplexNumber resultDivision14; //division result of number 1 and 4
     private static ComplexNumber resultDivision15; //division result of number 1 and 5
     private static ComplexNumber resultDivision16; //division result of number 1 and 6
     private static ComplexNumber resultDivision22; //division result of number 2 and 2
     private static ComplexNumber resultDivision23; //division result of number 2 and 3
     private static ComplexNumber resultDivision24; //division result of number 2 and 4
     private static ComplexNumber resultDivision25; //division result of number 2 and 5
     private static ComplexNumber resultDivision26; //division result of number 2 and 6
     private static ComplexNumber resultDivision33; //division result of number 3 and 3
     private static ComplexNumber resultDivision34; //division result of number 3 and 4
     private static ComplexNumber resultDivision35; //division result of number 3 and 5
     private static ComplexNumber resultDivision36; //division result of number 3 and 6
     private static ComplexNumber resultDivision44; //division result of number 4 and 4
     private static ComplexNumber resultDivision45; //division result of number 4 and 5
     private static ComplexNumber resultDivision46; //division result of number 4 and 6
     private static ComplexNumber resultDivision55; //division result of number 5 and 5
     private static ComplexNumber resultDivision56; //division result of number 5 and 6
     private static ComplexNumber resultDivision66; //division result of number 6 and 6
     private static ComplexNumber resultDivision10; //division result of number 1 and 0
     private static ComplexNumber resultDivision20; //division result of number 2 and 0
     private static ComplexNumber resultDivision30; //division result of number 3 and 0
     private static ComplexNumber resultDivision40; //division result of number 4 and 0
     private static ComplexNumber resultDivision50; //division result of number 5 and 0
     private static ComplexNumber resultDivision60; //division result of number 6 and 0
     private static ComplexNumber resultDivision21; //division result of number 2 and 1
     private static ComplexNumber resultDivision31; //division result of number 3 and 1
     private static ComplexNumber resultDivision41; //division result of number 4 and 1
     private static ComplexNumber resultDivision51; //division result of number 5 and 1
     private static ComplexNumber resultDivision61; //division result of number 6 and 1
     private static ComplexNumber resultDivision32; //division result of number 3 and 2
     private static ComplexNumber resultDivision42; //division result of number 4 and 2
     private static ComplexNumber resultDivision52; //division result of number 5 and 2
     private static ComplexNumber resultDivision62; //division result of number 6 and 2
     private static ComplexNumber resultDivision43; //division result of number 4 and 3
     private static ComplexNumber resultDivision53; //division result of number 5 and 3
     private static ComplexNumber resultDivision63; //division result of number 6 and 3
     private static ComplexNumber resultDivision54; //division result of number 5 and 4
     private static ComplexNumber resultDivision64; //division result of number 6 and 4
     private static ComplexNumber resultDivision65; //division result of number 6 and 5


    //results of the absolute operation
    // private static ComplexNumber resultAbsolute0; //absolute of number 0
    // private static ComplexNumber resultAbsolute1; //absolute of number 1
    // private static ComplexNumber resultAbsolute2; //absolute of number 2
    // private static ComplexNumber resultAbsolute3; //absolute of number 3
    // private static ComplexNumber resultAbsolute4; //absolute of number 4
    // private static ComplexNumber resultAbsolute5; //absolute of number 5
    // private static ComplexNumber resultAbsolute6; //absolute of number 6


    //results of the square root operation
    private static ComplexNumber resultSquareRoot0; //square root of number 0
    private static ComplexNumber resultSquareRoot1; //square root of number 1
    private static ComplexNumber resultSquareRoot2; //square root of number 2
    private static ComplexNumber resultSquareRoot3; //square root of number 3
    private static ComplexNumber resultSquareRoot4; //square root of number 4
    private static ComplexNumber resultSquareRoot5; //square root of number 5
    private static ComplexNumber resultSquareRoot6; //square root of number 6

    @BeforeClass
    public static void setUp() {
        number0 = new ComplexNumber(0,0);
        number1 = new ComplexNumber(3,4);
        number2 = new ComplexNumber(-2,-1);
        number3 = new ComplexNumber(7,-8);
        number4 = new ComplexNumber(-10,11);
        number5 = new ComplexNumber(8,0);
        number6 = new ComplexNumber(0,-4);

        resultSignInvertion0 = new ComplexNumber(0,0);
        resultSignInvertion1 = new ComplexNumber(-3,-4);
        resultSignInvertion2 = new ComplexNumber(2,1);
        resultSignInvertion3 = new ComplexNumber(-7,8);
        resultSignInvertion4 = new ComplexNumber(10,-11);
        resultSignInvertion5 = new ComplexNumber(-8,0);
        resultSignInvertion6 = new ComplexNumber(0,4);

        resultSum00 = new ComplexNumber(0,0);
        resultSum01 = new ComplexNumber(3,4);
        resultSum02 = new ComplexNumber(-2,-1);
        resultSum03 = new ComplexNumber(7,-8);
        resultSum04 = new ComplexNumber(-10,11);
        resultSum05 = new ComplexNumber(8,0);
        resultSum06 = new ComplexNumber(0,-4);
        resultSum11 = new ComplexNumber(6,8);
        resultSum12 = new ComplexNumber(1,3);
        resultSum13 = new ComplexNumber(10,-4);
        resultSum14 = new ComplexNumber(-7,15);
        resultSum15 = new ComplexNumber(11,4);
        resultSum16 = new ComplexNumber(3,0);
        resultSum22 = new ComplexNumber(-4,-2);
        resultSum23 = new ComplexNumber(5,-9);
        resultSum24 = new ComplexNumber(-12,10);
        resultSum25 = new ComplexNumber(6,-1);
        resultSum26 = new ComplexNumber(-2,-5);
        resultSum33 = new ComplexNumber(14,-16);
        resultSum34 = new ComplexNumber(-3,3);
        resultSum35 = new ComplexNumber(15,-8);
        resultSum36 = new ComplexNumber(7,-12);
        resultSum44 = new ComplexNumber(-20,22);
        resultSum45 = new ComplexNumber(-2,11);
        resultSum46 = new ComplexNumber(-10,7);
        resultSum55 = new ComplexNumber(16,0);
        resultSum56 = new ComplexNumber(8,-4);
        resultSum66 = new ComplexNumber(0,-8);

        resultDifference00 = new ComplexNumber(0,0);
        resultDifference01 = new ComplexNumber(-3,-4);
        resultDifference02 = new ComplexNumber(2,1);
        resultDifference03 = new ComplexNumber(-7,8);
        resultDifference04 = new ComplexNumber(10,-11);
        resultDifference05 = new ComplexNumber(-8,0);
        resultDifference06 = new ComplexNumber(0,4);
        resultDifference11 = new ComplexNumber(0,0);
        resultDifference12 = new ComplexNumber(5,5);
        resultDifference13 = new ComplexNumber(-4,12);
        resultDifference14 = new ComplexNumber(13,-7);
        resultDifference15 = new ComplexNumber(-5,4);
        resultDifference16 = new ComplexNumber(3,8);
        resultDifference22 = new ComplexNumber(0,0);
        resultDifference23 = new ComplexNumber(-9,7);
        resultDifference24 = new ComplexNumber(8,-12);
        resultDifference25 = new ComplexNumber(-10,-1);
        resultDifference26 = new ComplexNumber(-2,3);
        resultDifference33 = new ComplexNumber(0,0);
        resultDifference34 = new ComplexNumber(17,-19);
        resultDifference35 = new ComplexNumber(-1,-8);
        resultDifference36 = new ComplexNumber(7,-4);
        resultDifference44 = new ComplexNumber(0,0);
        resultDifference45 = new ComplexNumber(-18,11);
        resultDifference46= new ComplexNumber(-10,15);
        resultDifference55 = new ComplexNumber(0,0);
        resultDifference56 = new ComplexNumber(8,4);
        resultDifference66 = new ComplexNumber(0,0);
        resultDifference10 = new ComplexNumber(3,4);
        resultDifference20 = new ComplexNumber(-2,-1);
        resultDifference30 = new ComplexNumber(7,-8);
        resultDifference40 = new ComplexNumber(-10,11);
        resultDifference50 = new ComplexNumber(8,0);
        resultDifference60 = new ComplexNumber(0,-4);
        resultDifference21 = new ComplexNumber(-5,-5);
        resultDifference31 = new ComplexNumber(4,-12);
        resultDifference41 = new ComplexNumber(-13,7);
        resultDifference51 = new ComplexNumber(5,-4);
        resultDifference61 = new ComplexNumber(-3,-8);
        resultDifference32 = new ComplexNumber(9,-7);
        resultDifference42 = new ComplexNumber(-8,12);
        resultDifference52 = new ComplexNumber(10,1);
        resultDifference62 = new ComplexNumber(2,-3);
        resultDifference43 = new ComplexNumber(-17,19);
        resultDifference53 = new ComplexNumber(1,8);
        resultDifference63 = new ComplexNumber(-7,4);
        resultDifference54 = new ComplexNumber(18,-11);
        resultDifference64 = new ComplexNumber(10,-15);
        resultDifference65 = new ComplexNumber(-8,-4);

        resultMultiplication00 = new ComplexNumber(0,0);
        resultMultiplication01 = new ComplexNumber(0,0);
        resultMultiplication02 = new ComplexNumber(0,0);
        resultMultiplication03 = new ComplexNumber(0,0);
        resultMultiplication04 = new ComplexNumber(0,0);
        resultMultiplication05 = new ComplexNumber(0,0);
        resultMultiplication06 = new ComplexNumber(0,0);
        resultMultiplication11 = new ComplexNumber(-7,24);
        resultMultiplication12 = new ComplexNumber(-2,-11);
        resultMultiplication13 = new ComplexNumber(53,4);
        resultMultiplication14 = new ComplexNumber(-74,-7);
        resultMultiplication15 = new ComplexNumber(24,32);
        resultMultiplication16 = new ComplexNumber(16,-12);
        resultMultiplication22 = new ComplexNumber(3,4);
        resultMultiplication23 = new ComplexNumber(-22,9);
        resultMultiplication24 = new ComplexNumber(31,-12);
        resultMultiplication25 = new ComplexNumber(-16,-8);
        resultMultiplication26 = new ComplexNumber(-4,8);
        resultMultiplication33 = new ComplexNumber(-15,-112);
        resultMultiplication34 = new ComplexNumber(18,157);
        resultMultiplication35 = new ComplexNumber(56,-64);
        resultMultiplication36 = new ComplexNumber(-32,-28);
        resultMultiplication44 = new ComplexNumber(-21,-220);
        resultMultiplication45 = new ComplexNumber(-80,88);
        resultMultiplication46 = new ComplexNumber(44,40);
        resultMultiplication55 = new ComplexNumber(64,0);
        resultMultiplication56 = new ComplexNumber(0,-32);
        resultMultiplication66 = new ComplexNumber(-16,0);

        resultDivision01 = new ComplexNumber(0,0);
        resultDivision02 = new ComplexNumber(0,0);
        resultDivision03 = new ComplexNumber(0,0);
        resultDivision04 = new ComplexNumber(0,0);
        resultDivision05 = new ComplexNumber(0,0);
        resultDivision06 = new ComplexNumber(0,0);
        resultDivision11 = new ComplexNumber(1,0);
        resultDivision12 = new ComplexNumber(-2,-1);
        resultDivision13 = new ComplexNumber(-0.097345132743363,0.460176991150442);
        resultDivision14 = new ComplexNumber(0.063348416289593,-0.330316742081448);
        resultDivision15 = new ComplexNumber(0.375,0.5);
        resultDivision16 = new ComplexNumber(-1,0.75);
        resultDivision22 = new ComplexNumber(1,0);
        resultDivision23 = new ComplexNumber(-0.053097345132743,-0.20353982300885);
        resultDivision24 = new ComplexNumber(0.040723981900452,0.144796380090498);
        resultDivision25 = new ComplexNumber(-0.25,-0.125);
        resultDivision26 = new ComplexNumber(0.25,-0.5);
        resultDivision33 = new ComplexNumber(1,0);
        resultDivision34 = new ComplexNumber(-0.714932126696833,0.013574660633484);
        resultDivision35 = new ComplexNumber(0.875,-1);
        resultDivision36 = new ComplexNumber(2,1.75);
        resultDivision44 = new ComplexNumber(1,0);
        resultDivision45 = new ComplexNumber(-1.25,1.375);
        resultDivision46 = new ComplexNumber(-2.75,-2.5);
        resultDivision55 = new ComplexNumber(1,0);
        resultDivision56 = new ComplexNumber(0,2);
        resultDivision66 = new ComplexNumber(1,0);
        resultDivision10 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision20 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision30 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision40 = new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        resultDivision50 = new ComplexNumber(Double.POSITIVE_INFINITY,0);
        resultDivision60 = new ComplexNumber(0,Double.POSITIVE_INFINITY);
        resultDivision21 = new ComplexNumber(-0.4,+0.2);
        resultDivision31 = new ComplexNumber(-0.44,-2.08);
        resultDivision41 = new ComplexNumber(0.56,2.92);
        resultDivision51 = new ComplexNumber(0.96,-1.28);
        resultDivision61 = new ComplexNumber(-0.64,-0.48);
        resultDivision32 = new ComplexNumber(-1.2,4.6);
        resultDivision42 = new ComplexNumber(1.8,-6.4);
        resultDivision52 = new ComplexNumber(-3.2,1.6);
        resultDivision62 = new ComplexNumber(0.8,1.6);
        resultDivision43 = new ComplexNumber(-1.398230088495575,-0.026548672566372);
        resultDivision53 = new ComplexNumber(0.495575221238938,0.566371681415929);
        resultDivision63 = new ComplexNumber(0.283185840707965,-0.247787610619469);
        resultDivision54 = new ComplexNumber(-0.361990950226244,-0.398190045248869);
        resultDivision64 = new ComplexNumber(-0.199095022624434,0.180995475113122);
        resultDivision65 = new ComplexNumber(0,-0.5);

        // resultAbsolute0 = new ComplexNumber(0,0);
        // resultAbsolute1 = new ComplexNumber(5,0);
        // resultAbsolute2 = new ComplexNumber(2.23606797749979,0);
        // resultAbsolute3 = new ComplexNumber(10.63014581273465,0);
        // resultAbsolute4 = new ComplexNumber(14.866068747318506,0);
        // resultAbsolute5 = new ComplexNumber(8,0);
        // resultAbsolute6 = new ComplexNumber(4,0);

        resultSquareRoot0 = new ComplexNumber(0,0);
        resultSquareRoot1 = new ComplexNumber(2,1);
        resultSquareRoot2 = new ComplexNumber(0.343560749722512,-1.455346690225355);
        resultSquareRoot3 = new ComplexNumber(2.969018845741354,-1.347246416349780);
        resultSquareRoot4 = new ComplexNumber(1.559818698970894,3.526050818360288);
        resultSquareRoot5 = new ComplexNumber(2.828427124746190,0);
        resultSquareRoot6 = new ComplexNumber(1.414213562373095,-1.414213562373095);
    }

    @Test
    public void testSignInvertion() {
        Assert.assertEquals("Sign Invertion of number0 works",resultSignInvertion0, Operations.signInvertion(number0));
        Assert.assertEquals("Sign Invertion of number1 works",resultSignInvertion1, Operations.signInvertion(number1));
        Assert.assertEquals("Sign Invertion of number2 works",resultSignInvertion2, Operations.signInvertion(number2));
        Assert.assertEquals("Sign Invertion of number3 works",resultSignInvertion3, Operations.signInvertion(number3));
        Assert.assertEquals("Sign Invertion of number4 works",resultSignInvertion4, Operations.signInvertion(number4));
        Assert.assertEquals("Sign Invertion of number4 works",resultSignInvertion5, Operations.signInvertion(number5));
        Assert.assertEquals("Sign Invertion of number4 works",resultSignInvertion6, Operations.signInvertion(number6));
    }

    @Test
    public void testSum() {
        Assert.assertEquals("Sum of number0 and number0 works",resultSum00, Operations.sum(number0,number0));
        Assert.assertEquals("Sum of number0 and number1 works",resultSum01, Operations.sum(number0,number1));
        Assert.assertEquals("Sum of number0 and number2 works",resultSum02, Operations.sum(number0,number2));
        Assert.assertEquals("Sum of number0 and number3 works",resultSum03, Operations.sum(number0,number3));
        Assert.assertEquals("Sum of number0 and number4 works",resultSum04, Operations.sum(number0,number4));
        Assert.assertEquals("Sum of number0 and number5 works",resultSum05, Operations.sum(number0,number5));
        Assert.assertEquals("Sum of number0 and number6 works",resultSum06, Operations.sum(number0,number6));
        Assert.assertEquals("Sum of number1 and number1 works",resultSum11, Operations.sum(number1,number1));
        Assert.assertEquals("Sum of number1 and number2 works",resultSum12, Operations.sum(number1,number2));
        Assert.assertEquals("Sum of number1 and number3 works",resultSum13, Operations.sum(number1,number3));
        Assert.assertEquals("Sum of number1 and number4 works",resultSum14, Operations.sum(number1,number4));
        Assert.assertEquals("Sum of number1 and number5 works",resultSum15, Operations.sum(number1,number5));
        Assert.assertEquals("Sum of number1 and number6 works",resultSum16, Operations.sum(number1,number6));
        Assert.assertEquals("Sum of number2 and number2 works",resultSum22, Operations.sum(number2,number2));
        Assert.assertEquals("Sum of number2 and number3 works",resultSum23, Operations.sum(number2,number3));
        Assert.assertEquals("Sum of number2 and number4 works",resultSum24, Operations.sum(number2,number4));
        Assert.assertEquals("Sum of number2 and number5 works",resultSum25, Operations.sum(number2,number5));
        Assert.assertEquals("Sum of number2 and number6 works",resultSum26, Operations.sum(number2,number6));
        Assert.assertEquals("Sum of number3 and number3 works",resultSum33, Operations.sum(number3,number3));
        Assert.assertEquals("Sum of number3 and number4 works",resultSum34, Operations.sum(number3,number4));
        Assert.assertEquals("Sum of number3 and number5 works",resultSum35, Operations.sum(number3,number5));
        Assert.assertEquals("Sum of number3 and number6 works",resultSum36, Operations.sum(number3,number6));
        Assert.assertEquals("Sum of number4 and number4 works",resultSum44, Operations.sum(number4,number4));
        Assert.assertEquals("Sum of number4 and number5 works",resultSum45, Operations.sum(number4,number5));
        Assert.assertEquals("Sum of number4 and number6 works",resultSum46, Operations.sum(number4,number6));
        Assert.assertEquals("Sum of number5 and number5 works",resultSum55, Operations.sum(number5,number5));
        Assert.assertEquals("Sum of number5 and number6 works",resultSum56, Operations.sum(number5,number6));
        Assert.assertEquals("Sum of number6 and number6 works",resultSum66, Operations.sum(number6,number6));
    }

    @Test
    public void testDifference() {
        Assert.assertEquals("Difference of number0 and number0 works",resultDifference00, Operations.difference(number0,number0));
        Assert.assertEquals("Difference of number0 and number1 works",resultDifference01, Operations.difference(number0,number1));
        Assert.assertEquals("Difference of number0 and number2 works",resultDifference02, Operations.difference(number0,number2));
        Assert.assertEquals("Difference of number0 and number3 works",resultDifference03, Operations.difference(number0,number3));
        Assert.assertEquals("Difference of number0 and number4 works",resultDifference04, Operations.difference(number0,number4));
        Assert.assertEquals("Difference of number0 and number5 works",resultDifference05, Operations.difference(number0,number5));
        Assert.assertEquals("Difference of number0 and number6 works",resultDifference06, Operations.difference(number0,number6));
        Assert.assertEquals("Difference of number1 and number1 works",resultDifference11, Operations.difference(number1,number1));
        Assert.assertEquals("Difference of number1 and number2 works",resultDifference12, Operations.difference(number1,number2));
        Assert.assertEquals("Difference of number1 and number3 works",resultDifference13, Operations.difference(number1,number3));
        Assert.assertEquals("Difference of number1 and number4 works",resultDifference14, Operations.difference(number1,number4));
        Assert.assertEquals("Difference of number1 and number5 works",resultDifference15, Operations.difference(number1,number5));
        Assert.assertEquals("Difference of number1 and number6 works",resultDifference16, Operations.difference(number1,number6));
        Assert.assertEquals("Difference of number2 and number2 works",resultDifference22, Operations.difference(number2,number2));
        Assert.assertEquals("Difference of number2 and number3 works",resultDifference23, Operations.difference(number2,number3));
        Assert.assertEquals("Difference of number2 and number4 works",resultDifference24, Operations.difference(number2,number4));
        Assert.assertEquals("Difference of number2 and number5 works",resultDifference25, Operations.difference(number2,number5));
        Assert.assertEquals("Difference of number2 and number6 works",resultDifference26, Operations.difference(number2,number6));
        Assert.assertEquals("Difference of number3 and number3 works",resultDifference33, Operations.difference(number3,number3));
        Assert.assertEquals("Difference of number3 and number4 works",resultDifference34, Operations.difference(number3,number4));
        Assert.assertEquals("Difference of number3 and number5 works",resultDifference35, Operations.difference(number3,number5));
        Assert.assertEquals("Difference of number3 and number6 works",resultDifference36, Operations.difference(number3,number6));
        Assert.assertEquals("Difference of number4 and number4 works",resultDifference44, Operations.difference(number4,number4));
        Assert.assertEquals("Difference of number4 and number5 works",resultDifference45, Operations.difference(number4,number5));
        Assert.assertEquals("Difference of number4 and number6 works",resultDifference46, Operations.difference(number4,number6));
        Assert.assertEquals("Difference of number5 and number5 works",resultDifference55, Operations.difference(number5,number5));
        Assert.assertEquals("Difference of number5 and number6 works",resultDifference56, Operations.difference(number5,number6));
        Assert.assertEquals("Difference of number6 and number6 works",resultDifference66, Operations.difference(number6,number6));
        Assert.assertEquals("Difference of number1 and number0 works",resultDifference10, Operations.difference(number1,number0));
        Assert.assertEquals("Difference of number2 and number0 works",resultDifference20, Operations.difference(number2,number0));
        Assert.assertEquals("Difference of number3 and number0 works",resultDifference30, Operations.difference(number3,number0));
        Assert.assertEquals("Difference of number4 and number0 works",resultDifference40, Operations.difference(number4,number0));
        Assert.assertEquals("Difference of number5 and number0 works",resultDifference50, Operations.difference(number5,number0));
        Assert.assertEquals("Difference of number6 and number0 works",resultDifference60, Operations.difference(number6,number0));
        Assert.assertEquals("Difference of number2 and number1 works",resultDifference21, Operations.difference(number2,number1));
        Assert.assertEquals("Difference of number3 and number1 works",resultDifference31, Operations.difference(number3,number1));
        Assert.assertEquals("Difference of number4 and number1 works",resultDifference41, Operations.difference(number4,number1));
        Assert.assertEquals("Difference of number5 and number1 works",resultDifference51, Operations.difference(number5,number1));
        Assert.assertEquals("Difference of number6 and number1 works",resultDifference61, Operations.difference(number6,number1));
        Assert.assertEquals("Difference of number3 and number2 works",resultDifference32, Operations.difference(number3,number2));
        Assert.assertEquals("Difference of number4 and number2 works",resultDifference42, Operations.difference(number4,number2));
        Assert.assertEquals("Difference of number5 and number2 works",resultDifference52, Operations.difference(number5,number2));
        Assert.assertEquals("Difference of number6 and number2 works",resultDifference62, Operations.difference(number6,number2));
        Assert.assertEquals("Difference of number4 and number3 works",resultDifference43, Operations.difference(number4,number3));
        Assert.assertEquals("Difference of number5 and number3 works",resultDifference53, Operations.difference(number5,number3));
        Assert.assertEquals("Difference of number6 and number3 works",resultDifference63, Operations.difference(number6,number3));
        Assert.assertEquals("Difference of number5 and number4 works",resultDifference54, Operations.difference(number5,number4));
        Assert.assertEquals("Difference of number6 and number4 works",resultDifference64, Operations.difference(number6,number4));
        Assert.assertEquals("Difference of number6 and number5 works",resultDifference65, Operations.difference(number6,number5));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("Multiplication of number0 and number0 works",resultMultiplication00, Operations.multiplication(number0,number0));
        Assert.assertEquals("Multiplication of number0 and number1 works",resultMultiplication01, Operations.multiplication(number0,number1));
        Assert.assertEquals("Multiplication of number0 and number2 works",resultMultiplication02, Operations.multiplication(number0,number2));
        Assert.assertEquals("Multiplication of number0 and number3 works",resultMultiplication03, Operations.multiplication(number0,number3));
        Assert.assertEquals("Multiplication of number0 and number4 works",resultMultiplication04, Operations.multiplication(number0,number4));
        Assert.assertEquals("Multiplication of number0 and number5 works",resultMultiplication05, Operations.multiplication(number0,number5));
        Assert.assertEquals("Multiplication of number0 and number6 works",resultMultiplication06, Operations.multiplication(number0,number6));
        Assert.assertEquals("Multiplication of number1 and number1 works",resultMultiplication11, Operations.multiplication(number1,number1));
        Assert.assertEquals("Multiplication of number1 and number2 works",resultMultiplication12, Operations.multiplication(number1,number2));
        Assert.assertEquals("Multiplication of number1 and number3 works",resultMultiplication13, Operations.multiplication(number1,number3));
        Assert.assertEquals("Multiplication of number1 and number4 works",resultMultiplication14, Operations.multiplication(number1,number4));
        Assert.assertEquals("Multiplication of number1 and number5 works",resultMultiplication15, Operations.multiplication(number1,number5));
        Assert.assertEquals("Multiplication of number1 and number6 works",resultMultiplication16, Operations.multiplication(number1,number6));
        Assert.assertEquals("Multiplication of number2 and number2 works",resultMultiplication22, Operations.multiplication(number2,number2));
        Assert.assertEquals("Multiplication of number2 and number3 works",resultMultiplication23, Operations.multiplication(number2,number3));
        Assert.assertEquals("Multiplication of number2 and number4 works",resultMultiplication24, Operations.multiplication(number2,number4));
        Assert.assertEquals("Multiplication of number2 and number5 works",resultMultiplication25, Operations.multiplication(number2,number5));
        Assert.assertEquals("Multiplication of number2 and number6 works",resultMultiplication26, Operations.multiplication(number2,number6));
        Assert.assertEquals("Multiplication of number3 and number3 works",resultMultiplication33, Operations.multiplication(number3,number3));
        Assert.assertEquals("Multiplication of number3 and number4 works",resultMultiplication34, Operations.multiplication(number3,number4));
        Assert.assertEquals("Multiplication of number3 and number5 works",resultMultiplication35, Operations.multiplication(number3,number5));
        Assert.assertEquals("Multiplication of number3 and number6 works",resultMultiplication36, Operations.multiplication(number3,number6));
        Assert.assertEquals("Multiplication of number4 and number4 works",resultMultiplication44, Operations.multiplication(number4,number4));
        Assert.assertEquals("Multiplication of number4 and number5 works",resultMultiplication45, Operations.multiplication(number4,number5));
        Assert.assertEquals("Multiplication of number4 and number6 works",resultMultiplication46, Operations.multiplication(number4,number6));
        Assert.assertEquals("Multiplication of number5 and number5 works",resultMultiplication55, Operations.multiplication(number5,number5));
        Assert.assertEquals("Multiplication of number5 and number6 works",resultMultiplication56, Operations.multiplication(number5,number6));
        Assert.assertEquals("Multiplication of number6 and number6 works",resultMultiplication66, Operations.multiplication(number6,number6));
    }

    @Test
    public void testDivision() {
        Assert.assertEquals("Division of number0 and number1 works",resultDivision01, Operations.division(number0,number1));
        Assert.assertEquals("Division of number0 and number2 works",resultDivision02, Operations.division(number0,number2));
        Assert.assertEquals("Division of number0 and number3 works",resultDivision03, Operations.division(number0,number3));
        Assert.assertEquals("Division of number0 and number4 works",resultDivision04, Operations.division(number0,number4));
        Assert.assertEquals("Division of number0 and number5 works",resultDivision05, Operations.division(number0,number5));
        Assert.assertEquals("Division of number0 and number6 works",resultDivision06, Operations.division(number0,number6));
        Assert.assertEquals("Division of number1 and number1 works",resultDivision11, Operations.division(number1,number1));
        Assert.assertEquals("Division of number1 and number2 works",resultDivision12, Operations.division(number1,number2));
        Assert.assertEquals("Division of number1 and number3 works",resultDivision13, Operations.division(number1,number3));
        Assert.assertEquals("Division of number1 and number4 works",resultDivision14, Operations.division(number1,number4));
        Assert.assertEquals("Division of number1 and number5 works",resultDivision15, Operations.division(number1,number5));
        Assert.assertEquals("Division of number1 and number6 works",resultDivision16, Operations.division(number1,number6));
        Assert.assertEquals("Division of number2 and number2 works",resultDivision22, Operations.division(number2,number2));
        Assert.assertEquals("Division of number2 and number3 works",resultDivision23, Operations.division(number2,number3));
        Assert.assertEquals("Division of number2 and number4 works",resultDivision24, Operations.division(number2,number4));
        Assert.assertEquals("Division of number2 and number5 works",resultDivision25, Operations.division(number2,number5));
        Assert.assertEquals("Division of number2 and number6 works",resultDivision26, Operations.division(number2,number6));
        Assert.assertEquals("Division of number3 and number3 works",resultDivision33, Operations.division(number3,number3));
        Assert.assertEquals("Division of number3 and number4 works",resultDivision34, Operations.division(number3,number4));
        Assert.assertEquals("Division of number3 and number5 works",resultDivision35, Operations.division(number3,number5));
        Assert.assertEquals("Division of number3 and number6 works",resultDivision36, Operations.division(number3,number6));
        Assert.assertEquals("Division of number4 and number4 works",resultDivision44, Operations.division(number4,number4));
        Assert.assertEquals("Division of number4 and number5 works",resultDivision45, Operations.division(number4,number5));
        Assert.assertEquals("Division of number4 and number6 works",resultDivision46, Operations.division(number4,number6));
        Assert.assertEquals("Division of number5 and number5 works",resultDivision55, Operations.division(number5,number5));
        Assert.assertEquals("Division of number5 and number6 works",resultDivision56, Operations.division(number5,number6));
        Assert.assertEquals("Division of number6 and number6 works",resultDivision66, Operations.division(number6,number6));
        Assert.assertEquals("Division of number1 and number0 works",resultDivision10, Operations.division(number1,number0));
        Assert.assertEquals("Division of number2 and number0 works",resultDivision20, Operations.division(number2,number0));
        Assert.assertEquals("Division of number3 and number0 works",resultDivision30, Operations.division(number3,number0));
        Assert.assertEquals("Division of number4 and number0 works",resultDivision40, Operations.division(number4,number0));
        Assert.assertEquals("Division of number5 and number0 works",resultDivision50, Operations.division(number5,number0));
        Assert.assertEquals("Division of number6 and number0 works",resultDivision60, Operations.division(number6,number0));
        Assert.assertEquals("Division of number2 and number1 works",resultDivision21, Operations.division(number2,number1));
        Assert.assertEquals("Division of number3 and number1 works",resultDivision31, Operations.division(number3,number1));
        Assert.assertEquals("Division of number4 and number1 works",resultDivision41, Operations.division(number4,number1));
        Assert.assertEquals("Division of number5 and number1 works",resultDivision51, Operations.division(number5,number1));
        Assert.assertEquals("Division of number6 and number1 works",resultDivision61, Operations.division(number6,number1));
        Assert.assertEquals("Division of number3 and number2 works",resultDivision32, Operations.division(number3,number2));
        Assert.assertEquals("Division of number4 and number2 works",resultDivision42, Operations.division(number4,number2));
        Assert.assertEquals("Division of number5 and number2 works",resultDivision52, Operations.division(number5,number2));
        Assert.assertEquals("Division of number6 and number2 works",resultDivision62, Operations.division(number6,number2));
        Assert.assertEquals("Division of number4 and number3 works",resultDivision43, Operations.division(number4,number3));
        Assert.assertEquals("Division of number5 and number3 works",resultDivision53, Operations.division(number5,number3));
        Assert.assertEquals("Division of number6 and number3 works",resultDivision63, Operations.division(number6,number3));
        Assert.assertEquals("Division of number5 and number4 works",resultDivision54, Operations.division(number5,number4));
        Assert.assertEquals("Division of number6 and number4 works",resultDivision64, Operations.division(number6,number4));
        Assert.assertEquals("Division of number6 and number5 works",resultDivision65, Operations.division(number6,number5));
    }

    @Test(expected = IndeterminateFormException.class)
    public void testDivisionIndeterminateForm(){
        Operations.division(number0,number0);
    }

    // @Test
    // public void testAbsolute() {
    //     Assert.assertEquals("Absolute of number0 works",resultAbsolute0, Operations.absolute(number0));
    //     Assert.assertEquals("Absolute of number1 works",resultAbsolute1, Operations.absolute(number1));
    //     Assert.assertEquals("Absolute of number2 works",resultAbsolute2, Operations.absolute(number2));
    //     Assert.assertEquals("Absolute of number3 works",resultAbsolute3, Operations.absolute(number3));
    //     Assert.assertEquals("Absolute of number4 works",resultAbsolute4, Operations.absolute(number4));
    //     Assert.assertEquals("Absolute of number5 works",resultAbsolute5, Operations.absolute(number5));
    //     Assert.assertEquals("Absolute of number6 works",resultAbsolute6, Operations.absolute(number6));
    // }

    @Test
    public void testSquareRoot() {
        Assert.assertEquals("Square Root of number0 works",resultSquareRoot0, Operations.squareRoot(number0));
        Assert.assertEquals("Square Root of number1 works",resultSquareRoot1, Operations.squareRoot(number1));
        Assert.assertEquals("Square Root of number2 works",resultSquareRoot2, Operations.squareRoot(number2));
        Assert.assertEquals("Square Root of number3 works",resultSquareRoot3, Operations.squareRoot(number3));
        Assert.assertEquals("Square Root of number4 works",resultSquareRoot4, Operations.squareRoot(number4));
        Assert.assertEquals("Square Root of number5 works",resultSquareRoot5, Operations.squareRoot(number5));
        Assert.assertEquals("Square Root of number6 works",resultSquareRoot6, Operations.squareRoot(number6));
    }
}
