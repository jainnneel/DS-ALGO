package com.allinonepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class medianUpdate {

    static void medianUpdates(List<String> map) {
        List<Integer> val = new ArrayList<>();
        for (String ch : map) {
            if (ch.split(" ")[0].equalsIgnoreCase("a")) {
                val.add(Integer.parseInt(ch.split(" ")[1]));
            }else {
                if (val.size()==0) {
                    System.out.println("wrong");
                    continue;
                }else {
                    val.remove(val.lastIndexOf(Integer.parseInt(ch.split(" ")[1])));
                }
            }
            
            printMedian(val);
        }
    }
    
    private static void printMedian(List<Integer> val) {
        
        Collections.sort(val);
        
        if (val.size()==0) {
            System.out.println("wrong");
            return;
        }
        if (val.size()%2==0) {
            System.out.println((float)(val.get((val.size()/2)-1) + val.get(val.size()/2))/2);
        }else {
            System.out.println(val.get((val.size())/2));
        }
    }

    public static void main(String[] args) {
        
        List<String> in = new ArrayList<>();
        
        in.add("r 1");
        in.add("a 1");
        in.add("a 2");
        in.add("a 1");
        in.add("r 1");
        in.add("r 2");
        in.add("r 1");
        
        medianUpdates(in);
        
    }
}
