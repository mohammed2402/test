package com.mohammed.Cache.CachingPolicy;

public interface CachingPolicy<Key> {
    void accessKey(Key key);

    Key evictKey();
}
