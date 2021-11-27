package src.main.java.operations;

import src.main.java.exceptions.IndeterminateFormException;
import src.main.java.resources.ComplexNumber;

/**
 * @file Operations.java
 * @author Francesco Tortora
 * @date 23 Nov 2021
 */

/**
 * @brief This class contains static methods for operating with complex numbers.
 *
 */
public class Operations {

    /**
     * @brief Invert the sign of a complex number.
     * @param operand complex number for which you want to invert the sign.
     * @return complex number with inverted sign.
     */
    public static ComplexNumber signInvertion(ComplexNumber operand) {
        return new ComplexNumber(-operand.getReal(),-operand.getImaginary());
    }

    /**
     * @brief Performs the sum between two complex numbers.
     * @param leftOperand first operand of the sum operation.
     * @param rightOperand second operand of the sum operation.
     * @return complex number given by the sum of the two operands.
     */
    public static ComplexNumber sum(ComplexNumber leftOperand, ComplexNumber rightOperand) {
        return new ComplexNumber(leftOperand.getReal()+rightOperand.getReal(),leftOperand.getImaginary()+rightOperand.getImaginary());
    }

    /**
     * @brief Performs the subtraction between two complex numbers.
     * @param leftOperand first operand of the difference operation.
     * @param rightOperand second operand of the difference operation.
     * @return complex number given by the difference between the two operands.
     */
    public static ComplexNumber difference(ComplexNumber leftOperand, ComplexNumber rightOperand) {
        return sum(leftOperand, signInvertion(rightOperand));
    }

    /**
     * @brief Performs the multiplication between two complex numbers.
     * @param leftOperand first operand of the multiplication operation.
     * @param rightOperand second operand of the multiplication operation.
     * @return complex number given by the multiplication between the two operands.
     */
    public static ComplexNumber multiplication(ComplexNumber leftOperand, ComplexNumber rightOperand) {
        return new ComplexNumber(leftOperand.getReal()*rightOperand.getReal()-leftOperand.getImaginary()*rightOperand.getImaginary(), leftOperand.getImaginary()*rightOperand.getReal()+leftOperand.getReal()*rightOperand.getImaginary());
    }

    /**
     * @brief Performs the division between two complex numbers.
     * @param leftOperand first operand of the difference operation.
     * @param rightOperand second operand of the difference operation.
     * @return complex number given by the division between the two operands.
     */
    public static ComplexNumber division(ComplexNumber leftOperand, ComplexNumber rightOperand) throws IndeterminateFormException {
        double denominator = Math.pow(rightOperand.getReal(), 2) + Math.pow(rightOperand.getImaginary(), 2);
        double numeratorA = leftOperand.getReal() * rightOperand.getReal() + leftOperand.getImaginary() * rightOperand.getImaginary();
        double numeratorB = leftOperand.getImaginary() * rightOperand.getReal() - leftOperand.getReal() * rightOperand.getImaginary();

        if(denominator==0)
            if(leftOperand.getReal()==0 && leftOperand.getImaginary()==0)
                throw new IndeterminateFormException();
            else if(leftOperand.getImaginary()==0)
                return new ComplexNumber(Double.POSITIVE_INFINITY,0);
            else if(leftOperand.getReal()==0)
                return new ComplexNumber(0,Double.POSITIVE_INFINITY);
            else
                return new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);

       return new ComplexNumber(numeratorA/denominator, numeratorB/denominator);
    }

    /**
     * @brief Performs the modoulus of a complex numbers.
     * @param operand complex number for which you want to perform the modoulus operation.
     * @return complex number which represent the modoulus of operand number.
     */
    private static ComplexNumber absolute(ComplexNumber operand) {
        return new ComplexNumber(Math.sqrt(Math.pow(operand.getReal(), 2) + Math.pow(operand.getImaginary(), 2)),0);
    }

    /**
     * @brief Performs the square root of a complex numbers.
     * @param operand complex number for which you want to perform the square root.
     * @return complex number which represent the square root of operand number.
     */
    public static ComplexNumber squareRoot(ComplexNumber operand) {
        ComplexNumber abs = absolute(operand);
        if (abs.getReal()==0) return new ComplexNumber(0,0);
        ComplexNumber squareRootAbs= new ComplexNumber(Math.sqrt(abs.getReal()),0);
        ComplexNumber sumAbsOperand = sum(operand,abs);
        ComplexNumber AbsSumAbsOperand = absolute(sumAbsOperand);
        return multiplication(squareRootAbs, division(sumAbsOperand, AbsSumAbsOperand));
    }
}
