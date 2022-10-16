package com.mohammed;

import com.mohammed.Cache.Cache;
import com.mohammed.Cache.CachingPolicy.LRUEvictionPolicy;
import com.mohammed.Cache.Storage.HashMapStorage;

public class Main {
    public static void main (String args[]){
        Cache<Integer,Integer> cache= new Cache();
        cache.setStorage(new HashMapStorage<>(2));
        cache.setCachingPolicy(new LRUEvictionPolicy<>());

        cache.put(2,3);
        cache.put(3,4);
        cache.get(2);
        cache.put(5,6);
        cache.get(2);

    }

}
