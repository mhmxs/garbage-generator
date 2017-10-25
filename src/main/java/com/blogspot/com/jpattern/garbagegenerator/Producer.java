package com.blogspot.com.jpattern.garbagegenerator;

import java.util.Collections;
import java.util.UUID;

import com.blogspot.com.jpattern.garbagegenerator.Main.Config;

public class Producer implements Runnable {

    private Queue queue;

    private Config config;

    public Producer(Queue queue, Config config) {
        this.queue = queue;
        this.config = config;
    }

    @Override
    public void run() {
        while (!queue.isClosed()) {
            doIt();
        }
    }

    private void doIt() {
        UUID uuid = UUID.randomUUID();
        Integer id = uuid.hashCode();
        Integer abs = Math.abs(id);
        queue.add(Collections.singletonMap(String.valueOf(abs / config.divisor), uuid.toString()));
    }
}
