package com.allinonepage;

public class pattern {

    static void patterns(String in) {
        int length = in.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i==j) {
                    if (i==(length+1/2) && j==(length+1/2) ) {
                        System.out.println(in.charAt((length/2)+1));
                    }else {
                        System.out.print(in.charAt(i));
                    }
                }else if (j == length - i - 1) {
                    System.out.print(in.charAt(length-i-1));
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        
    }
    
    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
//        patterns("neelmjain");
        pattern2(8);
//        pattern3(5);
    }
}
