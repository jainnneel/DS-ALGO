package com.allinonepage;

import java.util.Scanner;

public class DownToZero {
    
//    static boolean primeOrNot(int a) {
//        int i;
//        for (i = 2; i < a; i++) {
//            if (a%i==0) {
//                break;
//            }
//        }
//        if (a==2) {
//            return true;
//        }
//        if (a == i) {
//            return true;
//        }
//        
//       return false; 
//    }
//    
//    static int downToZero(int inp) {
//           int count = 0;
//            for (int i = 2; i <= Integer.MAX_VALUE; i++) {
//                if (inp == 1) {
//                    return 1;
//                }
//                if (inp == 2) {
//                    count = count+2;
//                    return count;
//                }
//                if (primeOrNot(inp)) {
//                    inp--;
//                    i = 1;
//                    count++;
//                }else if (inp%i==0) {
//                    count++;
//                    inp = Math.max(i,inp/i);
//                    i = 1;
//                }else if (inp == 0) {
//                    return count;
//                }
//           }
//        return count;
//    }
//    
//    public static void main(String[] args) {
//        
//        List<Integer> arr = new ArrayList<>();
//        arr.add(3);
//        arr.add(4);
//        for (int a : arr) {
//            System.out.println(downToZero(412509));
//        }
//        
////        arr.add(4);
//        
////        System.out.println(primeOrNot(99));
////        System.out.println(primeOrNot(9));
////        System.out.println(primeOrNot(2));
////        System.out.println(primeOrNot(5));
////        System.out.println(primeOrNot(251));
//    }
    static final int LIMIT = 1_000_000;
    static int[] solutions = buildSolutions();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        for (int tc = 0; tc < Q; tc++) {
            int N = sc.nextInt();

            System.out.println(solve(N));
        }

        sc.close();
    }

    static int[] buildSolutions() {
        int[] solutions = new int[LIMIT + 1];
        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = solutions[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    solutions[i] = Math.min(solutions[i], solutions[i / j] + 1);
                }
            }
        }
        return solutions;
    }

    static int solve(int N) {
        return solutions[N];
    }
}
