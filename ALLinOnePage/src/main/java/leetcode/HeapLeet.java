package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapLeet {

    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {3,3},
            new int[] {5,-1},
            new int[] {-2,4}
        };
//        kClosest(val,2);
//        frequencySort("2a554442f544asfasssffffasss");
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(words,2);
    }
    
   static class Pair implements Comparator<Integer> {
        char ch;
        int value;
        
        public Pair(char ch, int value) {
            super();
            this.ch = ch;
            this.value = value;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1>o2) {
                return 1;
            }else {
                return -1;
            }    
        }
        
    }
   static class Pairs implements Comparator<Pairs> {
       String str;
       int value;
       
       public Pairs(String ch, int value) {
           super();
           this.str = ch;
           this.value = value;
       }

       @Override
       public int compare(Pairs o1, Pairs o2) {
           return o1.str.compareTo(o2.str);    
       }

    @Override
    public String toString() {
        return "Pairs [str=" + str + ", value=" + value + "]";
    }
       
   }
   public static List<String> topKFrequent(String[] words, int k) {
       PriorityQueue<Pairs> pairs = new PriorityQueue<>((o1,o2) -> o1.value>o2.value?1:-1);

       Map<String,Integer> map = new HashMap<>();
       for(String i : words){
           map.putIfAbsent(i,0);
           map.put(i,map.get(i)+1);
       }
       for(Map.Entry<String,Integer> entry:map.entrySet()){
           pairs.add(new Pairs(entry.getKey(),entry.getValue()));
           
           if(pairs.size()>k){
               pairs.poll();
           }
       }
       List<String> ans = new ArrayList<>();
       for(Pairs pair : pairs){
           ans.add(pair.str);
       }
       List<String> ans1 = new ArrayList<>();
       Collections.reverse(ans1);
       return ans;
   }
   
    public static String frequencySort(String s) {
        PriorityQueue<Pair> pairs = new PriorityQueue<>((p1,p2) -> p1.value>p2.value?-1:1);
        int[] fre = new int[52];
        for(char ch : s.toCharArray()){
             if(ch>=65 && ch<=90) fre[ch-65]++;
             else fre[ch-97+26]++;
        }
        for(int i =0;i<52;i++){
           if(fre[i]!=0 && i<26) pairs.add(new Pair((char)(i+'A'),fre[i]));
           else if(fre[i]!=0)  pairs.add(new Pair((char)(i+'a'-26),fre[i]));
        }
        StringBuilder s1 = new StringBuilder();
        while(!pairs.isEmpty()){
            Pair pr = pairs.poll(); 
            while(pr.value-- > 0){
                 s1.append(pr.ch);
            }
        }
        return String.valueOf(s1);
    }
     static class comaprator implements Comparator<Integer[]>{

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            if (o1[1]>o2[1]) {
                return -1;
            }else {
                return 1;
            }
        }
        
    }
    public static int[][] kClosest(int[][] p, int k) {
        int[][] ans = new int[k][2];
         PriorityQueue<Integer[]> pr = new PriorityQueue<>(new comaprator()); 
        for(int i = 0; i < p.length ; i++){
            int d = (int)Math.pow(Math.pow(p[i][0],2) + Math.pow(p[i][1],2),0.5);
            pr.add(new Integer[] {i,d});
            if (pr.size()>k) {
                pr.poll();
            }
        }
        int size = pr.size();
        for(int i = 0;i<size;i++) {
            Integer[] poll = pr.poll();
            ans[i] = p[poll[0]];
        }
        return ans;
    }
}
