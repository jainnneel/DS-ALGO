package com.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class NetworkConn {

    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,3,2},{1,3,2}};
       new NetworkConn().networkDelayTime(times,4,2);
    }
    
    static class Edge{
        int src;
        int dest;
        int wt;
        
        public Edge(int i,int j,int k){
            src = i;
            dest = j;
            wt = k;
        }
    }
    
    static class Pair{
        int v;
        int wsf;

        public Pair(int v, int wsf) {
            this.v = v;
            this.wsf = wsf;
        }
    }
    
    LinkedList<Edge> adj[] = null;
    
    int ans = Integer.MAX_VALUE;
    
    void addEdge(LinkedList<Edge> adj[],int src,int nbr,int wt) {
        adj[src].add(new Edge(src, nbr, wt));
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        adj = new LinkedList[n];
        
        for (int i = 0; i < n; i++) {
              adj[i] = new LinkedList<>();  
        } 
        
        for(int i = 0; i < times.length; i++){
            addEdge(adj,times[i][0]-1,times[i][1]-1,times[i][2]);
        }
        
        boolean[] v = new boolean[adj.length];
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf);
        
        queue.add(new Pair(k-1,0));
        
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            System.out.println(poll.wsf);
            ans = poll.wsf;
            
            if (v[poll.v]) {
                continue;
            } else {
                v[poll.v] = true;
            }
            
            for(Edge ed : adj[poll.v]){
                if(!v[ed.dest]){
                    queue.add(new Pair(ed.dest,poll.wsf+ed.wt));
                }
            }
        }
        
        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                return -1;
            }
        }
        
        return ans;
    }

}
