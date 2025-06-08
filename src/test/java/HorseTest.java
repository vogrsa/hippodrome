import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}

//Проверить, что при передаче в конструктор первым параметром пустой строки или строки содержащей только
// пробельные символы (пробел, табуляция и т.д.), выброшенное исключение будет содержать сообщение "Name cannot be blank.";
