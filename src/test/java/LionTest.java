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
        Feline feline = Mockito.mock(Feline.class);  // Мокируем Feline вместо Predator
        Lion lion = new Lion(sex, feline);

        if ("Самец".equals(sex)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }

    @Test
    void testGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);  // Теперь mock работает с Feline

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void testInvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}