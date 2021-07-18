package com.backtraking;

public class SolveSudoku {

    public static void main(String[] args) {
        
        int[][] sudoku = {
                         {3, 0 ,6 ,5, 0, 8, 4 ,0 ,0},
                         {5 ,2, 0 ,0 ,0,0,0,0 ,0 },
                         {0 ,8, 7 ,0, 0, 0, 0 ,3 ,1},
                         {0 ,0 ,3 ,0, 1 ,0 ,0 ,8,0},
                         {9 ,0, 0 ,8 ,6 ,3 ,0 ,0, 5},
                         {0 ,5 ,0 ,0 ,9, 0, 6, 0, 0},
                         {1 ,3 ,0, 0 ,0 ,0 ,2, 5 ,0},
                         {0 ,0, 0 ,0, 0, 0, 0 ,7 ,4},
                         {0 ,0 ,5 ,2, 0 ,6, 3, 0 ,0}
                        };
        solveIt(sudoku);
        System.out.println();
        
    }

    private static void solveIt(int[][] sudoku) {
        
        psolve(sudoku,0,0);
        
    }

    private static boolean psolve(int[][] sudoku, int i, int j) {
        
        if( i == 9) {
            
            return true;
        }
        
        int ni,nj;
        
        if(j==sudoku.length - 1) {
            ni = i + 1;
            nj = 0;
        }else {
            ni = i;
            nj = j+1;
        }
        
                if(sudoku[i][j] == 0) {
                    for(int m = 1; m < 10; m++) {
                        if(isValid(sudoku,m,i,j)) {
                            sudoku[i][j]  = m;
                            if(psolve(sudoku, ni, nj)) {
                                return true;
                            };
                            sudoku[i][j]  = 0;
                        }
                    }
                }else {
                    if (psolve(sudoku, ni, nj)) {
                        return true;
                    }
                }
                return false;
    }

    private static boolean isValid(int[][] sudoku, int m, int i, int j) {
        
        
        for(int k = 0; k < 9; k++) {
            if(sudoku[i][k] == m) {
                return false;
            }
        }
        
        for(int k = 0; k < 9; k++) {
            if(sudoku[k][j] == m) {
                return false;
            }
        }
        
        int rows =  (i / 3) * 3;
        int rowe =  ((i + 3)/3) * 3;
        
        int cols = ( j / 3) * 3;
        int cole = ((j + 3)/ 3) * 3;
        
        for(int r = rows; r < rowe; r++) {
            for(int c = cols; c < cole; c++) {
                if(sudoku[r][c] == m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}




























