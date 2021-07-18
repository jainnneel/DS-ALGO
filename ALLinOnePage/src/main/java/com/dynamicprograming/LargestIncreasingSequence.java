package com.dynamicprograming;

import java.util.Arrays;

public class LargestIncreasingSequence {

    public static void main(String[] args) {
        
        int[][] val = new int[][] {
            new int[] {46,89},
            new int[] {50,53},
            new int[] {52,68},
            new int[] {72,45},
            new int[] {77,81},
        };
        
        int[] w = {5,10,11,8,7,12,6,5,7,8,13,14};
        findIt(w);
//        maxEnvelopes(val);
    }
    
    public static int maxEnvelopes(int[][] e) {
        int arr[] = new int[e.length];
       
       Arrays.fill(arr, 1);
       Arrays.sort(e,(e1,e2)->e2[0]-e1[0]);
       
       for(int i = 0; i < e.length; i++){
           for(int j = 0; j < i; j++){
               if( e[i][0] < e[j][0]  && e[i][1] < e[j][1] && arr[i]<=arr[j]){
                   arr[i] = arr[j]+1;
               }        
           }
       }
       return arr[e.length-1];
       
   }

    private static void findIt(int[] w) {
        int arr[] = new int[w.length];
//        int[] w = {5,10,11,8,7,12,6,5,7,8,13,14};
        Arrays.fill(arr, 1);
        
        for(int j = 1; j < w.length; j++) {
            
            for(int i = 0; i < j; i++) {
                
                if(w[j]>w[i] && arr[j]<=arr[i]) {
                
                    arr[j] = arr[i]+1;
                }
            }
        }
        
        int cur =  arr[w.length-1];
        int in = w.length-1;
        while (cur>0) {
            if(arr[in] == cur) {
                System.out.println(w[in]);
                cur--;
            }
            in--;
        }
        
        System.out.println();
        
    }
    
    
}
