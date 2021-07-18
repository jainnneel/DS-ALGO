package com.preplacement;

public class RotateImage {

    public static void main(String[] args) {
        int[][] a = new int[][] {
            new int[] {1,2,3,4},
            new int[] {5,6,7,8},
            new int[] {9,10,11,12},
            new int[] {13,14,15,16},
            
        };
        int[][] a2 = new int[][] {
            new int[] {1,2,3},
            new int[] {4,5,6},
            new int[] {7,8,9},
            
        };
        rotate(a);
//        rotatewithoutextraspace(a);
    }
    
    private static void rotatewithoutextraspace(int[][] ans) {
        //transpose
        for (int i = 0; i < ans.length; i++) {
            for (int j = i; j < ans[0].length; j++) {
                if (i!=j) {
                        int temp= ans[i][j];
                        ans[i][j] = ans[j][i];
                        ans[j][i] = temp;
               }
            }
        }
        //flip
        for (int i = 0; i < ans.length/2; i++) {
                for (int j = 0; j < ans.length; j++) {
                    int temp= ans[j][i];
                    ans[j][i] = ans[j][ans.length-1-i];
                    ans[j][ans.length-1-i] = temp;
                }
        }
        
        System.out.println();
    }

    public static void rotate(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length]; 
        
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[j][ans.length-1-i] = matrix[i][j];
            }
        }
        System.out.println();
    }
}
