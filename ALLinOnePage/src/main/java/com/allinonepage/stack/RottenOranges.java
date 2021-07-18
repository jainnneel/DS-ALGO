package com.allinonepage.stack;

public class RottenOranges {

    public static void main(String[] args) {
        
        
        
        int[][] grid = {{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(orangesRotting(grid));
        
        
    }
    
    public static int orangesRotting(int[][] grid){
        int ans = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean f = false;
                if (grid[i][j] == 2 && check(grid)) {
                    if (i-1 >= 0 && j >= 0  && grid[i-1][j] == 1) {
                        f = true;
                        grid[i-1][j] = 3;
                    }
                    if (i >= 0 && j-1 >= 0  && grid[i][j-1] == 1) {
                        f = true;
                        grid[i][j-1] = 3;
                    }
                    if (i + 1 < grid.length && j >= 0  && grid[i+1][j] == 1) {
                        f = true;
                        grid[i+1][j] = 3;
                    }
                    if (i >= 0 && j+1 < grid.length  && grid[i][j+1] == 1) {
                        f = true;
                        grid[i][j+1] = 3;
                    }
                }

                if (f) {
                    convert(grid);
                    ans++;
                }
            }
        }
        
        
        return ans;
        
        
    }

    private static void convert(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
    }
    private static boolean check(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
