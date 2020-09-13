package converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FahrenheitToCelciusTest {

    @Test
    public void mustBeAbleToCreateConverter() {
        // Arrange

        // Act
        FahrenheitToCelcius test = new FahrenheitToCelcius();

        // Assert
        assertEquals(30.0, test.convert(86.0));

    }
}
