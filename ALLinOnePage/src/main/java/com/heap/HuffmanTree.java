package com.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanTree {

    public static void main(String[] args) {
        connectRopes(Arrays.asList(4,2,5,3,1));
    }

    private static void connectRopes(List<Integer> asList) {
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for (Integer object : asList) {
            priorityQueue.add(object);
        }
        
        int sum = 0;
        while (priorityQueue.size()!=1) {
            int f = priorityQueue.poll();
            int s = priorityQueue.poll();
            sum = sum + (f+s);
            priorityQueue.add((f+s));
        }
    }
}
