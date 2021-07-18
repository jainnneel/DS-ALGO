package com.allinonepage.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Celebrity {

    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {0,1,0},
            new int[] {0,0,0},
            new int[] {0,1,0}
        };
        celebrity(val,3);
    }
    
public static int evaluatePostFix(String s){
        Stack<String> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if((ch - 48) >= 0 && (ch - 48) <= 9){
                st.push(ch+"");
            }else{
                String ch2 = st.pop();
                String ch1 = st.pop();
                int temp = 0;
                if(ch == '+'){
                    temp = Integer.parseInt(ch1) + Integer.parseInt(ch1);
                }else if(ch == '-'){
                    temp = Integer.parseInt(ch1) - Integer.parseInt(ch1);
                }else if(ch == '*'){
                    temp = Integer.parseInt(ch1) * Integer.parseInt(ch1);
                }else{
                    temp = Integer.parseInt(ch1) / Integer.parseInt(ch1);
                }
                st.push(temp+"");
            }
        }
        return Integer.parseInt(st.pop());
    }
    static int celebrity(int m[][], int n){
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                if(m[i][j] == 1){
                    if (map.get(j)!=null) {
                        map.put( j , map.get(j)+1);
                    }else {
                        map.put( j , 1);
                    }
                    
                }
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == n-1){
                return key;
            }
        }
        return -1;
         
    }
}
