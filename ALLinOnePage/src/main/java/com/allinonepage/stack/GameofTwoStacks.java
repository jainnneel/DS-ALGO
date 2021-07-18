package com.allinonepage.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class GameofTwoStacks {

    public static void main(String[] args) {
        int[] a = {1,6,4,2,4};
        int[] b = {5,8,2,1};
//        twoStacksPriority(10 , a, b);
        tostacks(10,a,b);
    }
    
    private static void tostacks(int i, int[] a, int[] b) {
        Arrays.sort(a);
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for (Integer object : a) {
            stack.push(object);
        }
        for (Integer object : b) {
            stack2.push(object);
        } 
        int sum = 0;
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            if (stack.peek()>stack2.peek()) {
                sum = sum + stack2.pop();
            }else {
                sum = sum + stack.pop();
            }
            if (sum>i) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

    static int twoStacksPriority(int x, int[] a, int[] b) {
        int ans = 0;
        PriorityQueue<Integer> priorityQueuea = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueb = new PriorityQueue<>();
        
        for (int i : a) {
            priorityQueuea.add(i);
        }
        for (int i : b) {
            priorityQueueb.add(i);
        }
        
        boolean flag = true;
        int sum = 0;
        while (sum<x && !priorityQueuea.isEmpty() && !priorityQueueb.isEmpty()) {
            if (flag) {
                sum = sum + priorityQueuea.poll();
                flag = !flag;
            }else {
                sum = sum + priorityQueueb.poll();
                flag = !flag;
            }
            ans++;
        }
        
        return ans;
    }
}
