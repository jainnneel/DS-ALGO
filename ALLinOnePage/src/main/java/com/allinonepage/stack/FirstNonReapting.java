package com.allinonepage.stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class FirstNonReapting {

    public static void main(String[] args) {
        findit("ftvbwnimpvvbfvtot");
        minValue("aabcbcbcabcc",3);
    }
    
    static int minValue(String s, int k){
        
        int[] fre = new int[26];
        
        for(char i : s.toCharArray()){
            fre[i - 'a']++;
        }
        
        PriorityQueue<Integer> prio = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: fre){
            prio.add(i);
        }
        
        while(k-- > 0 && !prio.isEmpty()){
            int i = prio.poll();
            prio.add(i-1);
        }
        int ans = 0;
        
        while(prio.size()>0){
            ans = ans + (int)Math.pow(prio.poll(),2);
        }
        return ans;
    }
    
    private static void findit(String string) {
       
        Deque<Character> deque = new ArrayDeque<>();
        
        StringBuilder builder = new StringBuilder();
        
        for (Character character : string.toCharArray()) {
            
            if (deque.isEmpty()) {
                deque.offer(character);
                builder.append(character);
            }else if( !deque.isEmpty() && deque.peekFirst() == character) {
                deque.poll();
                if (!deque.isEmpty()) {
                    builder.append(deque.peek());
                }else {
                    builder.append("#");
                }
            }else {
                deque.addLast(character);
                builder.append(deque.peek());
            }
        }
        System.out.println();
    }
}
