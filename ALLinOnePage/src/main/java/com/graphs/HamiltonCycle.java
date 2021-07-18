package com.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HamiltonCycle {

    LinkedList<Integer> adj[] = null;
    
    public HamiltonCycle(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
              adj[i] = new LinkedList<>();  
        }
    }
    
    public static void main(String[] args) {
        HamiltonCycle cycle= new HamiltonCycle(7);
        cycle.addEdge(0,1);
        cycle.addEdge(1,2);
        cycle.addEdge(0,3);
        cycle.addEdge(2,3);
        cycle.addEdge(3,4);
        cycle.addEdge(2,5);
        cycle.addEdge(4,5);
        cycle.addEdge(4,6);
        cycle.addEdge(5,6);
//        printHamilTonPathAndCycle(cycle.adj);
//        printBFS(cycle.adj);
//        HamiltonCycle bfs= new HamiltonCycle(4);
//        bfs.addEdge(0, 1);
//        bfs.addEdge(1, 2);
//        bfs.addEdge(0, 2);
//        bfs.addEdge(1, 3);
//        bfs.addEdge(2, 3);
//        bfs.topological(bfs.adj);
        
//        cycle.topological(cycle.adj);
        
        cycle.iterativeDfs(cycle.adj);
    }

    
    private void iterativeDfs(LinkedList<Integer>[] adj) {
        
        Stack<Integer> st = new Stack<>();
        boolean[] v = new boolean[adj.length];
        st.push(0);
        
        while (!st.isEmpty()) {
            
            int poll = st.pop();
            
            if (v[poll]) {
                continue;
            }else {
                v[poll] = true;
            }
            
            System.out.println(poll);
            
            for (Integer i : adj[poll]) {
                if (!v[i]) {
                    st.add(i);
                }
            }
        }
    }

    private void topological(LinkedList<Integer>[] adj) {
        
        Stack<Integer> integers = new Stack<>();
        
        boolean[] visited = new boolean[adj.length];
        
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                findTopo(adj,integers,visited,i);
            }
        }
        System.out.println();
    }
    
    private void findTopo(LinkedList<Integer>[] adj, Stack<Integer> st, boolean[] v,int src) {
        
        for (Integer ele : adj[src]) {
            if (!v[ele]) {
                v[ele] = true;
                findTopo(adj, st, v, ele);
            }
        }
        st.add(src);

    }

    
    private static void printBFS(LinkedList<Integer>[] adj) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] v = new boolean[adj.length];
        int src = 0;
        queue.add(src);
        
        while (!queue.isEmpty()) {
            
            int ele = queue.poll();
            
            if (v[ele] == true) {
                continue;
            }
            
            v[ele] = true;
            
            System.out.println(ele);
            
            for (Integer e : adj[ele]) {
                if (!v[e]) {
                    queue.add(e);
                }
            }
        }
        
    }

    private static void printHamilTonPathAndCycle(LinkedList<Integer>[] adj) {
        
        boolean[] v = new boolean[adj.length];
        int src  = 0;
        
        v[src] = true;
        
        findPath(adj,src,v,src,src+" ");
        
    }

    private static void findPath(LinkedList<Integer>[] adj, int src, boolean[] v,int curr,String psf) {
       
        if (allVisited(v)) {
            if (currIsNbr(adj,src,curr)) {
                System.out.println(psf + "******");
            }else {
                System.out.println(psf + "#######");
            }
            return;
        }
        
        for (Integer ele : adj[curr]) {
            if (!v[ele]) {
                v[ele] = true;
                findPath(adj, src, v, ele, psf +" "+ele);
                v[ele] = false;
            }
        }
        
    }

    private static boolean currIsNbr(LinkedList<Integer>[] adj ,int src,int curr) {
        for (Integer ele : adj[curr]) {
             if (ele == src) {
                return true;
            }
        }
        return false;
    }

    private static boolean allVisited(boolean[] v) {
        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                return false;
            }
        }
        return true;
    }

    private void addEdge(int i, int j) {
        this.adj[i].add(j);
        this.adj[j].add(i);
    }
    
}
























