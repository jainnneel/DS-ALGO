package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SpreadInfection {
   
    static LinkedList<Integer> adj[] = null;
    
    public SpreadInfection(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    static void addEdge(int src,int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    
    public static void main(String[] args) {
        SpreadInfection bfs  =  new SpreadInfection(7);
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(2, 3);
        addEdge(1, 2);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(6, 4);
        addEdge(6, 5);
        
        int[] visited = new int[7];
        spreadInfection(visited,0);
    }
    private static void spreadInfection(int[] visited,int src) {
       int time = 0;
       int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(src);
        
        while (queue.size()>0) {
            int ele = queue.poll();
            if (visited[ele]>0) {
                continue;
            }else {
                visited[ele] = time+1;
                count++;
            }
            
            for (Integer integer : adj[ele]) {
                if (visited[integer]==0) {
                    queue.add(integer);
                }
            }
            time++;
        }
        System.out.println(count);
        
    }
    
    
}
