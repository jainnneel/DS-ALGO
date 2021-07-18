package com.backtraking;

import java.util.ArrayList;
import java.util.List;

public class LIS {

    public static void main(String[] args) {
        
        List<Integer[]> integers = new ArrayList<>();
        
        Integer[] a1 = {5,8,9,5,2};
        
        integers.add(a1);
        
        System.out.println(String.valueOf(integers.get(0)));
        
        int[] arr = {5,8,7,1,9};
        findIt(arr,arr.length,1,1,arr[0]);
    }

    private static void findIt(int[] arr,int n,int curr,int in,int prev) {
        
        if(in >= n) {
            return;
        }
        
        if (arr[in] > prev) {
            prev = arr[in];
            curr++;
        }
        
        findIt(arr, n, curr, in+1, prev);
        findIt(arr, n, curr, in+1, prev);
        
    }
    
    
}
