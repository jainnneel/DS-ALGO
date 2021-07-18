package com.allinonepage.stack;

import java.util.Stack;

public class NslAndNsr {
    
    public static void main(String[] args) {
        int a[] = {4,3,6,2,7,2};
//        nsl(a);
        nsr(a);
    }

    private static void nsr(int[] a) {
        int ans[] = new int[a.length];
        int abs = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = a.length-1; i >= 0; i--) {
            if (stack.size()==0) {
                ans[i] = abs;
                stack.push(a[i]);
            }else if (stack.size()!=0 && stack.peek()<a[i]) {
                ans[i] = stack.peek();
                stack.push(a[i]);
            }else if (stack.peek()>a[i]) {
                while (stack.size()!=0 && stack.peek()>=a[i]) {
                    stack.pop();
                }
                if (stack.size()==0) {
                    ans[i] = abs;
                    stack.push(a[i]);
                    continue;
                }
                ans[i] = stack.peek();
                stack.push(a[i]);
            }
            
        }
        
        for (int object : ans) {
            System.out.print(" "+object);
        }
        System.out.println();
        
    }

    private static void nsl(int[] a) {
        
        int ans[] = new int[a.length];
        int abs = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < a.length; i++) {
            if (stack.size()==0) {
                ans[i] = abs;
                stack.push(a[i]);
            }else if (stack.size()!=0 && stack.peek()<a[i]) {
                ans[i] = stack.peek();
                stack.push(a[i]);
            }else if (stack.peek()>a[i]) {
                while (stack.size()!=0 && stack.peek()>=a[i]) {
                    stack.pop();
                }
                if (stack.size()==0) {
                    ans[i] = abs;
                    stack.push(a[i]);
                    continue;
                }
                ans[i] = stack.peek();
                stack.push(a[i]);
            }
            
        }
        
        for (int object : ans) {
            System.out.print(" "+object);
        }
        System.out.println();
    }
}
