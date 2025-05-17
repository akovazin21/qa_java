package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline;  // Зависимость на конкретный класс Feline

    public Lion(String sex, Feline feline) throws Exception {  // Конструктор принимает Feline
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();  // Вызов метода Feline
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();  // Вызов метода Feline
    }
}