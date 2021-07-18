package com.allinonepage.stack;

import java.util.Stack;

public class NllAndNlr {

    public static void main(String[] args) {
        int a[] = {3,6,4,8,5,2};
//        nll(a);
        nlr(a);
    }

    private static void nlr(int[] a) {
        int ans[] = new int[a.length];
        int abs = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = a.length-1; i >= 0; i--) {
            if (stack.size()==0) {
                ans[i] = abs;
                stack.push(a[i]);
            }else if (stack.size()!=0 && stack.peek()>a[i]) {
                ans[i] = stack.peek();
                stack.push(a[i]);
            }else if (stack.peek()<a[i]) {
                while (stack.size()!=0 && stack.peek()<=a[i]) {
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
            System.out.println(object);
        }
        
        
    }

    private static void nll(int[] a) {
        
        int ans[] = new int[a.length];
        int abs = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < a.length; i++) {
            if (stack.size()==0) {
                ans[i] = abs;
                stack.push(a[i]);
            }else if (stack.size()!=0 && stack.peek()>a[i]) {
                ans[i] = stack.peek();
                stack.push(a[i]);
            }else if (stack.peek()<a[i]) {
                while (stack.size()!=0 && stack.peek()<=a[i]) {
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
            System.out.println(object);
        }
    }
}
