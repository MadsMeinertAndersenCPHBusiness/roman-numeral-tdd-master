package converter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberToRomanNumeralTest {
    private NumberToRomanNumeralConverter test;

    @BeforeEach
    public void setup()
    {
        test = new NumberToRomanNumeralConverter();
    }

    @Test
    public void testThirtyNineMustEqualXXXIX() {
        // Arrange
        // Act
        // Assert
        assertEquals("XXXIX", test.convert(39));

    }
    @Test
    public void testTwoHundredAndFortySixMustEqualCCXLVI() {
        // Arrange
        // Act
        // Assert
        assertEquals("CCXLVI", test.convert(246));

    }
    @Test
    public void testSevenHundredAndEightyNineMustEqualDCCLXXXIX() {
        // Arrange
        // Act
        // Assert
        assertEquals("DCCLXXXIX", test.convert(789));

    }
    @Test
    public void testTwThousandFourHundredAndTwentyOneMustEqualMMCDXXI() {
        // Arrange
        // Act
        // Assert
        assertEquals("MMCDXXI", test.convert(2421));

    }
}
