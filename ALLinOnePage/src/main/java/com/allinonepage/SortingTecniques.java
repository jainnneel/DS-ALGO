package com.allinonepage;

public class SortingTecniques {
    
    static void selectionSort(int[] arr) {
//        int ans = 0;
//        for (int i = 0; i < a.length; i++) {
//            int small = a[i];
//            int temp;
//            int in=i;
//            for (int j = i; j < a.length; j++) {
//                if (a[j]<small) {
//                    small = a[j];
//                    in = j;
//                }
//            }
//            if (a[i]!=small) {
//                temp = a[i];
//                a[i] = small;
//                a[in] = temp;
//                ans++;
//                
//            }
//        }
//        System.out.println(ans);
//        
        int count = 0; 
        int i = 0; 
        while (i < arr.length) { 
  
            // If current element is 
            // not at the right position 
            if (arr[i] != i + 1) { 
  
                while (arr[i] != i + 1) { 
                    int temp = 0; 
  
                    // Swap current element 
                    // with correct position 
                    // of that element 
                    temp = arr[arr[i] - 1]; 
                    arr[arr[i] - 1] = arr[i]; 
                    arr[i] = temp; 
                    count++; 
                } 
            } 
  
            // Increment for next index 
            // when current element is at 
            // correct position 
            i++; 
        } 
        System.out.println(count);
    }

    private static void quickSort(int[] a,int low,int high) {
        int m;
        if (low<high) {
            m= partitioning(a,low,high);
            quickSort(a,0,m-1);
            quickSort(a,m+1,high);
        }
        
    }
    
//    private static int partitioning(int arr[], int begin, int end) {
    private static int partitioning(int a[], int low, int high) {
        int i = low+1;
        int j = high;
        int temp;
        while (a[i]<a[low]) {
            i++;
        }
        
        while (a[j]>a[low]) {
            j--;
        }
        
        if (i<=j) {
            temp =  a[i];
            a[i] = a[j];
            a[j] = temp;
        }else {
            temp =  a[low];
            a[low] = a[j];
            a[j] = temp;
        }
       
        
        return j;
//        int pivot = arr[end];
//        int i = (begin-1);
//
//        for (int j=begin; j<end; j++)
//        {
//            if (arr[j] <= pivot) {
//                i++;
//
//                int swapTemp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = swapTemp;
//            }
//        }
//
//        int swapTemp = arr[i+1];
//        arr[i+1] = arr[end];
//        arr[end] = swapTemp;
//
//        return i+1;
    }

    public static void main(String[] args) {
//        int[] a = {50,30,10,90,80,20,40,70};
//        selectionSort(a);
        int[] a = {-4,3,1,9,8,2,4,7};
        quickSort(a,0,a.length-1);
    }

}
