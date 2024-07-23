package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

import org.slf4j.Logger;

import java.util.List;
import java.util.stream.IntStream;

public class PhilosopherWithReentrantLock extends Philosopher{
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(PhilosopherWithReentrantLock.class);
    private final ChopstickWithReentrantLock leftChopstick;
    private final ChopstickWithReentrantLock rightChopstick;

    public PhilosopherWithReentrantLock(int number, ChopstickWithReentrantLock leftChopstick, ChopstickWithReentrantLock rightChopstick) {
        super(number);
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void eat(int numSeconds) {
        try {
            leftChopstick.getLock().lock();
            logger.info("{} has left chopstick {}", this, leftChopstick);

            Thread.sleep(numSeconds * 1000L);
            rightChopstick.getLock().lock();
            logger.info("{} has right chopstick {}", this, rightChopstick);

            logger.info("{} is eating", this);
            Thread.sleep(EATING_SECONDS * 1000L);
        } catch (InterruptedException e) {
            logger.error("Interrupted while eating", e);
        } finally {
            rightChopstick.getLock().unlock();
            leftChopstick.getLock().unlock();
        }
    }

    public static List<? extends Philosopher> createPhilosophers(int numPhilosophers) {
        List<ChopstickWithReentrantLock> chopsticks = IntStream.range(0, numPhilosophers)
                .mapToObj(ChopstickWithReentrantLock::new)
                .toList();
        // assign chopsticks to philosophers, philosophers i gets chopsticks i and i+1
        return IntStream.range(0, numPhilosophers)
                .mapToObj(i -> new PhilosopherWithReentrantLock(i, chopsticks.get(i), chopsticks.get((i + 1) % numPhilosophers)))
                .toList();
    }

}
