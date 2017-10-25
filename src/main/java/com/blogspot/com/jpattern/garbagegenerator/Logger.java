package com.blogspot.com.jpattern.garbagegenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class Logger {

    private static Logger Logger = new Logger();

    private AtomicInteger counter = new AtomicInteger();

    public static Logger instance() {
        return Logger;
    }

    public void log(String item) {
        int printed = counter.incrementAndGet();
        if (printed != 0 && printed % 100 == 0) {
            counter.getAndSet(0);
            System.err.println("");
        }
        System.err.print(item);
    }
}
