package com.graphs;

public class MinEffort {

    public static void main(String[] args) {
        int[][] h = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        minimumEffortPath(h);
    }
    
    public static int minimumEffortPath(int[][] h) {
        int m = h.length;
        int n = h[0].length;
        
        int[][] mat = new int[h.length][h[0].length];
        mat[0][0] = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    mat[i][j] = Math.max(mat[i][j-1],Math.abs(h[i][j] - h[i][j - 1]));
                }else if(j == 0){
                    mat[i][j] = Math.max(mat[i-1][j],Math.abs(h[i][j] - h[i - 1][j]));
                }else{
                    mat[i][j] = Math.min(Math.max(mat[i-1][j] ,Math.abs(h[i][j] - h[i - 1][j]))
                             ,Math.max(mat[i][j-1] ,Math.abs(h[i][j] - h[i][j - 1])));        
                }
            }
        }
    return mat[m-1][n-1];
 }
}
