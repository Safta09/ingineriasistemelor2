
// DoubleCalculatorTest.java
package calculator.test;

import calculator.DoubleCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {

    private DoubleCalculator doubleCalculator;

    @BeforeEach
    void setUp() {
        doubleCalculator = new DoubleCalculator(0.0);
    }

    @Test
    void testDoubleCalculatorConstructor() {
        // Arrange
        double initialValue = 42.5;

        // Act
        DoubleCalculator calc = new DoubleCalculator(initialValue);

        // Assert
        assertEquals(initialValue, calc.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorResult() {
        // Arrange
        double initialValue = 10.5;
        doubleCalculator = new DoubleCalculator(initialValue);

        // Act
        double result = doubleCalculator.result();

        // Assert
        assertEquals(initialValue, result, 0.001);
    }

    @Test
    void testDoubleCalculatorClear() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.clear();

        // Assert
        assertEquals(0.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorAdd_PositiveValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.add(5.5);

        // Assert
        assertEquals(16.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorAdd_NegativeValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.add(-5.5);

        // Assert
        assertEquals(5.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorAdd_ZeroValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.add(0.0);

        // Assert
        assertEquals(10.5, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorSubtract_PositiveValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.subtract(5.5);

        // Assert
        assertEquals(5.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorSubtract_NegativeValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.subtract(-5.5);

        // Assert
        assertEquals(16.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorSubtract_ZeroValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.subtract(0.0);

        // Assert
        assertEquals(10.5, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorMultiply_PositiveValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.multiply(2.0);

        // Assert
        assertEquals(21.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorMultiply_NegativeValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.multiply(-2.0);

        // Assert
        assertEquals(-21.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorMultiply_ZeroValue() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.5);

        // Act
        doubleCalculator.multiply(0.0);

        // Assert
        assertEquals(0.0, doubleCalculator.result(), 0.001);
    }

    @Test
    void testDoubleCalculatorChainedOperations() {
        // Arrange
        doubleCalculator = new DoubleCalculator(10.0);

        // Act
        double result = doubleCalculator.add(5.0).subtract(3.3).multiply(2.2).result();

        // Assert
        assertEquals(25.74, result, 0.001);
    }

    @Test
    void testDoubleCalculatorPrecision() {
        // Arrange
        doubleCalculator = new DoubleCalculator(0.1);

        // Act
        doubleCalculator.add(0.2);

        // Assert
        assertEquals(0.3, doubleCalculator.result(), 0.000001);
    }
}