package com.dynamicprograming;

public class WatchingCPL {

    public static void main(String[] args) {
        
        int[] arr = {7 ,8 ,19 ,7 ,8 ,7 ,10 ,20};
        int w  = 38;
        
        boolean[] b = new boolean[8];
        System.out.println(minimumBox(arr,38,0,b,0,0));
        System.out.println(minimumBox(arr,38,0,b,0,0));
        
    }

    private static int minimumBox(int[] arr, int w, int in, boolean[] b,int ans,int curr) {
        
        if(in == arr.length) {
            if(curr >= w) {
                return ans;
            }
            return Integer.MAX_VALUE;
        }
        if(curr >= w) {
            return ans;
        }
        
        if (b[in] == false) {
            b[in] = true;
            int with = minimumBox(arr, w, in + 1, b, ans + 1, curr + arr[in]);
            b[in] = false;
            int without = minimumBox(arr, w, in + 1, b, ans, curr);
            if(with >= without) {
                b[in] = true;
            }
            return Math.min(with, without);
        }else {
            return minimumBox(arr, w, in + 1, b, ans, curr);
        }
    }
}
