package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GridlandMetro {

    public static void main(String[] args) {
//        int i = 636975049358227002;
        List<List<Integer>> tracks = Arrays.asList(Arrays.asList(1,1,2),Arrays.asList(1,4,4),Arrays.asList(2,1,2),Arrays.asList(2,2,3),Arrays.asList(2,4,5),Arrays.asList(4,1,2),Arrays.asList(4,4,5));
//        gridlandMetro(4,5,7,tracks);
        int[] c = {1 ,3 ,5 ,7 ,9};
//        getMinimumCost(3, c);\
        knightlOnAChessboard(4);
    }
    
    public static int[][] knightlOnAChessboard(int n) {
        List<List<Integer>> list = new ArrayList<>();
        
        boolean[][] b = new boolean[n][n];
        int[][] ans = new int[n-1][n-1];
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (ans[i-1][j-1] == 0) {
                    b = new boolean[n][n];
                    ans[i-1][j-1] = ans[j-1][i-1] =  findIt(b , 0 , 0 , i, j,0);
                }
            }
        }
        return ans;
        }
    
    
    
    private static int findIt(boolean[][] ba, int i, int j, int a, int b,int curr) {
       
        if(i < 0 || j < 0 || i >= ba.length || j >= ba.length) {
            return Integer.MAX_VALUE;
        }
        if(i == ba.length-1 && j == ba.length-1) {
            return curr;
        }
        int ans = Integer.MAX_VALUE;
        if (!ba[i][j]) {
            ba[i][j] = true;
            ans = 1 +  Math.min(ans, findIt(ba,i-a,j-b,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i-a,j+b,a,b,curr+1));
           
            ans =  Math.min(ans, findIt(ba,i-b,j+a,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i+b,j+a,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i+a,j+b,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i+a,j-b,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i-b,j+a,a,b,curr+1));
            
            ans =  Math.min(ans, findIt(ba,i-b,j-a,a,b,curr+1));
            
            ba[i][j] = false;
        
        }
        
        return ans;
    }

    static int getMinimumCost(int k, int[] c) {
        
        Arrays.sort(c);
        int tm = k;
        int ans = 0;
        int i = c.length-1;
        int n = 0;    
        int l = 0;
            
            while( i >= n){
                while(tm-- > 0 && i >= n){
                    ans = ans + (l + 1) * c[i];
                    i--;
                }
                if(tm == -1){
                    tm = k;
                    l++;
                }
            }
        return ans;

}
    
    public static int gridlandMetro(int n, int m, int k, List<List<Integer>> tracks) {
        
//        Collections.sort(track,(a,b) -> a.get(0) - b.get(0));
//        List<List<Integer>> tracks = new ArrayList<>(track);
        Collections.sort(tracks,(a,b) -> {
         
            if(a.get(0) - b.get(0) != 0) {
                return a.get(0) - b.get(0);
            }else {
                return a.get(1) - b.get(1);
            }
            
        });
       //  n = n-1;
        int ans = 0;
        for(int i = 0; i < k; i++){
            int min = tracks.get(i).get(1);
            int max = tracks.get(i).get(2);
            ans = ans + (max - min) + 1;
            int j;
            for(j = i+1; j < k; j++){
               
                if(tracks.get(j).get(0) == tracks.get(i).get(0)){
                    int[] ansa = neswminormax(min,max,tracks.get(j).get(1),tracks.get(j).get(2));
                    if(ansa[0] != -1){
                       min = ansa[0];
                       max = ansa[1];
                       ans = ans + (max - min) + 1;
                    }
                                                    
                }else{
                    break;
                }
            }
            
            i = j-1;
        }
        Long  ansLong = Long.valueOf(n * m) - Long.valueOf(ans);
        return  (int) (ansLong%1000000009);
   }
   
   
   public static int[] neswminormax(int cmin,int cmax,int ci,int cj){
       
       int[] ans = new int[2];
       if(cmin <= ci && cmax >= cj){
           ans[0] = -1;
           return ans;
       }else if(cmax >= ci){
           ans[0] = cmax+1;
           ans[1] = cj;
           return ans;
       }else{
           ans[0] = ci;
           ans[1] = cj;
           return ans;
       }
       
   }
   
}
