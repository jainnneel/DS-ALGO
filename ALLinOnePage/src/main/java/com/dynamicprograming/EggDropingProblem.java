package com.dynamicprograming;

public class EggDropingProblem {
    
    static int[][] mem = new int[4][7];
    
    public static void main(String[] args) {
    
        double mind = 42.0;
        double hrd = 243.5;
        System.out.println(360 - (42 - 243.5));
        System.out.println(Math.abs(Math.min( Math.abs(mind - hrd), Math.abs(360 - (mind - hrd)))));;
        
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                mem[i][j] = -1;
            }
        }
        
        System.out.println(findFloor(3,6));
    }

    private static int findFloor(int e, int f) {
        
        if (mem[e][f]!=-1) {
            return mem[e][f];
        }
        
        if(f == 0 || f== 1) {
            return f;
        }
        
        if(e == 1) {
            return f;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            int temp = 1 + Math.max(findFloor(e-1, i-1), findFloor(e, f - i));
            min = Math.min(temp , min);            
        }
        
        return mem[e][f] = min;
    }
    
    
}
