package com.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCS {
    static int[][] t = new int[17][17];
    public static void main(String[] args) {
//        System.out.println(lcsUsingRecursion("neel","npreetl",3,6));
//        System.out.println(lcsMemorize("kajal","npreetl",4,6));
//        System.out.println(lcsTopDownDp("neel","npreetl",4,7));
//        System.out.println(longestSubString("rfkqyuqfjkxy", new StringBuilder("rfkqyuqfjkxy").reverse().toString() ,12,12));
//        System.out.println(printLcs("acbcf","abcdaf",5,6));
//        System.out.println(printLcs2("acbcf","abcdaf",5,6));
//        System.out.println(printShortestCommanSuperstring("AGGTAB","GXTXAYB",6,7));
//        System.out.println(longestpalidromString("forgeeksskeegfor"));
//        longestReaptingSubSequence("axxxy");
//        countSubstrings("nitin");
//        optimalWalk(7,1,100);
        
        int[][] edges = {{0,1},{0,3},{1,2},{3,2}};
        
//        possible_paths(edges,4,0,2);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(3);
        ans.add(3);
        ans.add(0);
        ans.add(7);
        ans.add(3);
        ans.add(5);
        ans.add(4);
        ans.add(6);
        ans.add(9);
        
        
        increment(ans,3);
    }
    
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int n) {
        ArrayList<Integer> ans = new ArrayList();
        
        int carry = 0;
        if(arr.get(arr.size() - 1) + 1 > 9){
            ans.add(0);
            carry = 1;
        }else{
            arr.set(arr.size() - 1,arr.get(arr.size() - 1) + 1 );
            return arr;
        }
        for(int i = arr.size() - 2; i >= 0; i--){
            
            int sum = arr.get(i) + carry;
            
            if(sum > 9){
                ans.add(0);
                carry = 1;
            }else{
                ans.add(sum);
                carry = 0;
            }
        }
        if(carry == 1){
            ans.add(carry);
        }
        Collections.reverse(ans);
        
        return ans;
     }
    
    public static int possible_paths(int[][] edges, int n, int s, int d)
    {
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(map.get(edges[i][1])!=null){
                List<Integer> arr = map.get(edges[i][1]);
                arr.add(edges[i][0]);
                map.put( edges[i][1] , arr);
            }else{
                List<Integer> arr = new ArrayList<>();
                arr.add(edges[i][0]);
                map.put( edges[i][1] , arr);
            }
        }
        System.out.println(map);
        int ans = 0;
        for(Integer ll : map.get(d)){
            
            ans = ans + recurrIt(ll,s,map);
            
        }
        
        return ans;
          
    }
    
    static int recurrIt(int dest,int src,Map<Integer,List<Integer>> map){
        
        if(dest == src){
            return 1;
        }
        int ans = 0;
        for(Integer i : map.get(dest)){
            ans = ans + recurrIt(i,src,map);
        }
        return ans;
    }
    

    static long optimalWalk(long n, long a, long b)
    {
       
      long[] mat = new long[2+1]; 
       Arrays.fill(mat,-1);
       mat[0] = a;
       return recureIt(n,a,b,n,mat);
        
        
    }
    
    static long recureIt(long curr,long a,long b,long n,long[] mat){
        
        if(curr > n){
            return Long.MAX_VALUE;
        }
        if(curr == 1){
            return a;
        }    
        
        if(curr % 2 == 0){
            long left = a + recureIt(curr - 1,a,b,n,mat);
            long right = a + recureIt(curr + 1,a,b,n,mat);
            long doub = b + recureIt(curr / 2,a,b,n,mat);
            return Math.min(left,Math.max(right,doub));
        }else{
            long left = a + recureIt(curr - 1,a,b,n,mat);
            long right = a + recureIt(curr + 1,a,b,n,mat);
            return Math.min(left,right);
        }
        
    }
    
    public static int countSubstrings(String s) {
        int count=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        
        for(int diag=0;diag<s.length();diag++){
            int st=0;
            int end=diag;
            while(end<s.length()){
                if(diag==0){
                    dp[st][end]=true;
                }else if(diag==1){
                    dp[st][end]=s.charAt(st)==s.charAt(end);
                }else{
                   if(s.charAt(st)==s.charAt(end) && dp[st+1][end-1]){
                       dp[st][end]=true;
                   }
                }
                
                if(dp[st][end]) count++;
                st++;
                end++;
            }
        }
        return count;
    }
    
    private static void longestReaptingSubSequence(String str) {
        int[][] mat = new int[str.length()+1][str.length()+1];
        int n = str.length();
        for (int i = 0; i < mat.length; i++) {
            mat[0][i] = 0;
            mat[i][0] = 0;
        }
        
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                if (str.charAt(i-1) == str.charAt(j-1) && i != j) {
                    mat[i][j] = 1 + mat[i-1][j-1];
                }else {
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        System.out.println(mat[n][n]);
        
    }



    private static String longestpalidromString(String s1) {
        return printLcs2(s1,new StringBuilder(s1).reverse().toString(),s1.length(),s1.length());
    }



    private static int printShortestCommanSuperstring(String s1, String s2, int n1, int n2) {
       String common = printLcs2(s1,s2,n1,n2);
        int i = 0;
        int j = 0; 
        int k = 0;
        StringBuilder ans  = new StringBuilder();
        while (i<n1 && j<n2 && k<common.length()) {
           char one = s1.charAt(i);
           char two = s2.charAt(j);
           
           if (one==two && one==common.charAt(k)) {
               ans.append(one);
               k++;
               i++;j++;
           }else if (common.charAt(k)==one) {
               ans.append(two);
               j++;
           }else if (common.charAt(k)==two) {
               ans.append(one);
               i++;
            }else{
                ans.append(one);
                ans.append(two);
                i++;
                j++;
            }
       }
        System.out.println(ans.toString());
        return ans.toString().length();
    }



    private static String printLcs2(String s1, String s2, int n1, int n2) {
        
        int mat[][] = lcsTopDownDp1(s1,s2,n1,n2);
        StringBuilder builder = new StringBuilder();
        int i = n1;
        int j = n2;
        while (i >0 && j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                i--;
                j--;
                builder.append(s1.charAt(i));
            }else {
                if (mat[i-1][j]>mat[i][j-1]) {
                    i--;
                }else {
                    j--;
                }
            }
        }
        
        return builder.reverse().toString();
    }

    private static int[][] lcsTopDownDp1(String s1, String s2, int n1, int n2) {
        
        if (n1==0 || n2==0) {
            return null;
        }
        for (int i = 1; i <=n1  ; i++) {
            for (int j = 1; j <= n2; j++) {
                t[i][j] = -1;
            }
        }
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }else {
                   t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        
        return t;
    }


    private static String printLcs(String s1, String s2, int n1, int n2) {
        if (n1==0 || n2==0) {
            return "";
        }
        String[][] ts = new String[s1.length()+1][s2.length()+1];
        
            for (int j = 0; j <= n2; j++) {
                  ts[0][j] = "";
            }
            for (int j = 0; j <= n1; j++) {
                ts[j][0] = "";
          }
       
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    ts[i][j] =  ts[i-1][j-1] + s1.charAt(i-1)+"";
                }else {
                       ts[i][j] = ts[i-1][j].length()>ts[i][j-1].length()?ts[i-1][j]:ts[i][j-1] ;
                   }
                }
            }
        
        return ts[n1][n2];
    }

    private static int[][] longestSubString1(String s1, String s2, int n1, int n2) {
        if (n1==0 || n2==0) {
            return t;
        }
        for (int i = 1; i <17  ; i++) {
            for (int j = 1; j < 17; j++) {
                t[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    ans = Math.max(t[i][j], ans);
                }else {
                   t[i][j] = 0;
                }
            }
        }
        
        return t;
    }

    private static int longestSubString(String s1, String s2, int n1, int n2) {
        if (n1==0 || n2==0) {
            return 0;
        }
        for (int i = 1; i <6  ; i++) {
            for (int j = 1; j < 6; j++) {
                t[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    ans = Math.max(t[i][j], ans);
                }else {
                   t[i][j] = 0;
                }
            }
        }
        
        return ans;
    }

    private static int lcsTopDownDp(String s1, String s2, int n1, int n2) {
        if (n1==0 || n2==0) {
            return 0;
        }
        for (int i = 1; i <5  ; i++) {
            for (int j = 1; j < 8; j++) {
                t[i][j] = -1;
            }
        }
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }else {
                   t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n1][n2];
    }

    private static int lcsMemorize(String s1, String s2,int n1,int n2) {
        if (n1<0 || n2<0) {
            return 0;
        }
        if (t[n1][n2]!=-1) {
            return t[n1][n2];
        }
        if (s1.charAt(n1)==s2.charAt(n2)) {
            return t[n1][n2] = 1+lcsMemorize(s1, s2, n1-1, n2-1);
        }else {
            return t[n1][n2] = Math.max(lcsMemorize(s1, s2, n1, n2-1),lcsMemorize(s1, s2, n1-1, n2));
        }
    }

    private static int lcsUsingRecursion(String s1, String s2,int n1,int n2) {
        if (n1<0 || n2<0) {
            return 0;
        }
        
        if (s1.charAt(n1)==s2.charAt(n2)) {
            return 1+lcsUsingRecursion(s1, s2, n1-1, n2-1);
        }else {
            return Math.max(lcsUsingRecursion(s1, s2, n1, n2-1),lcsUsingRecursion(s1, s2, n1-1, n2));
        }
    }
}
