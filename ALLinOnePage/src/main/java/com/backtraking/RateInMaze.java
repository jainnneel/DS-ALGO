package com.backtraking;

import java.util.ArrayList;

public class RateInMaze {

    public static void main(String[] args) {
        
        int[][] m = {{1, 0, 0, 0},
                    {1, 1, 0, 1}, 
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
        findPath(m,4);
    }
    
 public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); 
        boolean[][] v = new boolean[n][n];
        findit(m,n,ans,0,0,sb,v);
        return ans;   
    }
    
    static boolean findit(int[][] m, int n,ArrayList<String> ans,int i,int j,StringBuilder sb,boolean[][] v){
        

        if(i < 0 || j < 0 || i >= n || j >=n ){
            return false;
        }
        
        if(i == n-1 && j == n-1){
            ans.add(sb.toString());
            return false;
        }
                    
        if(!v[i][j]){
            v[i][j] = true;
            if( i < n-1 && j < n && m[i+1][j]!=0 && !findit(m,n,ans,i+1,j,sb.append('D'),v)){
                sb.deleteCharAt(sb.length()-1);
            }
            if( i < n && j < n-1 && m[i][j+1]!=0 && !findit(m,n,ans,i,j+1,sb.append('R'),v)){
                sb.deleteCharAt(sb.length()-1);
            }
            if( i > 0 && j >= 0 && m[i-1][j]!=0 && !findit(m,n,ans,i-1,j,sb.append('U'),v)){
                sb.deleteCharAt(sb.length()-1);
            }
            if( i >= 0 && j > 0 && m[i][j-1]!=0 && !findit(m,n,ans,i,j-1,sb.append('L'),v)){
                sb.deleteCharAt(sb.length()-1);
            }
            
            v[i][j] = false;
            
        }
        
       return false; 
    }
}
