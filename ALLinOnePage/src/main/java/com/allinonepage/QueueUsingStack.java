package com.allinonepage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {

    static void queueStack(List<String> in) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        for (String inp : in) {
            if (inp.split(" ")[0].equals("1")) {
                
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
               
                s1.push(Integer.parseInt(inp.split(" ")[1]));
                
                while (!s2.empty()) {
                    s1.push(s2.pop());
                }
            }else if(inp.split(" ")[0].equals("2")) {
                
                if (!s1.empty()) {
                    s1.pop();
                }else {
                    System.out.println("for pop queue is empty");
                }
            }else {
               
                System.out.println(s1.peek());
            }
        }
        
    }
    
    
    public static void main(String[] args) {
 List<String> in = new ArrayList<>();
        
        in.add("1 42");
        in.add("2 ");
        in.add("1 14");
        in.add("3 ");
        in.add("1 28");
        in.add("3 ");
        in.add("1 60");
        in.add("1 78");
        in.add("2 ");
        in.add("2 ");
       
//        queueStack(in);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> s1 = new Stack<>();
          Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
          int op = scanner.nextInt();
          
             if (op==1) {
                 int value = scanner.nextInt();
                  s1.push(value);
              }else if(op==2) {
                  if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                  if (!s2.isEmpty()) {
                    s2.pop();
                }
              }else {
                  if (s2.isEmpty()) {
                      while (!s1.isEmpty()) {
                          s2.push(s1.pop());
                      }
                      System.out.println(s2.peek());
                  }else {
                      System.out.println(s2.peek());
                  }
              }
      }
      scanner.close();       
      }
    
}

