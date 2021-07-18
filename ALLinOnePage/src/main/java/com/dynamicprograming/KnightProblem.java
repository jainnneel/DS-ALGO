package com.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class KnightProblem {
    
    public static void sieve(boolean[] isPrime,int n)
    {
        for(int i=1;i<n;i++)
            isPrime[i] = true;
 
        isPrime[0] = false;
        isPrime[1] = false;
 
        for(int i=2;i*i<n;i++)
        {
            if(isPrime[i] == true)
            {
                for(int j=(2*i);j<n;j+=i)
                    isPrime[j] = false;
            }
        }
    }
    
    public static void main(String[] args) {
    
        List<Integer> list = new ArrayList<>();
        boolean[][] br = new boolean[8][8];
        int[][] arr = new int[8][8];
        addAllStep(br,list,0,0,1,arr);
//        System.out.println();
//        knightProbability(3, 3, 0,0);
    }
    
    
    public static double knightProbability(int n, int k, int row, int col) {
        if(n == 1 && k == 0){
            return (double)1;
        }
        if(n == 1 && k != 1){
            return 0;
        }
        int[][] brd = new int[n][n];
            
            if(row-2 >=0 && col + 1 < n){
                brd[row-2][col + 1] = 1;
            }
            if(row-1 >=0 && col + 2 < n){
                brd[row-1][col + 2] = 1;
            }
            if(row+1 < n && col + 2 < n){
                brd[row+1][col + 2] = 1;
            }
            if(row+2 < n && col + 1 < n){
                brd[row+2][col + 1] = 1;
            }
            if(row+2 < n && col - 1 >= 0){
                brd[row+2][col - 1] = 1;
            }
            if(row+1 < n && col - 2 >= 0){
                brd[row+1][col - 2] = 1;
            }
            if(row-1 >=0 && col - 2 >= 0){
                brd[row-1][col - 2] = 1;
            }
            if(row-2 >=0 && col - 1 >= 0){
                brd[row-2][col - 1] = 1;
            }
       int[][] bb = findAns(brd,k,n);
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans = ans + bb[i][j];
            }
        }
        return ans * 1 / Math.pow(8,k);
        
    }
    
    static int[][] findAns(int[][] brd,int k,int n){
        
        while(k-- > 1){
            int[][] bb = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    
                    if(brd[i][j] != 0){
                        int row = i;
                        int col = j;
                        if(row-2 >=0 && col + 1 < n){
                            bb[row-2][col + 1] += 1;
                        }
                        if(row-1 >=0 && col + 2 < n){
                            bb[row-1][col + 2] += 1;
                        }
                        if(row+1 < n && col + 2 < n){
                            bb[row+1][col + 2] += 1;
                        }
                        if(row+2 < n && col + 1 < n){
                            bb[row+2][col + 1] += 1;
                        }
                        if(row+2 < n && col - 1 >= 0){
                            bb[row+2][col - 1] += 1;
                        }
                        if(row+1 < n && col - 2 >= 0){
                            bb[row+1][col - 2] += 1;
                        }
                        if(row-1 >=0 && col - 2 >= 0){
                            bb[row-1][col - 2] += 1;
                        }
                        if(row-2 >=0 && col - 1 >= 0){
                            bb[row-2][col - 1] += 1;
                        }
                    }

                }
            }
            brd = bb;
        }
        return brd;
    }
    
    

    private static boolean addAllStep(boolean[][] br, List<Integer> list, int i, int j,int count,int[][] arr) {
       
        if(i < 0 || j < 0 || i >= br.length || j >= br.length || arr[i][j]!=0) {
            return false;
        }
        
        if(count == 64) {
            return true;
        }
            arr[i][j] = count;
            count++;
          if(addAllStep(br,list,i-2,j+1,count,arr) ||
            
            addAllStep(br,list,i-2,j-1,count,arr) ||
            
            addAllStep(br,list,i+2,j+1,count,arr) ||
            
            addAllStep(br,list,i+2,j-1,count,arr) ||
            
            addAllStep(br,list,i-1,j+2,count,arr) ||
            
            addAllStep(br,list,i-1,j-2,count,arr) ||
            
            addAllStep(br,list,i+1,j+2,count,arr) ||
            
            addAllStep(br,list,i+1,j-2,count,arr) ) {
              
              return true;
          }else {
              count--;
              arr[i][j] = -1;
              return false;
        }
        
         
        }
        
   
    
    
    
    
}
