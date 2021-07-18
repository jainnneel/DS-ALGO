package com.dynamicprograming;

import java.util.Arrays;

public class GoldMineProblem {
    static int mat[][] = new int[4][4];
    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {10, 33, 13, 15},
            new int[] {22, 21, 04, 1},
            new int[] {5, 0, 2, 3},
            new int[] {0, 6, 14, 2}
        };
        
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], -1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < val.length; i++) {
            
            max = Integer.max(max, maxgold(val,i,0));
            System.out.println(max);
        }
    }

    private static int maxgold(int[][] val, int i, int j) {
        if (i < 0 || i >= val.length || j < 0 || j >= val[0].length) {
            return 0;
        }
        if (mat[i][j] != -1) {
            return mat[i][j];
        }
        int ans = val[i][j];
          int max1  = val[i][j] + maxgold(val, i-1, j+1);
          int max2 =  val[i][j] + maxgold(val, i+1, j+1);
          int max3 =  val[i][j] + maxgold(val, i, j+1);
          ans = Math.max(max1, ans);
          ans = Math.max(max2, ans);
          ans = Math.max(max3, ans);
          
        return mat[i][j] =  ans;
    }
}
