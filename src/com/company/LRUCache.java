package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LRUCache {
    private Set<Integer> cache;
    private int CACHE_SIZE;

     LRUCache(int capacity){
        cache = new HashSet<Integer>(capacity);
        CACHE_SIZE = capacity;
    }
    private boolean get(int page){
         if(!cache.contains(page)){
             return false;
         }else {
             cache.remove(page);
             cache.add(page);
             return true;
         }
    }
    private void put(int page){
         if(cache.contains(page)){
             cache.remove(page);
             cache.add(page);
         }else{
             if(CACHE_SIZE == cache.size()){
                 int firstKey = cache.iterator().next();
                 cache.remove(firstKey);
             }
             cache.add(page);
         }
    }

    public void refer(int page){
         if(get(page) == false){
             put(page);
         }
    }

    public void display(){
        List<Integer> l = new LinkedList<>(cache);
        Iterator<Integer> itr = ((LinkedList<Integer>) l).descendingIterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String [] args){
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
