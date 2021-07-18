package com.preplacement;

public class Elementcount {

    public static void main(String[] args) {
        
        int a[] = {3, 1, 2, 2, 2 ,1 ,4 ,3 ,3};
        
        appearmorethennbyktimes(a,4);
    }
    //by using map and also brute force can be possible
    
    //time complexitity : O(nk) with O(k-1) extra space
    static class CountElelment{
        int ele;
        int count;
    }
    
    private static void appearmorethennbyktimes(int[] a, int i) {
        
        if (i<2) {
            return;
        }

        CountElelment countElelment[] = new CountElelment[i-1];
        
        for (int j = 0; j < i-1; j++) {
            countElelment[j] = new CountElelment();
        }
        
        for (int j = 0; j < countElelment.length; j++) {
            countElelment[j].count = 0;
        }
        
        for (int j = 0; j < a.length; j++) {
            
            int k2;
            
            for (k2 = 0; k2 < countElelment.length; k2++) {
                
                if (a[j]==countElelment[k2].ele) {
                    countElelment[k2].count =  countElelment[k2].count + 1 ;
                    break;
                }
            }
            
            if (k2==i-1) {
                int k;
                
                for ( k = 0; k < countElelment.length; k++) {
                     if (countElelment[k].count == 0) {
                        countElelment[k].ele = a[j];
                        countElelment[k].count += 1;
                        break;
                    }
                }
                if (k==i-1) {
                    for (k=0;k<i-1;k++) {
                        countElelment[k].count-=1;
                    } 
                }
                
            }
        }
    }
}
