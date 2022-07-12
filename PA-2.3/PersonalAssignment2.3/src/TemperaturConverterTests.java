import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperaturConverterTests {
    @Test
    public void ConvertToCelsius_ReturnsExpectedValue() {
        // Act
        var result = TemperatureConverter.convertFahrenheitToCelsius(32);

        // Assert
        assertEquals(0, result, 0.001);
    }
}
