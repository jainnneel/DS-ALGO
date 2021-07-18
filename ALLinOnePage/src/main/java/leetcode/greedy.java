package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class greedy {

    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();

            int a[] = new int[m];
            Integer b[] = new Integer[n];
            
            for(int i = 0; i< m;i++){
                a[i] = sc.nextInt();
            }
            
            for(int i = 0; i< n;i++){
                b[i] = sc.nextInt();
            }
            
            Arrays.sort(a);
            Arrays.sort(b,(p,y) -> y-p);
            
            int john = 0;
            for(int i : a){
                john += i; 
            }
            int jack = 0;
            for(int i : b){
                jack += i; 
            }
            int l = 0;
            int ans = 0;
            while(john <= jack && l < m && l < n){
                john  = john - a[l] + b[l];
                jack = jack - b[l] + a[l];
                int temp = a[l];
                a[l] = b[l];
                b[l] = temp;
                
                ans++;
                l++;
            }
            if(john > jack){
                System.out.println(ans);
            }else{
                System.out.println(-1);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
//        int[] a = {1,2};
//        int s[] = {1,2,3};
////         minSubsequence(a);
////        System.out.println( lastStoneWeight(a));
////        System.out.println(numWaterBottles(15, 4));
////          System.out.println(largestSumAfterKNegations(a,5));
////        System.out.println(findContentChildren(a,s));
//        int b[] = {5,5,5,5,20,20,5,5,20,5};
////        lemonadeChange(b);
//        reinitializePermutation(4);
    }
    
    
    public static int reinitializePermutation(int n) {
        
        System.out.println(Integer.highestOneBit(50));

        int[] prem = new int[n];
        
        for(int i = 0; i < n; i++){
            prem[i] = i;
        }
        
        int[] temp = Arrays.copyOf(prem,n);
        
        for(int i = 0; i < n; i++){
            if(i%2==0){
                temp[i] = prem[i/2];
            }else{
                temp[i] = prem[n/2 + (i-1)/2];
            }
        }
        int ans = 1;
        while(!check(prem,temp)){
            int[] temp1 = Arrays.copyOf(temp,n);
             for(int i = 0; i < n; i++){
                if(i%2==0){
                    temp1[i] = temp[i/2];
                }else{
                    temp1[i] = temp[n/2 + (i-1)/2];
                }
             }
             temp = Arrays.copyOf(temp1, n);
            ans++;
        }
        return ans;
        
    }
    static boolean  check(int[] prem,int[] temp){
            int  i = 0;
            for(int pre : prem){
                if(temp[i] != pre){
                    return false;
                }
                i++;
            }    
            return true;
        }
    
    public static boolean lemonadeChange(int[] b) {
        int a[] = new int[2];
        for(int i = 0;i<b.length;i++){
            if(b[i]==5){
                a[0]++;
            }else if(b[i]==10){
                if(a[0]==0) return false;
                a[0]--;
                a[1]++;
            }else{
                if (a[1]==0) {
                    if (a[0]>2) {
                        a[0]=a[0]-3;
                    }else {
                        return false;
                    }
                }else {
                    if(a[0]==0) return false;
                    else a[1]--;a[0]--;
                }
            }
        }
        return true; 
     }
   
    public static int numWaterBottles(int nb, int ne) {
        int ans = 0;
        ans = nb;
        while(nb>=ne){
            int i = nb/ne;
            int m = nb%ne;
            ans+=i;
            nb = i+m;
        }
        return ans;
    }
    
    public static List<Integer> minSubsequence(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
        int sum = 0;
        
        for(int i:nums){
            sum+=i;    
        }
        int lsum = 0;
        // list.add(nums[0]);
        // sum-=nums[0];
        for(int i =nums.length-1;i>=0;i--){
            if(lsum<=sum){
                lsum+=nums[i];
                sum-=nums[i];
                list.add(nums[i]);
            }
        }
        return list;
        
    }
    public static int lastStoneWeight(int[] stones) {
//        List<Integer> sl = IntStream.of(stones) 
//                                    .boxed() 
//                                    .collect(Collectors.toList()); 
        int ans = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->o1>o2?-1:1);
        for(Integer i: stones) {
            priorityQueue.add(i);
        }
        while (priorityQueue.size()>1) {
            int i  = priorityQueue.remove();
            int j = priorityQueue.remove();
            
           if(i!=j) priorityQueue.add(Math.abs(i-j));
        }
        if(priorityQueue.size()>0) ans= priorityQueue.remove(); 
        return ans; 
               
  }
    public static int largestSumAfterKNegations(int[] a, int k) {
        int sum = 0;
        for(int ij:a){
            sum+=ij;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->o1>o2?1:-1);
        for(Integer i: a) {
            priorityQueue.add(i);
        }
        
        while (k-- >0) {
            Integer remove = priorityQueue.remove();
            priorityQueue.add(-remove);
            sum+=remove*(-2);
        }
        return sum;
    }
    
    public static int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->o1>o2?-1:1);
        for(Integer i: s) {
            priorityQueue.add(i);
        }
        for(int i=g.length-1;i>=0;i--) {
            if (g[i]<=priorityQueue.peek()) {
                int remove = priorityQueue.remove();
                priorityQueue.add(remove-g[i]);
                ans++;
            }
        }
        
        return ans;
    }
}
















