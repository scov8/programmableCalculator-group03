package src.main.java.resources;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @file Number.java
 * @author Marco Plaitano
 * @date 22 Nov 2021
 */

/**
 * @brief This class represents a Complex Number.
 *
 *        Real numbers are a special case of Complex Numbers with null imaginary
 *        part.
 */
public class ComplexNumber {
    private double a;
    private double b;

    /**
     * @brief Complex number constructor.
     * @param a Real part of the number.
     * @param b Imaginary part of the number.
     */
    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @brief Real number constructor.
     * @param a Real part of the number.
     */
    public ComplexNumber(double a) {
        this.a = a;
        this.b = 0;
    }

    /**
     * @brief Get real part of the number.
     * @return the Real Part of the number.
     */
    public double getReal() {
        return a;
    }

    /**
     * @brief Set real part of the number.
     * @param real the real part to set.
     */
    public void setReal(double real) {
        this.a = real;
    }

    /**
     * @brief Get imaginary part of the number.
     * @return the imaginary part of the number.
     */
    public double getImaginary() {
        return b;
    }

    /**
     * @brief Set imaginary part of the number.
     * @param imaginary the imaginary part to set.
     */
    public void setImaginary(double imaginary) {
        this.b = imaginary;
    }

    /**
     * @brief Update both real and imaginary part of the number.
     * @param a Real part.
     * @param b Imaginary part.
     */
    public void setValues(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @brief Return an approximation of the double value.
     * @param number The value to approximate.
     * @return An approximated value of `number`.
     */
    private double approximate(double number) {
        return Double.valueOf(Math.round(number * 10000000000.0) / 10000000000.0);
    }

    /**
     * @brief Check whether given double is either 0.0 or -0.0.
     * @param n The double to check.
     * @return `true` if n is zero; `false` otherwise.
     */
    private boolean isZero(double n) {
        return approximate(n) == 0.0 || approximate(n) == -0.0;
    }

    /**
     * @brief Check whether `self` and `obj` are equals.
     *
     *        Comparison is based on the values of the real and imaginary part of
     *        the number.
     * @param obj Other instance of this class.
     * @return `true` if `self` and `obj` are equal; `false` otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexNumber)) {
            return false;
        }

        ComplexNumber other = (ComplexNumber) obj;

        if ((isZero(a) && isZero(other.a)) || (approximate(a) == approximate(other.a)))
            if ((isZero(b) && isZero(other.b)) || (approximate(b) == approximate(other.b)))
                return true;
        return false;
    }

    /**
     * @brief Return a string representation of the object.
     * @return String representing the complex number.
     */
    @Override
    public String toString() {
        NumberFormat nf = new DecimalFormat("##.###", new DecimalFormatSymbols(Locale.US));

        if (isZero(a) && isZero(b))
            return "0";
        else if (isZero(a))
            return nf.format(b) + "i";
        else if (isZero(b))
            return nf.format(a);

        String as, bs;
        // If the number is too small it can not be rounded up to its first 3
        // decimal digits or it would be dis
        if (approximate(Math.abs(a)) >= 0.001)
            as = nf.format(a);
        else
            as = String.valueOf(a);
        if (approximate(Math.abs(b)) >= 0.001)
            bs = nf.format(Math.abs(b));
        else
            bs = String.valueOf(Math.abs(b));

        if (this.b < 0)
            return as + " - " + bs + "i";
        else
            return as + " + " + bs + "i";
    }
}
