package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LilysHomework {

    public static void main(String[] args) {
        int[] a = {3 ,4 ,2 ,5 ,1}; 
        lilysHomework(a);
    }
    
    private static void lilysHomework(int[] a) {
       int arr[] = new int[a.length];
       for (int i = 0; i < a.length; i++) {
        arr[i] = a[i];
      }
        int ans1 =  lilysHomeworak(arr);
       
       for(int i = 0,j=a.length-1;i<a.length/2;i++,j--) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
       }
       int ans2 = lilysHomeworak(a);
       System.out.println(ans1 + " "+ ans2);
    }

    static int lilysHomeworak(int[] arr) {
        int ans1= 0;
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        List<Integer> integers = new ArrayList<>();
        
        for (Integer integer : arr) {
            integers.add(integer);
        }
        Collections.sort(integers);
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=integers.get(i)) {
                int index = map.get(integers.get(i));
                map.put(arr[i], index);
                map.put(integers.get(i), i);
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                ans1++;
            }
        }
        return ans1;
    }

}
