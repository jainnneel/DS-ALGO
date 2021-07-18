package com.backtraking;

public class Nqueen {

    public static void main(String[] args) {
    
        boolean[] col = new boolean[4]; 
        boolean[] normal = new boolean[7];
        boolean[] revese = new boolean[7];
        
        boolean[][] board = new boolean[4][4];
        
        findIt(board,col,normal,revese,0,"");
    
    }

    private static void findIt(boolean[][] board, boolean[] cols, boolean[] normal, boolean[] revese,int row,String asf) {
        
        if(row == 4) {
            System.out.println(asf+".");
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            
            if (!cols[col] && !normal[row + col] && !revese[row - col + 4 - 1] ) {
                board[row][col] = true;
                cols[col] = true;
                normal[row + col] = true;
                revese[row - col + 4 - 1] = true;
                findIt(board, cols, normal, revese, row+1, asf+" "+row+"-"+col);
                board[row][col] = false;
                cols[col] = false;
                normal[row + col] = false;
                revese[row - col + 4 - 1] = false;
            }
            
        }
        
        
    }

   
    
    
}
