package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class Cricket {
    private static int findAnswer(int[][] shorts, int[][] players) {
        int ans = 0;
        List<Integer> answers = new ArrayList<>();
        System.out.println(shorts.length+"--"+players.length);
        for (int i = 0; i < players.length; i++) {
            int count = 0; 
            for (int j = 0; j < shorts.length; j++) {
                if (((players[i][1]-shorts[j][0]>=0) && (players[i][0]-shorts[j][0]<=0)) ||
                        ((players[i][0]-shorts[j][1]<=0) && (players[i][0]-shorts[j][0]>=0)) ||
                            ((players[i][1]-shorts[j][1]>=0) && (players[i][0]-shorts[j][0]<=0))) {
                    count++;
                }
            }
            answers.add(count);
        }
        for (Integer integer : answers) {
            ans+=integer;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] shorts = new int[][] {
            new int[] {1,2},
            new int[] { 2,3},
            new int[] {4,5},
            new int[] {6,7}
        };
        
        int[][] players = new int[][] {
            new int[] {1,5},
            new int[] { 2,3},
            new int[] {4,7},
            new int[] {5,7}
        };
        
        findAnswer(shorts,players);
    }

 
}
