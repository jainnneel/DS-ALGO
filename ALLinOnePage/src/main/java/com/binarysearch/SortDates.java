package com.binarysearch;

import java.util.ArrayList;

public class SortDates {

    public static void main(String[] args) {
        
        int capacity = 3;
        int arr[] = {2,3,1,3,1,3,1,2};
          
        // To represent set of current pages.We use
        // an Arraylist
        ArrayList<Integer> s=new ArrayList<>(capacity);
        int count=0;
        int page_faults=0;
        for(int i:arr)
        {
            // Insert it into set if not present
            // already which represents page fault
            if(!s.contains(i))
            {
              
            // Check if the set can hold equal pages
            if(s.size()==capacity)
            {
                s.remove(0);
                s.add(capacity-1,i);
            }
            else
                s.add(count,i);
                // Increment page faults
                page_faults++;
                count++;
          
            }
            else
            {
                // Remove the indexes page
                s.remove((Object)i);
                // insert the current page
                s.add(s.size(),i);         
            }
          
        }
        System.out.println(page_faults);
        
        
        String[] str = {"12041996","20101996","05061997","12041989","11081987"};
        
        sortDates(str);
        
        
    }

    private static void sortDates(String[] str) {
        
        redisSort(str,0,2,31);
        redisSort(str,2,4,12);
        redisSort(str,4,8,10000);
        
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    private static void redisSort(String[] str, int i, int j,int cap) {
        
        int[] fre = new int[cap];
        String[] ansarr = new String[str.length];
        for (int k = 0; k < str.length; k++) {
            fre[Integer.parseInt(str[k].substring(i,j),10)]++;
        }
        
        for (int k = 1; k < fre.length; k++) {
            fre[k] = fre[k-1] + fre[k];
        }
        
        for (int k = str.length - 1; k >= 0; k--) {
            int pos = fre[Integer.parseInt(str[k].substring(i,j),10)] - 1;
            ansarr[pos] = str[k];
            fre[Integer.parseInt(str[k].substring(i,j),10)]--;
        }
        
        for (int k = 0; k < ansarr.length; k++) {
            str[k] = ansarr[k];
        }
        
    }
}



























