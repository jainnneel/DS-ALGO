package com.dynamicprograming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CostMinimum {

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};
//        mincostTickets(days,cost);
        countSubstrings("aba");
    }
    
    public static int countSubstrings(String s) {
        int ans = 0;
        boolean[][] mat = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            mat[i][i] = true;
            ans++;
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                mat[i][i+1] = true;
                ans++;
             }
        }
        for(int i = 3; i <= s.length(); i++){
            int st = 0;
           for(int j = st + i - 1;j<s.length();j++,st++)
                if(s.charAt(st) == s.charAt(j) && mat[st][j-1]){
                    mat[st][j] = true;
                    ans++;
                }
        }
        
        return ans;
    }
    
    public static int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[366];
        Arrays.fill(memo, -1);
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : days){
            set.add(i);
        }
        
        return dp(1,memo,set,costs);
    }
    
    public static int dp(int i,int[] memo,Set<Integer> set,int[] costs){
        if(i > 365){
            return 0;
        }
        
        if(memo[i] != -1){
            return memo[i];
        }
        
        int ans;
        
        if(set.contains(i)){
            ans = Math.min(dp(i+1,memo,set,costs) + costs[0],dp(i + 7,memo,set,costs) + costs[1]);
            ans = Math.min(ans ,dp(i + 30,memo,set,costs) + costs[2]);
        }else{
            ans = dp(i+1,memo,set,costs);
        }
        
        return memo[i] = ans;
        
    }
}

