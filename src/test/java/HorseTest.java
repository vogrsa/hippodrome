import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {

    @Test
    public void nullFirstParameterConstructorException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 15, 15));
    }

    @Test
    public void firstNullParameterExceptionContainMessage() {
        try {
            new Horse(null, 15, 15);
        } catch (IllegalArgumentException e) {
            //e.getMessage();
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "           ", "/t/t"})
    public void ExceptionWhenFirstParametersIsEmptyOrWhitespaceString(String value) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(value, 2, 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "/t/t"})
    public void ExceptionMessageWhenFirstParametersIsEmptyOrWhitespaceString(String value) {

        try {
            new Horse(value, 2, 5);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @Test
    public void ExceptionWhenSecondParameterNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("abc", -2, 5));
    }
    @Test
    public void ExceptionMessageWhenSecondParameterNegative() {
        try {
            new Horse("abc", -2, 5);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }
    @Test
    public void ExceptionWhenThirdParameterNegative(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("abc", 2, -5));
    }

    @Test
    public void ExceptionMessageWhenThirdParameterNegative() {
        try {
            new Horse("abc", 2, -5);
        } catch (IllegalArgumentException e) {
            assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }

}

//Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
// выброшенное исключение будет содержать сообщение "Speed cannot be negative.";
