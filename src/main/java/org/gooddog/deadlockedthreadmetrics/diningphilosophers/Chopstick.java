package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

public class Chopstick {
    private final int number;

    public Chopstick(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "number=" + number +
                '}';
    }
}
