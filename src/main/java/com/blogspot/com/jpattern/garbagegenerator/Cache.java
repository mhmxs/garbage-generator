package com.blogspot.com.jpattern.garbagegenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {

    private final Map<Integer, String> cache;

    public Cache(int maxSize) {
        cache = new LinkedHashMap<Integer, String>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > maxSize;
            }
        };
    }

    public void put(Integer i, String s) {
        cache.put(i, s);
    }

    public void reset() {
        cache.clear();
    }
}
