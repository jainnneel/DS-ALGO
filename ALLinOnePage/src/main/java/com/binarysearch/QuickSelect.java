package com.binarysearch;

public class QuickSelect {

    public static void main(String[] args) {
        
        int arr[] = {1,9,8,2,3,7,6,5,4};
        
        quickSort(arr,0,8,9);
        
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }

    private static void quickSort(int[] arr,int low,int high,int k) {
      
        if(low>high) {
            return;
        }
        
        int pivot = arr[high];
        int m = partition(arr,pivot,low,high);
        
        if(m == k - 1) {
            System.out.println(arr[m]);
            return;
        }else if(m > k - 1) {
            quickSort(arr, low, m - 1,k);
        }else {
            quickSort(arr, m+1, high,k);
        }
    }

    private static int partition(int[] arr, int pivot, int low, int high) {
//        System.out.println(pivot);
        
        int i = low;
        int j = low;
        
        
        while (i <= high) {
            
            if (arr[i] <= pivot) {
                swap(arr,i,j);
                i++;
                j++;
            }else {
                i++;
            }
            
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}























