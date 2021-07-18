package com.graphs;

import java.util.LinkedList;

public class DetectCycle {

    static LinkedList<Integer> adj[];

    public DetectCycle(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public static void main(String[] args) {
        DetectCycle bfs  =  new DetectCycle(5);
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(0, 3);
        bfs.addEdge(0, 4);
        bfs.addEdge(4, 3);
        boolean[] v = new boolean[adj.length];
//        detectcycle(v,0);
        int[] stat = new int[adj.length];
        detectcycleinundirectedgrapgh(stat, 0);
        
    }

    private static void detectcycleinundirectedgrapgh(int[] stat, int main) {
        
        boolean flag = false;
        for (int i = 0; i < adj.length; i++) {
            stat[i] = 1;
                for (int j = 0; j < stat.length; j++) {
                    flag = detectUnUtil(adj,stat,adj[i].get(j));
                    if (flag) {
                        System.out.println("yes");
                        return;
                    }
                }
                stat[i] = 0;
        }
    }

    private static boolean detectUnUtil(LinkedList<Integer>[] adj2, int[] stat, Integer integer) {
        
        if (stat[integer] == 2) {
            return true;
        }
        if (stat[integer]==1) {
            stat[integer] = 2;
        }
        if (stat[integer]==0) {
            stat[integer] = 1;
        }
        boolean flag  =false;
        for (int i = 0; i < adj[integer].size(); i++) {
            if (stat[adj[integer].get(i)]==1) {
                stat[adj[integer].get(i)]=2;
            }else {
                flag = detectUnUtil(adj2, stat, adj[integer].get(i));
                stat[integer]--;
            }  
           if (flag) {
               return true;
           }
            
        }
        if (stat[integer]==1 || stat[integer]==2) {
            stat[integer] = 0;
        }
        return false;
    }

    private static void detectcycle(boolean[] v,int main) {
        
//        if (main==adj.length) {
//            return;
//        }
//        if (adj[main].size()==0) {
//            v[main] = false;
//            return;
//        }
//        if (v[main]==true) {
//            return;
//        }
//        v[main] = true;
//          for (int nei : adj[main]) {
//               if (!v[nei]) {
//                   v[nei] = true;
//                   System.out.println(nei);
//                   detectcycle(v,nei);
//               }
//          }
//          v =new boolean[adj.length];
//          detectcycle(v,main+1);
        boolean flag = false;
        
        for (int i = 0; i < adj.length; i++) {
            v[i] = true;
                for (int j = 0; j < adj[i].size(); j++) {
                     flag = detectUtil(adj,v,adj[i].get(j));
                     if (flag) {
                        System.out.println("yes");
                        return;
                    }
                     v[adj[i].get(j)] =false;
                }
                v[i] = false;
        }
        
        
    }

    private static boolean detectUtil(LinkedList<Integer>[] adj2, boolean[] v, Integer integer) {
        
        if (v[integer]==true) {
            return true;
        }
        boolean flag = false;
            v[integer] = true;
                for (int j = 0; j < adj[integer].size(); j++) {
                     flag = detectUtil(adj,v,adj[integer].get(j));
                     if (flag) {
                        return true;
                    }
                }
        v[integer] = false;
        return false;
    }

    public  void addEdgeDirected(int source,int desti) {
        adj[source].add(desti);
    }
    public void addEdge(int source,int desti) {
        adj[source].add(desti);
        adj[desti].add(source);
    }
    
}
