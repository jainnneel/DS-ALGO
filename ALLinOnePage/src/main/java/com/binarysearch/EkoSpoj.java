package com.binarysearch;

import java.util.Scanner;

public class EkoSpoj {

    public static void main(String[] args) {
        
  
//        
//        Scanner scanner = new Scanner(System.in);
//        
//        int n = scanner.nextInt();
//        int sum = scanner.nextInt();
//        int arr[] = new int[n];
//        
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        
//        findmaxele(arr,sum);
//        
//        scanner.close();
        findNum(1);
    }

    static int findNum(int n)
    {
        int low = 1;
        int high = 10000;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            
            int m = low + (high - low)/2;
            
            int trail = zeros(m);
            
            if(trail >= n){
                ans = Integer.min(ans,m);
                high = m - 1;
            }else{
                low = m+1;
            }
            
        }
        return ans;
    }
    
    static int zeros(int m){
        int ans = 0;
        for(int i = 5; i <= m; i=i*5){
            ans = ans + m/i;
        }
        return ans;        
    }
    
    private static void findmaxele(int[] arr, int sum) {
        int high = Integer.MIN_VALUE;
        int low = 0;
        for (int j = 0; j < arr.length; j++) {
            high = Math.max(high, arr[j]);
        }
        int ans = Integer.MIN_VALUE;
        while (low<=high) {
            
            int m = low + (high - low)/2;
            
            int val =  findSumforM(arr,m);
            
            if (val >= sum) {
                ans = Math.max(ans, m);
                low = m+1;
            }else {
                high = m-1;
            }
        }
        System.out.println(ans);
    }

    private static int findSumforM(int[] arr, int i) {
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            
            if (arr[j]/i > 0) {
                sum = sum + arr[j]%i;
            }
            
        }
        
        return sum;
    }
}







