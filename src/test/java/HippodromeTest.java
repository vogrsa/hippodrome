import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
         new Hippodrome(horses);
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
            verify(horse, atLeast(1)).move();
        }

    }
    @Test
    public void getWinner() {
        Horse horse1 = new Horse("horse1", 2, 1);
        Horse horse2 = new Horse("horse2", 2, 0.2);
        Horse horse5 = new Horse("horse5", 2, 5);

        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse5));
        assertSame(horse5, hippodrome.getWinner());
    }



}

