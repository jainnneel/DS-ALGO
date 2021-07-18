package codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PilgrimsDestination {

    static class Pair{
        int key;
        int value;
        public Pair(int key, int value) {
            super();
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            return "Pair [key=" + key + ", value=" + value + "]";
        }
    }

    private static int findGcd(int i, int j) {
        
        if(j == 0) {
            return i;
        }
        
        if( i == 0) {
            return j;
        }
        
        
        if(i == j) {
            return i;
        }
        
        if(i > j)
            return findGcd(i-j,j);
        else 
            return findGcd(i,j-i);
    }
    static boolean findIt(int i,int j){
        if(findGcd(i,j)!=1){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        
        System.out.println(findGcd(4,6));
        
    Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            for(int j = 2;j < 50;j++){
                boolean re = true;
                for(int i=l;i<=r;i++){
                   if(!findIt(i,j)){
                       re = false;
                       break;
                   }
                }
                if(re){
                   System.out.println(j); 
                   break;
                }
            }
           
        }
        
        
        int n = 6;
        Map<Integer, List<Pair>> map = new HashMap<>();
            
//        Scanner sc = new Scanner(System.in);
        
        int node = sc.nextInt();
        
        while(node-- > 1) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int val = sc.nextInt();
            
            List<Pair> list = map.get(src);
            if(list!=null) {
                list.add(new Pair(dest, val));
                map.put(src,list);
            }else {
                list = new ArrayList<>();
                list.add(new Pair(dest, val));
                map.put(src, list);
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        findIt(map,ans,1, 0,map.get(1));
        
        int[] m = {100 ,20, 10 ,50};
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(Integer integer : ans) {
            max = Math.max(max, integer);
            min = Math.min(min,integer);
        }
        int ans1 = 0;
        
        for (int i  : m) {
            if (i >= min && i <= max) {
                ans1++;
            }
        }
        if (ans1 > ans.size()) {
            System.out.println(ans.size());
        }else {
            System.out.println(ans1);
        }
        
        
        
    }


    private static void findIt(Map<Integer, List<Pair>> map, List<Integer> ans, int dist,int curr,List<Pair> lis) {
            
            if(lis  == null) {
                ans.add(curr);
                return;
            }
        
           for (Pair ent : lis) {
               curr = curr + dist * ent.getValue();
               findIt(map, ans, dist + 1, curr, map.get(ent.key));
               curr = curr - dist * ent.getValue();
           }
    }
}

























