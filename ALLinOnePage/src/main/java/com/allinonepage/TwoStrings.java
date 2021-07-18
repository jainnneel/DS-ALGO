package com.allinonepage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoStrings {

    public static void main(String[] args) {
//        checksub("neel","kamal");
        int a[] = {7,2,5,3,5,3};
        int b[] = {7,2,5,4,6,3,5,3};
        
        missingNumber(a,b);
    }

    private static void missingNumber(int[] a, int[] b) {
        int[] o = new int[10001];
        List<Integer> ansl = new ArrayList<>();
       
        for (int i = 0; i < b.length; i++) {
            o[b[i]]++;
        }
        for (int i = 0; i < a.length; i++) {
            o[a[i]]--;
        }
        for (int i = 0;i < o.length; i++) {
            if (o[i]>0) {
                ansl.add(i);
            }
        }
        int ans[] = new int[ansl.size()];
        for (int i = 0; i < ansl.size(); i++) {
            ans[i] = ansl.get(i);
        }
        
    }

    private static void checksub(String string, String string2) {
        
        Set<Character> characters = new HashSet<>();
        
        for (int i = 0; i < string.length(); i++) {
            characters.add(string.charAt(i));
        }
        for (int i = 0; i < string2.length(); i++) {
            if (characters.contains(string2.charAt(i))) {
                System.out.println("YES");
            }
        }
    }
}
