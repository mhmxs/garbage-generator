package com.blogspot.com.jpattern.garbagegenerator;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Queue implements Closeable {

    private final List<Map<String, String>> queue = new CopyOnWriteArrayList<>();

    private volatile boolean closed;

    public void add(Map<String, String> elem) {
        Logger.instance().log("+");
        queue.add(elem);
    }

    public Map<String, String> get() {
        try {
            Map<String, String> elem = queue.stream().findFirst().get();
            Logger.instance().log("-");
            queue.remove(elem);
            return elem;
        } catch (java.util.NoSuchElementException e) {
            Logger.instance().log("x");
            return null;
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
    }

    public boolean isFlushed() {
        return closed && queue.isEmpty();
    }
}
