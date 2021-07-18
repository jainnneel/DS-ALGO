package com.allinonepage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waiter {

    static int[] waiter(List<Integer> in,int itre) {
        int[] ans = new int[in.size()];
        List<Stack<Integer>> a = new ArrayList<>();
        List<Stack<Integer>> b = new ArrayList<>();
        Stack<Integer> a0 = new Stack<>();
        for (Integer integer : in) {
            a0.add(integer);
        }
        a.add(a0);
        for (int i = 1; i <= itre; i++) {
            Stack<Integer> forA = new Stack<>();
            Stack<Integer> forb = new Stack<>();
           
            a.add(forA);
            b.add(forb);
         
            while (!a.get(i-1).isEmpty()) {
                Integer pop = a.get(i-1).pop();
                if (pop%primenumber(i)==0) {
                    b.get(i-1).push(pop);
                }else {
                    a.get(i).push(pop);
                }
            }
        }
        int i =0;
        for (Stack<Integer> object : b) {
            while (!object.isEmpty()) {
                ans[i++] = object.pop();
            }
        }
        for (Stack<Integer> object : a) {
            while (!object.isEmpty()) {
                ans[i++] = object.pop();
            }
        }
        return ans;
    }
    
    
    private static Integer primenumber(int n) {
//        int count = 0;
//        for (int j = 1; j <= Integer.MAX_VALUE; j++) {
//            int j2;    
//            for (j2 = 2; j2 < j; j2++) {
//                if (j%j2==0) {
//                    break;
//                }
//            }
//            if (count == i) {
//                return j-1;
//            }
//            if (j==2) {
//                count++;
//                continue;
//            }if (j==j2) {
//                count++;
//                continue;
//            }
//           
//        }
//        return null;
        
        List<Integer> list = new  ArrayList<Integer>();
        for (int i = 0; i < 1201; i++) {
            int j;
            for (j = 2; j < i; j++) {
               if (i%j==0) {
                   break;
               }
           }if (i==2) {
               list.add(i);
           }
           if (i==j) {
               list.add(j);
           }
       }
        return list.get(n);
    }

    public static void main(String[] args) {
        List<Integer> in =  new ArrayList<>();
        in.add(3);
        in.add(4);
        in.add(7);
        in.add(6);
        in.add(5);
        
        waiter(in,1);
    }
}
