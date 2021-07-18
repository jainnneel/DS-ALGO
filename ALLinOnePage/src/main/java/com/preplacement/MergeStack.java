package com.preplacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

public class MergeStack {

    public static void main(String[] args) {
//        int[][] a = new int[][] {
//            new int[] {0,2},
//            new int[] {5,10},
//            new int[] {13,23},
//            new int[] {24,25},
//        };
//        int[][] b = new int[][] {
//            new int[] {1,5},
//            new int[] {8,12},
//            new int[] {15,24},
//            new int[] {25,26},
//        };
        int[][] a = new int[][] {
            new int[] {1,3},
        };
        int[][] b = new int[][] {
            new int[] {5,9},
        };
//        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        merge(a);
//        System.out.println(minJumps(arr,0,arr.length-1));
        int arr1[] = {1,3,2};
        int arr2[] = {0, 2, 6, 8, 9};
//        merge1(arr1,arr2,4,5);
//        nextPermutation(arr1);
        intervalIntersection(a,b);
    }

    public static int[][] intervalIntersection(int[][] f, int[][] s) {
        int i = 0;
        int j = 0;
        List<int[]> ansL = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        
        if(f[0][0] <= s[0][0]){
            int[] f0 = new int[2];
            f0[0] = f[0][0];
            f0[1] = f[0][1];
            stack.push(f0);
            i++;
        }else{
            int[] f0 = new int[2];
            f0[0] = s[0][0];
            f0[1] = s[0][1];
            stack.push(f0);
            j++;
        }
        
        while(i < f.length && j < s.length){
            if(f[i][0] <= s[j][0]){
                if(stack.peek()[0] <= f[i][0] && stack.peek()[1] >= f[i][0]){
                    int[] f0 = new int[2];
                    f0[0] = Math.max(f[i][0],stack.peek()[0]);
                    f0[1] = Math.min(stack.peek()[1],f[i][1]);
                    ansL.add(f0);
                    int[] f1 = new int[2];
                    f1[1] = Math.max(stack.peek()[1],f[i][1]);
                    f1[0] = Math.min(stack.peek()[1],f[i][1]);
                    stack.pop();
                    stack.push(f1);
                }else {
                    stack.push(f[i]);
                }
                i++;
            }else{
                 if(stack.peek()[0] <= s[j][0] && stack.peek()[1] >= s[j][0]){
                    int[] f0 = new int[2];
                    f0[0] = Math.max(s[j][0],stack.peek()[0]);
                    f0[1] = Math.min(stack.peek()[1],s[j][1]);
                    ansL.add(f0);
                    int[] f1 = new int[2];
                    f1[1] = Math.max(stack.peek()[1],s[j][1]);
                    f1[0] = Math.min(stack.peek()[1],s[j][1]);
                    stack.pop();
                    stack.push(f1);
                }else {
                    stack.push(s[j]);
                }
                 j++;
            }
        }
        
        while (i<f.length) {
            if(stack.peek()[0] <= f[i][0] && stack.peek()[1] >= f[i][0]){
                int[] f0 = new int[2];
                f0[0] = Math.max(f[i][0],stack.peek()[0]);
                f0[1] = Math.min(stack.peek()[1],f[i][1]);
                ansL.add(f0);
                int[] f1 = new int[2];
                f1[1] = Math.max(stack.peek()[1],f[i][1]);
                f1[0] = Math.min(stack.peek()[1],f[i][1]);
                stack.pop();
                stack.push(f1);
            }else {
                stack.push(f[i]);
            }
            i++;
        }
        
        while (j < s.length) {
            if(stack.peek()[0] <= s[j][0] && stack.peek()[1] >= s[j][0]){
                int[] f0 = new int[2];
                f0[0] = Math.max(s[j][0],stack.peek()[0]);
                f0[1] = Math.min(stack.peek()[1],s[j][1]);
                ansL.add(f0);
                int[] f1 = new int[2];
                f1[1] = Math.max(stack.peek()[1],s[j][1]);
                f1[0] = Math.min(stack.peek()[1],s[j][1]);
                stack.pop();
                stack.push(f1);
            }else {
                stack.push(s[j]);
            }
             j++;
        }
        
        int[][] ans = new int[ansL.size()][2];
        int index = 0;
        for (int[] ks : ansL) {
            ans[index++] = ks;
        }
        
        return ans;
    }
    
    
    
    public static void nextPermutation(int[] nums) {
        
        int n = nums.length - 1;
        int min = n;
        
        int k = n ;
        
        while( k>0 && nums[k] < nums[k-1]){
            k--;
        }
        if(k == 0) {
            Arrays.sort(nums);
            return;
        }
        int mid = k-1;
        
        while( k<=n && nums[mid] >= nums[k]){
            k++;
        }
        if(k == n+1) {
            return;
        }
        
        
        int temp = nums[mid];
        nums[mid] = nums[k];
        nums[k] = temp;
        
        if (n-k<2) {
            int temp1 = nums[n];
            nums[n] = nums[k];
            nums[k] = temp1;
            return;
        }
        
        for(int i = k,j = n; i <= (n-k)/2 ; i++,j--){
            int temp1 = nums[i];
            nums[i] = nums[j];
            nums[j] = temp1;
        }
        
    }
    
    
    
    
    
    public static void merge1(int arr1[], int arr2[], int n, int m) {
        
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i]>=arr2[0]){
                int temp = arr2[0];
                arr2[0] = arr1[i];
                arr1[i] = temp;
            }
            int k = 0;
            while(arr2[k]>arr2[k+1]){
                int temp = arr2[k];
                arr2[k] = arr2[k+1];
                arr2[k+1] = temp;
                k++;
            }
        }
        
    }
    
    private static int minJumps(int[] arr, int l, int r) {
        
        if(l==r) {
            return 0;
        }
        
        if (arr[l] == 0) {
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i =  l + 1; i <= r && i <= l + arr[l] ; i++) {
            
            int jumps = minJumps(arr, i, r);
            
            if (jumps!=Integer.MAX_VALUE && jumps+1<min) {
                min = jumps + 1;
            }
        }
        return min;
        
        
    }

    private static void merge(int[][] a) {
        Stack<int[]> stack = new Stack<>();
        
        Arrays.sort(a,(c,b)->c[0] - b[0]);
        stack.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (stack.peek()[1] >=  a[i][0] ) {
                int[] n = new int[2];
                n[0] = stack.peek()[0];
                n[1] = Math.max(stack.peek()[1],a[i][1]);
                stack.pop();
                stack.push(n);
            }else {
                stack.push(a[i]);
            }
        }
        int[][] ans = new int[stack.size()][2];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i][0] = stack.peek()[0];
            ans[i][1] = stack.peek()[1];
            i++;
            stack.pop();
        }
        Arrays.sort(a,(c,b)->b[0] - c[0]);
        System.out.println();
    }
}





