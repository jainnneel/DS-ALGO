package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
static LinkedList<Integer> adj[];
    
    public PossibleBipartition(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    
    public static void main(String[] args) {
        PossibleBipartition bfs  =  new PossibleBipartition(5);
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 4);
        bfs.addEdge(0, 4);
        bfs.addEdge(2, 4);
        int[] stat = new int[adj.length];
        int[] v = new int[adj.length];
        bipartitionPossible(stat);
    
    }
    
//    private static void bipartitionPossible(int[] stat, int i, int[] v) {
//        if (v[i]==0) {
//            v[i] = 1;
//        }
//        for (int j = 0; j < adj[i].size(); j++) {
//            if (v[adj[i].get(j)]!=2) {
//                if (v[adj[i].get(j)]==1) {
//                    v[adj[i].get(j)] = 2;
//                }else {
//                    if (stat[adj[i].get(j)]==0) {
//                        if (stat[i]==1) {
//                            stat[adj[i].get(j)] = 2;
//                        }else {
//                            stat[adj[i].get(j)] = 1;
//                        }
//                    }else if (Math.abs(stat[adj[i].get(j)]-stat[i])!=1) {
//                        return;
//                    }
//                    bipartitionPossible(stat,adj[i].get(j),v);
//                }
//            }
//        }
//        
//    }
    
    private static void bipartitionPossible(int[] stat) {
        
        for (int i = 0; i < adj.length; i++) {
            if (stat[i]==0) {
                if (!isbipartite(i,stat)) {
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println("yes");
        return;
    }


    private static boolean isbipartite(int i, int[] stat) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        stat[i] = 2;
        
        while (!queue.isEmpty()) {
            int cur = queue.peek();
            queue.poll();
            for (Integer integer : adj[cur]) {
                if (stat[integer] == stat[cur]) {
                    return false;
                }
                if (stat[integer]==0) {
                    if (stat[cur]==1) {
                        stat[integer] =  2;
                    }else {
                        stat[integer] = 1;
                    }
                }
                queue.add(integer);
            }
            
        }
         
        return true;
    }


    public  void addEdge(int source,int desti) {
        adj[source].add(desti);
        adj[desti].add(source);
    }
}
