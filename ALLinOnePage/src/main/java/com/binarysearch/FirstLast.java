package com.binarysearch;

import java.util.ArrayList;

public class FirstLast {

    public static void main(String[] args) {
        
        long[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        
        System.out.println(find(arr,9,5));
    }
    
    static ArrayList<Long> find(long arr[], int n, int x)
    {
        int i = 0;
        int j = n;
        long f = (long)x;
        int index = 0;
        while(i<=j){
            int m = (i+j)/2;
            if(arr[m] == f){
                index = m;
                break;
            }else if(arr[m] < f){
                i = m+1;
            }else{
                j = m-1;
            }
        }
        ArrayList<Long> ans = new ArrayList<>();
        for(int m = index; m >= 0; m--){
            if(arr[m] != f){
                ans.add((long)(m+1));
            }
        }
        for(int m = index+1; m < arr.length; m++){
            if(arr[m] != f){
                ans.add((long)(m+1));
            }
        }
        return ans;
    }
}
