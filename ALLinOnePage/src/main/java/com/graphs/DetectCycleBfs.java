package com.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DetectCycleBfs {
    static LinkedList<Integer> adj[] = null;

    public DetectCycleBfs(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    static void addEdge(int src,int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
  
//    public static void main(String[] args) {
//        System.out.println("\nSorting using Java8 streams\n");
//         
//        sortByValueJava8Stream();
//    }
 
    private static void sortByValueJava8Stream() 
    {
        Map<String, Integer> unSortedMap = getUnSortedMap();
         
        System.out.println("Unsorted Map : " + unSortedMap);
 
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
         
        System.out.println("Sorted Map   : " + sortedMap);
         
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
         
        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }
 
    private static Map<String, Integer> getUnSortedMap() 
    {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);
        return unsortMap;
    }
    public static void main(String[] args) {
        DetectCycleBfs allParths = new DetectCycleBfs(7);
//        addEdge(0, 1);
//        addEdge(2, 3);
//        addEdge(5, 4);
//        addEdge(5, 6);
//        addEdge(6, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        
        boolean[] visited = new boolean[7];
        
        System.out.println(cycleOrNot(visited));
    
    }
    private static boolean cycleOrNot(boolean[] visited) {
        for (int i = 0; i < 7; i++) {
            if (visited[i]==false && checkCycleOrNot(i,visited)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkCycleOrNot(int i, boolean[] visited) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(i);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
            if (visited[cur]) {
                return true;
            }else {
                visited[cur] = true; 
            }
                for (Integer integer : adj[cur]) {
                      if (visited[integer]==false) {
                          queue.add(integer);
                    }
                }
        }
        return false;
    }
}













