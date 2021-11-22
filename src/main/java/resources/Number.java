package src.main.java.resources;

import java.util.Objects;

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
public class Number {
    private double a;
    private double b;

    /**
     * @brief Complex number constructor.
     * @param a real part of the number.
     * @param b complex part of the number.
     */
    public Number(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @brief Real number constructor.
     * @param a real part of the number.
     */
    public Number(double a) {
        this.a = a;
        this.b = 0;
    }

    /**
     * @return the Real Part of the number.
     */
    public double getReal() {
        return a;
    }

    /**
     * @param real the real part to set.
     */
    public void setReal(double real) {
        this.a = real;
    }

    /**
     * @return the imaginary part of the number.
     */
    public double getImaginary() {
        return b;
    }

    /**
     * @param imaginary the imaginary part to set.
     */
    public void setImaginary(double imaginary) {
        this.b = imaginary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Number)) {
            return false;
        }
        Number other = (Number) obj;
        return Double.doubleToLongBits(a) == Double.doubleToLongBits(other.a)
                && Double.doubleToLongBits(b) == Double.doubleToLongBits(other.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "{Number: " + this.a + " " + this.b + "}";
    }
}
