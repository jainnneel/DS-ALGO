package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class StackeImpl {

    static void staclmani(List<String> st){
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        for (String i : st) {
            if (i.split(" ")[0].equals("1")) {
                ans.add(Integer.parseInt(i.split(" ")[1]));
                top++;
            }else if(i.split(" ")[0].equals("2")) {
                ans.remove(top-1);
                top--;
            }else {
                System.out.println(ans.get(top-1));
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        List<String> in = new ArrayList<>();
        
        in.add("1 97");
        in.add("2 ");
        in.add("1 20");
        in.add("2 1");
        in.add("1 26");
        in.add("1 20");
        in.add("2 ");
        in.add("3 ");
        in.add("1 91");
        in.add("3 ");
       
        staclmani(in);
        
    }
}
