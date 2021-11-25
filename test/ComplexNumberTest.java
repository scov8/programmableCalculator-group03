/**
 * @file NumberTest.java
 * @author Marco Plaitano
 * @date 22 Nov 2021
 */

package test;

import org.junit.*;

import static org.junit.Assert.*;

import src.main.java.resources.ComplexNumber;


public class ComplexNumberTest {
    private static ComplexNumber n1;
    private static ComplexNumber n2;

    @BeforeClass
    public static void setUp() {
        n1 = new ComplexNumber(1, 1);
        n2 = new ComplexNumber(1, 1);
    }

    @Test
    public void testSetValues() {
        n1.setValues(23.50, 12);
        assertEquals(23.50, n1.getReal(), 0.0);
        assertEquals(12, n1.getImaginary(), 0.0);

        n1.setValues(9.001, -12.37);
        assertEquals(9.001, n1.getReal(), 0.0);
        assertEquals(-12.37, n1.getImaginary(), 0.0);

        n1.setValues(-26, 5);
        assertEquals(-26, n1.getReal(), 0.0);
        assertEquals(5, n1.getImaginary(), 0.0);

        n1.setValues(0, 5.5);
        assertEquals(0, n1.getReal(), 0.0);
        assertEquals(5.5, n1.getImaginary(), 0.0);

        n1.setValues(0, -1.5);
        assertEquals(0, n1.getReal(), 0.0);
        assertEquals(-1.5, n1.getImaginary(), 0.0);

        n1.setValues(34.12, 0);
        assertEquals(34.12, n1.getReal(), 0.0);
        assertEquals(0, n1.getImaginary(), 0.0);

        n1.setValues(-8, 0);
        assertEquals(-8, n1.getReal(), 0.0);
        assertEquals(0, n1.getImaginary(), 0.0);

        n1.setValues(0, 0);
        assertEquals(0, n1.getReal(), 0.0);
        assertEquals(0, n1.getImaginary(), 0.0);
    }

    @Test
    public void testEquals() {
        n1.setValues(1, 2);
        n2.setValues(1, 2);
        assertEquals(n1, n2);
        n2.setValues(1.00, 2.0);
        assertEquals(n1, n2);
        n1.setValues(15.001, -22.54);
        n2.setValues(15.001, -22.54);
        assertEquals(n1, n2);
        n1.setValues(-15.22, 87);
        n2.setValues(-15.22, 87);
        assertEquals(n1, n2);
        n1.setValues(-99, -0.2);
        n2.setValues(-99, -0.2);
        assertEquals(n1, n2);

        n1.setValues(0, 5.5);
        n2.setValues(0, 5.5);
        assertEquals(n1, n2);
        n1.setValues(0, -109.5);
        n2.setValues(0, -109.5);
        assertEquals(n1, n2);
        n1.setValues(32.89, 0);
        n2.setValues(32.89, 0);
        assertEquals(n1, n2);
        n1.setValues(-0.4, 0);
        n2.setValues(-0.4, 0);
        assertEquals(n1, n2);
        n1.setValues(0, 0);
        n2.setValues(0, 0);
        assertEquals(n1, n2);
        n1.setValues(-0, 0);
        n2.setValues(-0, 0);
        assertEquals(n1, n2);
        n1.setValues(0, -0);
        n2.setValues(0, -0);
        assertEquals(n1, n2);
        n1.setValues(-0, -0);
        n2.setValues(-0, -0);
        assertEquals(n1, n2);

        // Our implementation takes into account the first 10 decimal digits
        // when comparing doubles; n1 and n2 are not equals.
        n1.setValues(1.0, 2.0);
        n2.setValues(1.0000000001, 2);
        assertNotEquals(n1, n2);
        // With 11 decimal digits and the 11th being different, the result
        // depends on whether the 11th is >= 5 or not.
        n1.setValues(1.0, 2.0);
        n2.setValues(1.00000000001, 2);
        assertEquals(n1, n2);
        n1.setValues(1.0, 2.0);
        n2.setValues(1.00000000004, 2);
        assertEquals(n1, n2);
        n1.setValues(1.0, 2.0);
        n2.setValues(1.00000000005, 2);
        assertNotEquals(n1, n2);
        n1.setValues(1.0, 2.0);
        n2.setValues(1.00000000009, 2);
        assertNotEquals(n1, n2);

        n1.setValues(95.01, 12.54);
        n2.setValues(95.01, 12);
        assertNotEquals(n1, n2);
        n1.setValues(301, -22.54);
        n2.setValues(301, -2);
        assertNotEquals(n1, n2);
        n1.setValues(-16, 7);
        n2.setValues(-16, 6);
        assertNotEquals(n1, n2);
        n1.setValues(-99, -0.2);
        n2.setValues(-99, -0.02);
        assertNotEquals(n1, n2);

        n1.setValues(95.01, 12.54);
        n2.setValues(95, 12.54);
        assertNotEquals(n1, n2);
        n1.setValues(301, -2);
        n2.setValues(302, -2);
        assertNotEquals(n1, n2);
        n1.setValues(-16, 7);
        n2.setValues(-16.000002, 7);
        assertNotEquals(n1, n2);
        n1.setValues(-99, -0.2);
        n2.setValues(99,  -0.2);
        assertNotEquals(n1, n2);
    }

    @Test
    public void testToString() {
        n1.setValues(12.4, 32);
        assertEquals("12.4 + 32i", n1.toString());

        n1.setValues(12, -32.092);
        assertEquals("12 - 32.092i", n1.toString());

        n1.setValues(-0.12, -3.088);
        assertEquals("-0.12 - 3.088i", n1.toString());

        n1.setValues(-12, 32);
        assertEquals("-12 + 32i", n1.toString());

        n1.setValues(12.3, 32.25);
        assertEquals("12.3 + 32.25i", n1.toString());

        n1.setValues(0.01, -1);
        assertEquals("0.01 - 1i", n1.toString());

        // a small number is written in exponential form.
        n1.setValues(0.000001, 32.1);
        assertEquals("1.0E-6 + 32.1i", n1.toString());

        // when one of the parts (either real or imaginary) is ~0 it is not
        // written out.

        // a way to small number is approximated to 0.
        n1.setValues(0.00000000001, 32.1);
        assertEquals("32.1i", n1.toString());

        n1.setValues(3, 0);
        assertEquals("3", n1.toString());

        n1.setValues(3.0005, 0);
        assertEquals("3.001", n1.toString());

        n1.setValues(0, -23);
        assertEquals("-23i", n1.toString());
    }
}
