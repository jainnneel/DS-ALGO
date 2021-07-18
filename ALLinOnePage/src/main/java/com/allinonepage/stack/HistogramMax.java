package com.allinonepage.stack;

import java.util.Stack;

public class HistogramMax {

    public static void main(String[] args) {
        int a[] = {1, 2 ,3 ,4, 5};
        mah(a);
        
    }

    private static void mah(int[] a) {
        
        int lv[] = new int[a.length];
        int rv[] = new int[a.length];
        
        int absr = a.length;
        int absl = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i =a.length-1; i>=0; i--) {
            if (stack.size()==0) {
                rv[i] = absr;
                stack.push(i);
            }else if (stack.size()!=0 && a[stack.peek()]<a[i]) {
                rv[i] = stack.peek();
                stack.push(i);
            }else if (a[stack.peek()]>a[i]) {
                while (stack.size()!=0 && a[stack.peek()]>=a[i]) {
                    stack.pop();
                }
                if (stack.size()==0) {
                    rv[i] = absr;
                    stack.push(i);
                    continue;
                }
                rv[i] = stack.peek();
                stack.push(i);
            }
            
        }
        stack = new Stack<>();
        for (int i =0; i<a.length; i++) {
            if (stack.size()==0) {
                lv[i] = absl;
                stack.push(i);
            }else if (stack.size()!=0 && a[stack.peek()]<a[i]) {
                lv[i] = stack.peek();
                stack.push(i);
            }else if (a[stack.peek()]>a[i]) {
                while (stack.size()!=0 && a[stack.peek()]>=a[i]) {
                    stack.pop();
                }
                if (stack.size()==0) {
                    lv[i] = absl;
                    stack.push(i);
                    continue;
                }
                lv[i] = stack.peek();
                stack.push(i);
            }
            
        }
        for (int object : lv) {
            System.out.print(object+" ");
        }
        System.out.println();
        for (int object : rv) {
            System.out.print(object+" ");
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rv.length; i++) {
             int sum = 0; 
             if (lv[i]==0) {
                 sum = ((rv[i]-lv[i]))*a[i];
            }else {
                sum = ((rv[i]-lv[i])-1)*a[i];
            }
             max = sum>max?sum:max;
        }
       
        System.out.println(max);
    }
}
