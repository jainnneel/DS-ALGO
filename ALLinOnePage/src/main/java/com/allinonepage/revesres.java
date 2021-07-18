package com.allinonepage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class revesres {
    
//  public static void main(String[] args) {
//      int a[] = {5,8,445,878,45};
//      int b[] =new int[10];
//      int i,j;
//      for (i = 0,j = a.length-1;i<=a.length-1;i++,j--) {
//          b[j] = a[i];
//      }
//      for (i = 0;i<=b.length-1;i++) {
//          System.out.println(b[i]);
//      }
//      System.out.println(b);
//  }
//  static void rearrange(int arr[], int n)
//  {
//      int j = 0, temp;
//      for (int i = 0; i < n; i++) {
//          if (arr[i] < 0) {
//              if (i != j) {
//                  temp = arr[i];
//                  arr[i] = arr[j];
//                  arr[j] = temp;
//              }
//              j++;
//          }
//      }
//  }
//
//  // A utility function to print an array
//  static void printArray(int arr[], int n)
//  {
//      for (int i = 0; i < n; i++)
//          System.out.print(arr[i] + " ");
//  }
//
//  // Driver code
//  public static void main(String args[])
//  {
//      int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
//      int n = arr.length;
//
//      rearrange(arr, n);
//      printArray(arr, n);
//  }
//  static int printUnion(int arr1[], int arr2[], int m, int n) 
//  { 
//      int i = 0, j = 0; 
//      while (i < m && j < n) { 
//          if (arr1[i] < arr2[j]) 
//              System.out.print(arr1[i++] + " "); 
//          else if (arr2[j] < arr1[i]) 
//              System.out.print(arr2[j++] + " "); 
//          else { 
//              System.out.print(arr2[j++] + " "); 
//              i++; 
//          } 
//      } 
//
//      /* Print remaining elements of  
//       the larger array */
//      while (i < m) 
//          System.out.print(arr1[i++] + " "); 
//      while (j < n) 
//          System.out.print(arr2[j++] + " "); 
//
//      return 0; 
//  } 
//
//  public static void main(String args[]) 
//  { 
//      int arr1[] = { 1, 2, 4, 5, 6 }; 
//      int arr2[] = { 2, 3, 5, 7 }; 
//      int m = arr1.length; 
//      int n = arr2.length; 
//      printUnion(arr1, arr2, m, n); 
//  } 
  
//  static int[] cyclicArray(int arr[], int n) {
////      int temp = arr[n-1];
////      arr[n-1] = arr[0];
////      arr[0] = temp;
////      for(int i = 0;i<arr.length-1;i++) {
////         if (i==arr.length-1) {
////             arr[0] = arr[i];
////         }else{
////             arr[i+1] = arr[i];
////             i++;
////         }
////      }
//      int x = arr[arr.length-1], i; 
//      for (i = arr.length-1; i > 0; i--) 
//         arr[i] = arr[i-1]; 
//      arr[0] = x; 
//      return arr;
//  }
//  public static void main(String args[]) 
//{ 
//    int arr1[] = { 1, 2, 4, 5, 6 }; 
//    arr1 = cyclicArray(arr1,arr1.length); 
//    System.out.println(arr1);
//    for (int i = 0; i <= arr1.length-1; i++)
//        System.out.print(arr1[i] + " ");
//    System.out.println(Integer.MIN_VALUE);
//} 
  

//  static int maxSubArraySum(int a[]) 
//  { 
//      int size = a.length; 
//      int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
//
//      for (int i = 0; i < size; i++) 
//      { 
//          max_ending_here = max_ending_here + a[i]; 
//          if (max_so_far < max_ending_here) 
//              max_so_far = max_ending_here; 
//          if (max_ending_here < 0) 
//              max_ending_here = 0; 
//      } 
//      return max_so_far; 
//  } 
  
  

//  }
 public class revesres {
      
//      List<Integer> seq = new ArrayList<>();
//      List<List<Integer>> lists = new ArrayList<List<Integer>>();
//      int last= 0;
//      
//      public revesres(int n) {
//          for (int i = 0; i < n; i++) {
//              seq = new ArrayList<>();
//              lists.add(seq);
//          }
//      }
//      
//      void appendValue(int x,int y,int n) {
//          int rowIndex = (x^last)%n;
//          List<Integer> sques = lists.get(rowIndex);
//          sques.add(y);
//      }
//      
//      private void printLast(int x,int y,int n) {
//          int col = 0;
//          int rowIndex = (x^last)%n;
//          List<Integer> list = lists.get(rowIndex);
//          col = y%list.size();
//          last = list.get(col);
//          System.out.print(last);
//      }
//      public static void main(String[] args) {
//          Scanner sc = new Scanner(System.in);
//          int N = sc.nextInt();
//          int Q = sc.nextInt();
//          revesres da = new revesres(N);
//          for (int i = 0; i < Q; i++) {
//              int queryType = sc.nextInt();
//              int x = sc.nextInt();
//              int y = sc.nextInt();
//              if (queryType == 1) {
//                  da.appendValue(x, y, N);
//              } else {
//                  da.printLast(x, y, N);
//              }
//
//          }
//          sc.close();
//      }
     
//     public void rotate(int n, List<Integer> a) {
////         while (n>0) {
////             int first = a[0];
////             for (int i = 1; i < a.length; i++) {
////                 a[i-1] = a[i];
////             }
////             a[a.length-1]=first;
////             n--;
////        }
//         while (n>0) {
//             int first = a.get(0);
//             for (int i = 1; i < a.size(); i++) {
//                     a.set(a.get(i-1),a.get(i));
//             }
//             a.set(a.size()-1,first);
//             n--;
//        }
//        
//    }
//     public static void main(String[] args) {
//        int a[] = {1,2,3,4,5};
//        List<Integer> a1 = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            a1.add(a[i]);
//        }
//        revesres revesres = new revesres();
//        revesres.rotate(4, a1);
//        for(int an : a1) {
//            System.out.println(an);
//        }
//    }
     
//     public int[] sparseMatrix(String[] string,String[] query) {
//         int a[] = new int[query.length];
//         for(int j = 0;j<query.length;j++) {
//             int i = 0;
//             for (String s : string) {
//                if (query[j].equalsIgnoreCase(s)) {
//                    a[j] = ++i;
//                }
//            }
//         }
//         return a;
//    }
//     public static void main(String[] args) {
//       revesres  revesres = new revesres();
//       int[] sparseMatrix = revesres.sparseMatrix(new String[]{"ab","ab","abc"},new String[]{"ab","abc","bc"});
//       for(int an : sparseMatrix) {
//         System.out.println(an);
//     }
//    }
     
//     public int matrixMani(int n,int[][] mat) {
//         int max=0;
//         int start[] = new int[n+1];
//         for (int i = 0; i < mat.length; i++) {
//                     for (int j2 = mat[i][0]; j2 <=mat[i][1]; j2++) {
//                             start[j2]=mat[i][2]+start[j2];
//                    }
//         }
//         max=start[0];
//         for (int i = 0; i < start.length; i++) {
//            if (start[i]>max) {
//                max=start[i];
//            }
//        }
//         return max;
//        
//    }
//     
//     public static void main(String[] args) {
//         int[][] foo = new int[][] {
     
//             new int[] { 1, 5, 3},
//             new int[] { 4, 8, 7},
//             new int[] { 6, 9, 1}
//         };
//         revesres  revesres = new revesres();
//         int matrixMani = revesres.matrixMani(10, foo);
//         System.out.println(matrixMani);
//     }
//     
//     public int hourGlass(int[][] a) {
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < 4; i++) {
//                 for (int j = 0; j < 4; j++) {
//                    int ans = a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
//                        if (max<ans) {
//                            max = ans;
//                        }
//                 }
//        }
//         return max;
//    }
//    
//     public static void main(String[] args) {
//         revesres  revesres = new revesres();
//         int[][] foo = new int[][] {
//           new int[] {  -9 ,-9 ,-9  ,1 ,1 ,1 },
//           new int[] { 0 ,-9,  0 , 4, 3, 2},
//           new int[] { -9 ,-9 ,-9  ,1 ,2 ,3},
//           new int[] {0 , 0 , 8 , 6, 6, 0},
//           new int[] {  0 , 0 , 0 ,-2 ,0, 0},
//           new int[] {0  ,0 , 1 , 2, 4, 0}
//       };
//               System.out.println(revesres.hourGlass(foo));
//}s
     
}
































