package com.allinonepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Maxtip {

    public static void main(String[] args) {
       int a[] = {1, 2, 3, 4, 5};
       int b[] = {5, 4, 3, 2, 1};
        maxTip(a,b,5,3,3);
    }
    
    static long maxTip(int[] a, int[] b, int n, int x, int y) {
        int an = 0;
         long max = 0;
        int rh = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n ; i++){
            map.put(i,Math.abs(a[i]-b[i]));
        }
        LinkedHashMap<Integer,Integer> sorted = new LinkedHashMap<>();
       
        List<Map.Entry<Integer,Integer>> li = new ArrayList<>(map.entrySet());
        
        Collections.sort(li , new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(Map.Entry<Integer,Integer> e : li){
            sorted.put(e.getKey(),e.getValue());
        }
        
         for(Map.Entry<Integer,Integer> e : sorted.entrySet()){
            if(an<x){
                if(a[e.getKey()] >= b[e.getKey()]) {
                    max = max + a[e.getKey()];
                    an++;
                }else if(rh<y) {
                    max = max + b[e.getKey()];
                    rh++;
                }else {
                    max = max + a[e.getKey()];
                    an++;
               }
            }else{
                max = max + b[e.getKey()];
                rh++;
            }
            
        }
        
        return max;
     }
}
