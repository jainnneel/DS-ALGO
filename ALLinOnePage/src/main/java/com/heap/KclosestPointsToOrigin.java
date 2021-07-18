package com.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {

    static class pair implements Comparable<pair> {
        int key;
        int value;
        pair p;
        
        public pair(int key,int value) {
            this.key = key;
            this.value = value;
        } 
        
        public pair(int value, pair p) {
            super();
            this.value = value;
            this.p = p;
        }

        @Override
        public int compareTo(pair o) {
            if (this.value>o.value) {
                return 1;
            }else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "pair [key=" + key + ", value=" + value + ", p=" + p + "]";
        }
        
    }
    
    public static void main(String[] args) {
        List<pair> list = new ArrayList<>();
        list.add(new pair(1,3));
        list.add(new pair(-2,2));
        list.add(new pair(5,8));
        list.add(new pair(0,1));
        KclosestPointsToOrigins(list);
    }

    private static void KclosestPointsToOrigins(List<pair> list) {
        
        int k  = 2 ;
        
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>();
        
        for (pair object : list) {
            int a = (int) Math.pow(Math.pow(object.key,2)+Math.pow(object.value,2), 0.5);
            priorityQueue.add(new pair(a,object));

            if (priorityQueue.size()>k) {
                pair p  = priorityQueue.poll();
                System.out.println(p.p.key+" "+ p.p.value);
            }
        }
    
    }
}
