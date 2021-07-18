package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class NextAlphabatical {

    public static void main(String[] args) {
        nextalphabatical(Arrays.asList('a','b','d','f','k','l','q','r','s'));
    }

    private static void nextalphabatical(List<Character> asList) {
        
        char c = 'm';
        
        int low = 0;
        int high = asList.size()-1;
        int ceilNear = -1;
        int floorNear = -1;
        while (low<=high) {
            
            int m = low+(high-low)/2;
            if (asList.get(m)==c) {
                System.out.println(m);
                return;
            }
            
            if (asList.get(m)>c) {
                ceilNear = m;
                high = m-1;
            }
            else {
                floorNear =m;
                low = m+1;
            }
        }
        
        System.out.println(ceilNear);
        System.out.println(floorNear);
        
    }
}
