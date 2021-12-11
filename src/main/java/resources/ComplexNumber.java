package src.main.java.resources;

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
     * @brief Format the double number into a string. Big numbers are written
     *        in scientific notation.
     * @param d Double number to format.
     * @return String representation of d.
     */
    private String formatDouble(double d) {
        String s;

        if (Math.abs(d) < 0.001)
            return String.valueOf(d);

        if (d > 10000)
            s = String.format("%.5e", d);
        else
            s = String.format("%.5f", d);

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
