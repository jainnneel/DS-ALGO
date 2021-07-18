package com.allinonepage.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class InsertEleAtBottom {

    public static void main(String[] args) {
        List<Integer> as = new ArrayList<>(Arrays.asList(3,4,5));
//        insertBottom(as,10,3);
        Stack<Integer> deque = new Stack<>();
        deque.add(3); //3,4,5,1,4,8
        deque.add(4);
        deque.add(5);
        deque.add(1);
        deque.add(4);
        deque.add(8);
        System.out.println(deque);
        reverseStack(deque);
        System.out.println(deque);
    }

    private static void reverseStack(Stack<Integer> deque) {
        
        if(deque.size() == 0) {
            return;
        }
        
        int ele = deque.pop();
        
        reverseStack(deque);
        
//        deque.add(ele);
//        eleAtBottom(deque,ele);
        eleAtBottom(deque,ele);
        
        
    }

    private static void eleAtBottom(Stack<Integer> deque, int ele) {
        if(deque.size() == 0) {
            deque.push(ele);
            return;
        }
        
        int ele1 = deque.pop();
        
        eleAtBottom(deque, ele);
        
        deque.push(ele1);
        
    }

    private static void insertBottom(List<Integer> asList, int i,int n) {
       
        if(n == 0) {
            return;
        }
        
        int ele = asList.get(n-1);
        asList.remove(n-1);
        insertBottom(asList, i, n-1);
        
        if(asList.size() == 0) asList.add(i);
        asList.add(ele);
    }
}
