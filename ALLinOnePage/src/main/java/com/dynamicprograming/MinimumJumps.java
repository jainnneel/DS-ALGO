package com.dynamicprograming;

import java.util.Arrays;

public class MinimumJumps {
    
    static int[] dp = new int[6];
    
    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        int[] arr = {2,3,1,1,4};
        
//        int ans = jums(arr,0,4);
//        System.out.println(ans);
        
//        System.out.println(jumpornot(arr,0,4));
        canJump(arr);
     }
   
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for(int i=0; i<=max; i++){
            max = Math.max(max, i+nums[i]);
            if(max >= len-1)  return true;
        }
        return false;
    }
    
   static boolean jumpornot(int[] nums,int start,int end){
        
        if(start == end){
            return true;
        }
        
        if(start > end){
            return false;
        }
        
        if(start == 0){
            return false;
        }
        boolean ans = false;
        for(int i = start+1; i <= end && i <= nums[start] + start; i++){
            boolean res =  jumpornot(nums,i,end);
            if(res == true){
                ans = res;
            }
        }
        return ans;
    }
    
    
    private static int jums(int[] arr,int st,int end) {
       
        if (st == end) {
            return 0;
        }
        
        if (dp[st]!=-1) {
            return dp[st];
        }
        
        if (arr[st] == 0) {
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = st+1; j <= end && j <= arr[st] + st; j++) {
              int ans = jums(arr, j , end);
              if (ans != Integer.MAX_VALUE && ans+1<min) {
                   min = ans + 1;
              }
        }
        return dp[st] =  min;
    }
}
