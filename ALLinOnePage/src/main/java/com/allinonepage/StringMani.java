package com.allinonepage;

import java.util.HashMap;
import java.util.Map;

public class StringMani {
    
//    static String superReducedString(String s) {
//        String ans = "";
//        char[] in = s.toCharArray();
//        for (int i = 0; i < s.length()-1; i=i+1) {
//             if (in[i]==in[i+1]) {
//                in[i] = 0;
//            }
//        }
//        for (char c : in) {
//            if (c!='c') {
//                ans = ans + c;
//                ans = ans.trim();
//            }
//        }
//        if (ans.equals("")) {
//            return "Empty String";
//        }
//        return ans.trim();
//    }
    static char getFirstKey(int id,Map<Character,Integer> map) {
        char ans = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == id) {
                return entry.getKey();
            }
        }
        return ans;
    }
    
    static String superReducedString(String s) {
        String ans = "";
        Map<Character ,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char in : charArray) {
                map.put(in, 0);
        }
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i],map.get(charArray[i])+1);
        }
        
        for (int c : map.values()) {
            if (c%2!=0) {
                char firstKey = getFirstKey(c,map);
                ans = ans + firstKey;
                map.put(firstKey,0);
            }
        }
        if (ans.equals("")) {
            ans = "Empty String";
        }
        return ans;
    }
    static int camelcase(String s) {
        int ans = 0;
        
        for (int ch : s.toCharArray()) {
              if (ch>=65 && ch<=90) {
                      ans++;
            }
        }
        return ans+1;

    }
    
    static int minimumNumber(int n, String password) {
        int ans = 0;
        
        boolean digit = false;
        boolean length = false;
        boolean caps = false;
        boolean small = false;
        boolean chars = false;
        
        char[] chs = {'!','@','#','$','%','^','&','*','(',')','-','+'};
         
        if (password.length()>5) {
            length = true;
        }
       for (char c : chs) {
           if (password.contains(c+"")) {
               chars = true;
           }
       } 
       for (int c : password.toCharArray()) {
               if (c>=65 && c<=90) {
                   caps = true;
               }
               if (c>=97 && c<=122) {
                   small = true;
               }
               if (c>=48 && c<=57) {
                   digit = true;
               }
       }
       if (digit && length && caps && small && chars) {
           return ans;
       } 
       if(!length) {
           ans = 6-password.length();
           return ans;
       }
       if (!digit) {
           ans++;
       } if (!caps) {
           ans++;
       } if (!small) {
           ans++;
       } if (!chars) {
              ans++;
       }
        
        return ans;
    }
    
    static int pageCount(int n, int p) {
        int ans = 0;
        if (p==1) {
            return 0;
         }
        if (n%2==0 && (p==n-1) ) {
            return 1;
        }
        
        if (n%2==0 && (p==n-1) ) {
            return 0;
        }
        
        if (n%2==1 && (p==n || p==n-1) ) {
            return 0;
        }
        
        if ((n-p)/2 < (p-1)/2) {
            ans = (n-p)/2;
         }else if ((n-p)/2 > (p-1)/2) {
             if (p%2==0) {
                 ans = (p-1)/2+1;
            }else {
                ans = (p-1)/2;
            }
        }else {
            ans = (p-1)/2;;
        }
        return ans;     
    }
    
    public static int countingValleys(int steps, String path) {
        int ans = 0;
        int vall = 0;    
            for (Character st : path.toCharArray()) {
                    if (st == 'U') {
                        if(ans==-1) {
                            vall++;
                        }
                        ans++;
                    }else {
                        ans--;
                        
                    }
            }
        
        return vall;
   }
    
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int sum = -1;
        for (int i = 0; i < drives.length; i++) {
             for (int j = 0; j < keyboards.length; j++) {
                 int isum = keyboards[j]+drives[i];
                 if (isum > sum && isum<=b) {
                    sum = isum;
                }
            }
        }
        
        return sum;
        
    }
    static String catAndMouse(int x, int y, int z) {
        String ans = "";
        if ( Math.abs(z-x) < Math.abs(z-y)) {
            ans = "Cat A";
        }else if(Math.abs(z-x) > Math.abs(z-y)) {
            ans = "Cat B";
        }else {
            ans = "Mouse C";
        }
        return ans;

    }
    
    static boolean checkAlternateOrNot(String in) {
        char[] inp = in.toCharArray();
        for (int i = 0; i < in.length()-1; i++) {
            if (inp[i]==inp[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    static int alternate(String s) {
        int ans = 0;
        return ans;
    }
    
    static void checkZeroContainBetweenOneOrNot(String input){
//          for (int i = 0; i < input.length(); i++) {
//              if (input.charAt(i) == '1') {
//                  for (int j = i+1; j < input.length(); j++) {
//                      if (input.charAt(j)=='0') {
//                           for (int j2 = j+1; j2 < input.length(); j2++) {
//                                if (input.charAt(j2)=='1') {
//                                    System.out.println("false");
//                                    return;
//                                }
//                        }
//                    }else {
//                        break;
//                    }
//                }
//            }
//        }
//          System.out.println("true");
        int start = input.length()+1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='1') {
                start = i;
                break;
            }
        }
        int last = 0;
        for (int i = input.length()-1; i >=0 ; i--) {
            if (input.charAt(i)=='1') {
                last = i;
                break;
            }
        }
        for (int i = start; i <= last; i++) {
            if (input.charAt(i)=='0') {
                System.out.println("true");
                return;
            }
        }
    }
    static void minimumFlips(String str) {
        String input = str;
        char[] ch = str.toCharArray();
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
             if (ch[i]=='0') {
                 if (i!=0 && str.charAt(i-1)=='1') {
                   cnt++;  
                 }
                  ch[i] = '1';
            }
        }
        if (str.charAt(0)=='0') {
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(ch);
        cnt =0;
        ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]=='1') {
                if (i!=0 && str.charAt(i-1)=='0') {
                  cnt++;  
                }
                 ch[i] = '0';
           }
       }
     
        System.out.println(cnt);
        System.out.println(ch);
    }
    private static void stringWithCharCount(String string, char c, int i) {
        int cnt =0;
        int ans = 0;
         for (int j = 0; j < string.length(); j++) {
             if (string.charAt(j)==c) {
                 cnt++;
             }
             if (cnt == i) {
                 ans = j+1;
                 break;
             }
         }
             System.out.println(string.substring(ans));
        
     }
    
    static int countLength(String in) {
        if (in.equals("")) {
            return 0;
        }else {
            return 1 + countLength(in.substring(1));
        }
    }
    
     static void checkPattern(String in) {
         int cnt = 0;
         for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i)=='a') {
                cnt++;
            }
        }
         for (int i = 0; i < in.length(); i++) {
             if (in.charAt(i)=='b') {
                 cnt--;
             }
         }
         System.out.println(cnt);   
         
     }
     static String longestCommonSubsequece(String str1,String str2){
         String ans = "";
//         for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                if (str1.charAt(i)==str2.charAt(j)) {
//                    ans = ans + str1.charAt(i);
//                }
//            }
//        }
         
         int[] s1 = new int[26];
         int[] s2 = new int[26];
         
         for (int i = 0; i < str1.length(); i++) {
            s1[str1.charAt(i)-'a']++;
        }
         
         for (int i = 0; i < str2.length(); i++) {
             s2[str2.charAt(i)-'a']++;
        }
         
         for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= Math.min(s1[i],s2[i]) ; j++) {
                ans = ans + (char)(i + 'a');
            }
        }
         
         return ans;
     }
     static int xorZero(String s) 
     { 
         int one_count = 0, zero_count = 0; 
         char[] str=s.toCharArray(); 
         int n = str.length; 
        
         // Counting number of 0 and 1 
         for (int i = 0; i < n; i++) 
             if (str[i] == '1') 
                 one_count++; 
             else
                 zero_count++; 
            
         // If count of ones is even 
         // then return count of zero 
         // else count of one 
         if (one_count % 2 == 0) 
             return zero_count; 
         return one_count; 
     } 
    
    public static void main(String[] args) {
//        superReducedString("zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh");
//        camelcase("saveChangesInTheEditor");
//        System.out.println(minimumNumber(5,"jnhqj"));
//        pageCount(6,5);
//        countingValleys(8,"DDUUDDUDUUUD");
//        System.out.println(checkAlternateOrNot("babab"));
//        checkZeroContainBetweenOneOrNot("1001");
//        minimumFlips("010101100011");
//        stringWithCharCount("i",'i',3);
//          System.out.println(countLength("neeljain"));
//        checkPattern("aaaabbbbb");
//        System.out.println( longestCommonSubsequece("neel","keeldsn"));

        String s = "101010101010"; 
        System.out.println(xorZero(s));   
    }

    }
