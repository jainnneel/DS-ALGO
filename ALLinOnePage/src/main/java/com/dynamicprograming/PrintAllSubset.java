package com.dynamicprograming;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PrintAllSubset {

    public static void main(String[] args) {
        int[] a = {4,2,7,1,3};
        subsetsum(a,10);
    }

    private static void subsetsum(int[] a, int w) {
        
        boolean[][] mat = new boolean[a.length+1][w+1];
        
        for(int i = 0; i <= w; i++) {
            mat[0][i] = false;
        }
        for(int i = 0; i <= a.length; i++) {
            mat[i][0] = true;
        }
        
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                
                if(j >= a[i-1]) {
                    mat[i][j] = mat[i-1][j - a[i-1]] || mat[i-1][j];
                }else {
                    mat[i][j] = mat[i-1][j];
                }
                
            }
        }
        
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+"   ");
            }
            System.out.println();
        }
        
        printAll(mat,a,w);
        System.out.println();
        
        
    
    }
    
    static class res{
        int i;
        int j;
        int w;
        public int getI() {
            return i;
        }
        public void setI(int i) {
            this.i = i;
        }
        public int getJ() {
            return j;
        }
        public void setJ(int j) {
            this.j = j;
        }
        public int getW() {
            return w;
        }
        public void setW(int w) {
            this.w = w;
        }
        public res(int i, int j, int w) {
            super();
            this.i = i;
            this.j = j;
            this.w = w;
        }
        @Override
        public String toString() {
            return "res [i=" + i + ", j=" + j + ", w=" + w + "]";
        }
        
    }

    private static void printAll(boolean[][] mat,int[] a, int w) {
        
        Queue<res> que = new LinkedList<>();
        que.add(new res(mat.length-1, mat[0].length-1, a[mat.length-1-1]));
        while (!que.isEmpty()) {
            
            res ele = que.poll();
            
            
            
            
            if ( ele.getI()-1 >= 0  && ele.getJ() >= 0 && mat[ele.getI()-1][ele.getJ()]) {
                que.add(new res(ele.getI()-1, ele.getJ(), a[ele.getI()-2]));
            }
            if ( ele.getI()-1 >= 0 &&  ele.getJ() - ele.getW() >= 0 && mat[ele.getI()-1][ele.getJ() - ele.getW()]) {
                que.add(new res(ele.getI()-1, ele.getJ() - ele.getW(), a[ele.getI()-2]));
            }
            
        }
        
        
        
    }
}
















