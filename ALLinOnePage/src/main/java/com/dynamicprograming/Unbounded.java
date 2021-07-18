package com.dynamicprograming;

public class Unbounded {

    public static void main(String[] args) {
    
        int[] w = {1,2,3};
        int val[] = {50,15,12}; 
        unbounded(w,val,10);
    }

    private static void unbounded(int[] w, int[] val, int i) {
        
        int wi = 10;
        int[][] mat = new int[w.length+1][wi+1];
        for (int j = 0; j <= w.length; j++) {
            for (int j2 = 0; j2 <= wi; j2++) {
                mat[j][j2] = -1;
            }
        }
        
        for (int j = 0; j <= w.length; j++) {
            mat[j][0] = 0;
        }
        for (int j = 0; j <= wi; j++) {
            mat[0][j] = 0;
        }
        
        for (int j = 1; j <= w.length; j++) {
            for (int j2 = 1; j2 <= wi; j2++) {
                if (w[j-1] <= j2) {
                    mat[j][j2] = Math.max(mat[j-1][j2], val[j-1] + mat[j][j2 - w[j-1]]);
                }else {
                    mat[j][j2] = mat[j-1][j2];
                }
            }
        }
        
        System.out.println(mat[w.length][wi]);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
