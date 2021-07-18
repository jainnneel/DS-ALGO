package com.backtraking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintPermutation {
    
    public static void main(String[] args) {
//        Set<String> anSet = new HashSet<>();
//        
//        List<String> subseq = new ArrayList<>();
//        subseq("AAABBC","",subseq);
//        
//            for (String s : subseq) {
//                Map<Character, Integer> map = new HashMap<>();
//                for (Character ch : s.toCharArray()) {
//                    map.put(ch, map.getOrDefault(ch, 0)+1);
//                }
//                if(s.length() > 0) numTilePossibilities(0,"",map,s.length(),anSet);
//            }
//        System.out.println(anSet.size());
        int nums[] = {1,2,3};
        permute(nums);
//        getHappyString(3,3);
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        List<Integer> curr = new ArrayList<>();
        
        printIt(map,nums,nums.length,ll,curr);
        
        return ll;
    }
    
    void printIt(Map<Integer,Integer> map,int[] nums,int n,List<List<Integer>> ll,List<Integer> curr){
        
        if(curr.size() == nums.length){
            List<Integer> lc = new ArrayList<>(curr);
            ll.add(curr);
            return;
        }  
        
        for(int num : nums){
            if(map.get(num) > 0){
                map.put(num, map.get(num) - 1);
                curr.add(num);
                printIt(map,nums,n,ll,curr);
                curr.remove(curr.size()-1);
                map.put(num, map.get(num) + 1);
            }
        }
    }
    
    public static String getHappyString(int n, int k) {
        List<String> permute = new ArrayList<>();
        char arr[] = {'a','b'};
        Map<Character,Integer> map = new HashMap<>();
        for (Character ch : arr) {
              map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        allpermute(3,map,permute,0,"",0,0);
        System.out.println(permute);
        return permute.get(k);
    }
    
    static void allpermute(int n,Map<Character,Integer> map,List<String> permute ,int in,String out,int curr,int ts){
        if(in == n ){
            if(ts == 2) {
                permute.add(out);
            }
            return;
        }
        if(curr >= n){
            return;
        }
        for(Character ch : map.keySet()){
//                if(out.length() == 0) {
//                    allpermute(n,map,permute,in+1,out+ch,curr+1);
//                }
//                if(out.length()>0 && ch != out.charAt(out.length()-1)){
//                    allpermute(n,map,permute,in+1,out+ch,curr+1);
//                }
            if(map.get(ch) > 0) {
                map.put(ch,map.get(ch) - 1);
                allpermute(n,map,permute,in+1,out+ch,curr+1,ts+1);
                map.put(ch,map.get(ch) + 1);
            }else {
                allpermute(n,map,permute,in+1,out+"-",curr+1,ts);
            }
          }
            
    }
    
    
 public static List<List<Integer>> permute(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer ch : nums) {
              map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        if(nums.length > 0) numTilePossibilities(0,map,nums.length,l,ll);
        return ll;
    }
    
 
 
    public static void numTilePossibilities(int count,Map<Integer, Integer> map,int n,List<Integer> l,List<List<Integer>> ll) {
        if (n <= count) {
            List<Integer> aIntegers = new ArrayList<>(l);
            ll.add(aIntegers);
            return;
        }
        for (Integer ch : map.keySet()) {
            if (map.get(ch)>0) {     
                map.put(ch, map.get(ch)-1);
                l.add(ch);
                numTilePossibilities(count+1,map,n,l,ll);
                l.remove(l.size()-1);
                map.put(ch, map.get(ch)+1);
            }
        }
    }
    
    public static void numTilePossibilities(int count,String ans,Map<Character, Integer> map,int n,Set<String> anSet) {
        if (n <= count) {
           anSet.add(ans);
            return;
        }
        for (Character ch : map.keySet()) {
            if (map.get(ch)>0) {
                map.put(ch, map.get(ch)-1);
                numTilePossibilities(count+1,ans+ch,map,n,anSet);
                map.put(ch, map.get(ch)+1);
            }
        }
    }
    
    static void  subseq(String in,String out,List<String> sub) {
        if (in.length()==0) {
            sub.add(out);
            return;
        }
        
        String out1 = out;
        String out2 = out + in.charAt(0);
       
        subseq(in.substring(1), out1, sub);
        subseq(in.substring(1), out2, sub);
    
    }
}





