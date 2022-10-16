package com.mohammed.Cache.CachingPolicy;

import com.mohammed.CustomDS.DoublyLinkedList;
import com.mohammed.CustomDS.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements CachingPolicy<Key>{

    DoublyLinkedList<Key> keyDLL;
    Map<Key, DoublyLinkedListNode<Key>> key2NodeMap;

    public LRUEvictionPolicy() {
        keyDLL = new DoublyLinkedList<>();
        key2NodeMap = new HashMap<>();
    }
    public void accessKey(Key key){
        DoublyLinkedListNode<Key> node;
        if(key2NodeMap.containsKey(key)) {
            node = key2NodeMap.get(key);
            keyDLL.remove(node);
            keyDLL.insertAtEnd(node);
        } else {
            key2NodeMap.put(key,keyDLL.insertElementAtEnd(key));
        }
    }

    public Key evictKey(){
        return keyDLL.removeFromBeginning();
    }
}
