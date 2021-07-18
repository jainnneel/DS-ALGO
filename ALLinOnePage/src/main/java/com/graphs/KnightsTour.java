package com.graphs;

import java.util.LinkedList;

public class KnightsTour {

  static LinkedList<Integer> adj[] = null;
    
    public KnightsTour(int n) {
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
        int[][] arr = new int[5][5];
        printTour(arr,2,2,1);
    
    }
    private static void printTour(int[][] arr,int r,int c,int move) {
      if (r<0 || c<0 || r>=arr.length || c>=arr.length || arr[r][c]>0) {
        return;
      }else if(move==arr.length*arr.length) {
          arr[r][c] = move;
          for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i][j]);
            }
        }
         arr[r][c] = 0; 
      }
        
        arr[r][c] = move;
        printTour(arr, r-2, c+1, move);
        printTour(arr, r-1, c+2, move);
        printTour(arr, r+1, c+2, move);
        printTour(arr, r+2, c+1, move);
        printTour(arr, r+2, c-1, move);
        printTour(arr, r+1, c-2, move);
        printTour(arr, r-1, c-2, move);
        printTour(arr, r-2, c-1, move);
        arr[r][c] = 0;
    }
}








