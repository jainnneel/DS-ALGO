package com.backtraking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {5,3,-1,-1,7,-1,-1,-1,-1},
            new int[] {6,-1,-1,1,9,5,-1,-1,-1},
            new int[] {-1,9,8,-1,-1,-1,-1,6,-1},
            new int[] {4,-1,-1,8,-1,3,-1,-1,1},
            new int[] {7,-1,-1,-1,2,-1,-1,-1,6},
            new int[] {-1,6,-1,-1,7,-1,2,8,-1},
            new int[] {-1,-1,-1,4,1,9,-1,-1,5},
            new int[] {-1,-1,-1,-1,8,-1,-1,7,9},
        };
        
//        solveIt(val);
        int[] w = {3,3,3,3,3,1,3};
        check(w);
    }
    
    

    private static void check(int[] g) {
        
        String string = "neel";
        System.out.println(string.lastIndexOf('e'));
        
        Map<Integer,List<Integer>> map = new TreeMap<>();
        
        for(int i = 0; i < g.length; i++){
            List<Integer> l = map.getOrDefault(g[i],new ArrayList<>());
            l.add(i);
            map.put(g[i],l);
        }
        System.out.println();
    }



    private static void solveIt(int[][] val) {
        
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val.length; j++) {
                    if (val[i][j] == -1) {
                        solve(val,i-1,j);
                        solve(val,i,j+1);
                        solve(val,i+1,j);
                        solve(val,i,j-1);
                    }
            }
        }
        System.out.println();
        
        
    }

    private static void solve(int[][] val, int i, int j) {
            
        if (i < 0 || j < 0 || i >= val.length || j >= val.length) {
            return;
        }
        
        for (int j2 = 1; j2 <= 9; j2++) {
            if (val[i][j] == -1) {
                val[i][j] = j2;
               if (checkForRow(val,i) ||
                   checkForColumn(val,j) ||
                   checkBox(val,i,j)) {
                   solve(val,i-1,j);
                   solve(val,i,j+1);
                   solve(val,i+1,j);
                   solve(val,i,j-1);
            }else {
                val[i][j] = -1;
            }
               
                
            }
        }
        
    }

    private static boolean checkForColumn(int[][] val, int j) {
        
        boolean[] v = new boolean[9];
        
        for (int i = 0; i < v.length; i++) {
            if (val[j][i]!=-1 && !v[val[0][j]-1]) {
                v[val[0][j]-1] = true;
            }else {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!v[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForRow(int[][] val, int j) {
        boolean[] v = new boolean[9];
        
        for (int i = 0; i < v.length; i++) {
            if (val[j][i]!=-1 && !v[val[j][i]]) {
                v[val[j][i]] = true;
            }else {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!v[i]) {
                return false;
            }
        }
        return true;
        
    }

    private static boolean checkBox(int[][] val, int i , int j) {
        
        int r1 =  i - (i%3);
        int r2 = r1 + 2;
        
        int c1 = j - (j%3);
        int c2 = c1 + 2;
        boolean[] v = new boolean[9];
        for (int k = r1; k <= r2; k++) {
            for (int k2 = c1; k2 <= c2; k2++) {
                if (val[k][k2]!=-1 && !v[val[k][k2]]) {
                    v[val[k][k2]] = true;
                }else {
                    return false;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            if (!v[k]) {
                return false;
            }
        }
        return true;
        
    }
}












