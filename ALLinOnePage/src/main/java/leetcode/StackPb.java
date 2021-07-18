package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackPb {

    public static void main(String[] args) {
//        removeOuterParentheses("(()())(())(()(()))");
//        removeDuplicates("abbaca");
        int target[] = {1,3};
//        buildArray(target, 3);
        int n1[] = {4,1,2};
        int n2[] = {1,3,4,2};
//        nextGreaterElement(n1, n2);
        String logs[] = {"d1/","d2/","../","d21/","./"};
        minOperations(logs);
    }
    
    public static int minOperations(String[] logs) {
        int count = 0;
        for(String s:logs){
            if(s.equals("../")) count--;
            else if(s.equals("./")) {}
            else count++;
        }
        return count;        
    }
    
    public static int[] nextGreaterElement(int[] n1, int[] n2) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i<n2.length;i++){
            map.put(n2[i],i);
        }
        int[] ans = new int[n1.length];
        int l = 0;
        for(int j = 0; j < n1.length ; j++){
            boolean b = false;
            for(int k = map.get(n1[j]);k<n2.length;k++){
                if(n1[j]<n2[k]){
                    b = true;
                    ans[l++] = n2[k];
                    break;
                }
            }
            if(!b) ans[l++]=-1;
        }
        return ans;        
    }
    
    public static List<String> buildArray(int[] target, int n) {
//        Deque<Integer> stack = new ArrayDeque<>();
        int k = 0;
        List<String> ans = new ArrayList<>();
        for(int i =1;i<=n && k<target.length;i++){
          if(i==target[k]){
              k++;
              ans.add("Push");
          }else{
              ans.add("Push");
              ans.add("Pop");
          }
        }
        return ans;
    }
    
    public static String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
               if(!stack.isEmpty())  stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder b = new StringBuilder();
        while(!stack.isEmpty()){
            b.append(stack.pollLast());
        }
        return String.valueOf(b);
    }
    
    
    public static String removeOuterParentheses(String S) {
     StringBuilder ans = new StringBuilder(); 
     if(S.isEmpty()) return "";
     int start = 0;
     int end = 0;
     Deque<Character> stack = new ArrayDeque<>();
     stack.push(S.charAt(0));
     for(int i = 1;i<S.length();i++) {
         char charAt = S.charAt(i);
        if (charAt=='(') {
            stack.push(charAt);
            end++;
        }else{
            if (!stack.isEmpty()) {
                stack.pop();
                end++;
            }
        }
        if (stack.isEmpty()) {
            ans.append(S.substring(start+1, end));
            start = end+1;
        }
     }
     
     return String.valueOf(ans);   
    }
}
