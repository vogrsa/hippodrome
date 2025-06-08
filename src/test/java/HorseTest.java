import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.lang.reflect.Field;

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

    @Test
    public void getNameWhileItwasPassedFirstParameter() {
        Horse horse = new Horse("Fast", 2, 5);
        assertEquals("Fast", horse.getName());
    }

}

//метод getName
//Проверить, что метод возвращает строку, которая была передана первым параметром в конструктор;
//метод getSpeed
//Проверить, что метод возвращает число, которое было передано вторым параметром в конструктор;
//метод getDistance
//Проверить, что метод возвращает число, которое было передано третьим параметром в конструктор;
//Проверить, что метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами;
//метод move
//Проверить, что метод вызывает внутри метод getRandomDouble с параметрами 0.2 и 0.9. Для этого нужно использовать MockedStatic и его метод verify;
//Проверить, что метод присваивает дистанции значение высчитанное по формуле: distance + speed * getRandomDouble(0.2, 0.9). Для этого нужно замокать getRandomDouble, чтобы он возвращал определенные значения, которые нужно задать параметризовав тест.;
