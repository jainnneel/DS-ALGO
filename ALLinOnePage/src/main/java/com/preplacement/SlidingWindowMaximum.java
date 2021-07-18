package com.preplacement;

public class SlidingWindowMaximum {
    
    public static void main(String[] args) {
        int[] a = {1};
        maxSlidingWindow(a,1);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
     
        int ans[] = new int[nums.length+1-k];
        
        for (int i = 0; i < nums.length+1-k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k+i; j++) {
                
                    if (nums[j]>max) {
                        max = nums[j];
                    }
                
            }
            ans[i] = max; 
            
        }
        return ans;
    }
    
}

