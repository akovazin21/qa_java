package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    void getFamily_ReturnsCorrectString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void getFood_WithValidAnimalKind_ReturnsCorrectFoodList(String animalKind) throws Exception {
        List<String> result = animal.getFood(animalKind);

        if ("Травоядное".equals(animalKind)) {
            assertEquals(List.of("Трава", "Различные растения"), result);
        } else {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
        }
    }

    @Test
    void getFood_WithInvalidAnimalKind_ThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестный вид");
        });

        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}