package com.dynamicprograming;

import java.util.Arrays;

public class MaxChain {

    public static void main(String[] args) {
        
        int[][] pairs = {{1,2},{1,3},{3,20},{21,22},{21,28},{23,25},{25,29}};
//        findLongestChain(pairs);
        String[] str = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        longestStrChain(str);
    
    }
    
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(s1,s2) -> s1.length() - s2.length() != 0 ? s1.length() - s2.length() : s1.compareTo(s2));
        int arr[] = new int[n];
        Arrays.fill(arr,1);
        int ans = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(Math.abs(words[j].length() - words[i].length()) == 1 &&                                                              isSubSeq(words[j],words[i]))
                {
                       arr[i] = Math.max(arr[i],1 + arr[j]);     
                }
            }  
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
    
    static boolean isSubSeq(String s1, String s2){
        int i = 0;
        int j = 0;
        
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        if(i != s1.length()){
            return false;
        }else{
            return true;
        }
        
    }
    
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(num1,num2)->Integer.compare(num1[1],num2[1]));
        int ans = 1;
        int curr = pairs[0][1];
        for(int i = 0; i < pairs.length - 1; i++){
            if(curr < pairs[i+1][0]){
                System.out.println(pairs[i][1] +" " + pairs[i+1][0]);
                curr = pairs[i+1][1];
                ans++;
            }
        }
        return ans;
    }
}
