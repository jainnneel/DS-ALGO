package com.allinonepage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRrankSort {

    static String[] bigSorting(String[] unsorted) {
        
         BigInteger[] array = new BigInteger[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            BigInteger bigIntegerStr=new BigInteger(unsorted[i]);
            array[i] =bigIntegerStr;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            unsorted[i] = array[i]+"";
        }
        
        return unsorted;
    }
    
    static int introTutorial(int V, int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==V) {
                return i;
            }
        }
        
        return -1;
    }
    
    static void insertionSort1(int n, int[] arr) {
        
        int temp = arr[arr.length-1];
        for (int i = arr.length-1; i >= 0; i--) {
            if (i==0) {
                arr[i]=temp;
            }else {
                if (temp < arr[i-1]) {
                    arr[i] = arr[i-1];
                }else {
                    arr[i] = temp;
                    break;
                }
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j]+" ");
                }
                System.out.println();
            }
         }
          
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }
    }
    
    static void insertionSort2(int n, int[] arr) {
        int j,temp;
        int ans=0;
        for (int i = 1; i < arr.length; i++) {
            j=i-1;
            temp = arr[i];
            while (j>=0 && arr[j]>temp) {
                arr[j+1] = arr[j];
                ans++;
                j--;
            }
            arr[j+1] = temp;
            for (int l = 0; l < arr.length; l++) {
                System.out.print(arr[l]+" ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }
    private static int partition(int arr[], int begin, int end)
    {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
//    static int partition(int[] a,int low,int high){
//        int i=low+1,j=high;
//        
//        while(a[i] < a[low]){
//            i++;
//        }
//        while(a[j] > a[low]){
//            j--;
//        }
//        if(i<=j){
//            int temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//        }else{
//            int temp =  a[low];
//            a[low] = a[j];
//            a[j] = temp;
//        }
//        return j;
//    }
    
    static void quicksorts(int[] a,int low,int high){
        int m;
        if(low<high){
            m = partition(a,low,high);
            quicksorts(a,0,m-1);
            quicksorts(a,m+1,high);            
        }

    }
    
    static int[] countingSort(int[] arr) {
        
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        int[] s1c = new int[max+2];
        List<Integer> list = new ArrayList<>();
        int[] s2c = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            s1c[arr[i]]++;
        }
        
        for (int i = 0; i < s1c.length; i++) {
            int c = s1c[i];
            while (c!=0) {
                list.add(i);
                System.out.println(i);
                c--;
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            s2c[i] = list.get(i);
        }
        
        return s2c;
    }
    
    static int[] closestNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] s2c = new int[arr.length];
        
        Arrays.sort(arr);
        
        int minDiff = Math.abs(arr[1] - arr[0]);
        
        for (int i = 0; i < arr.length-1; i++) {
            if (Math.abs(arr[i+1] - arr[i])<=minDiff) {
                minDiff = Math.abs(arr[i+1] - arr[i]);
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (Math.abs(arr[i+1] - arr[i])==minDiff) {
                list.add(arr[i]);
                list.add(arr[i+1]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            s2c[i] = list.get(i);
        }
        return s2c;
    }
    
    static int[] quickSort(int[] arr) {
        quicksorts(arr,0,arr.length-1);
        for (int l = 0; l < arr.length; l++) {
            System.out.print(arr[l]+" ");
        }
        return arr;
    }
    public static int sherlockAndAnagrams(String s) {
        
        Map<String,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j < n+1; j++){
                String str = s.substring(i,j);
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                map.put(String.valueOf(ch),map.getOrDefault(String.valueOf(ch),0)+1);
            }
        }
        int ans = 0;
        
        for(Map.Entry<String,Integer> en : map.entrySet()){
            int tm = en.getValue();
            ans = ans + (tm*(tm - 1)/2);
        }
        
        return ans;
    }
    
    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        int max  = Integer.MIN_VALUE;
        for(int i : x){
            max = Math.max(i,max);
        }
        
        boolean[] arr = new boolean[max+1];
        for(int i : x){
            arr[i] = true;
        }
        
        int ans = 0;
        
        for(int i = 1; i < max+1;i++){
            if( i+k <= max && arr[i] && arr[i + k]){
                ans++;
                i = i + k+ k; 
            }else if(arr[i]){
                ans++;
                i = i + k ;
            }
        }    
        return ans;
    }
    
     public static void main(String[] args) {
         
         hackerlandRadioTransmitters(Arrays.asList(7 ,2 ,4 ,6 ,5 ,9 ,12, 11 , 15),2);
         
//         sherlockAndAnagrams("cdcd");
         
//         int[] a = {63, 54, 17 ,78 ,43, 70, 32, 97, 16, 94, 74, 18, 60, 61, 35, 83, 13, 56, 75, 52, 70, 12, 24, 37 ,17, 0, 16, 64, 34, 81 ,82, 24 ,69 ,2 ,30, 61, 83, 37, 97, 16, 70 ,53, 0 ,61, 12, 17, 97, 67, 33, 30, 49, 70 ,11 ,40 ,67, 94, 84, 60, 35, 58 ,19 ,81, 16, 14 ,68, 46, 42, 81, 75 ,87 ,13 ,84, 33, 34 ,14 ,96 ,7 ,59, 17, 98, 79, 47, 71, 75, 8 ,27, 73 ,66, 64, 12, 29, 35, 80, 78, 80, 6, 5, 24, 49 ,82};
//         insertionSort1(5,a);
//         insertionSort2(5,a);
//         quickSort(a);
         int[] a = {-20 ,-3916237 ,-357920 ,-3620601, 7374819, -7330761 ,30, 6246457 ,-6461594 ,266854 ,-520, -470 };
//         countingSort(a);
         closestNumbers(a);
    }   
}
