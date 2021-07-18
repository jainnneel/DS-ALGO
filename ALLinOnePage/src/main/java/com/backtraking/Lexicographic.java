package com.backtraking;

public class Lexicographic {

    public static void main(String[] args) {
        printit(1,1000);
    }

    private static void printit(int i, int n) {
       
        if( i > n ) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            printit(10 * i + j, n);
        }
        
    }

}
