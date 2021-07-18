package com.backtraking;

public class CombinationInMatrix {

    public static void main(String[] args) {
        
        printit(4);
    }

    private static void printit(int i) {
        
        int[][] mat = new int[i][i];
        
        printit2(mat,0,"",0,0,4);
        
        
    }

    private static void printit2(int[][] mat, int in, String out,int row,int col,int total) {
        
        if (row == mat.length) {
            if (in == total) {
                System.out.println(out);
            }
            return;
        }
        
        String nic = "";
        String inc = "";
        
        
        if(col == mat.length-1) {
            row = row + 1;
            col = 0;
            nic = out + "-\n";
            inc = out + "q\n";
        }else {
            col = col + 1;
            nic = out + "-";
            inc = out + "q";
        }
        
        
        
        printit2(mat,in,nic,row,col,total);
        printit2(mat,in+1,inc,row,col,total);
        
        
    }
    
    
}
