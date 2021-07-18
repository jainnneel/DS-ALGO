package com.allinonepage.stack;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

     public static void main(String[] args) {
        
    }   
     
     static int[] waiter(int[] number, int q) {
        int[] ans = new int[number.length];
        
        
        
        return ans;
     }
     
     private int getPrimeAt(int number) {
         int ans = 0;
         
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
         return ans;
     }
}
