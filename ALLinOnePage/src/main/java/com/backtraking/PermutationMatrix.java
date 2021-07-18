package com.backtraking;

public class PermutationMatrix {
   static  int ans = 0;
    public static void main(String[] args) {
        
        printit(4);
        
    }

    private static void printit(int i) {
        int[][] mat = new int[i][i];
        
        printit2(mat,4,0);
        System.out.println(ans);
    }

    private static void printit2(int[][] mat, int k, int in) {
        
        if (in == k) {
            if (in == k) {
                ans++;
                for (int l = 0; l < mat.length; l++) {
                    for (int l2 = 0; l2 < mat.length; l2++) {
                        System.out.print(mat[l][l2]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }
        
        for (int l = 0; l < mat.length; l++) {
            for (int l2 = 0; l2 < mat.length; l2++) {
                if (mat[l][l2] == 0) {
                    mat[l][l2] = 1;
                    printit2(mat,k, in+1);
                    mat[l][l2] = 0;
                }
            }
        }
        
        
    }
}


























