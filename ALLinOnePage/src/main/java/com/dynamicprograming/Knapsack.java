package com.dynamicprograming;

public class Knapsack {

    static int[][] mat = new int[6][21]; 
    public static void main(String[] args) {
        int[] v = {1,5,8,4,3};
        int[] w = {8,7,6,2,8};
//        System.out.println(maxprofitKnapsack(v,w,20,5));
//        Arrays.fill(mat, -1);
        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= 20; j++) {
                mat[i][j] = -1;
            }
        }
        for(int i = 0; i<=20 ; i++) {
                mat[0][i] = 0;
            }
        for(int i = 0; i<=5 ; i++) {
            mat[i][0] = 0;
        }
//        System.out.println(kanpsackMemoraization(v,w,20,5));
        System.out.println(kanpsackTopdown(v,w,8,5));
       
    }



    private static int kanpsackTopdown(int[] v, int[] w, int wi, int j) {
        for(int i = 0; i<=20 ; i++) {
            mat[0][i] = 0;
        }
        for(int i = 0; i<=5 ; i++) {
            mat[i][0] = 0;
        }
        
        for (int i = 1; i < w.length; i++) {
            for (int k = 1; k <= wi; k++) {
                if (k>=w[i]) {
                    mat[i][k] = Math.max(mat[i-1][k],v[i] +  mat[i-1][k-w[i]]);
                }else {
                    mat[i][k] = mat[i-1][k];
                }
            }
        }
        
        return mat[w.length-1][wi];
    }



    private static int kanpsackMemoraization(int[] v, int[] w, int i, int n) {
        if(n==0 || i==0) {
            return 0;
        }
        
        if (mat[n-1][i-1]!=-1) {
            return mat[n-1][i-1];
        }else {
            if(w[n-1]<=i) {
                return  mat[n-1][i-1] = Math.max(v[n-1] + maxprofitKnapsack(v,w,i-w[n-1],n-1), maxprofitKnapsack(v,w,i,n-1));
            }else {
                return mat[n-1][i-1] = maxprofitKnapsack(v,w,i,n-1);
            }
        }
    }

    private static int maxprofitKnapsack(int[] v, int[] w, int i, int n) {
        
        if(n==0 || i==0) {
            return 0;
        }
        
        if(w[n-1]<=i) {
            return Math.max(v[n-1] + maxprofitKnapsack(v,w,i-w[n-1],n-1), maxprofitKnapsack(v,w,i,n-1));
        }else {
            return maxprofitKnapsack(v,w,i,n-1);
        }
        
    }
    
    
}
