package com.dynamicprograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

    public static void main(String[] args) {
        
        String s = "rcbyndyxxrcbyndyxx";
        String[] st = {"rcbyn","dy","rcbyndy","xx","lorel"};
        Map<String,List<String>> ans = new HashMap<>();
        wordbreak(s,st,ans,s.length(),"");
        System.out.println();
    }

    private static String wordbreak(String s, String[] st,Map<String,List<String>> ans,int n,String starts) {
        
        if (s == "") {
            return "";
        }
        
        for (int i = 0; i < st.length;i++) {
            String anss = "";
            String start = starts;
            if ( s.startsWith(st[i]) ) {
                if(s.length() == n) {
                    start = st[i];
                }
                anss = anss + st[i];
                List<String> sttList =  ans.getOrDefault(start,null);
                if(sttList!=null) {
                    sttList.add(anss);
                    ans.put(start, sttList);
                }else {
                    List<String> nn = new ArrayList<>();
                    nn.add(anss);
                    ans.put(start, nn);
                }
                wordbreak(s.substring(st[i].length()),st,ans,n,start);
            }
        }
        return "";
    }
    
    
    
}
