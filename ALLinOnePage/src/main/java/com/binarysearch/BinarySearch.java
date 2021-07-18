package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
//        binarySearche(Arrays.asList(1,2,3,4,5,6,7),0,6);
//        binarySearchitrate(Arrays.asList(1,2,3,4,5,6,7),0,6);
//        binarySearcheOrderNotKnown(Arrays.asList(1,2,3,4,5,6,7),0,6);
//        minimumelement(Arrays.asList(9,11,13,15,22,45,65,1,5,6,7,8));
        int[] arr = {2,2};
        findTwoElement(arr, 2);
        
    }
    
    static int[] findTwoElement(int arr[], int n) {
        
        boolean[] bl = new boolean[n+1];
        int rep = 0;
        for(int i = 0;i < n; i++){
            if(bl[arr[i]]){
                rep = arr[i];
                break;
            }else{
                bl[arr[i]] = true;
            }
        }
        
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; i < n ; i++){
            if(arr[i] != rep){
                 temp1 = (temp1 ^ arr[i]);   
            }
        }
        temp1 = (temp1 ^ rep);
        for(int i = 1; i <= n; i++){
            temp2 = (temp2 ^ i);
        }
        int[] ans = new int[2];
         ans[0] = rep;
         ans[1] = (temp1 ^ temp2);
        return ans;
     }

    private static void minimumelement(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        int ans = 0;
        while (i <= j) {
            int m = (i + j) / 2;
            
            if( m > 0 && m < list.size() - 1 && list.get(m - 1) > list.get(m) && list.get(m + 1) >= list.get(m)) {
                ans = m;
                break;
            }else if (list.get(m) > list.get(list.size()-1)) {
                i = m + 1;
            }else if(list.get(m) < list.get(0)) {
                j = m - 1;
            }
        }
        int rotate = list.size() - ans;
        int[] arr = {9,11,13,15,22,45,65,1,5,6,7,8};
        int in1 =  Arrays.binarySearch(arr, 0, ans -1, 13);
        int in2 =  Arrays.binarySearch(arr, ans + 1, list.size(), 13);
        System.out.println(in1 +" "+in2);
        System.out.println(ans);    
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void binarySearcheOrderNotKnown(List<Integer> asList,int low,int high) {
        
        int type = asList.get(0)<asList.get(1) ? 0 : 1;
        
        if (type == 0) {
            int x = 2;
            while (low<high) {
                
                int m = (low+high)/2;
                if (asList.get(m)==x) {
                    System.out.println(m);
                    return;
                }
                if (asList.get(m)>x) {
                    high= m-1;
                }else {
                    low = m+1;
                }
                
            }
        }else {
            int x = 2;
            while (low<high) {
                
                int m = (low+high)/2;
                if (asList.get(m)==x) {
                    System.out.println(m);
                    return;
                }
                if (asList.get(m)<x) {
                    high= m-1;
                }else {
                    low = m+1;
                }
            }
        }
    }

    private static void binarySearchitrate(List<Integer> asList,int low,int high) {
        int x = 2;
        while (low<high) {
            
            int m = (low+high)/2;
            if (asList.get(m)==x) {
                System.out.println(m);
                return;
            }
            if (asList.get(m)>x) {
                high= m-1;
            }else {
                low = m+1;
            }
            
        }
    }

    private static void binarySearche(List<Integer> asList,int low,int high) {
        
        int x = 2;
        
        if (low>high) {
            return;
        }
        int m = (low+high)/2;
        if (asList.get(m)==x) {
            System.out.println(m);
            return;
        }
        if (asList.get(m)>x) {
            binarySearche(asList,0,m-1);
        }else {
            binarySearche(asList,m+1,high);
        }
        
    }
}
