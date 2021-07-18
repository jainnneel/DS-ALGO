package com.dynamicprograming;

import java.util.Arrays;

public class CatlanNumber {

    public static void main(String[] args) {
        
        for (int i = 0; i < 4; ++i) {
            System.out.println(i);
        }
        
        
        int[] cat = new int[11];
        Arrays.fill(cat, -1);
        cat[0] = 1;
        cat[1] = 1;
//        System.out.println(findit(3));
        System.out.println(catWithDp(3,cat));
        
    }

    private static int catWithDp(int i, int[] cat) {
        
        if (cat[i]!=-1) {
            return cat[i];
        }
        
        int ans  = 0;
        
        for (int j = 0; j < i; j++) {
            
            ans = ans + catWithDp(j, cat) * catWithDp(i - j - 1, cat);
        }
        
        return cat[i] = ans;
    }

    private static int findit(int n) {
        
      if(n <= 1) {
          return 1;
      }
      int ans  = 0;
      for (int i = 0; i < n; i++) {
          ans = ans + findit(i) * findit(n - i - 1);
      }
      return ans;
    }
    
    
}
