package com.dynamicprograming;

public class Uncrossedlines {

    public static void main(String[] args) {
    
        int[] a = {2,3,2,4};
        int[] b = {2,4,3,4};
        findIt(a,b);
    }

    private static void findIt(int[] a, int[] b) {
            
        int[][] mat = new int[a.length+1][b.length+1];

        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = 0;
            mat[0][i] = 0;
        }
        
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) {
                    mat[i][j] = mat[i-1][j-1] + 1;
                }else {
                    mat[i][j]= Math.max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }
        System.out.println();
        
    }

    
    
    
}

