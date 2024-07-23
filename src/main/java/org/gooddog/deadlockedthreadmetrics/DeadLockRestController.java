package org.gooddog.deadlockedthreadmetrics;

import org.gooddog.deadlockedthreadmetrics.diningphilosophers.DiningPhilosophers;
import org.gooddog.deadlockedthreadmetrics.diningphilosophers.PhilosopherWithMonitorLock;
import org.gooddog.deadlockedthreadmetrics.diningphilosophers.PhilosopherWithReentrantLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadLockRestController {

    @GetMapping("/monitorDeadlock")
    public void monitorDeadlock(@RequestParam(name = "numPhilosophers", required = false, defaultValue = "5") int numPhilosophers,
                                @RequestParam(name = "eatingTimeSeconds", required = false, defaultValue = "10") int eatingTimeSeconds) {
        DiningPhilosophers dp = new DiningPhilosophers(PhilosopherWithMonitorLock.createPhilosophers(numPhilosophers), eatingTimeSeconds);
        dp.startDinner();
    }

    @GetMapping("/deadlock")
    public void deadlock(@RequestParam(name = "numPhilosophers", required = false, defaultValue = "5") int numPhilosophers,
                         @RequestParam(name = "eatingTimeSeconds", required = false, defaultValue = "10") int eatingTimeSeconds) {
        DiningPhilosophers dp = new DiningPhilosophers(PhilosopherWithReentrantLock.createPhilosophers(numPhilosophers), eatingTimeSeconds);
        dp.startDinner();
    }
}
