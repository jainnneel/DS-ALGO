package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class NearlySorted {

    public static void main(String[] args) {
        nearly(Arrays.asList(5,10,30,20,40,50,65,55,70,95,83));
    }

    private static void nearly(List<Integer> asList) {
        
        int low = 0;
        int high = asList.size();
        int x = 95;
        while (low<high) {
            int m = low + (high-low)/2;
            if (m>0 && asList.get(m-1)==x) {
                System.out.println(m-1);
                break;
            }
            if (asList.get(m)==x) {
                System.out.println(m);
                break;
            }
            if (m<asList.size() && asList.get(m+1)==x) {
                System.out.println(m+1);
                break;
            }
            
            if (asList.get(m)<x) {
                low = m+1;
            }else {
                high = m-1;
            }
        }
        
    }
}
