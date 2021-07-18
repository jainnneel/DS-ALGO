package com.allinonepage;

public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {

        if (x1>x2 && v1>v2) {
            return "NO";
        }
        if (x2>x1 && v2>v1) {
            return "NO";
        }
        if (x1>x2) {
            while (true) {
                if (x1 == x2) {
                    return "YES";
                }
                
                if (x1<x2) {
                    return "NO";
                }
                
                x1 = v1 + x1;
                x2 = v2 + x2;
            }
        }else {
            while (true) {
                if (x1 == x2) {
                    return "YES";
                }
                
                if (x1>x2) {
                    return "NO";
                }
                
                x1 = v1 + x1;
                x2 = v2 + x2;
            }
        }
        
    }
    public static void main(String[] args) {
        kangaroo(0, 3, 4, 2);
    }
}
