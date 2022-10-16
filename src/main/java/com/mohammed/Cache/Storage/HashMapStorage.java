package com.mohammed.Cache.Storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> keyValueHashMap;
    private Integer capacity;

    public HashMapStorage(Integer capacity) {
        keyValueHashMap = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public Value get(Key key) {
        if(!keyValueHashMap.containsKey(key)) throw new RuntimeException("Key doesnt exist");
        return keyValueHashMap.get(key);
    }

    @Override
    public void add(Key key, Value value) {
        if(capacity == keyValueHashMap.size()) throw new RuntimeException("Cache is full");
        keyValueHashMap.put(key, value);
    }

    @Override
    public void remove(Key key) {
        if(keyValueHashMap.size() == 0) throw new RuntimeException("Cache is empty");
        keyValueHashMap.remove(key);
    }

}
