package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class GameOfStack {

    public static void main(String[] args) {
        
        int a[] = {15, 5, 18, 19, 19, 2 ,4 ,17, 7, 16, 14, 5 ,19, 2, 5, 7, 5, 12, 15, 1 ,7 ,8 ,2, 12, 12, 4 ,19, 18, 1 ,11 ,2 ,16, 16, 0 ,7 ,7, 15};
        int b[] = {3, 5, 14, 19, 19, 19, 18, 1 ,16, 17, 6 ,0 ,13, 19, 7 ,1 ,1, 12 ,5, 6, 11, 3 ,19, 14, 5, 7 ,3, 18, 14, 10, 13, 10, 15, 19, 9, 14, 11, 0, 7, 7, 17, 6 ,8 ,10, 5 ,7 ,3 ,7 ,19, 8};
        
        int x = 64;
        
        System.out.println(game(x,a,b));
    }
    
    private static int tvalue(List<Integer> stack) {
        int size = 0;
        for(int i:stack){
            size = size + i;
        }
        return size;
    }
    
    private static int game(int x, int[] a, int[] b) {
        List<Integer> ansL = new ArrayList<>();
        int topA = 0;
        int topB = 0;
        
        while (true) {
            
            if (tvalue(ansL)>x) {
                return ansL.size();
            }
            
            if (topA > a.length && topB > b.length) {
                return ansL.size()-1;
            }
            
            if (topA >= a.length || topB >= b.length) {
                if (topA <= a.length) {
                    ansL.add(a[topA-1]);
                    topA++;
                    continue;
                }else if(topB <= b.length){
                    ansL.add(b[topB-1]);
                    topB++;
                    continue;
                }
            }
            
            if (a[topA] <= a[topB]) {
                ansL.add(a[topA]);
                topA++;
            }else {
                ansL.add(a[topB]);
                topB++;
            }
        }
       
    }
}
