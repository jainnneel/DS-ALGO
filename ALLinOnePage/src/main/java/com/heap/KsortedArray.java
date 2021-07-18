package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KsortedArray {

    public static void main(String[] args) {
        ksortedArrays(Arrays.asList(6,5,3,2,8,10,9));
    }

    private static void ksortedArrays(List<Integer> asList) {
        
        int k = 3; 
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for (Integer val : asList) {
            
            priorityQueue.add(val);
            
            if (priorityQueue.size()>k) {
                list.add(priorityQueue.poll());
            }
        }
      for (Integer object : priorityQueue) {
        list.add(object);
    }
        
    }
}
