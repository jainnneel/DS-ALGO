package com.graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class HamitonianCycle {
    static LinkedList<Integer> adj[] = null;
    
    public HamitonianCycle(int n) {
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
        HamitonianCycle allParths = new HamitonianCycle(6);
        addEdge(0, 1);
        addEdge(0, 5);
        addEdge(3, 5);
        addEdge(5, 4);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 4);
        HashSet<Integer> visited = new HashSet<>();
        cyleOrNot(visited,0,0+"",0);
    }
    
    private static void cyleOrNot(HashSet<Integer> visited,int src,String path,int origin) {
        
        if (visited.size()==adj.length-1) {
            for (Integer integer : adj[src]) {
                if (integer==origin) {
                    System.out.println(path);
                }
            }
        }

        visited.add(src);
        
        for (Integer integer : adj[src]) {
            if (!visited.contains(integer)) {
                cyleOrNot(visited, integer, path+" "+integer,origin);
            }
        }
        visited.remove(src);
    }
}
