package com.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakProblem {

    public static void main(String[] args) {
        String s = "ilikeicecream";
        
        List<String> words = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile",
                "ice","cream", "icecream", "man", "go", "mango");
        
//        findit(s,words);
        String arr[] = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
//        secFrequent(arr,6);
        areIsomorphic("aab","xyz");
    }

    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length()){
            return false;
        }
        java.util.Map<Character,Character> map = new java.util.HashMap<>();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(char i = 0; i < ch1.length; i++){
            char c1 = map.getOrDefault(i,'#');
            if(c1 == '#'){
                map.put(ch1[i],ch2[i]);
            }else{
                if(c1 != ch2[i]){
                    return false;
                }
            }
        }
        return true;
    }
    static String secFrequent(String arr[], int N)
    {
        Map<String,Integer> map = new HashMap<>();
        
        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int max = Integer.MIN_VALUE;
        int min = max;
        Collection<Integer> aList = map.values();
        List<Integer> newaList = new ArrayList<>();
        for(Integer i : aList){
            newaList.add(i);
        }
        Collections.sort(newaList);
        min = newaList.get(newaList.size() - 2);
        
        for(Map.Entry<String,Integer> en : map.entrySet()){
            if(en.getValue() ==  min){
                return en.getKey();
            }
        }
        return "";
        
    }
    
    private static void findit(String s, List<String> words) {
       
        int[] dp = new int[s.length()];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j <= i; j++) {
                
                String word = s.substring(j,i+1);
                
                if(words.contains(word)) {
                    
                    if(j > 0) {
                        dp[i] = dp[i] + dp[j-1];
                    }
                    if(j == 0) {
                        dp[i] = 1;
                    }
                    
                }
                
            }
        }
        
        
        
        System.out.println();
    }
}












