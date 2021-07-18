package com.allinonepage;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class JimandtheOrders {
    public static void main(String[] args) {
        int a[][] = new int[][] {
          new int[] {8,3},
          new int[] {5,6},
          new int[] {6,2},
          new int[] {2,3},
          new int[] {4,3},
        };
        jimOrders(a);
    }
    
    static int[] jimOrders(int[][] orders) {
        
        int ans[] = new int[orders.length];
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < orders.length; i++) {
            map.put(orders[i][0]+orders[i][1],i+1 );
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(map.values());
//        for (int i = 0; i < orders.length; i++) {
//            priorityQueue.add(orders[i][0]+orders[i][1]);
//        }
        
        int i =0;
        while (!priorityQueue.isEmpty()) {
            ans[i++] = getfirstoccure(priorityQueue.poll(),map);
        }
        
        return ans;
    }

    private static int getfirstoccure(Integer poll, Map<Integer, Integer> map) {
        for (Integer eInteger : map.keySet()) {
            if (poll==map.get(eInteger)) {
                map.remove(eInteger);
                return eInteger;
            }
        }
        return 0;
    }
}
