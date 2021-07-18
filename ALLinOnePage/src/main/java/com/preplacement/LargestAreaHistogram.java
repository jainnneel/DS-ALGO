package com.preplacement;

public class LargestAreaHistogram {

    public static void main(String[] args) {
        int a[] = {1,2,1,4,3};
        largetarea(a);
    }

    private static void largetarea(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            int l=0,r=0;
            if (i==0) {
                l=0;
            }else {
                int k;
                for (k = i; k >= 0; k--) {
                    if (a[i]>a[k]) {
                        break;
                   }
               }
                l=k+1;
            }
            if (i==a.length-1) {
                r=a.length-1;
            }else {
                int j;
                for (j = i; j < a.length; j++) {
                    if (a[i]>a[j]) {
                        break;
                    }
                }
                r=j;
            }
            sum = (r-l)*a[i]; 
           if (sum>max) {
            max = sum;
        } 
        }
        System.out.println(max);
    }
}
