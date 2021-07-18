package com.backtraking;

public class UniquePath {

    static int ans = 0;
    
    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {1,0,0,0},
            new int[] {0,0,0,0},
            new int[] {0,0,0,2}
        };
       new UniquePath().uniquePathsIII(val);
       System.out.println(ans);
    }
    
    public int uniquePathsIII(int[][] grid) {
        
        boolean[][] v = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == -1){
                   v[i][j] = true;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                   v[i][j] = true;
                   countuniquepath(grid,i,j-1,v);
                   countuniquepath(grid,i-1,j,v);
                   countuniquepath(grid,i,j+1,v);
                   countuniquepath(grid,i+1,j,v);
                }
            }
        }
        
        return ans;
    }
    
     void countuniquepath(int[][] grid, int i, int j,boolean[][] v){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        
        if(v[i][j] == true){
            return;
        }
        
        if(grid[i][j] == -1){
            
            return;
        }
         
        if(grid[i][j] == 2){
            System.out.println(i+" "+j);
            v[i][j] = true;
            if(checkAlltrue(v)){
                ans = ans + 1;
            }
            v[i][j] = false;
            return;                          
        }
        
        
        v[i][j] = true;
        System.out.println(i+" "+j);
        countuniquepath(grid,i,j-1,v);
        countuniquepath(grid,i-1,j,v);
        countuniquepath(grid,i,j+1,v);
        countuniquepath(grid,i+1,j,v);
        v[i][j] = false;
        
    }
    
    static boolean checkAlltrue(boolean[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == false){
                    return false;
                }
            }
        }
        return true;
    }
    
}
