package com.binarysearch;

import java.util.Arrays;

public class WeightedJobScheduling {

    static class midval{
        int ans;
    }
    
    public static void main(String[] args) {

        Integer[][] jobs = { { 1, 2, 50 }, { 3, 5, 20 }, { 6, 19, 100 }, { 2, 100, 200 } };

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] mat = new int[5];
        Arrays.fill(mat, -1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < jobs.length; i++) {
            midval name = new midval();
            findAns(jobs, i, jobs[i][2], 4, name,mat);
            ans =Math.max(ans,name.ans);
        }
        System.out.println(ans);
    }
    
    static int findAns(Integer[][] jobs, int i, int pf, int n,midval ans1,int[] mat) {
        if(mat[i] != -1) {
            return mat[i];
        }
        if( i == n) {
            return pf;
        }
        int ans = Integer.MIN_VALUE;
        for (int j = i+1; j < jobs.length; j++) {
            if (jobs[j][0] >= jobs[i][1]) {
                ans = Math.max(ans, findAns(jobs, j, pf + jobs[j][2], n,ans1,mat));
                ans1.ans = Math.max(ans, ans1.ans);
                mat[i] = ans1.ans;
            }
        }
        return pf;
    }
}

















