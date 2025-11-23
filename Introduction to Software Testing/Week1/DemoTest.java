import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

import org.junit.Test;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {
    @Test
    public void testIsTriangleValid1() {
        assertTrue(Demo.isTriangle(3,4,5));
    }

    @Test
    public void testIsTriangleValid1_1() {
        assertTrue(Demo.isTriangle(4,3,5));
    }

    @Test
    public void testIsTriangleValid1_2() {
        assertTrue(Demo.isTriangle(4,5,3));
    }

    @Test
    public void testIsTriangleValid1_3() {
        assertTrue(Demo.isTriangle(3,5,4));
    }

    @Test
    public void testIsTriangleValid1_4() {
        assertTrue(Demo.isTriangle(5,3,4));
    }

    @Test
    public void testIsTriangleValid1_5() {
        assertTrue(Demo.isTriangle(5,4,3));
    }


    @Test
    public void testIsTriangleValidFloat1() {
        assertTrue(Demo.isTriangle(3.5,5,4));
    }

    @Test
    public void testIsTriangleValidFloat2() {
        assertTrue(Demo.isTriangle(3.5,Math.sqrt(2),4));
    }

    @Test
    public void testIsTriangleValidFloat3() {
        assertTrue(Demo.isTriangle(3.5,Math.sqrt(2),Math.PI));
    }

    @Test
    public void testIsTriangleInvalid() {
        assertFalse(Demo.isTriangle(1,2,100));
    }

    @Test
    public void testIsTriangleInvalid2() {
        assertFalse(Demo.isTriangle(1,100,3));
    }

    @Test
    public void testIsTriangleInvalid3() {
        assertFalse(Demo.isTriangle(100,2,3));
    }

    @Test
    public void testIsTriangleInvalidZero() {
        assertFalse(Demo.isTriangle(0,1,1));
    }

    @Test
    public void testIsTriangleInvalidZero2() {
        assertFalse(Demo.isTriangle(0,0,0));
    }

    @Test
    public void testIsTriangleEquliatero() {
        assertTrue(Demo.isTriangle(1,1,1));
    }

    @Test
    public void testIsTriangleIsoscele() {
        assertTrue(Demo.isTriangle(1,1,1.5));
    }

    @Test
    public void testIsTriangleIsoscele2() {
        assertFalse(Demo.isTriangle(1,1,2));
    }

    @Test
    public void testIsTriangleInvalidNegative() {
        assertFalse(Demo.isTriangle(-1,1,1));
    }

    @Test
    public void testIsTriangleInvalidNegative1() {
        assertFalse(Demo.isTriangle(1,-1,1));
    }

    @Test
    public void testIsTriangleInvalidNegative2() {
        assertFalse(Demo.isTriangle(1,1,-1));
    }

    @Test
    public void testIsTriangleInvalidFlatLine() {
        assertFalse(Demo.isTriangle(2,3,5));
    }

    @Test
    public void testIsTriangleInvalidWithNaN() {
        assertFalse(Demo.isTriangle(Double.NaN, 2, 3));
    }

    @Test
    public void testIsTriangleInvalidWithNaN2() {
        assertFalse(Demo.isTriangle(1, Double.NaN, 3));
    }

    @Test
    public void testIsTriangleInvalidWithNaN3() {
        assertFalse(Demo.isTriangle(1, 2, Double.NaN));
    }

    @Test
    public void testIsTriangleInvalidWithNaN4() {
        assertFalse(Demo.isTriangle(Double.NaN, Double.NaN, Double.NaN));
    }

    @Test
    public void testIsTriangleInvalidWithInfinite() {
        assertFalse(Demo.isTriangle(Double.POSITIVE_INFINITY, 2, 3));
    }

    @Test
    public void testIsTriangleInvalidWithInfinite2() {
        assertFalse(Demo.isTriangle(1, 2, Double.POSITIVE_INFINITY));
    }

    @Test
    public void testIsTriangleInvalidWithInfinite3() {
        assertFalse(Demo.isTriangle(1, Double.POSITIVE_INFINITY, 3));
    }

    @Test
    public void testIsTriangleInvalidWithNegInfinite() {
        assertFalse(Demo.isTriangle(Double.NEGATIVE_INFINITY, 2, 3));
    }

    @Test
    public void testIsTriangleInvalidWithNegInfinite2() {
        assertFalse(Demo.isTriangle(1, 2, Double.NEGATIVE_INFINITY));
    }

    @Test
    public void testIsTriangleInvalidWithNegInfinite3() {
        assertFalse(Demo.isTriangle(1, Double.NEGATIVE_INFINITY, 3));
    }

    @Test
    public void testIsTriangleInvalidWithMaxValue() {
        assertFalse(Demo.isTriangle(Double.MAX_VALUE, 2, 3));
    }

    @Test
    public void testIsTriangleInvalidWithMaxValue2() {
        assertFalse(Demo.isTriangle(1, 2, Double.MAX_VALUE));
    }

    @Test
    public void testIsTriangleInvalidWithMaxValue3() {
        assertFalse(Demo.isTriangle(1, Double.MAX_VALUE, 3));
    }

    @Test
    public void testIsTriangleInvalidWithOverMaxValue() {
        assertFalse(Demo.isTriangle(Double.MAX_VALUE+1, 2, 3));
    }

    @Test
    public void testIsTriangleInvalidWithOverMaxValue2() {
        assertFalse(Demo.isTriangle(1, 2, Double.MAX_VALUE+1));
    }

    @Test
    public void testIsTriangleInvalidWithOverMaxValue3() {
        assertFalse(Demo.isTriangle(1, Double.MAX_VALUE+1, 3));
    }

    @Test
    public void testIsTriangleValidWithBigNumber() {
        assertTrue(Demo.isTriangle(1e150, 1e150, 1e150));
    }

    @Test
    public void testIsTriangleValidNonNumber() {
        assertFalse(Demo.isTriangle('a', 1, 1));
    }

    @Test
    public void testIsTriangleValidNonNumbe2r() {
        assertFalse(Demo.isTriangle(1, 'b', 1));
    }

    @Test
    public void testIsTriangleValidNonNumber3() {
        assertFalse(Demo.isTriangle(1, 1, 'c'));
    }
  
    @Test
    public void testMainValidTriangle() {
        String input = "3\n4\n5\n";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;

        try {
            // Simula input da tastiera
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Cattura output
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            // Esegui il main
            Demo.main(new String[]{});

            String result = out.toString();

            // Verifica che contenga la frase
            assertTrue(result.contains("This is a triangle."));

        } finally {
            // Ripristina stream originali
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }

    @Test
    public void testMainInValidTriangle() {
        String input = "3\n4\n200\n";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;

        try {
            // Simula input da tastiera
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Cattura output
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            // Esegui il main
            Demo.main(new String[]{});

            String result = out.toString();

            // Verifica che contenga la frase
            assertTrue(result.contains("This is not a triangle."));

        } finally {
            // Ripristina stream originali
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }

}
