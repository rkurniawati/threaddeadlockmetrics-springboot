package org.gooddog.deadlockedthreadmetrics.diningphilosophers;

import org.slf4j.Logger;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class PhilosopherWithMonitorLock extends Philosopher{
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(PhilosopherWithMonitorLock.class);
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public PhilosopherWithMonitorLock(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        super(number);
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void eat(int numSeconds) {
        try {
            synchronized (leftChopstick) {
                logger.info("{} has left chopstick {}", this, leftChopstick);
                sleep(numSeconds * 1000L);
                synchronized (rightChopstick) {
                    logger.info("{} has right chopstick {}", this, rightChopstick);
                    logger.info("{} is eating", this);
                    sleep(EATING_SECONDS * 1000L);
                }
            }
        } catch(InterruptedException e) {
            logger.error("Interrupted while eating", e);
        }
    }

    public static List<? extends Philosopher> createPhilosophers(int numPhilosophers) {
        List<Chopstick> chopsticks = IntStream.range(0, numPhilosophers)
                .mapToObj(Chopstick::new)
                .toList();
        // assign chopsticks to philosophers, philosophers i gets chopsticks i and i+1
        return IntStream.range(0, numPhilosophers)
                .mapToObj(i -> new PhilosopherWithMonitorLock(i, chopsticks.get(i), chopsticks.get((i + 1) % numPhilosophers)))
                .toList();
    }
}
