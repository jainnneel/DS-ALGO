package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {

    public static void main(String[] args) {
//        numberoftimes(Arrays.asList(19,20,6,7,8,9,10,12,18));
        findElement(Arrays.asList(19,20,6,7,8,9,10,12,18),20);
    }

    private static void findElement(List<Integer> asList, int x) {
        int low = 0;
        int high = asList.size()-1;
        int min = Integer.MAX_VALUE;
        
        while (low<high) {
            int m = (low+high)/2;
            if (asList.get(m-1)>asList.get(m) && asList.get(m+1)>asList.get(m)) {
                min = m;
                if (asList.get(min)==x) {
                    System.out.println(min);
                    return;
                }
               if (asList.get(min)>x) {
                   low = min+1;
               }else {
                   high = min-1;
               }
               break;
            }

            if (asList.get(low)>asList.get(m)) {
                high=(m)%asList.size();
            }else {
                low = (m)%asList.size();
            }
            
        }
        
        while (low<=high) {
                    
                    int m = (low+high)/2;
                    if (asList.get(m)==x) {
                        System.out.println(m);
                        return;
                    }
                    if (asList.get(m)>x) {
                        high= m-1;
                    }else {
                        low = m+1;
                    }
                    
                }
    }

    private static void numberoftimes(List<Integer> asList) {
        
        int low = 0;
        int high = asList.size()-1;
        int min = Integer.MAX_VALUE;
        
        while (low<high) {
            int m = (low+high)/2;
            if (asList.get(m-1)>asList.get(m) && asList.get(m+1)>asList.get(m)) {
                min = m;
                break;
            }

            if (asList.get(low)>asList.get(m)) {
                high=(m)%asList.size();
            }else {
                low = (m)%asList.size();
            }
            
        }
        System.out.println(asList.size()-min);
        
    }
}
