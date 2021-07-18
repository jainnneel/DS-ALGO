package com.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MatrixChainMultiplication {
    
    static int[][] mat = new int[5][5];
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        
      
        int arr[] = {5,4,6,2,7};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                 if (i==j) {
                    mat[i][j]=0;
                }else {
                    mat[i][j]=-1;
                }
            }
        }
       
//        System.out.println(mcm(arr,1,arr.length-1));
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = -1;
            }
        }
        
//        System.out.println(palidromePartition("nitin",0,arr.length-1));
//        String pattern = "T^F&T|F";
//        System.out.println(evaluateExpression(pattern,1,pattern.length()-2,true));
//        System.out.println();
//        largestPalidromString("aaaabbaa");
        System.out.println();
        caseSort("defRTSersUXI");
    }
    static class chr{
        char ch;
        chr(char ch){
            this.ch = ch;
        }
    }
    public static String caseSort(String str)
    {
        
        char[] ch = str.toCharArray();
        chr[] name = new chr[ch.length];
        int k = 0;
        for(char cc : ch) {
            name[k++] = new chr(cc);
        }
        Comparator<chr> comparator = new Comparator<chr>() {

            @Override
            public int compare(chr o1, chr o2) {
                char c1 = o1.ch;
                char c2 = o2.ch;
                if(c1 >= 65 && c1 <= 91 && c2 >= 65 && c2 <= 91){
                    return c1 - c2;
                }
                
                if(c1 >= 97 && c1 <= 122 && c2 >= 97 && c2 <= 122){
                    return c1 - c2;                
                }
                
                return c2 - c1;
            }
        };
        Arrays.sort(name,comparator);
        String ans  = "";
        for(chr name2 : name) {
            ans = ans + name2.ch;
        }
        return ans;
                
    }
    

    private static void largestPalidromString(String s) {
           int mat[][] = new int[s.length()][s.length()];
           int max = 1;
           int start = 0;
           for(int i = 0;i < s.length();i++) {
               mat[i][i] = 1;
           }
           
           for (int i = 0; i < mat.length-1; i++) {
              if (s.charAt(i)==s.charAt(i+1)) {
                  mat[i][i+1] = 1;
                  max = 2;
                  start = i;
              }else {
                mat[i][i+1] = 0;
                
            }
          }
          
          for (int i = 3; i <= mat.length; i++) {
            for (int j = 0; j < s.length()-i+1; j++) {
                int end = j + i -1;
                if (mat[j+1][end-1] == 1 && s.charAt(j) == s.charAt(end) ) {
                    mat[j][end] = 1;
                    if (i>max) {
                        max = i;
                        start = j;
                    }
                }else {
                    mat[j][end] = 0;
                }
                
            }
        }
          for (int i = start; i < start+max; i++) {
            System.out.print(s.charAt(i));
        }
          
          System.out.println();
    }

    private static int evaluateExpression(String s, int i, int j, boolean isTrue) {
      
        if (i==j) {
            if (isTrue) {
                return s.charAt(i)=='T'?1:0;
            }else {
                return s.charAt(i)=='F'?1:0;
            }
        }
        int ans = 0;
        for (int k = i+1; k <= j-1; k=k+2) {
           
            int lf = evaluateExpression(s,i,k,false);
            int lt = evaluateExpression(s, i, k, true);
            int rf = evaluateExpression(s, k+1, j, false);
            int rt = evaluateExpression(s, k+1, j, true);
            
            if (s.charAt(k)=='|') {
                if (isTrue) {
                    ans = ans + lt*rt + lt*rf + lf*rt;
                }else {
                    ans = ans + lf*rf;
                }
            }else if (s.charAt(k)=='&') {
                if (isTrue) {
                    ans = ans + lt*rt;
                }else {
                    ans = ans + lf*rf + lt*rf + lf*rt;
                }
            }else {
                if (isTrue) {
                    ans = ans + lt*rf + lf*rt;
                }else {
                    ans = ans + lf*rf  + lt*rt;
                }
            }
            
        }
        
        return ans;
    }

  
    private static int palidromePartition(String arr, int i, int j) {
        
        int ans = Integer.MAX_VALUE;
        if(ispalidrome(arr,i,j)) {
            list.add(arr.substring(i, j+1));
//            return 0; 
        }
        if (j-i<1) {
            return 0;
        }

        if (mat[i][j]!=-1) {
            return mat[i][j];
        }
        
        for (int k = i; k <= j-1; k++) {
            mat[i][j] = palidromePartition(arr, i, k) + palidromePartition(arr, k+1, j) + 1;
            ans  = Math.min(ans, mat[i][j]);
        }
        
        return ans;
    }


    private static boolean ispalidrome(String arr, int i, int j) {
        
       while (j>=i) {
           if (arr.charAt(i)==arr.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
       }
        return true;
    }


    private static int mcm(int[] arr, int i, int j) {
        int ans = Integer.MAX_VALUE;
        if (j-i<1) {
            return 0;
        }
        
        if (mat[i-1][j-1]!=-1) {
            return mat[i-1][j-1];
        }
        
        for (int k = i; k <= j-1; k++) {
            mat[i-1][j-1] = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            ans= Math.min(mat[i-1][j-1], ans);
        }
        return ans;
    }
    
}
