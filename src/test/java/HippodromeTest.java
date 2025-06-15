import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HippodromeTest {
    private List<Horse> horses = new ArrayList<>();

    @Test
    public void nullException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));

    }
    @Test
    public void nullExceptionMessage() {
        try {
            new Hippodrome(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void emptyListException() {
        try {
          Hippodrome hippodrome = new Hippodrome(horses);
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }
    @Test
    public void getHorses() {
        List<Horse> horseList = new ArrayList<>();
        for (int i = 1; i < 30 ; i++) {
            horseList.add(new Horse("" + i, i, i));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);
 //       assertSame(horseList, hippodrome.getHorses());
        assertEquals(horseList, hippodrome.getHorses());
    }

    @Test
    public void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50 ; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse : horses) {
            verify(horse).move();
        }

    }
}

