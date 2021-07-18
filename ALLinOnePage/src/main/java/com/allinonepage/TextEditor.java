package com.allinonepage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TextEditor {

    static void stringMani(List<String> in) {
       
       List<Character> list = new ArrayList<>();
       Stack<Integer> ostack = new Stack<>();
       List<Character> reval = new ArrayList<>();
        for (String inp : in) {
            if (inp.split(" ")[0].equals("1")) {
                ostack.push(in.indexOf(inp));
                for (char i = 0; i < inp.split(" ")[1].length(); i++) {
                    list.add(inp.split(" ")[1].charAt(i));
               }
            }else if (inp.split(" ")[0].equals("2")) {
                if (list.size()==0) {
                    System.out.println("empty");
                }else {  
                ostack.push(in.indexOf(inp));
                for (int i = 0; i < Integer.parseInt(inp.split(" ")[1]); i++) {
                     
                    reval.add(list.remove(list.size()-1));
                    }
                   }
            }else if (inp.split(" ")[0].equals("3")) {
                if (list.size()==0) {
                    System.out.println("empty");
                }else {
                    System.out.println(list.get(Integer.parseInt(inp.split(" ")[1])-1));
                }
            }else if (inp.split(" ")[0].equals("4")) {
                String uin = in.get(ostack.pop());
                if (uin.split(" ")[0].equals("1")) {
                    for (int i = 0; i < uin.split(" ")[1].length(); i++) {
                        list.remove(list.indexOf(uin.split(" ")[1].charAt(i)));
                    }
                }else if (uin.split(" ")[0].equals("2")) {
                    for (int i = 0; i < Integer.parseInt(uin.split(" ")[1]); i++) {
                        list.add(reval.remove(reval.size()-1));
                    }
                } 
            }
        }
    }
    
    public static void main(String[] args) {
     List<String> in = new ArrayList<>();
        
        in.add("1 abc");
        in.add("3 3");
        in.add("4 ");
        in.add("2 3");
        in.add("1 xy");
        in.add("3 3");
        in.add("1 abcnee");
        in.add("3 3");
        in.add("4 ");
        in.add("3 1");
        in.add("1 abc");
        in.add("2 3");
        in.add("1 sss");
        in.add("3 1");
        stringMani(in);
    }
}
