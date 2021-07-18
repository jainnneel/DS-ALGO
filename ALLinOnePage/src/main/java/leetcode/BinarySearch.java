package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearch {

    public static void main(String[] args) {
    System.out.println(Long.toBinaryString(Long.valueOf("4294967295")));
        int[] a = {1,2,2,1};
        int[] b = {2,2}; 
//        System.out.println(peakIndexInMountainArray(a));
//          System.out.println(intersection(a,b));
//        System.out.println(twoSum(a, 8));
//        System.out.println(isSubsequence("abc","ahbgdc"));
//        System.out.println(intersect(a,b));
    }
    
    public static int search(int[] ar, int a,int lows) {
        int low = lows;
       int high = ar.length-1;
       while(low<=high){
           int m = low + (high - low)/2;
           if(ar[m]==a) {
               return m;
           }
           else if(ar[m]>a) {
               high = m-1;
           }
           else if(ar[m]<a) {
               low = m+1;
           }
       }
       return -1;
   }
   
   public static int[] intersect(int[] n1, int[] n2) {
       Arrays.sort(n1);
       Arrays.sort(n2);
       List<Integer> ans = new ArrayList<>();
       int low = 0;
       for(int i = 0;i<n1.length;i++){
           int index = search(n2,n1[i],low);  
           if(index!=-1) {
               ans.add(n1[i]);
               low = index+1; 
           }
       }
       int k =0;
       int a[] = new int[ans.size()];
       for(int i:ans){
           a[k++] = i;
       }
       return a;
   }
    
    
    public static int search(char[] ar, char a,int lows) {
        int low = lows;
       int high = ar.length-1;
       while(low<=high){
           int m = low + (high - low)/2;
           if(ar[m]==a) {
               return m;
           }
           else if(ar[m]>a) {
               high = m-1;
           }
           else if(ar[m]<a) {
               low = m+1;
           }
       }
       return -1;
   }
   
   public static boolean isSubsequence(String s, String t) {
       int cur = -1;
       char[] ce = t.toCharArray();
       for(int i=0;i<s.length();i++){
           int index = search(ce,s.charAt(i),cur+1);
           if(index == -1) return false;
           cur = index;
       }
       return false;
   }
    
    public static int searcha(int a,int[] ar,int in){
        int low = 0;
        int high = ar.length-1;
        while(low<=high){
            int m = low + (high - low)/2;
            if(ar[m]==a) {
                return m+1;
            }
            else if(ar[m]>a) {
                high = m-1;
            }
            else if(ar[m]<a) {
                low = m+1;
            }
        }
        return 0;
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        for(int i=0;i<numbers.length;i++){
            int index =  searcha(target-numbers[i],numbers,i);
            if(index!=0){
                ans[0] = i;
                ans[1] = index==i?index+1:index;
            }
        }
        return ans;
    }
    
    public static boolean search(int a,int[] ar){
        int low = 0;
        int high = ar.length-1;
        while(low<=high){
            int m = low + (high - low)/2;
            if(ar[m]==a) return true;
            else if(ar[m]>a) high = m-1;
            else if(ar[m]<a) low = m+1;
        }
        return false;
    }
    
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> ans = new HashSet<>();
        
        for(int i = 0; i < nums1.length; i++){
                if(search(nums1[i],nums2)) ans.add(nums1[i]);
        }
        int a[] = new int[ans.size()];
        int k = 0;
        for(int i : ans) {
            a[k++] = i;
        }
        return a;
    }
    
    
    public static int peakIndexInMountainArray(int[] arr) {
//      int index = 0;
     
//      for(int i = 0; i< arr.length;i++){
//          if(arr[i]>arr[index]) index = i;
//      }
//      return index;
     
     int low = 0;
     int high = arr.length-1;
     
     while(low<=high){
         
         if(low==high || high-low==1){
             return arr[high]>arr[low]?high:low;
         }
         int mid = low + (high-low)/2;
         
         if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) return mid;
         
         if(arr[mid]>arr[mid-1]){
             low = mid+1;
         }else{
             high = mid-1;
         }
     }
     return 0;
 }
}
