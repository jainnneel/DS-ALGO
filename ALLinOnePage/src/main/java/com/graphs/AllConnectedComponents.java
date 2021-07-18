package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllConnectedComponents {

  static LinkedList<Integer> adj[] = null;
    
    public AllConnectedComponents(int n) {
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
        AllConnectedComponents allParths = new AllConnectedComponents(7);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(3, 4);
        addEdge(5, 6);
        boolean[] visited = new boolean[7];
        getAllConnected(visited);
    }
    
    
    private static void getAllConnected(boolean[] visited) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            List<Integer> one = new ArrayList<>();
            getComponents(i,visited,one);
            if(one.size()>0) lists.add(one);
        }
        return;
    }
    private static void getComponents(int src,boolean[] visited, List<Integer> one) {
        
        if (visited[src]==false) {
            visited[src] = true;
            one.add(src);
            for (Integer n : adj[src]) {
                getComponents(n, visited, one);
            }
        }
        
    }
}












