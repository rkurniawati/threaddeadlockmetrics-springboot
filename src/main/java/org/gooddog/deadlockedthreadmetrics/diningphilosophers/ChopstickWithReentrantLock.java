package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopstickWithReentrantLock extends Chopstick {
    private final ReentrantLock lock;

    public ChopstickWithReentrantLock(int number) {
        super(number);
        this.lock = new ReentrantLock();
    }

    public Lock getLock() {
        return lock;
    }
}
