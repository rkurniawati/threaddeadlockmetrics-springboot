package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

public abstract class Philosopher {
    private final int number;
    public final int EATING_SECONDS = 20;

    public Philosopher(int number) {
        this.number = number;
    }

    /**
     * The philosopher eats by picking up the left chopstick, wait numSeconds, then picking up the right chopstick
     * @param numSeconds number of seconds to wait after picking up the left chopstick
     */
    abstract public void eat(int numSeconds);

    @Override
    public String toString() {
        return "Philosopher[" +
                "number=" + number + "]";
    }
}
