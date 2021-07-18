package com.dynamicprograming;

public class DIEHARD {

    public static void main(String[] args) {
      
      int max  = Integer.MIN_VALUE;  
        
      for (int i = 0; i < 3; i++) {
              int air = air(i, 20 , 8);
              System.out.println(air);
            max = Math.max(max,air);
              
      }  
      System.out.println(max);  
    }

    private static int air(int i, int j, int k) {
        
        if (j <= 0 || k <= 0) {
            return -1;
        }
        
        if (i == 0) {
            int water = 1 + air(1, j-5, k-10);
            int fire = 1 + air(2, j-20, k+5);
            return Math.max(water, fire);
         }else if (i == 1) {
            int air = 1 + air(0, j+2, k+3);
            int fire = 1 + air(2, j-20, k+5);
            return Math.max(air, fire);
        }else {
            int air = 1 + air(0, j+2, k+3);
            int water = 1 + air(1,j-5, k-10);
            return Math.max(air, water);
        }
    }
    
    
}

