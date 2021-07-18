package com.preplacement;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Minstack implements Cloneable {
   static Stack<Integer> deque = new Stack<>();
   
    static int min = 0;
    public static void main(String[] args) {
   
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(10);
        
        push(7);
        push(2);
        push(6);
        push(3);
        pop();
        push(1);
        pop();
        push(2);
        push(8);
        getmin();
    }

    private static void getmin() {
        if (deque.size()==0) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }

    private static void pop() {
        
        if (deque.size()==0) {
            System.out.println(-1);
        }
        if (top()>min) {
            System.out.println(deque.pop());
        }else {
            Integer poll = deque.pop();
            System.out.println(min);
            min = 2*min-poll;
        }
    }

    private static void push(int i) {
        
        if (deque.size()==0) {
            deque.push(i);
            min = i;
        }else {
            if (i>=min) {
                deque.push(i);
            }else if (i<min) {
                deque.push(2*i-min);
                min = i;
            }
        }
    }
    
    private static int top() {
        if (deque.size()==0) {
            return -1;
        }
        if (deque.peek()>=min) {
            return deque.peek();
        }else {
            return min;
        }
    }
    
}