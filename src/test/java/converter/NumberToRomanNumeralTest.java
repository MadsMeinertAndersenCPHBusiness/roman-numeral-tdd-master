package converter;

import converter.NumberToRomanNumeralConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberToRomanNumeralTest {

    @Test
    public void mustBeAbleToCreateConverter() {
        // Arrange

        // Act
        NumberToRomanNumeralConverter c = new NumberToRomanNumeralConverter();

        // Assert

    }
}
