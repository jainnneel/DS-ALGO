package com.dynamicprograming;

public class HouseRobber {

    static int[] mem = new int[100];
    
    public static void main(String[] args) {
        int[] ans = {1,3,1,3,100};
        boolean[] b = new boolean[ans.length];
        findit(ans, 0 , b , ans.length, 0);
    }

    private static int findit(int[] ans,int i , boolean[] b , int t , int sum) {
        
        if (mem[i] != -1) {
            return mem[i];
        }
        
        if(i >= t-1) {
            if (!b[i] && !b[i-1] && !b[0]) {
                sum = sum + ans[i];
            }
            System.out.println(sum);
            return sum;
        }
        
        
        if (i == 0) {
                b[0] = true;
                int sum1 =  findit(ans, (i+1)%(ans.length), b, t, sum + ans[0]);
                b[0] = false;
               int sum2 =  findit(ans, (i+1)%(ans.length), b, t, sum);
               return mem[i] =  Math.max(sum1, sum2);
        }else if (!b[i]) {
            if (!b[i - 1]) {
                b[i] = true;
               int sum1 =  findit(ans, (i+1)%(ans.length), b, t, sum+ans[i]);
                b[i] = false;
               int sum2 =  findit(ans, (i+1)%(ans.length), b, t, sum);
               return mem[i] =  Math.max(sum1, sum2);
            }else {
               return mem[i]  =  findit(ans, (i+1)%(ans.length), b, t, sum);
            }
        }
        return 0;
    }
}
