package com.allinonepage.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LRUCache {

    static class pair{
        int key;
        int val;
        
        public pair(int key,int val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "pair [key=" + key + ", val=" + val + "]";
        }
    }
    
   static Map<Integer,Integer> map;
    static Queue<pair> queue;
    static int cap;
    LRUCache(int cap2)
    {
        map = new HashMap<>();
        queue = new LinkedList<>();
        cap = cap2;
    }
    
    
    public static int get(int key)
    {
        if(map.containsKey(key)){
         Stack<pair> st = new Stack<>();
         
         while(!queue.isEmpty()){
             pair p = queue.poll();
             if(p.key == key){
                 while(!st.isEmpty()){
                     queue.offer(st.pop());
                 }
                 queue.offer(p);
                 break;
             }else{
                 st.push(p);
             }
         }
         return map.get(key);
        }else{
            return -1;
        }
                 
    }

    public static void set(int key, int value)
    {
           if(queue.size() < cap && !map.containsKey(key)){
                queue.offer(new pair(key,value));
                map.put(key,value);
           }else if (map.containsKey(key)) {
               map.put(key, value);
               return;
           }else{
               pair p = queue.poll();
                map.remove(p.key);
                queue.offer(new pair(key,value));
                map.put(key,value);
           }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        set(1,2);
        set(2,3);
        set(1,5);
        set(4,5);
        set(6,7);
        System.out.println(get(4));
        set(1,2);
        set(10,56);
        set(89,82);
        System.out.println(get(10));
        set(56,99);
        System.out.println(get(3));
        
    }
}
