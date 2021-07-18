package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    static LinkedList<Integer> adj[];
    
    public BFS(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    
    public static void main(String[] args) {
        
        List<Integer> integers= Arrays.asList(1,3,4,2,5,6,7);
        integers.stream().sorted().forEach(System.out :: print);
        integers.parallelStream().forEachOrdered(System.out :: print);

        
        BFS bfs  =  new BFS(5);
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 4);
        bfs.addEdge(0, 4);
        bfs.addEdge(2, 4);
//        System.out.println(bfs.bfsMinimumFromSourceTodestination(0,3));
        
        int[][] grid = {{1,1,0,1},{1,0,0,0},{1,1,0,1}};
        
//        minimumSpreadTime(grid,2,3);
        findSpans(Arrays.asList(4 ,2 ,3 ,3 ,6));
    }
    
    static class pair{
        int in;
        int val;
        pair(int in,int val){
            this.in = in;
            this.val = val;
        }
    }
    public static ArrayList<Integer> findSpans(List<Integer> price) {
        Stack<pair> st = new Stack<>();
        st.push(new pair(0,price.get(0)));
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 1; i < price.size(); i++){
            int tans = 0;
            int tm = price.get(i);
            while(!st.isEmpty() && st.peek().val <= tm){
                pair p = st.pop();
                tans += ans.get(p.in);
                tm = p.val;
            }
            
            ans.add(tans+1);
            st.push(new pair(i,price.get(i)));
        }
        return ans;
        
    }
    
    static class smoker{
        int i;
        int j;
        int time;
        smoker(int i,int j,int time){
            this.time=time;
            this.j = j;
            this.i = i;
        }
    }
    
    public static int minimumSpreadTime(int[][] grid, int x, int y) {
        
        Queue<smoker> qu = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        qu.add(new smoker(x,y,0));
        int ans = 0;
        boolean[][] v = new boolean[n][m];
        v[x][y] = true;
        while(!qu.isEmpty()){
            smoker sm = qu.poll();
            ans = Math.max(ans,sm.time);
            
            if(sm.i - 1 >= 0 && sm.j >= 0 && grid[sm.i-1][sm.j] == 0 && !v[sm.i-1][sm.j]){
                v[sm.i-1][sm.j] = true;
                qu.add(new smoker(sm.i-1,sm.j,sm.time+1));
            }
            if(sm.i >= 0 && sm.j + 1 < m && grid[sm.i][sm.j+1] == 0 && !v[sm.i][sm.j+1]){
                v[sm.i][sm.j+1] = true;
                qu.add(new smoker(sm.i,sm.j + 1,sm.time+1));
            }
            if(sm.i + 1 < n && sm.j >= 0 && grid[sm.i+1][sm.j] == 0 && !v[sm.i+1][sm.j]){
                v[sm.i+1][sm.j] = true;
                qu.add(new smoker(sm.i + 1,sm.j,sm.time+1));
            }
            if(sm.i >= 0 && sm.j - 1 >= 0 && grid[sm.i][sm.j-1] == 0 && !v[sm.i][sm.j-1]){
                v[sm.i][sm.j-1] = true;
                qu.add(new smoker(sm.i,sm.j - 1,sm.time+1));
            }
            
        }
        
        return ans;
    }
    
    
    public  void addEdge(int source,int desti) {
        adj[source].add(desti);
        adj[desti].add(source);
    }
    
    public  int bfsMinimumFromSourceTodestination(int source,int destination) {
        boolean[] v = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        v[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
            if (cur==destination) {
                break;
            }
            for (int nei : adj[cur] ) {
                if (!v[nei]) {
                    v[nei] = true;
                    queue.add(nei);
                    parent[nei] = cur;
                }
            }
        }
        
               
        int cur = destination;
        int dis = 0;
        
        while (parent[cur] != -1) {
            cur = parent[cur];
            dis++;
        }
        return dis;
    }
    
    
}
