package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FloorAndCeil {

    public static void main(String[] args) {
        floorele(Arrays.asList(1,43,76,94,101,123),93);
        ceilele(Arrays.asList(1,43,76,94,101,123),102);
    }

    private static void ceilele(List<Integer> asList, int x) {
        
        int low = 0 ;
        int high = asList.size();
        int near =0;
        while(low<high) {
            
            int m = low + (high-low)/2;
            
            if (asList.get(m)==x) {
                near = m;
                break;
            }else if (asList.get(m)<x) {
               
                low = m + 1;
            }else {
                near = m;
                high = m -1;
            }
        }
        System.out.println(near);

        
    }

    private static void floorele(List<Integer> asList, int x) {
        
        int low = 0 ;
        int high = asList.size();
        int near =0;
        while(low<high) {
            
            int m = low + (high-low)/2;
            if (asList.get(m)==x) {
                near = m;
                break;
            }else if (asList.get(m)<x) {
                near = m;
                low = m + 1;
            }else {
                
                high = m -1;
            }
        }
        if (low==high && asList.size()>low) {
            near+=1;
        }
        System.out.println(near);
    }
}
