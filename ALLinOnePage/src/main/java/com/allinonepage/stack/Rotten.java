package com.allinonepage.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten {

    public static void main(String[] args) {
        int[][] g = {{0,1,2},
                    {0,1,2},
                    {2,1,1}};
        orangesRotting(g);
    }
    
    static class pair{
        int i;
        int j;
        int tm;
        public pair(int i1,int j1,int tm1){
            i = i1;
            j = j1;
            tm = tm1;
        }
        @Override
        public String toString() {
            return "pair [i=" + i + ", j=" + j + ", tm=" + tm + "]";
        }
        
    }
    public static int orangesRotting(int[][] g)
    {
        int ans = 0;
        int n = g.length;
        int m = g[0].length;
        Queue<pair> qu = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(g[i][j] == 2){
                    qu.add(new pair(i,j,0));
                }
            }
        }
        
        
        while(!qu.isEmpty()){
            
            pair p1 = qu.poll();
            ans = Math.max(ans,p1.tm);
            if(p1.i - 1 >= 0 && p1.j >= 0 && g[p1.i - 1][p1.j] == 1){
                g[p1.i - 1][p1.j] = 2;
                qu.add(new pair(p1.i - 1,p1.j,p1.tm + 1));
            } 
             if(p1.i + 1 < n && p1.j >= 0 && g[p1.i + 1][p1.j] == 1){
                g[p1.i + 1][p1.j] = 2;
                qu.add(new pair(p1.i + 1,p1.j,p1.tm + 1));
            } 
             if(p1.i  >= 0 && p1.j - 1 >= 0 && g[p1.i][p1.j - 1] == 1){
                g[p1.i][p1.j-1] = 2;
                qu.add(new pair(p1.i,p1.j - 1,p1.tm + 1));
            } 
             if(p1.i >= 0 && p1.j + 1 < m && g[p1.i][p1.j + 1] == 1){
                 g[p1.i][p1.j+1] = 2;
                qu.add(new pair(p1.i,p1.j + 1,p1.tm + 1));
            } 
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(g[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
