package com.allinonepage;

import java.util.Arrays;
import java.util.List;

public class SubarrayDivision {
    
    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(1, 1, 1 ,1 ,1, 1);
        birthday(s, 3, 2);
        
    }
    
    static int birthday(List<Integer> s, int d, int m) {
        int ans  = 0;
        
        for (int i = 0; i < s.size()-m+1; i++) {
            int sum = 0;
            for (int j = i; j < m+i; j++) {
                sum = sum + s.get(j);
                if (sum>d) {
                    break;
                }
            }
            if (sum==d) {
                ans+=1;
            }
        }
        
        
        return ans;
    }

}

