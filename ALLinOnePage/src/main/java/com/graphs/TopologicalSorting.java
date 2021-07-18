package com.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

 static LinkedList<Integer> adj[];
    
    public TopologicalSorting(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    
    public static void main(String[] args) {
        TopologicalSorting bfs  =  new TopologicalSorting(6);
//        bfs.addEdge(0, 2);
//        bfs.addEdge(0, 3);
//        bfs.addEdge(3, 1);
//        bfs.addEdge(5, 0);
//        bfs.addEdge(5, 2);
//        bfs.addEdge(4, 2);
//        bfs.addEdge(4, 1);
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 3);
        bfs.topological();
    }

    private void topological() {
        boolean[] v = new boolean[adj.length];
        if (detectcycle(v,0)) {
            System.out.println("not pos");
            return;
        }
        
        v = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < adj.length; i++) {
            if (!v[i]) {
                topologicalUtil(v,stack,i);
            }
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop()+"-->");
        }
    }


    private void topologicalUtil(boolean[] v, Stack<Integer> stack, int i) {
        
        v[i] = true;
        
        for (int j = 0; j < adj[i].size(); j++) {
            if (!v[adj[i].get(j)]) {
                topologicalUtil(v, stack,adj[i].get(j));
            }
        }
        stack.add(i);
    }


    private void topologicalUtil(boolean[] v, Integer i) {
        if (v[i]) {
            return;
        }
        v[i] = true;
        for (int j = 0; j < adj[i].size(); j++) {
            topologicalUtil(v,adj[i].get(j));
        }
        return;
    }

    private static boolean detectcycle(boolean[] v,int main) {
      boolean flag = false;
      
      for (int i = 0; i < adj.length; i++) {
          v[i] = true;
              for (int j = 0; j < adj[i].size(); j++) {
                   flag = detectUtil(adj,v,adj[i].get(j));
                   if (flag) {
                      System.out.println("yes");
                      return true;
                  }
                   v[adj[i].get(j)] =false;
              }
              v[i] = false;
      }
      return false;
      
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
    
    public  void addEdge(int source,int desti) {
        adj[source].add(desti);
    }
    
}
