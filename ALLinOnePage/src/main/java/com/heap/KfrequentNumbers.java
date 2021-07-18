package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KfrequentNumbers {

    static class pair implements Comparable<pair> {
        int key;
        int value;
        public pair(int key,int value) {
            this.key = key;
            this.value = value;
        } 
        @Override
        public int compareTo(pair o) {
            if (this.value>o.value) {
                return 1;
            }else {
                return -1;
            }
        }
        @Override
        public String toString() {
            return "pair [key=" + key + ", value=" + value + "]";
        }
        
    }
    
    
    public static void main(String[] args) {
        
        topKFrequentNumber(Arrays.asList(1,1,1,3,2,2,4));
//        sortBasedOnfrequency(Arrays.asList(1,1,1,3,2,2,4));
    }

    private static void sortBasedOnfrequency(List<Integer> asList) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for (Integer integer : asList) {
            map.put(integer,0);
        }
        
        for (Integer integer : asList) {
            map.put(integer,map.get(integer)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Map.Entry<Integer,Integer> object : map.entrySet()) {
            priorityQueue.add(new pair(object.getKey(),object.getValue()));
        }
        
        while(priorityQueue.size()!=0) {
            pair p = priorityQueue.poll();
            System.out.println(p.key);
        }
    }

    private static void topKFrequentNumber(List<Integer> asList) {
        
        int k  = 2;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for (Integer integer : asList) {
            map.put(integer,0);
        }
        
        for (Integer integer : asList) {
            map.put(integer,map.get(integer)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Map.Entry<Integer,Integer> object : map.entrySet()) {
            
            priorityQueue.add(new pair(object.getKey(),object.getValue()));
            
            if(priorityQueue.size()>k) {
              pair o =   priorityQueue.poll();
              list.add(o.key);
            }
        }
        System.out.println(list);
//        for (Integer integer : map.values()) {
//            
//            priorityQueue.add(integer);
//            
//            if(priorityQueue.size()>k) {
//                priorityQueue.poll();
//            }
//        
//        }
//        for (Integer object2 : priorityQueue) {
//            if (map.keySet().contains(map.get(object2))) {
//                System.out.println(map.get(object2));
//            }
//        }    
           
            
    }
}
