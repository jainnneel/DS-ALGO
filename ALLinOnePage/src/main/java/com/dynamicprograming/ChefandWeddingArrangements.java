package com.dynamicprograming;

import java.util.HashSet;
import java.util.Set;

public class ChefandWeddingArrangements {

    public static void main(String[] args) {
        
        int[] arr = {1,2,2,5,5,4,7,8};
        int k = 1;
        int n = 5;
        int i = 1;
        boolean[] b = new boolean[1];
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        int[][] mat = new int[6][6];
        for (int j = 0; j < mat.length; j++) {
            for (int j2 = 0; j2 < mat.length; j2++) {
                mat[j][j2] = -1;
            }
        }
        System.out.println(findMin(arr,set,i,0,10,10,b));
    }

    private static int findMin(int[] arr, Set<Integer> set, int i, int k,int cost,int pertb,boolean[] b) {
        
        if(i == arr.length) {
            return cost + k;
        }
        
        if(set.add(arr[i])) {
             return findMin(arr, set, i + 1, k, cost,pertb,b);  
        }else {
            if(b[0] == false) {
                b[0] = true;
                return Math.min( findMin(arr, set, i + 1, k + 1 + 1, cost,pertb,b),findMin(arr, set, i + 1, k , cost + pertb,pertb,b));
            }else {
                Set<Integer> set1 = new HashSet<>();
                return Math.min( findMin(arr, set, i + 1, k + 1, cost,pertb,b),findMin(arr, set1, i + 1, k , cost + pertb,pertb,new boolean[1]));
            }
        }
    }
}
