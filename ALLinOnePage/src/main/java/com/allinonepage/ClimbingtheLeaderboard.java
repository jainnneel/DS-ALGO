package com.allinonepage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class ClimbingtheLeaderboard {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(100 ,90 ,90 ,80 ,75 ,60));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(50 ,65, 77 ,90, 102));
        
        climbingLeaderboard(list,list1);
        climbingLeaderboard1(list,list1);
    }
    
    public static List<Integer> climbingLeaderboard1(List<Integer> ranked, List<Integer> player) {
        List<Integer> ans = new ArrayList<>(); 
        Deque<Integer> stack = new ArrayDeque<>(); 
        
//        Stack<Integer> stack = new Stack<>();
        
        for(Integer integer : ranked ) {
           if(!stack.contains(integer)) {
               stack.push(integer);
           }
        }
        
        for(int i = 0; i < player.size() ; i++) {
            while (!stack.isEmpty() && player.get(i)>=stack.peek()) {
                stack.pop();
            }
            stack.push(player.get(i));
            ans.add(stack.size());
        }
        
        
        return ans;
     }
    
    
    
    
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
           List<Integer> ans = new ArrayList<>(); 
           List<Integer> rank = new ArrayList<>(); 
           int count = 1;
           rank.add(count);
           for (int i = 0; i < ranked.size()-1; i++) {
               if (ranked.get(i)!=ranked.get(i+1)) {
                   rank.add(count+=1);
               }else {
                   rank.add(count);
            }
           }
           
           for (int i = 0; i < player.size(); i++) {
               
               for (int j = ranked.size()-1; j >= 0; j--) {
                
                   if (player.get(i)>=ranked.get(j)) {
                       continue;
                   }else {
                       if (ranked.size()-1 == j) {
                           ans.add(rank.get(j)+1);
                    }else {
                        ans.add(rank.get(j)+1);
                    }
                       break;
                }
            }
        }
           if (player.get(player.size()-1)>ranked.get(0)) {
               ans.add(1);
           }
           
           return ans;
        }

}
//int results[] = new int[alice.length];
//int rank = 1;
//int rankScore = scores[0];
//
//for (int a = alice.length - 1, s = 0; a >= 0; a--) {
//  if (alice[a] < rankScore) {
//      for (; s < scores.length; s++) {
//          if (scores[s] < rankScore) {
//              rank++;
//              rankScore = scores[s];
//          }               
//          if(alice[a] >= scores[s]) break;
//      }
//  }
//
//  results[a] = s == scores.length ? rank + 1 : rank;
//}
//
//return results;

