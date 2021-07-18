package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurance {
    
    public static void main(String[] args) {
        
        firstandlast(Arrays.asList(4,4,4,4,4,4,4),0,6);
        
    }

    private static void firstandlast(List<Integer> asList,int low,int high) {
        int f = high;
        int l = low;
        int x = 4;
        while (low<=high) {
            
            int m = (low+high)/2;
            if (asList.get(m)==x) {
                f = m < f ? m : f;
                high = m-1;
            }else if (asList.get(m)<x) {
                low= m+1;
            }else {
                high = m-1;
            }
            
        }
        low = 0;
        high = asList.size()-1;
        while (low<=high) {
            
            int m = (low+high)/2;
            if (asList.get(m)==x) {
                l = m > l ? m : l;
                low = m+1;
            }else if (asList.get(m)>x) {
                high= m-1;
            }else {
                low = m+1;
            }
        }
        System.out.println(l-f+1);
    }
}
