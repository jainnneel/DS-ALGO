package com.allinonepage.stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(45);
        stack.push(54);
        stack.push(6);
        stack.push(9999);
        stack.push(55);
        
//        reverseit(stack);
        sortit(stack);
        System.out.println();
    }
    
    private static void sortit(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size()==1) {
            return;
        }
        
        int temp = stack.pop();
        sortit(stack);
        sort(stack,temp);
        
    }

    private static void sort(Stack<Integer> stack, int temp) {
        
        if (stack.isEmpty() || stack.peek() < temp) {
            stack.push(temp);
            return;
        }
        
        
        int temp1 = stack.pop();
        sort(stack, temp);
        stack.push(temp1);
    }

    static void reverseit(Stack<Integer> stack) {
        
        if (stack.isEmpty() || stack.size()==1) {
            return;
        }
        int temp = stack.pop();
        reverseit(stack);
        insert(stack,temp);
        
    }

    private static void insert(Stack<Integer> stack,int temp) {
       
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        
        int temp1 = stack.pop();
        insert(stack, temp);
        stack.push(temp1);
        
    }
}
