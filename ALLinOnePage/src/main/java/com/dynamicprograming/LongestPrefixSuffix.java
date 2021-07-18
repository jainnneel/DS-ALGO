package com.dynamicprograming;

import java.util.Arrays;

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        
//        lps("sspss");
        uniquePaths(3,7);
    }
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(num1,num2)->Integer.compare(num2[1],num1[1]));

        int ans = 0;
        for(int i = 0; i < pairs.length - 1; i++){
            if(pairs[i][1] < pairs[i+1][0]){
                ans++;
            }
        }
        return ans;
    }
    
    static int ans = 0;
    public static int uniquePaths(int m, int n) {
        int[][] v = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(v[i],-1);
        }
        findpath(0,0,m-1,n-1,v);
        return ans;
    }
    
    static int findpath(int i,int j,int m,int n,int[][] v){

        if(i > m || j > n){
            return 0;
        }         
        
        if(i == m && j == n){
            return 1;
        }
        
         if(v[i][j]!=-1){
             return v[i][j];
        }
        
        
       int ans1 =  findpath(i,j+1,m,n,v);
       int ans2 =  findpath(i+1,j,m,n,v);
       
      
       
       v[i][j] = ans1 + ans2;
       
        return v[i][j];
    }
    
    static int lps(String s) {
        int i = 0;
        int j = 1;
        
        int[] arr = new int[s.length()];
        arr[0] = 0;
        
        
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                arr[j] = i + 1;
                i++;
                j++;
            }else{
               if( i > 0 ){
                    i  = arr[i-1];    
               }else{
                   arr[j] = 0;
                   j++;
               }
            }
        }
        return arr[s.length() - 1];
       
//        int n = s.length();
//      
//        int[] arr = new int[s.length()];
//        
//        arr[0] = 0;
//        
//        int i = 0;
//        int j = 1;
//        
//        while(j < n){
//           if(s.charAt(i) == s.charAt(j)){
//               arr[j] = i + 1;
//               i++;
//               j++;
//           }else{
//               if(s.charAt(arr[j-1]) == s.charAt(j)){
//                   arr[j] = arr[arr[j-1]];
//                   i = arr[j] + 1;
//                   j++;
//               }else{
//                   arr[j] = 0;
//                   j++;
//               }
//           }        
//        }
//        return arr[n-1];
        
     }
}
