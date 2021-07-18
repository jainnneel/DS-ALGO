package com.backtraking;

import java.util.ArrayList;
import java.util.List;

public class PrintCombination {

    public static void main(String[] args) {
//        ptintit("abc",3,2,0,"",0);
        int[] arr = {1,2,3,4,5,6,7,8,9}; 
        printCombination(arr, 5, 3);
        
//        combine(4,2);
//        combinationSum(arr,45);
    }
     
 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> curr = new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        findit11(candidates,target,ans,curr,0,0,9);
        
        return ans;
    }
    
 static void findit11(int[] input, int tg, List<List<Integer>> ans,List<Integer> curr,int in,int csum,int k){
     
     if(tg == csum &&  k == curr.size()){
         
         List<Integer> list = new ArrayList<>(curr);
         curr = new ArrayList<>(curr);
         ans.add(list);
         
         return;
     }
    if(tg < csum || in >= input.length){
        return;
    }
    
        curr.add(input[in]);
        csum = csum  + input[in];
        findit11(input,tg,ans,curr,in+1,csum,k);
        curr.remove(curr.size()-1);
        csum = csum - input[in];;
        findit11(input,tg,ans,curr,in+1,csum,k);
   
    
}
 
 static void findit(int[] input, int tg, List<List<Integer>> ans,List<Integer> curr,int in,int csum){
        
         if(tg == csum ){
             
             List<Integer> list = new ArrayList<>(curr);
             curr = new ArrayList<>(curr);
             ans.add(list);
             
             return;
         }
        if(tg < csum || in >= input.length){
            return;
        }
        
        if(input[in] + csum <= tg) {
            curr.add(input[in]);
            csum = csum  + input[in];
            findit(input,tg,ans,curr,in,csum);
            curr.remove(curr.size()-1);
            csum = csum - input[in];;
            findit(input,tg,ans,curr,in+1,csum);
        }else{
            int tm = 0;    
            if(curr.size() > 0) {
                    tm = curr.get(curr.size()-1);
                    curr.remove(curr.size()-1);
                }
            
            csum = csum - tm;
            findit(input,tg,ans,curr,in+1,csum);
        }
        
    }
    
public static List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i);
        }
        ptintit(sb,ans,n,k,0,"");
        return ans;   
    }
    
    static void ptintit(StringBuilder sb,List<List<Integer>> ans,int n,int k,int in,String out){
        
        
        if(k == out.length()){
            
            List<Integer> chs = new ArrayList<>();
            
            for(char i : out.toCharArray()){
                chs.add(i - 48);
            }
            
            ans.add(chs);
            return;
        }
        if(in >= n){
            return;
        }
        
        String out1 = out + sb.charAt(in);
        String out2 = out;
        
        ptintit(sb,ans,n,k,in+1,out1);
        ptintit(sb,ans,n,k,in+1,out2);
        
    }
    
    private static void ptintit(String s, int n, int r, int in, String out, int l) {
        if(in == r) {
            System.out.println(out);
            return;
        }
        
        if (l >= n) {
            return;
        }
        
        ptintit(s, n, r, in+1, out + s.charAt(l), l+1);
        ptintit(s, n, r, in , out , l+1);
    }


    static void printCombination(int arr[], int n, int r) {
        int data[] = new int[r];
        
        combinationUtil(arr, n, r, 0, data, 0);
    }

    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        if (i >= n)
            return;

        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        combinationUtil(arr, n, r, index, data, i + 1);
    }

}
