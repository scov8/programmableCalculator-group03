package src.main.java.resources;

import java.util.Locale;

/**
 * @file ComplexNumber.java
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
     * @param real      Real part of the number.
     * @param imaginary Imaginary part of the number.
     */
    public ComplexNumber(double real, double imaginary) {
        this.a = real;
        this.b = imaginary;
    }

    /**
     * @brief Real number constructor.
     * @param real Real part of the number.
     */
    public ComplexNumber(double real) {
        this.a = real;
        this.b = 0;
    }

    /**
     * @brief Construct Complex Number from a string.
     * @param text String representation of the number.
     */
    public ComplexNumber(String text) {
        // Uniform every string with 'j' instead of 'i'.
        text = text.replaceAll("i", "j");

        String a, b;

        // Look for the imaginary part sign's position in the string.
        int signPos = text.indexOf("+", 1);
        if (signPos < 0)
            signPos = text.indexOf("-", 1);
        // If no sign to divide real and imaginary part is found it means only
        // one of them is present in the string.
        if (signPos < 0) {
            // If the entire string is simply "j".
            if (text.compareTo("j") == 0) {
                a = "0";
                b = "1";
            }
            // If 'j' is in the string the number is imaginary.
            else if (text.indexOf("j") > 0) {
                a = "0";
                b = text.substring(0, text.length() - 1);
            }
            // Real number.
            else {
                a = text;
                b = "0";
            }
        } else {
            // Get substring representing real part of the number, sign included.
            a = text.substring(0, signPos);
            // Get substring representing imaginary part of the number, sign
            // included, i/j excluded.
            b = text.substring(signPos, text.length() - 1);
            if (b.length() == 1)
                b += "1";
        }

        this.a = Double.parseDouble(a);
        this.b = Double.parseDouble(b);
    }

    /**
     * @brief Get real part of the number.
     * @return The Real Part of the number.
     */
    public double getReal() {
        return a;
    }

    /**
     * @brief Set real part of the number.
     * @param real The real part to set.
     */
    public void setReal(double real) {
        this.a = real;
    }

    /**
     * @brief Get imaginary part of the number.
     * @return The imaginary part of the number.
     */
    public double getImaginary() {
        return b;
    }

    /**
     * @brief Set imaginary part of the number.
     * @param imaginary The imaginary part to set.
     */
    public void setImaginary(double imaginary) {
        this.b = imaginary;
    }

    /**
     * @brief Update both real and imaginary parts of the number.
     * @param real      Real part.
     * @param imaginary Imaginary part.
     */
    public void setValues(double real, double imaginary) {
        this.a = real;
        this.b = imaginary;
    }

    /**
     * @brief Return an approximation of the double value.
     * @param number The value to approximate.
     * @return An approximated value of number.
     */
    private double approximate(double number) {
        return Double.valueOf(Math.round(number * 10000000000.0) / 10000000000.0);
    }

    /**
     * @brief Check whether given double is either 0.0 or -0.0.
     * @param n The double to check.
     * @return `true` if n can be considered equal to zero; `false` otherwise.
     */
    private boolean isZero(double n) {
        return approximate(n) == 0.0 || approximate(n) == -0.0;
    }

    /**
     * @brief Check whether self and obj are equals.
     *
     *        Comparison is based on the values of the real and imaginary part of
     *        the numbers.
     * @param obj Other instance of this class.
     * @return `true` if self and obj are equal; `false` otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ComplexNumber))
            return false;

        ComplexNumber other = (ComplexNumber) obj;

        if ((isZero(a) && isZero(other.a)) || (approximate(a) == approximate(other.a)))
            if ((isZero(b) && isZero(other.b)) || (approximate(b) == approximate(other.b)))
                return true;
        return false;
    }

    /**
     * @brief Format the double number into a string.
     * @param n Double number to format.
     * @return String representation of d.
     */
    private String formatDouble(double n) {
        String s;

        // small numbers are presented in scientific notation.
        if (Math.abs(n) < 0.001)
            return String.valueOf(n);
        // use scientific notation only if number is too big (e.g. >= 100'000).
        else if (n >= 100000)
            s = String.format(Locale.US, "%.5e", n);
        // only show first 5 decimal digits.
        else
            s = String.format(Locale.US, "%.5f", n);

        // remove any trailing decimal digit if it is 0.
        while (s.endsWith("0"))
            s = s.substring(0, s.length() - 1);
        if (s.endsWith("."))
            s = s.substring(0, s.length() - 1);

        return s;
    }

    /**
     * @brief Return a string representation of the object.
     * @return String representing the complex number.
     */
    @Override
    public String toString() {
        if (isZero(a) && isZero(b))
            return "0";
        else if (isZero(a))
            return this.formatDouble(b) + "j";
        else if (isZero(b))
            return this.formatDouble(a);

        String as, bs;
        as = this.formatDouble(a);
        bs = this.formatDouble(Math.abs(b));

        if (this.b < 0)
            return as + " - " + bs + "j";
        else
            return as + " + " + bs + "j";
    }
}
