package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class Contacts {
    static List<Integer> contacts(String[][] queries) {
        List<String> cn = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
         for(int i = 0;i<queries.length;i++){
             for(int j = 0;j<queries[i].length;j++){
                 if(queries[i][j].trim().equals("add")){
                     cn.add(queries[i][j+1].trim());
                 }else if(queries[i][j].trim().equals("find")){
                     int count = 0;
                     for(String s : cn){
                         if(s.startsWith(queries[i][j+1].trim())){
                            count++; 
                         }
                     }
                     ans.add(count);
                 }
             }
         }
         return ans;

     }
    public static void main(String[] args) {
        String[][] foo = new String[][] {
          new String[] { "add" , "neel jain" },
          new String[] { "add" , "neil jain"},
          new String[] {"find","ne"},
          new String[] {"find","nei"}
      };
      
      
      System.out.println(contacts(foo));
    }
}
