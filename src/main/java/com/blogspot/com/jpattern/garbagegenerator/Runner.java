package com.blogspot.com.jpattern.garbagegenerator;

import com.blogspot.com.jpattern.garbagegenerator.Main.Config;

public class Runner {

    public void run(Config config) throws InterruptedException {
        Queue q = new Queue();

        new Thread(new Producer(q, config)).start();

        for (int i = 0; i < config.consumers; i++) {
            new Thread(new Consumer(q, config)).start();
        }

        Thread.sleep(config.produce);

        q.close();

        while(!q.isFlushed()) {
            Thread.sleep(10);
        }
    }
}
