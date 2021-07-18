package com.allinonepage;

public class AndOrXor {

    static int andXorOr(int[] a) {
        int ans = 0;
        
        for (int i = 0; i < a.length; i++) {
            int min1 =a[i];
            int min2 = a[i];
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                
                if (a[j]<min1) {
                    min2 = min1;
                    min1 = a[j];
                    
                }
                
                sum  = (((min2 & min1) ^ (min2 | min1)) & (min2 ^ min1));
                if (sum>ans) {
                    ans = sum;
                }
            }
           
        }
        
        return ans;
//        
//        int result = Integer.MIN_VALUE;
//        Stack<Integer> stack = new Stack<Integer>();
//        for (int number : a) {
//            while (!stack.empty()) {
//                result = Math.max(result, S(number, stack.peek()));
//
//                if (number < stack.peek()) {
//                    stack.pop();
//                } else {
//                    break;
//                }
//            }
//
//            stack.push(number);
//        }
//        return result;
//    }
//    static int S(int x, int y) {
//        return ((x & y) ^ (x | y)) & (x ^ y);
//    }
    }
    public static void main(String[] args) {
//        int a[] = {30301275, 19973434, 63004643 ,54007648 ,93722492 ,91677384, 58694045 ,41546981 ,15552151, 5811338};
        int a[] = {1,2,1,56,3,58,6,7};
        
       System.out.println(andXorOr(a));
    }
}
