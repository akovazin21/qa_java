package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predator);

        if ("Самец".equals(sex)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }

    @Test
    void testGetKittens() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predator);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void testInvalidSex() {
        Predator predator = Mockito.mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", predator));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}