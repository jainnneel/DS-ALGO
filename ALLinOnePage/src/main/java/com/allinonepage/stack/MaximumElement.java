package com.allinonepage.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {
        
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Stack<Integer> main = new Stack<>();
//        Stack<Integer> ss = new Stack<>();
//        
//        for (int i = 0; i < n; i++) {
//            int op = scanner.nextInt();
//            if (op==1) {
//                int nextInt = scanner.nextInt();
//                main.push(nextInt);
//                if (!ss.isEmpty()) {
//                    if(ss.peek()<nextInt) ss.push(nextInt);
//                }else {
//                    ss.push(nextInt);
//                }
//            }else if (op==2) {
//                if (!main.isEmpty()) {
//                    int ele = main.pop();
//                    if (ele == ss.peek()) {
//                        ss.pop();
//                    }
//                }
//            }else {
//                System.out.println(ss.peek());
//            }
//        }
//        
//        scanner.close();
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        Stack<Integer> maxValues = new Stack<Integer>();
        
        while(queries-- > 0) {
         switch(in.nextInt()) {
          case 1 : int item = in.nextInt();
                   if (!maxValues.isEmpty()) {
                     item = item > maxValues.peek() ? item : maxValues.peek();
                   }
               maxValues.push(item);
                   break;
          case 2 : maxValues.pop();
                   break;
          case 3 : System.out.println(maxValues.peek());
                   break;
     }
        }
        
        in.close();
    }
}
