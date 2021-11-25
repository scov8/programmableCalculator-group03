package src.main.java.resources;

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
    public static ComplexNumber signInvertion(ComplexNumber operand){
        return new ComplexNumber(-operand.getReal(),-operand.getImaginary());
    }

    /**
     * @brief Perform the sum between two complex numbers.
     * @param leftOperand first operand of the sum operation.
     * @param rightOperand second operand of the sum operation.
     * @return complex number given by the sum of the two operands.
     */
    public static ComplexNumber sum(ComplexNumber leftOperand, ComplexNumber rightOperand){
        return new ComplexNumber(leftOperand.getReal()+rightOperand.getReal(),leftOperand.getImaginary()+rightOperand.getImaginary());
    }

    /**
     * @brief Perform the subtraction between two complex numbers.
     * @param leftOperand first operand of the difference operation.
     * @param rightOperand second operand of the difference operation.
     * @return complex number given by the difference between the two operands.
     */
    public static ComplexNumber difference(ComplexNumber leftOperand, ComplexNumber rightOperand){
        return sum(leftOperand, signInvertion(rightOperand));
    }

    /**
     * @brief Perform the multiplication between two complex numbers.
     * @param leftOperand first operand of the multiplication operation.
     * @param rightOperand second operand of the multiplication operation.
     * @return complex number given by the multiplication between the two operands.
     */
    public static ComplexNumber multiplication(ComplexNumber leftOperand, ComplexNumber rightOperand){
        return new ComplexNumber(leftOperand.getReal()*rightOperand.getReal()-leftOperand.getImaginary()*rightOperand.getImaginary(), leftOperand.getImaginary()*rightOperand.getReal()+leftOperand.getReal()*rightOperand.getImaginary());
    }

    /**
     * @brief Perform the division between two complex numbers.
     * @param leftOperand first operand of the difference operation.
     * @param rightOperand second operand of the difference operation.
     * @return complex number given by the division between the two operands.
     */
    public static ComplexNumber division(ComplexNumber leftOperand, ComplexNumber rightOperand){
        double denominator = Math.pow(rightOperand.getReal(), 2) + Math.pow(rightOperand.getImaginary(), 2);
        double numeratorA = leftOperand.getReal() * rightOperand.getReal() + leftOperand.getImaginary() * rightOperand.getImaginary();
        double numeratorB = leftOperand.getImaginary() * rightOperand.getReal() - leftOperand.getReal() * rightOperand.getImaginary();
        return denominator==0 ? new ComplexNumber(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY): new ComplexNumber(numeratorA/denominator, numeratorB/denominator);
    }

    /**
     * @brief Perform the modoulus of a complex numbers.
     * @param operand complex number for which you want to perform the modoulus operation.
     * @return complex number which represent the modoulus of operand number.
     */
    public static ComplexNumber absolute(ComplexNumber operand){
        return new ComplexNumber(Math.sqrt(Math.pow(operand.getReal(), 2) + Math.pow(operand.getImaginary(), 2)),0);
    }

    /**
     * @brief Perform the square root of a complex numbers.
     * @param operand complex number for which you want to perform the square root.
     * @return complex number which represent the square root of operand number.
     */
    public static ComplexNumber squareRoot(ComplexNumber operand){
        ComplexNumber abs = absolute(operand);
        if (abs.getReal()==0) return new ComplexNumber(0,0);
        ComplexNumber squareRootAbs= new ComplexNumber(Math.sqrt(abs.getReal()),0);
        ComplexNumber sumAbsOperand = sum(operand,abs);
        ComplexNumber AbsSumAbsOperand = absolute(sumAbsOperand);
        return multiplication(squareRootAbs, division(sumAbsOperand, AbsSumAbsOperand));
    }
}
