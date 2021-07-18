package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyMatrix {
    
    static String chooseandswap(String a){
        StringBuilder sb = new StringBuilder(a);
        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb2 = new StringBuilder(String.valueOf(charArray)); 
        
        if(sb.toString().equals(sb2.toString())){
            return sb.toString();
        }
        
        char ch1 = sb.charAt(0);
        char ch2 = sb2.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != sb2.charAt(i)) {
                ch1 = sb.charAt(i);
                ch2 = sb2.charAt(i);
                break;
            }
        }
         System.out.println(ch1 + " " + ch2);
        for(int i = 0; i < sb.toString().length(); i++){
            if(sb.charAt(i) == ch1){
                sb.setCharAt(i,ch2);
            }else if(sb.charAt(i) == ch2){
                sb.setCharAt(i,ch1);
            }
           
        }
        if(sb.toString().compareTo(a) < 0){
            return sb.toString();
        }else{
            return a;
        }
    }
    
       public static void main(String[] args) {
           System.out.println(chooseandswap("abcdefghijklabcdefghijklpop"));
           
           Scanner sc = new Scanner(System.in);
//           String s = sc.nextLine();
//           System.out.println(s);
           int n = sc.nextInt();
           String string1 = sc.nextLine();
           boolean f = true;
           int arr[][] = null;
           for(int i = 0; i < n; i++){
                   String string = sc.nextLine();
                   String[] sarStrings = string.split(" ");
                   if (f) {
                       arr = new int[n][sarStrings.length];
                       f=!f;
                   }
                   for(int j = 0; j < sarStrings.length; j++){
                           arr[i][j] = Integer.parseInt(sarStrings[j]);
                   }
           }
           
           System.out.println();
           int zeros = 0;
           
           for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    zeros++;
                }else {
                    zeros--;
                }
            }
          }
          if (zeros < 0) {
            System.out.println(-1);
            return;
        } 
           
           int[] rowsum = new int[n];
           int[] colsum = new int[3];
           
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < 3; j++) {
                   rowsum[i] = rowsum[i] + arr[i][j];
                   colsum[j] = colsum[j] +  arr[i][j];
               }
           }
           
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < 3; j++) {
                  if (zeros > 0) {
                      if (arr[i][j] != 0) {
                          zeros--;
                        }else if(arr[i][j] == 0 && zeros>0) {
                            if(rowsum[i] <= colsum[j]) {
                                if (rowsum[i] % 2 == 0) {
                                   arr[i][j] = 2;
                                   rowsum[i] = rowsum[i]  + 2 ;
                                   colsum[j] = colsum[j]  + 2 ;
                               }else {
                                   arr[i][j] = 1 ;
                                   rowsum[i] = rowsum[i]  + 1 ;
                                   colsum[j] = colsum[j]  + 1 ;
                              }
                            }else {
                                if (rowsum[i] % 3 == 0) {
                                    arr[i][j] = 3 ;
                                    rowsum[i] = rowsum[i]  + 3 ;
                                    colsum[j] = colsum[j]  + 3 ;
                                }else if(rowsum[i] % 3 == 1) {
                                    arr[i][j] = 2 ;
                                    rowsum[i] = rowsum[i]  + 2 ;
                                    colsum[j] = colsum[j]  + 2 ;
                               }else {
                                   arr[i][j] = 1 ;
                                   rowsum[i] = rowsum[i]  + 1 ;
                                   colsum[j] = colsum[j]  + 1 ;
                             }
                          }
                          zeros--;  
                        }
                 }
               }
           }
           for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
          }
          
           
           
//           int rowmax = Integer.MIN_VALUE;
//           int colmin = Integer.MAX_VALUE;
//           
//           for(int i = 0; i < n; i++){
//               int row = Integer.MAX_VALUE;
//               int col = Integer.MIN_VALUE;
//               for(int j = 0; j < n; j++){
//                   row = Math.min(row,arr[i][j]);
//                   col = Math.max(col,arr[j][i]);
//               }
//               rowmax = Math.max(rowmax,row);
//               colmin = Math.min(colmin,col);
//           }
//         
//           
//           int ans = 0; 
//           if(rowmax == colmin){
//               System.out.println(ans);
//               return;
//           }else{
//               if(rowmax < colmin){
//                 int maxcnt = Integer.MAX_VALUE;
//                 for(int i = 0; i < n; i++){
//                     int curr = 0;
//                     for(int j = 0; j < n; j++){
//                          if(arr[j][i] > rowmax){
//                              curr++;
//                          }
//                     }
//                     maxcnt = Math.min(maxcnt,curr);
//                 }
//                 System.out.println(maxcnt);
//               }else{
//                 int mincnt = Integer.MAX_VALUE;
//                 for(int i = 0; i < n; i++){
//                     int curr = 0;
//                     for(int j = 0; j < n; j++){
//                          if(arr[i][j] < colmin){
//                              curr++;
//                          }
//                     }
//                     mincnt = Math.min(mincnt,curr);
//                 }
//                    System.out.println(mincnt);
//               }
//           }
       }
       
       
}
