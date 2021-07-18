package com.allinonepage;

import java.util.Arrays;

public class MaxParameterTriangle {

    static int[] maximumPerimeterTriangle(Integer[] sticks) {
        int[] ans = null;
        int ansMax = 0;
        Arrays.sort(sticks,( o1,  o2) ->  o1 > o2 ? -1 : 1 ); 
            
        
        for (int i = 0; i < sticks.length-2; i++) {
            if (sticks[i]<sticks[i+1]+sticks[i+2] && ansMax<sticks[i]+sticks[i+1]+sticks[i+2]) {
                ans = new int[3];
                ans[0] = sticks[i];
                ans[1] = sticks[i+1];
                ans[2] = sticks[i+2];
                ansMax =sticks[i]+sticks[i+1]+sticks[i+2];
            }
        }
        if (ansMax == 0) {
            ans = new int[1];
            ans[0] = -1;
        }
        Arrays.sort(ans);
     
        return ans;
    }
    public static void main(String[] args) {
        Integer[] a = {1 ,1 ,1 ,2 ,3 ,5};
        maximumPerimeterTriangle(a);
    }
}
