package com.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KclosetNumber {

    public static void main(String[] args) {
        kclosesetNumber(Arrays.asList(5,6,7,8,9));
    }

    private static void kclosesetNumber(List<Integer> asList) {
        
        int k = 3;
        int x = 7;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : asList) {
            
            int diff = Math.abs(integer-x);
            
            priorityQueue.add(diff);
            
            if (priorityQueue.size()>k) {
                priorityQueue.poll();
            }
             
        }
        int cnt = 0;
        for (Integer object : asList) {
            if (cnt <= k &&  priorityQueue.contains(Math.abs(object - x))) {
                cnt+=1;
                System.out.println(object);
            }
        } 
    }
}
