package com.dynamicprograming;

public class MaxDiffBetweenZeroAndOne {

    public static void main(String[] args) {
        findMaxiff("11000010001");
    }

    private static void findMaxiff(String str) {
        
        int ones = 0;
        int zeros = 0;
        
        int diff1 = Integer.MIN_VALUE;
        int diff2 = Integer.MIN_VALUE;
        for(char ch : str.toCharArray()) {
            if (ch == '0') {
                zeros++;
            }else {
                ones++;
            }
            
            int df1 = zeros - ones;
            int df2 = ones - zeros;
            
            if (df1 <= 0) {
                zeros = 0;
                ones = 0;
            }
            if (df2 <= 0) {
                zeros = 0;
                ones = 0;
            }
            
            diff1 = Math.max(diff1, df1);
            diff2 = Math.max(df2, diff2);
        }
        System.out.println(diff1);
        System.out.println(Math.max(Math.abs(diff2), Math.abs(diff1)));
            
    }
}
















