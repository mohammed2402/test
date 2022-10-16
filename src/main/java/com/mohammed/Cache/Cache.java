package com.mohammed.Cache;

import com.mohammed.Cache.CachingPolicy.CachingPolicy;
import com.mohammed.Cache.Storage.Storage;

public class Cache<Key,Value> {
    Storage<Key, Value> storage;
    CachingPolicy<Key> cachingPolicy;

    public Storage<Key, Value> getStorage() {
        return storage;
    }

    public void setStorage(Storage<Key, Value> storage) {
        this.storage = storage;
    }

    public CachingPolicy<Key> getCachingPolicy() {
        return cachingPolicy;
    }

    public void setCachingPolicy(CachingPolicy<Key> cachingPolicy) {
        this.cachingPolicy = cachingPolicy;
    }

    public void put(Key key, Value value){
        try {
            storage.add(key, value);
            cachingPolicy.accessKey(key);
        } catch (Exception ex) {
            Key evictedKey = cachingPolicy.evictKey();
            storage.remove(evictedKey);
            put(key, value);
        }
    }

    public Value get(Key key){
        Value value = storage.get(key);
        cachingPolicy.accessKey(key);
        return value;
    }

}
