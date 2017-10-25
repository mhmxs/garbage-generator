package com.blogspot.com.jpattern.garbagegenerator;

import java.util.Map;

import com.blogspot.com.jpattern.garbagegenerator.Main.Config;

public class Consumer implements Runnable {

    private Queue queue;

    private Config config;

    private Cache cache;

    public Consumer(Queue queue, Config config) {
        this.queue = queue;
        this.config = config;
        cache = new Cache(Integer.MAX_VALUE / config.divisor);
    }

    @Override
    public void run() {
        while (!queue.isFlushed()) {
            cache.reset();
            doIt();
        }
    }

    private void doIt() {
        Map<String, String> elem = queue.get();
        if (elem != null) {
            for (int i = 0; i <= Integer.MAX_VALUE / config.divisor; i++) {
                String k = new Integer(i).toString();
                cache.put(i, k);
                String uuid = elem.get(k);
                Logger.instance().log(".");
                if (uuid != null) {
                    Logger.instance().log("!");
                    return;
                }
            }
        }
    }
}
