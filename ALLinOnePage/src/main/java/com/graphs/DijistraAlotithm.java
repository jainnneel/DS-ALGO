package com.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijistraAlotithm {

    static class Pair {
        int v;
        String psf;
        int wsf;

        public Pair(int v, String string, int wsf) {
            super();
            this.v = v;
            this.psf = string;
            this.wsf = wsf;
        }
    }

    static class Edge {
        int i;
        int j;
        int wt;

        public Edge(int i, int j, int wt) {
            super();
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
    }

    LinkedList<Edge> adj[] = null;

    public DijistraAlotithm(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        DijistraAlotithm alotithm = new DijistraAlotithm(5);
//        alotithm.addEdge(0, 1, 10);
//        alotithm.addEdge(0, 3, 40);
//        alotithm.addEdge(1, 2, 10);
//        alotithm.addEdge(3, 2, 10);
//        alotithm.addEdge(3, 4, 2);
//        alotithm.addEdge(4, 5, 3);
//        alotithm.addEdge(5, 6, 4);
//        alotithm.addEdge(4, 6, 8);

//        alotithm.dijistra(alotithm.adj);

        alotithm.addEdge(0, 1, 100);
        alotithm.addEdge(0, 3, 300);
        alotithm.addEdge(1, 3, 100);
        alotithm.addEdge(2, 4, 10);
        alotithm.addEdge(3, 2, 10);
        alotithm.addEdge(4, 1, 100);

        alotithm.dfsAndpruning(alotithm.adj);
    }

    private void dfsAndpruning(LinkedList<Edge>[] adj) {

        boolean[] v = new boolean[adj.length];

        int src = 0;
        int dest = 4;
        v[src] = true;
        findMinCost(adj, v, src, dest, 0, 3);

    }

    static int ans = Integer.MAX_VALUE;

    private void findMinCost(LinkedList<Edge>[] adj, boolean[] v, int src, int dest, int cost, int k) {

        if (src == dest) {
            System.out.println(cost);
            ans = Math.min(ans, cost);
            return;
        }

        if (k == 0) {
            return;
        }

        v[src] = true;

        for (Edge ele : adj[src]) {
            if (!v[ele.j]) {
                v[ele.j] = true;
                if (ele.wt + cost <= ans) {
                    findMinCost(adj, v, ele.j, dest, ele.wt + cost, k - 1);
                }
                v[ele.j] = false;
            }
        }
    }

    private void dijistra(LinkedList<Edge>[] adj) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf);

        queue.add(new Pair(0, 0 + " ", 0));
        boolean[] v = new boolean[adj.length];

        while (!queue.isEmpty()) {

            Pair rm = queue.poll();

            if (v[rm.v]) {
                continue;
            } else {
                v[rm.v] = true;
            }

            System.out.println(rm.v);

            for (Edge ele : adj[rm.v]) {
                if (!v[ele.j]) {
                    queue.add(new Pair(ele.j, rm.psf + " " + ele.j, rm.wsf + ele.wt));
                }
            }
        }
    }

    private void addEdge(int src, int nbr, int wt) {
        this.adj[src].add(new Edge(src, nbr, wt));
//        this.adj[nbr].add(new Edge(nbr, src, wt));
    }
}
