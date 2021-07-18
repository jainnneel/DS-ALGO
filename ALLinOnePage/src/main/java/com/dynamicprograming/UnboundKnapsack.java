package com.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnboundKnapsack {

    public static void main(String[] args) {
        
//        int m = 4096,n = 6;
//        double d = (double)1/2;
//        double ans = Math.pow(m,(double)1/n);
//        int ans1 = (int)Math.pow(m,(double)1/n);
//         
//         if((ans - (double)ans1) == 0){
//             System.out.println(ans1);
//         }else{
//         }
//        
//        int[] w = {1,2,3,7,4};
//        int val[] = {5,25,120,12,23}; 
//        unboundedKnapsack(w,val);
//        unboundedKnapsackmemo(w,val);
//        
//        makingChangeProblem(w);
//        int[][] mat = {{3},{2}};
//        findDiagonalOrder(mat);
        
        getWays(85,Arrays.asList(50 ,10 ,17 ,21, 8, 3, 12, 41 ,9 ,13, 43, 37, 49, 19, 23 ,28, 45, 46, 29 ,16 ,34 ,25 ,2 ,22 ,1));
    }
    
    public static long getWays(int w, List<Integer> c) {
        
        int n = c.size();
        // Collections.sort(c);
        
        int[][] mat = new int[c.size()+1][w+1];
        
        for(int i = 0; i < n; i++){
            mat[i][0] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= w; j++){
                if(j >= c.get(i - 1)){
                    int wei = c.get(i - 1);
                    mat[i][j] =   mat[i][j - wei] + mat[i - 1][j];
                }else{
                    mat[i][j] = mat[i - 1][j];
                }
            }
        }
        
        return mat[n][w];
        
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];    
        List<List<Integer>> ansl = new ArrayList<>();
        
        ans[0] = mat[0][0];
        int n = mat.length;
        int m = mat[0].length;
        boolean flg = false;
        for(int i = 1; i < n; i++){
            int tempi = i;
            List<Integer> li = new ArrayList<>();
            li.add(mat[i][0]);
            for(int j = 0; j < i; j++){
                if(tempi > 0 && j < m - 1)  li.add(mat[tempi-1][j+1]);
                    tempi--;
            }
            if(!flg){
                Collections.reverse(li);
                ansl.add(li);
                flg = !flg;
            }else{
                ansl.add(li);
                flg = !flg;
            }
        }
        flg = !flg;
        for(int i = 1; i < n; i++){
            List<Integer> li = new ArrayList<>();
            li.add(mat[i][m - 1]);
            int tempi = i;
            for(int j = m - 1; j > i; j--){
                if(tempi < n-1 && j > 0) li.add(mat[tempi+1][j-1]);
                tempi++;
            }
            if(!flg){
                Collections.reverse(li);
                ansl.add(li);
                flg = !flg;
            }else{
                ansl.add(li);
                flg = !flg;
            }
        }
        int k = 1;
        for(int i = 0; i < ansl.size(); i++){
            for(int j = 0;j < ansl.get(i).size(); j++){
                ans[k++] = ansl.get(i).get(j);
            }
        }
        
        return ans;
        
    }
    
    private static void unboundedKnapsackmemo(int[] w, int[] val) {
        
        int[][] mat = new int[val.length+1][11];
        
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], -1);
        }
        findAns(w,val,mat,10,val.length-1);
        System.out.println(mat[w.length-1][10]);
        
    }

    private static int findAns(int[] w, int[] val, int[][] mat, int wi, int v) {
        
        if (v < 0) {
            return 0;
        }
        
        if (mat[v][wi] != -1) {
            return mat[v][wi];
        }
        
        
        if (w[v] <= wi) {
            return mat[v][wi] = Math.max( val[v] + findAns(w, val, mat, wi - w[v], v), findAns(w, val, mat, wi, v-1));
        }else {
            return mat[v][wi] = findAns(w, val, mat, wi, v-1);
        }
    }

    private static void makingChangeProblem(int[] w) {
        int wi = 5;
        int mat[][] = new int[w.length+1][wi+1];
        for (int i = 0; i < w.length+1; i++) {
            for (int j = 0; j <= wi; j++) {
                mat[i][j] = -1;
            }
        }
        for (int j = 1; j <= wi; j++) {
            mat[0][j] = Integer.MAX_VALUE+1;
        }
        if (w[0]==1) {
            for (int j = 1; j <= wi; j++) {
                mat[1][j] = j;
            }
        }else {
            for (int j = 1; j <= wi; j++) {
                if(j%w[0]==0) {
                    mat[1][j] = j/w[0];
                }else {
                    mat[1][j] = Integer.MIN_VALUE-1;
                }
            }
        }
        
        for (int j = 0; j <= w.length; j++) {
            mat[j][0] = 0;
        }
        
        for (int i = 2; i <= w.length; i++) {
            for (int j = 1; j <= wi; j++) {
                   if (w[i-1]<=j) {
                     mat[i][j] = Math.min(mat[i-1][j], 1 + mat[i][j-w[i-1]]);
                   }else {
                    mat[i][j] = mat[i-1][j];
                }
            }
         }
        System.out.println(mat[w.length][wi]);
    }

    private static void unboundedKnapsack(int[] w, int[] val) {
        int wi = 10;
        int mat[][] = new int[w.length+1][wi+1];
        for (int i = 0; i < w.length+1; i++) {
            for (int j = 0; j <= wi; j++) {
                mat[i][j] = -1;
            }
        }
        for (int j = 1; j <= wi; j++) {
            mat[0][j] = 0;
        }
        for (int j = 0; j <= w.length; j++) {
            mat[j][0] = 0;
        }
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= wi; j++) {
                   if (w[i-1]<=j) {
                     mat[i][j] = Math.max(mat[i-1][j],val[i-1] + mat[i][j-w[i-1]]);
                   }else {
                    mat[i][j] = mat[i-1][j];
                }
            }
         }
        System.out.println(mat[w.length][wi]);
    }
}
