package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearchOnUnsortedArray {

    public static void main(String[] args) {
        findPeekElement(Arrays.asList(96,34,67,45,12,98,38,23,68));
    }

    private static void findPeekElement(List<Integer> asList) {
        
        int low = 0;
        int high = asList.size()-1;

        int peekIndex ;  
        if (asList.get(high)>asList.get(high-1)) {
            System.out.println(asList.get(high));
        }
        
        if (asList.get(0)>asList.get(1)) {
            System.out.println(asList.get(0));
        }
        
        while (low<=high) {
            int m= low + (high - low)/2;
            if (m>0 && m<asList.size()-1 && asList.get(m-1)<asList.get(m) && asList.get(m+1)<asList.get(m) ) {
                peekIndex = m;
                System.out.println(asList.get(peekIndex));
                return;
            }
            if ( m<asList.size()-1 && asList.get(m)<asList.get(m+1)) {
                low = m+1;
            }else if(m>0 && asList.get(m)<asList.get(m-1)) {
                high = m -1;
            }
        }
        
    }
}
