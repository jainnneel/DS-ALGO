package com.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrintAllParths {

    static LinkedList<Integer> adj[] = null;
    
    public PrintAllParths(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    static int sw  = Integer.MAX_VALUE;
    static int lw = Integer.MIN_VALUE;
    static int kthLw = Integer.MIN_VALUE;
    static PriorityQueue<Integer> queue = new PriorityQueue<>(3);
    public static void main(String[] args) {
        PrintAllParths allParths = new PrintAllParths(5);
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(3, 4);
        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(4, 2);
        boolean[] visited = new boolean[5];
        printpath(0,2,visited,0+"",0);
        System.out.println(sw +" "+lw+" "+queue.peek());
    }
    
 
    
    private static void printpath(int src, int dest,boolean[] visited,String path,int cval) {
        if (src==dest) {
            System.out.println(path);
            
            if (cval < sw) {
                sw = cval;
            }
            if (cval > lw) {
                lw = cval;
            }
            queue.add(cval);
            if (queue.size()>2) {
                queue.poll();
            }
            return;
        }
        
        visited[src] = true;
        for (int b : adj[src]) {
            if (visited[b]==false) {
                printpath(b, dest, visited, path+" "+b,cval+1);
            }
        }
        visited[src] = false;
        
    }

    static void addEdge(int src,int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
  
}
