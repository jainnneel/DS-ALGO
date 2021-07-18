package com.allinonepage;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Qheap {
    
    static int qHeapmani(List<Integer> in,int k) {
        
        Queue<Integer> queue = new PriorityQueue<>();
        int count = 0 ;
//        for (String str : in) {
//                
//            if (str.split(" ")[0].equals("1")) {
//                queue.add(Integer.parseInt(str.split(" ")[1]));
//            }else if (str.split(" ")[0].equals("2")) {
//                queue.remove(Integer.parseInt(str.split(" ")[1]));
//            }else {
//                System.out.println(queue.peek());
//            }
//            
//        }
        for (int val : in) {
            queue.add(val);
        }
        
        while (queue.peek()<k) {
            if (queue.size()==1) {
                return -1;
            }
            int sw = (1*queue.remove())+(2*queue.remove());
            queue.add(sw);
            count++;
        }
        
        
        return count;
    }
    
    public static void main(String[] args) {
     List<Integer> in = new ArrayList<>();
       
     in.add(1);
     in.add(2);
     in.add(3);
     in.add(9);
     in.add(10);
     in.add(12);
//        in.add("1 4");
//        in.add("1 9");
//        in.add("3 ");
//        in.add("2 4");
//        in.add("3 ");
//        qHeapmani(in);
        
     System.out.println(qHeapmani(in,8467293));
    }
}
