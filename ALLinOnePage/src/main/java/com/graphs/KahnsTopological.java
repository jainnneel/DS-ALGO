package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KahnsTopological {

static LinkedList<Integer> adj[];
    
    public KahnsTopological(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public static void main(String[] args) {
        KahnsTopological bfs  =  new KahnsTopological(6);
        bfs.addEdge(5, 0);
        bfs.addEdge(5, 3);
        bfs.addEdge(3, 2);
        bfs.addEdge(3, 0);
        bfs.addEdge(2, 1);
        bfs.addEdge(4, 0);
        bfs.addEdge(4, 1);
        
        bfs.topological();
    }
    
    private void topological() {
        int[] indegree = new int[adj.length];
        boolean[] v = new boolean[adj.length]; 
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                indegree[adj[i].get(j)] =  indegree[adj[i].get(j)]+ 1;
            }
        }
        int count  = 0;
        Queue<Integer> queue = new LinkedList<>();
        pushQueue(indegree,queue,v);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
                for (int j = 0; j < adj[cur].size(); j++) {
                    indegree[adj[cur].get(j)] =  indegree[adj[cur].get(j)] -  1;
                }
                count  = count+1;
                pushQueue(indegree,queue,v);
        }
    }

    private void pushQueue(int[]  in, Queue<Integer> queue,boolean[] v) {
        for (int i = 0; i < in.length; i++) {
            if (in[i]==0) {
                if (!v[i]) {
                    v[i] = true;
                    queue.add(i);
                }
            }
        }
    }


    public  void addEdge(int source,int desti) {
        adj[source].add(desti);
    }
}
