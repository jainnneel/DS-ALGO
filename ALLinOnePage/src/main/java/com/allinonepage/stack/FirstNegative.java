package com.allinonepage.stack;

import java.util.Arrays;
import java.util.Stack;

public class FirstNegative {

    public static void main(String[] args) {
        
        long[] val = {12, -1, -7, 8, -15, 30, 16, 28};
        printFirstNegativeInteger(val, 8 , 3);
        
    }
    
    public static long[] printFirstNegativeInteger(long a[], int n, int k)
    {
        
        Stack<Integer> stack = new Stack<Integer>();
        long ans[] = new long[a.length];
        long ans1[] = new long[a.length];
        long abs = -1;
        for (int i = a.length-1; i >= 0; i--) {
            
           if (stack.isEmpty()) {
               if (a[i] < 0) {
                   stack.push(i);
                   ans[i] = i;
               }else {
                   ans[i] = abs;
               }
           }else if (!stack.isEmpty() && a[i] < 0) {
               ans[i] = i;
               stack.push(i);
           }else if(!stack.isEmpty()) {
               ans[i] = stack.peek();
           } 
        }
        
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] - i < k) {
               if(ans[i]!=-1) ans1[i] = a[(int)ans[i]];
            }else {
                ans1[i] = 0;
            }
        }
        long[] copyOf = Arrays.copyOf(ans1, ans1.length-k+1);
        
        return copyOf;
        
           
    }
}
