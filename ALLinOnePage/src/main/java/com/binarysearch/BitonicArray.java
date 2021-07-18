package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BitonicArray {
//first increase ----> peek(Max) <----- decrease
    public static void main(String[] args) {
        maxInBitonic(Arrays.asList(1,2,67,98,112,65,21,9));
        findEle(Arrays.asList(1,2,67,98,112,65,21,9),67);
    }

    private static void findEle(List<Integer> asList, int i) {
        
    }

    
    
    private static void maxInBitonic(List<Integer> asList) {
        
        int low = 0;
        int high = asList.size()-1;
        int peekIndex ;  

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
