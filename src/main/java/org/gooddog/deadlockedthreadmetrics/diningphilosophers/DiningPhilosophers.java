package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

import java.util.List;

public class DiningPhilosophers {
    private final List<? extends Philosopher> philosophers;
    private final int numSeconds;

    public DiningPhilosophers(List<? extends Philosopher> philosophers, int numSeconds) {
        this.philosophers = philosophers;
        this.numSeconds = numSeconds;
    }

    public void startDinner() {
        philosophers.forEach(philosopher -> {
            Thread t = new Thread(() -> philosopher.eat(numSeconds));
            t.start();
        });
    }
}
