package leetcode;

import java.util.Arrays;

public class TwoPointers {

    public static void main(String[] args) {
        int a[] = {1,2,3,0,0,0};
        int b[] = {2,5,6};
//        moveZeroes(a);
//        removeDuplicates(a);
//        reverseVowels("leetcode");
        merge(a, 3, b, 3);
    }
    
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
      int[] temp = new int[m+n];
      while(i<nums1.length-nums2.length && j<nums2.length){
          
          if(nums1[i]<=nums2[j]){
              temp[k++] = nums1[i];
              i++;
          }else{
              temp[k++] = nums2[j];
              j++;
          }
      }
      StringBuilder s = new StringBuilder();
      
      if(j==nums2.length){
              while(i<nums1.length ){
                  temp[k++] = nums1[i];
              }    
      }else{
              while(j<nums2.length ){
                  temp[k++] = nums2[j++];
                  
              }
      }
      nums1 = Arrays.copyOf(temp, m+n);
  }
    
    
    public static String reverseVowels(String s) {
        char[] sa = s.toCharArray();
        for(int i = 0,j=sa.length-1;i<sa.length/2;i++,j--){
               while(!(sa[i]=='a' || sa[i]=='e' || sa[i]=='i' || sa[i]=='o' || sa[i]=='u' || sa[i]=='A' || sa[i]=='E' || sa[i]=='I' || sa[i]=='O' || sa[i]=='U')){
                 if (i>=sa.length/2-1 && j<=sa.length/2+1) {
                    break;
                }
                 i++;
             }
             while(!(sa[j]=='a' || sa[j]=='e' || sa[j]=='i' || sa[j]=='o' || sa[j]=='u' || sa[j]=='A' || sa[j]=='E' || sa[j]=='I' || sa[j]=='O' || sa[j]=='U')){
                 if (i>=sa.length/2-1 && j<=sa.length/2+1) {
                     break;
                 }
                 j--;
             }
             if (i<sa.length/2) {
                 char temp = sa[i];
                 sa[i] = sa[j];
                 sa[j] = temp;
            }
        }
        return String.valueOf(sa);
    }
    
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
//                int temp = nums[j];
                nums[j] = nums[i+1];
//                nums[i+1] = temp;
                j++;
            }
        }
        
        nums = Arrays.copyOf(nums,j);
        return j;
    }
    
    public static void moveZeroes(int[] a) {
        
        for(int i=0;i<a.length;i++){
             if(a[i]==0){
                 for(int j = i;j<a.length-1;j++){
                     int temp = a[j];
                     a[j] = a[j+1];
                     a[j+1] = temp;
                 }
             }
        }
    }
    public int[] sortedSquares(int[] nums) {
        int sq[] = new int[nums.length];
        int k = 0;
        for(int i:nums){
            sq[k++] = Integer.valueOf((int) Math.pow(i,2));
        }
        Arrays.sort(sq);
        return sq;
    }
}
