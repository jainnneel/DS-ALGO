package com.dynamicprograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SticklerThief {

    public static void main(String[] args) {
        
//        int[] arr = {1,2,3};
//        System.out.println(FindMaxSum(arr,arr.length));
        long arr[] = {0,0,5,5,0,0};
        System.out.println(findSubarray(arr,6));
    }
    
    public static long findSubarray(long[] arr ,int n) 
    {
        Map<Long,Integer> map = new HashMap<>();
        
        long[] arri = new long[n];
        
        arri[0] = arr[0]; 
        
        for(int i = 1; i < n ; i++){
            arri[i] = arri[i-1] + arr[i];
        }
        
        for(int i = 0; i < n; i++){
            map.put(arri[i],map.getOrDefault(arri[i],0)+1);
        }
        long ans = 0;
        
        if(map.containsKey(0L)) ans = ans + map.get(0L);
        int i = 0;
        for(Map.Entry<Long,Integer> en : map.entrySet()){
            i = en.getValue();
            ans = ans + ((i * (i-1)) / 2);
        }
        return ans;
    }
    
    public static int FindMaxSum(int arr[], int n){
        
        int[] mat = new int[n+1];
        Arrays.fill(mat, -1);
        findIt(arr,0,n,mat);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            max = Math.max(max, mat[i]);
        }
        return max;
    }


    private static int findIt(int[] arr, int in, int n, int[] mat) {
       
        if(in >= n) {
            return 0;
        }
        
        if(mat[in] != -1) {
            return mat[in];
        }
        
        int inc = findIt(arr, in + 2, n,mat) + arr[in];
        
        int exc = findIt(arr, in+1, n, mat);
        
        return mat[in] = Math.max(inc, exc);
        
    }
}
























