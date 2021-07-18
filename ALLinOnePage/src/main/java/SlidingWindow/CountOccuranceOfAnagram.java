package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CountOccuranceOfAnagram {

    public static void main(String[] args) {
//        countIt("cbaebabacd","abc");
        minValue("egsdhatazqwtlkokhllblvcikppyrbhvkbaretudmsyxcmjkyunlqptagiaymivwlwpprlvddtdggmsghhrxxkzfvadhkbfvxu",88);
    }
    
    static class pair{
        int key;
        int value;
        
        pair(int key,int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "pair [key=" + key + ", value=" + value + "]";
        }
    }
    
    static int minValue(String s, int k){
        Map<Character,Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<pair> qu = new PriorityQueue<>((p1,p2) -> p1.value - p2.value);
        
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            qu.add(new pair(e.getKey(),e.getValue()));
        }
        
        while(k > 0){
            pair p = qu.poll();
            if(p.value >= 1){
                p.value = p.value - 1;
                qu.add(p);
                k--;
            }
        }
        
        int ans = 0;
        
        while(qu.size() > 0){
            ans = ans + (int)Math.pow(qu.poll().value,2);
        }
        
        return ans;
    }

    private static void countIt(String s, String p) {
      
        int k = p.length();
        int count = 0; 
        int j  = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : p.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0)+1);
            count++;
        }
        int ans = 0;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < s.length()-k+1; i++) {
            
            while (j<i+k) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
                if (map.get(s.charAt(j))==0) {
                    count--;
                }
                j++;
            }
            
            if(count==0) {
                ansList.add(i);
//                ans++;
            }
            
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+ 1);
            if(map.get(s.charAt(i))==1) {
                count++;
            }
        
        }
        System.out.println(ans);
    }
}











