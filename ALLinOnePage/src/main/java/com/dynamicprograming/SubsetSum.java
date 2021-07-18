package com.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] w = {1, 5, 4, 6, 2, 12, 9};
//        System.out.println(subsetSum(w,10));
//        System.out.println(equalSumPartition(w));
//        System.out.println(countOfSubsetSum(w,7));
//        System.out.println(minimumSubsetSumDiff(w));
//        System.out.println(countFriendsPairings(100000));
//        int[][] mat = new int[8][13];
//        for (int i = 0; i < mat.length; i++) {
//            Arrays.fill(mat[i], -1);
//        }
//        System.out.println(findMinElements(w,12,12,0,mat));
//        System.out.println();
       int arr[] = {900, 940, 950, 1100, 1500, 1800};
       int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        findPlatform(arr,dep,6);
    }
    
    
    static int findPlatform(int arri[], int dep[], int n)
    {
      
      int[][] arr = new int[n][2];
      
      for(int i = 0; i < n; i++){
            arr[i][0] = arri[i];
            arr[i][1] = dep[i];
      }
      
      Arrays.sort(arr,(a,b) -> a[0] - b[0]);
      
      List<Integer> ans = new ArrayList<Integer>();
      ans.add(arr[0][1]);
      for(int i = 1; i < arr.length; i++){
          boolean b = false; 
          for(int j = ans.size() - 1; j >=0 ; j--){
              if(arr[i][0] > ans.get(j)){
                  b = true;
                  ans.set(j,arr[i][1]);
                  break;
              }
          }
          if(!b){
              ans.add(arr[i][1]);  
          }
      }
      return ans.size();
      
        
    }
    
    
    private static int findMinElements(int[] w, int t,int curr,int in,int[][] mat) {
        
        if(curr < 0) {
            return Integer.MAX_VALUE-1;
        }
        
        if(curr == 0) {
            return 0;
        }
        
        if(in >= w.length) {
            return Integer.MAX_VALUE-1;
        }
        
        if(mat[in][curr] != -1) {
            return mat[in][curr];
        }
        
        return mat[in][curr] = Math.min(1 + findMinElements(w,t,curr - w[in], in+1, mat),findMinElements(w,t,curr, in+1, mat));
        
    }


    public static long countFriendsPairings(int n) 
    { 
       long[] mat = new long[n+1];
       
       for(int i = 0; i <= n; i++){
           if(i<=2){
               mat[i] = i;
           }else{
               mat[i] = (mat[i - 1]%1000000007 + ((i - 1)*mat[i - 2])%1000000007)%1000000007;
           }
       }
       return mat[n]%1000000007;
    }
    
    private static int minimumSubsetSumDiff(int[] w) {
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum = sum + w[i];
        }
        boolean[][] mat = new boolean[w.length+1][sum+1]; 
        for (int j = 1; j <= sum; j++) {
            mat[0][j] = false;
        }
        for (int j = 0; j <= w.length; j++) {
            mat[j][0] = true;
        }
        for (int i = 1; i <= w.length; i++) {
            for (int k = 1; k <= sum; k++) {
                if (k>=w[i-1]) {
                    mat[i][k] = mat[i-1][k] || mat[i-1][k-w[i-1]];
                }else {
                    mat[i][k] = mat[i-1][k];
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= mat[w.length-1].length/2; i++) {
            if (mat[w.length-1][i]) {
                list.add(i);
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (Integer integer : list) {
            min = Math.min(min, sum-2*integer);
        }
        return min;
    }



    private static int countOfSubsetSum(int[] w, int sum) {
        
        int[][] mat = new int[w.length][sum+1]; 
        for (int j = 1; j < sum; j++) {
            mat[0][j] = 0;
        }
        for (int j = 0; j < w.length; j++) {
            mat[j][0] = 1;
        }
        for (int i = 1; i < w.length; i++) {
            for (int k = 1; k <= sum; k++) {
                if (k>=w[i]) {
                    mat[i][k] = mat[i-1][k] + mat[i-1][k-w[i]];
                }else {
                    mat[i][k] = mat[i-1][k];
                }
            }
        }
            return mat[w.length-1][sum];
     }
    private static boolean equalSumPartition(int[] w) {
        
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum = sum + w[i];
        }
        if((sum & 1) == 1) {
            return false;
        }else {
            return subsetSum(w,sum/2);
        }
    }
    private static boolean subsetSum(int[] w, int sum) {
        boolean[][] mat = new boolean[w.length+1][sum+1]; 
        for (int j = 1; j <= sum; j++) {
            mat[0][j] = false;
        }
        for (int j = 0; j <= w.length; j++) {
            mat[j][0] = true;
        }
        for (int i = 1; i <= w.length; i++) {
            for (int k = 1; k <= sum; k++) {
                if (k>=w[i-1]) {
                    mat[i][k] = mat[i-1][k] || mat[i-1][k-w[i-1]];
                }else {
                    mat[i][k] = mat[i-1][k];
                }
            }
        }
        return mat[w.length][sum];
    }
}
