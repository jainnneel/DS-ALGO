package com.allinonepage.stack;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceNearest1 {

    
    public static void main(String[] args) {
        
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        nearest(grid);
    }
    
    static class dist{
        int val;
        int x;
        int y;
        public dist(int val, int x, int y) {
            super();
            this.val = val;
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "dist [val=" + val + ", x=" + x + ", y=" + y + "]";
        }
        
        
    }        
    
    public static int[][] nearest(int[][] grid)
    {
        Queue<dist> queue = new LinkedList<>();
        int[][] ans = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new dist(0, i, j));
                    ans[i][j] = 0;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            
            dist poll = queue.poll();
            
            if (poll.x-1 >=0 && poll.y >=0 && grid[poll.x-1][poll.y] == 0) {
                queue.offer(new dist(poll.val+1, poll.x-1, poll.y));
                grid[poll.x-1][poll.y] = 1;
                ans[poll.x-1][poll.y] = poll.val+1;
            }
            if (poll.x >=0 && poll.y+1 < grid[0].length && grid[poll.x][poll.y+1] == 0) {
                queue.offer(new dist(poll.val+1, poll.x, poll.y+1));
                grid[poll.x][poll.y+1] = 1;
                ans[poll.x][poll.y+1] = poll.val+1;
            }
            if (poll.x+1  < grid.length && poll.y >=0 && grid[poll.x+1][poll.y] == 0) {
                queue.offer(new dist(poll.val+1, poll.x+1, poll.y));
                grid[poll.x+1][poll.y] = 1;
                ans[poll.x+1][poll.y] = poll.val+1;
            }
            if (poll.x >=0 && poll.y-1 >=0 && grid[poll.x][poll.y-1] == 0) {
                queue.offer(new dist(poll.val+1, poll.x, poll.y-1)); 
                ans[poll.x][poll.y-1] = poll.val+1;
                grid[poll.x][poll.y-1] = 1;
            }
            
        }
        return ans;
        
    }
}

