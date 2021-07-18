package com.allinonepage.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interleave {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        
        interleave(queue);
    }

    private static void interleave(Queue<Integer> queue) {
       
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        int size  = queue.size()/2;
        int tmp = size;
        while(tmp-- > 0) {
            st1.push(queue.poll());
        }
        while (!queue.isEmpty()) {
            st2.push(queue.poll());
        }
        
        queue.clear();
        
        while (!st1.isEmpty()) {
            queue.offer(st2.pop());
            queue.offer(st1.pop());
        }
        
        System.out.println(queue);
        
    }
    
    
}




















