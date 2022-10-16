package com.mohammed.Cache.Storage;

public interface Storage<Key, Value> {
    void add(Key key, Value value);

    Value get(Key key);

    void remove(Key key);
}
