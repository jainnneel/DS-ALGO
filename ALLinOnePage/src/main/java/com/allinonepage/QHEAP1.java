package com.allinonepage;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHEAP1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            if (op==1) {
               int ele =  scanner.nextInt();
               priorityQueue.add(ele);    
            }else if(op==2) {
                priorityQueue.remove((Object)scanner.nextInt());
            }else {
                System.out.println(priorityQueue.peek());
            }
        }
        scanner.close();
    }
}
