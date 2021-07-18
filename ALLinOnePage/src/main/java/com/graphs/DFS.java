package com.graphs;

import java.util.LinkedList;

public class DFS {
    static LinkedList<Integer> adj[];

    public DFS(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    
    public static void main(String[] args) {
        DFS dfs  =  new DFS(6);
//        dfs.addEdge(0, 1);
//        dfs.addEdge(2, 2);
//        dfs.addEdge(1, 3);
//        dfs.addEdge(3, 4);
//        dfs.addEdge(0, 4);
//        dfs.addEdge(1, 4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 5);
        dfs.addEdge(2, 5);
        dfs.addEdge(2, 4);
        dfs.addEdge(3, 4);
        boolean[] v = new boolean[adj.length];
//        System.out.println(dfs.possiblepath(2,3,v));
        System.out.println(0+1);
        v[0] =true;
        DfsTra(v,0);
        
    }
    private boolean possiblepath(int i, int j, boolean[] v) {
        if (i==j) {
            return true;
        }
        
        for (int nei:adj[i]) {
            if (!v[nei]) {
                v[nei] = true;
                return possiblepath(nei, j, v);
            }
        }
        
        return false;
    }

    private static void DfsTra(boolean[] v,int src) {
        for (int i : adj[src]) {
            if (!v[i]) {
                System.out.println(i+1);
                v[i] = true;
                DfsTra(v, i);
            }
        }
        
    }

    public  void addEdge(int source,int desti) {
        adj[source].add(desti);
        adj[desti].add(source);
    }
}
