package com.backtraking;

public class LandMines {

    public static void main(String[] args) {
        
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < mat.length; i++) {
             int ans = 0;            
            boolean[][] b = new boolean[mat.length][mat.length]; 
             if (i== 0 && mat[i][0] != 0 &&  mat[i+1][0] != 0 && mat[i][1] != 0) {
//                 b[i][0] = true;
                 ans =  findit(mat,i,0,0,b);
             }else if (i== mat.length-1 &&  mat[i][0] != 0 && mat[i-1][0]!=0 && mat[i][1] != 0) {
//                 b[i][0] = true;
                 ans =  findit(mat,i,0,0,b);
             }else if (mat[i][0] != 0 && mat[i-1][0]!=0 && mat[i+1][0] != 0 && mat[i][1] != 0) {
//                 b[i][0] = true;
                 ans =  findit(mat,i,0,0,b);
            }
            
             min = Math.min(min, ans);
        }
        System.out.println();
        
    }

    private static int findit(int[][] mat, int i, int j, int k,boolean[][] b) {
        
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || b[i][j] || mat[i][j] == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (j== mat.length - 1) {
            return k;
        }
        
        if(j == 0 || isInvalid(mat,i,j)) {
            b[i][j] = true;
            int up = 1 + findit(mat, i-1, j, k + 1, b);
            int right =1 +  findit(mat, i, j+1,k + 1, b);
            int down = 1 + findit(mat, i+1, j, k + 1, b);
            int left = 1 + findit(mat, i, j-1, k + 1, b);
            b[i][j] = false;
            return Math.min(up, Math.min(right, Math.min(down, left)));
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isInvalid(int[][] mat, int i, int j) {
       
        if(i - 1 >= 0 && j-1>=0 && i + 1 < mat.length && j + 1 < mat[0].length) {
            
            if (mat[i-1][j] != 0 && mat[i][j+1] != 0 && mat[i+1][j] != 0 && mat[i][j-1]!=0) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}


















