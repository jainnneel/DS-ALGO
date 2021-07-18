package com.dynamicprograming;

public class SubMatrix {
    
    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {1,-1},
            new int[] {-1,1},
        };
        numSubmatrixSumTarget(val,0);
    }
    
    public static int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length;
        int n = mat.length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(mat[i][j] == target){
                    ans++;
                }else{
                    int sum = mat[i][j];
                    if(findsum(mat,target,i,j,sum)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    static boolean findsum(int[][] mat,int t,int i,int j,int sum){
        
        if(i < 0 || i >= mat.length || j < 0 || j >= mat.length){
            return false;
        }
        
        if(sum == t){
            int[] ans = new int[2];
            ans[0] = i;
            ans[1] = j;
            return true;
        }
        
        return findsum(mat,t,i+1,j,sum+mat[i+1][j]) || findsum(mat,t,i,j+1,sum+mat[i][j+1]);
    }
    
}
