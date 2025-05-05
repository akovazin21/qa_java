package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}