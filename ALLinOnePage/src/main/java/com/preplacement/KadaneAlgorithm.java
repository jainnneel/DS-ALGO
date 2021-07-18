package com.preplacement;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] a = {-1,4,5,6,-200,7,-7,1000};
//        largestsubarraySum(a);
        kadaneAlgo(a);
//        int[] a = {17,85,93,-45,-21};
//        shortestSubarray(a,150);
    }

    public static int shortestSubarray(int[] a, int k) {
        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 0; i<a.length; i++){
            sum = sum + a[i];
            if(sum<0){
                sum = 0;
                count--;
            } 
            
            count++;
            max = Math.max(sum,max);
            if(max>=k){
               flag = true;
               break;
            }
        }
        return flag?count:-1;
    }
    
    private static void kadaneAlgo(int[] a) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum<0) {
                sum = 0;
            }
            if (sum>max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    private static void largestsubarraySum(int[] a) {
        
      int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < a.length; i++) {
             for (int j = 0; j < a.length; j++) {
                 int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + a[k];
                }
                if (sum>max) {
                    max = sum;
                }
            }
        }
        
        System.out.println(max);
    }
}
