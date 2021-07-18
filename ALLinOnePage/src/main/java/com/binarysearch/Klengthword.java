package com.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class Klengthword {

    public static void main(String[] args) {
        printit("abcabc",2);
    }

    private static void printit(String string, int i) {
        
        Set<Character> set = new HashSet<>();
        String unique = "";
        
        for (char ch : string.toCharArray()) {
            if (set.add(ch)) {
                unique = unique + ch;
            }
        }
        
        print(unique,i,"",0,unique.length(),0,0);
        
    }

    private static void print(String unique, int k, String out, int i, int length, int in,int start) {
       if (i== k) {
            System.out.println(out);
            return;
       }
       if (in >= length) {
           return;
       }
       
       for (int j = 0; j < unique.length(); j++) {
           print(unique.substring(j+1), k, out + unique.charAt(j), i+1, length, in+1,j+1);
       }
        
    }
    
    
}
