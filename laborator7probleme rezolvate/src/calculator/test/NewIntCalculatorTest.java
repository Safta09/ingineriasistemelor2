
// NewIntCalculatorTest.java
package calculator.test;
import calculator.NewIntCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class NewIntCalculatorTest {

    private NewIntCalculator intCalculator;

    @BeforeEach
    void setUp() {
        intCalculator = new NewIntCalculator(0);
    }

    @Test
    void testIntCalculatorConstructor() {
        // Arrange
        int initialValue = 42;

        // Act
        NewIntCalculator calc = new NewIntCalculator(initialValue);

        // Assert
        assertEquals(initialValue, calc.result());
    }

    @Test
    void testIntCalculatorResult() {
        // Arrange
        int initialValue = 10;
        intCalculator = new NewIntCalculator(initialValue);

        // Act
        int result = intCalculator.result();

        // Assert
        assertEquals(initialValue, result);
    }

    @Test
    void testIntCalculatorClear() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.clear();

        // Assert
        assertEquals(0, intCalculator.result());
    }

    @Test
    void testIntCalculatorAdd_PositiveValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.add(5);

        // Assert
        assertEquals(15, intCalculator.result());
    }

    @Test
    void testIntCalculatorAdd_NegativeValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.add(-5);

        // Assert
        assertEquals(5, intCalculator.result());
    }

    @Test
    void testIntCalculatorAdd_ZeroValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.add(0);

        // Assert
        assertEquals(10, intCalculator.result());
    }

    @Test
    void testIntCalculatorSubtract_PositiveValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.subtract(5);

        // Assert
        assertEquals(5, intCalculator.result());
    }

    @Test
    void testIntCalculatorSubtract_NegativeValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.subtract(-5);

        // Assert
        assertEquals(15, intCalculator.result());
    }

    @Test
    void testIntCalculatorSubtract_ZeroValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.subtract(0);

        // Assert
        assertEquals(10, intCalculator.result());
    }

    @Test
    void testIntCalculatorMultiply_PositiveValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.multiply(2);

        // Assert
        assertEquals(20, intCalculator.result());
    }

    @Test
    void testIntCalculatorMultiply_NegativeValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.multiply(-2);

        // Assert
        assertEquals(-20, intCalculator.result());
    }

    @Test
    void testIntCalculatorMultiply_ZeroValue() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        intCalculator.multiply(0);

        // Assert
        assertEquals(0, intCalculator.result());
    }

    @Test
    void testIntCalculatorChainedOperations() {
        // Arrange
        intCalculator = new NewIntCalculator(10);

        // Act
        int result = intCalculator.add(5).subtract(3).multiply(2).result();

        // Assert
        assertEquals(24, result);
    }
}
