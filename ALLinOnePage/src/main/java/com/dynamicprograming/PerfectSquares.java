package com.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
 
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        findCount(13);
    }

    private static void findCount(int n) {
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(Math.pow(i, 0.5) - (int)Math.pow(i, 0.5) == 0) {
                list.add(i);
            }
        }
        
        int mat[] = new int[n+1];
        
        mat[0] = 0;
        mat[1] = 1;
        
        findit(mat,n,0,list);
        
//        recureIt(list,n,list.size()-1,n,0);
    }

    private static int findit(int[] mat, int n, int in,List<Integer> list) {
      
        for(int i = 2; i <= n;i++) {
            int ans = Integer.MAX_VALUE;
            for(int j = 0; j < list.size(); j++) {
                if(i - list.get(j) >= 0)
                    ans = Math.min(ans,1 + mat[i - list.get(j)]);
                
            }
            mat[i] = ans;
        }
        
        return mat[n];
        
    }

    private static void recureIt(List<Integer> list, int n, int in,int sum,int cnt) {
        
        if(sum  == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int i = in; i >= 0;i--) {
            if( n - list.get(i) >= 0) {
                recureIt(list, n - list.get(i), in, n - list.get(i), cnt+1);
            }else {
                recureIt(list, n, in - 1, sum, cnt);
            }
        }
    }
}






















