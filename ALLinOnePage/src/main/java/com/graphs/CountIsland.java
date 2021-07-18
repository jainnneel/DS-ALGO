package com.graphs;

public class CountIsland {

    public static void main(String[] args) {
        int[][] a = new int[][] {
            new int[] {1,1,0,0,0},
            new int[] {1,1,0,0,0},
            new int[] {0,0,1,0,0},
            new int[] {0,0,0,1,1},
        };
        countisland(a,0,0,a.length,a[0].length);
    }

    private static void countisland(int[][] a, int i, int j, int m, int n) {
        int dist =0;
        if (m==0) {
            return;
        }
        
        for (int k = 0; k < a.length; k++) {
            for (int k2 = 0; k2 < a[i].length; k2++) {
                if (a[k][k2]==1) {
                    countislandutil(a, k, k2, m, n);
                    dist++;
                }
            }
        }
        System.out.println(dist);
    }

    private static void countislandutil(int[][] a, int k, int k2, int m, int n) {
        
        if (k<0 || k2<0 || k>=m || k2>=n || a[k][k2]==0 || a[k][k2]==2 ) {
            return;
        }
        a[k][k2] = 2;
        countislandutil(a,k,k2+1,m,n);
        countislandutil(a,k,k2-1,m,n);
        countislandutil(a,k+1,k2,m,n);
        countislandutil(a,k-1,k2,m,n); 
    }    
}
