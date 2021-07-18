package com.dynamicprograming;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class AllPalidromicPartition {

    public static void main(String[] args) {
//        partition("sagar");
//        printAllPalidromic("nitin");
       int height[] = {4,1,4,10};
       int width[] = {6,2,5,12};
       int length[] = {7,3,6,32};
        maxHeight(height,width,length,4);
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        int[][] mat = new int[n][3];
        
        for(int i = 0; i < n ; i++){
            mat[i][0] = width[i];
            mat[i][1] = length[i];
            mat[i][2] = height[i];
        }
        
        Arrays.sort(mat,(a1,b1) -> a1[0] - b1[0] );
        
        System.out.println(String.valueOf(mat));
        
        return 0;
    }
    

    private static void printAllPalidromic(String string) {

        Deque<String> chars = new ArrayDeque<>();

        List<List<String>> list = new ArrayList<>();

        addllPalidrome(string, chars, list, 0, string.length());

        System.out.println();

    }

    private static void addllPalidrome(String str, Deque<String> chars, List<List<String>> list, int start, int end) {

        if (start >= end) {
            list.add(new ArrayList<>(chars));
            return;
        }

        for (int i = start; i < end; i++) {
            if (ispali(str, start, i)) {

                chars.addLast(str.substring(start, i + 1));

                addllPalidrome(str, chars, list, start + 1, end);

                chars.removeLast();
            }
        }

    }

    public static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 1) {
            List<String> l = new ArrayList<>();
            l.add(s);
            ans.add(l);
            return ans;

        }

        for (int i = 1; i <= s.length(); i++) {
            if (ispali(s, 0, i - 1)) {
                List<String> l = new ArrayList<>();
                l.add(s.substring(0, i));
                printAns(s.substring(i, s.length()), l);
                ans.add(l);
            }
        }
        return ans;

    }

    static void printAns(String s, List<String> ans) {
        if (s.length() == 0) {
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (ispali(s, 0, i - 1)) {
                ans.add(s.substring(0, i));
                printAns(s.substring(i, s.length()), ans);
            }
        }
    }

    private static boolean ispali(String arr, int i, int j) {

        while (j >= i) {
            if (arr.charAt(i) == arr.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
