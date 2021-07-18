package com.allinonepage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryJoinReturnType;

public class StringHacker {

     static void reducedString(String in){
//         int[] cin = new int[26];
//         String ans = "";
//         for (int i = 0; i < in.length(); i++) {
//            cin[in.charAt(i) - 'a']++;
//        }
//        
//         for (int i = 0; i < cin.length; i++) {
//            if (cin[i]%2!=0) {
//                ans = ans + (char)(i+'a');
//            }
//        }
         
         char[] ch = in.toCharArray();
         List<Character> inl = new ArrayList<>();
         for (int i = 0; i < ch.length-1; i++) {
               inl.add(ch[i]);
         }
         
         for (int i = 0; i < ch.length; i++) {
            if (inl.get(i)==inl.get(i+1)) {
                inl.remove(i);
                inl.remove(i+1);
            }
        }
         
     }
     
     static String caesarCipher(String s, int k) {
         
         String ans = "";
         k = k%26;
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>=65 && s.charAt(i)<=90 ) {
                int j = s.charAt(i) + k;
                if (j>90) {
                    j=j-26;
                }
                ans = ans + (char)j;
            }else if ((s.charAt(i)>=97 && s.charAt(i)<=122)) {
                int j = s.charAt(i) + k;
                if (j>122) {
                    j=j-26;
                }
                ans = ans + (char)j;    
            }else {
                ans = ans + s.charAt(i);
            }
            
        }
         
         
         return ans;

     }
     static int marsExploration(String s) {
         int ans = 0;
         String sos = "SOS";
         System.out.println(s.length());
         for(int i=0; i < s.length() ; i++){
            if(s.charAt(i) != sos.charAt(i % 3)){
                 ans++;
             }
         }
         return ans;

     }

     static String hackerrankInString(String s) {
         String ans = "";
         String hck =  "hackerrank";
         for (int i = 0,j = 0; i < s.length(); i++) {
                  if (s.charAt(i) == hck.charAt(j)) {
                      j++;
                  }
                  if (j==hck.length()) {
                    ans = "YES";
                    return ans;
                }
        }
         ans = "NO";
         return ans;
     }
     
     static String pangrams(String s) {
         String ans = "";
         String input = s.toUpperCase();
         int[] ch = new int[26];
         for (int i = 0; i < input.length(); i++) {
             if (input.charAt(i)==32) {
                 continue;
             }
             ch[input.charAt(i)-'A']++;
        }
         for (int i = 0; i < ch.length; i++) {
            if (ch[i]==0) {
                ans = "not pangram";
                return ans;
            }
        }
         ans = "pangram";
         return ans;
             
     }
     
     static String[] getWeigthOfAllContinousSubString(String str, int[] queries){
         Set<Integer> set = new HashSet<Integer>();
         String[] strings = new String[queries.length];
         char pre = ' ';
         int weight = 0;
         for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr!=pre) {
                weight = 0;
            }
            weight = weight + curr - 'a' + 1;
            set.add(weight);
            pre = curr;
        }
        for (int i = 0; i < queries.length; i++) {
             if (set.contains(queries[i])) {
                 strings[i] = "Yes";
             }else {
                 strings[i] = "No";
            }
        } 
         return strings;
     }
     
     static void funnyString(String str) {
         StringBuilder rev = new StringBuilder(str);
         rev.reverse();
         String revese = rev.toString();
         int[] st1 = new int[str.length()];
         int[] st2 = new int[str.length()];
         int[] dif1 = new int[str.length()];
         int[] dif2 = new int[str.length()];
     
         for (int i = 0; i < revese.length(); i++) {
             st2[i] = revese.charAt(i);
         }
         
         for (int i = 0; i < str.length(); i++) {
             st1[i] = str.charAt(i);
         }
         
         for (int i = 0; i < st2.length-1; i++) {
             dif1[i] = Math.abs(st1[i+1] - st1[i]);
         }
         
         for (int i = 0; i < st1.length-1; i++) {
             dif2[i] = Math.abs(st2[i+1] - st2[i]);
         }
         
         for (int i = 0; i < dif2.length; i++) {
            if (dif1[i]!=dif2[i]) {
                System.out.println("NO");
                return;
            }
        }
         
         System.out.println("yes");
     }
     
     static int gemstones(String[] array) {
//         int ans = 0;
//         List<Integer[]> list = new ArrayList<>();
//         for (int i = 0; i < arr.length; i++) {
//             Integer[] arr1 = new Integer[arr[i].length()]; 
//             list.add(arr1);
//         }
//         for (Integer[] integers : list) {
//             for (int i = 0; i < integers.length; i++) {
//                 integers[arr[i]]++; 
//             }
//        }
//         
//         return ans;
         final int NUM_ELEMENTS = 26;
         BitSet bitset = new BitSet(NUM_ELEMENTS);
         bitset.set(0, NUM_ELEMENTS);

         /* Create a BitSet for each rock. "AND" it with our original BitSet */
         for (String rock : array) {
             BitSet currBitSet = new BitSet(NUM_ELEMENTS);
             for (int i = 0; i < rock.length(); i++) {
                 currBitSet.set(rock.charAt(i) - 'a');
             }
             bitset.and(currBitSet);
         }
         
         return bitset.cardinality();
     }

     static int alternatingCharacters(String s) {
         int ans = 0;
         
         Stack<Character> in = new Stack<>();
         
         for (int i = 0; i < s.length(); i++) {
            if (!in.isEmpty()) {
                System.out.println(s.charAt(i)+"  "+in.peek());
                if (s.charAt(i)==in.peek()) {
                    ans++;
                    continue;
                }else {
                    in.push(s.charAt(i));
                }
            }else {
                in.push(s.charAt(i));
            }
        }
         
         return ans;

     }
     
     static int beautifulBinaryString(String b) {
         int ans = 0;
         
         for (int i = 0; i < b.length()-2; i++) {
             if (b.charAt(i)=='0' && b.charAt(i+1)=='1' && b.charAt(i+2)=='0') {
                ans++;
                i = i+2;
            }
        }
         
         return ans;
     }
     //abcd
     static int theLoveLetterMystery(String s) {
         int ans = 0;
         
         for (int i = 0,j=s.length()-1; i < s.length(); i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                ans = ans + Math.abs((int)(s.charAt(j) - s.charAt(i)));
            }
            if (j-i==1 || j==i) {
                break;
            }
        }
         
         return ans;
     }
     
     static int palindromeIndex(String s) {
         int ans1 = -1;
         int ans2 = -1;
         int cnt1 = 0;
         int cnt2 = 0;
         List<Character> list1 = new ArrayList<>();
        

         for (int i = 0;i<s.length();i++) {
            list1.add(s.charAt(i));
         }
         List<Character> list2 = new ArrayList<>(list1);
         for (int i = 0,j = list1.size()-1; i < list1.size();) {
                 if (list1.get(i)!=list1.get(j)) {
                    list1.remove(i);
                    ans1 = i;
                    cnt1++;
                    j--;
                 }else {
                    i++;
                }
                 if (j==i) {
                     break;
                 }
         }
         for (int i = 0,j = list2.size()-1; i < list2.size();) {
             if (list2.get(i)!=list2.get(j)) {
                list2.remove(j);
                ans2 = j;
                cnt2++;
                j--;
             }else {
                j--;
            }
             if (j==i) {
                 break;
             }
         }
         return cnt1==1?ans1:ans2;
     }
     
     static int anagram(String s) {
         int count = 0;
         int length = s.length();
        if (length%2!=0) {
            return -1;
         }
         String s1 = s.substring(0,length/2);
         String s2 = s.substring(length/2,length);
//         int[] s1c = new int[26];
//         int[] s2c = new int[26];
//         for (int i = 0; i < s1.length(); i++) {
//            s1c[s1.charAt(i)-'a']++;
//        }
//         for (int i = 0; i < s2.length(); i++) {
//             s2c[s1.charAt(i)-'a']++;
//         }
//         
//         for (int i = 0; i < s1.length(); i++) {
//             String si = s1.charAt(i)+"";
//              if (!s2.contains(si)) {
//                ans++;
//            }
//        }
//         
//         return ans;
         
         char[] s1Chars = s1.toCharArray();
         for (char c : s1Chars){
             int index = s2.indexOf(c);
             if (index == -1){
                 count++;
             } else {
                 s2 = s2.substring(0,index)+s2.substring(index+1);
             }
         }
         System.out.println(count);
         return count;
     }

     static int makingAnagrams(String s1, String s2) {
         int ans = 0;
           int[] s1c = new int[26];
           int[] s2c = new int[26];
           for (int i = 0; i < s1.length(); i++) {
              s1c[s1.charAt(i)-'a']++;
          }
           for (int i = 0; i < s2.length(); i++) {
               s2c[s2.charAt(i)-'a']++;
           }
           
         for (int i = 0,j=0; i < s1c.length; i++,j++) {
             if (s1c[i]!=s2c[j]) {
                 ans = ans + Math.abs(s1c[i]-s2c[j]);
                
            }
         }
         
         return ans;
     }

     static String gameOfThrones(String s) {
         String ans = "Yes";
         boolean flag1 = false;
         int[] s1c = new int[26];
         for (int i = 0; i < s.length(); i++) {
             s1c[s.charAt(i)-'a']++;
         }
//         if (s.length()%2!=0) {
             for (int i = 0; i < s1c.length; i++) {
                 if (s1c[i]%2==1) {
                     if (flag1) {
                        return "No";
                    }else {
                        flag1 = true;
                    }
//                 }else {
//                     flag1 = false;
//                 }
//             }
//             
//             for (int i = 0; i < s1c.length; i++) {
//                 if (s1c[i]!=-1) {
//                    return "No";
//                }
//            }
//        }else {
//            for (int i = 0; i < s1c.length; i++) {
//               if (s1c[i]!=2) {
//                   return "No";
//               }
//           }
//        }
//         
                 }
             }
//         }
         return ans;

     }
     
     static String twoStrings(String s1, String s2) {
         String ans = "No";
         int[] s1c = new int[26];
         for (int i = 0; i < s1.length(); i++) {
             s1c[s1.charAt(i)-'a']++;
         }
         int[] s2c = new int[26];
         for (int i = 0; i < s2.length(); i++) {
             s2c[s2.charAt(i)-'a']++;
         }
         
         for (int i = 0,j=0; i < s2c.length; i++,j++) {
             if (s1c[i] != s2c[j]) {
                 return "NO";
             }
        }
         
//         for (int i = 0; i < s1.length(); i++) {
//            String char1 = s1.charAt(i)+"";
//             if (s2.contains(char1)) {
//                 ans = "Yes";
//             }
//        }
//         
         return ans;

     }
     //abab
     static int stringConstruction(String s) {
         int ans = 0;
         
         boolean[] s1c = new boolean[26];
         
         for (int i = 0; i < s.length(); i++) {
             if (!s1c[s.charAt(i)-'a']) {
                 s1c[s.charAt(i)-'a']=true;
                 ans++;
            }
         }
        
         return ans;
     }

     static String isValid(String s) {
         int[] s1c = new int[26];
         boolean flag = false;
         for (int i = 0; i < s.length(); i++) {
             s1c[s.charAt(i)-'a']++;
         }
         int t = s1c[0];
         for (int i = 0; i < s1c.length; i++) {
           if (s1c[i]==0) {
               continue;
           }  
           if (s1c[i]==t) {
                continue;
            }else if (Math.abs(s1c[i]-t)==1 || s1c[i]==1) {
                if (!flag) {
                    flag = true;
                }else {
                    return "No";
                }
            }else {
                return "No";
            }
        }
         
         return "YES";
     }
     
     static boolean isPalindrome(char[] ch) {
         for (int i = 0,j=ch.length-1; i < ch.length; i++,j--) {
             if (ch[i]!=ch[j]) {
                return false;
            }
        }
         return true;
     }
     
     static String highestValuePalindrome(String s, int n, int k) {
         char[] ch = s.toCharArray();
         for (int i = 0,j=s.length()-1; i < s.length(); i++,j--) {
             int s1 = Integer.parseInt(ch[i]+"");
             int l1 = Integer.parseInt(ch[j]+"");
             if (s1!=l1) {
                 if (s1!=9) {
                     ch[i]= '9';
                     k--;
                 }
                 if (k==0) {
                     break;
                 }
                 if (l1!=9) {
                     ch[j] = '9';
                     k--;
                }
                 if (k==0) {
                     break;
                 }
             }
            
         }
         for (int i = 0,j=ch.length-1; i < ch.length; i++,j--) {
             if (k<2) {
                 break;
             }
             if (ch[i]!='9') {
                ch[i] = '9';
                ch[j] = '9';
                k--;
                k--;
            }
             
        }
         if (isPalindrome(ch)) {
            String ans = "";
            for (int i = 0; i < ch.length; i++) {
                ans = ans + ch[i];
            }
            return ans;
        }
         return "-1";

     }
    static  int lcs( char[] X, char[] Y, int m, int n ) 
     { 
//      
//       if (m == 0 || n == 0) {
//           System.out.println(String.valueOf(X)+"  "+String.valueOf(Y));
//           return 0; 
//       }
//       if (X[m-1] == Y[n-1]) 
//         return 1 + lcs(X, Y, m-1, n-1); 
//       else
//         return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n)); 
        
        int L[][] = new int[m+1][n+1]; 
        
        /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
             that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++) 
        { 
          for (int j=0; j<=n; j++) 
          { 
            if (i == 0 || j == 0) 
                L[i][j] = 0; 
            else if (X[i-1] == Y[j-1]) 
                L[i][j] = L[i-1][j-1] + 1; 
            else
                L[i][j] = max(L[i-1][j], L[i][j-1]); 
          } 
        } 
      return L[m][n]; 
     } 
     
     /* Utility function to get max of 2 integers */
    static int max(int a, int b) 
     { 
       return (a > b)? a : b; 
     } 
     
     public static void main(String[] args) {
//        reducedString("baababab");
//        System.out.println(caesarCipher("159357lcfd",98));
//        marsExploration("SSSSSSSSSSSSSSSOOOOOOOOOOOOOOOOOOOOOOOOOSSSSSSSO");
//         hackerrankInString("hereiamstackerrank");
//         pangrams("We promptly ju for the next prize");
         int[] a = {9,7,8,12,5};
         String[] strings = {"abcdde","baccd","eeabg"};
//         getWeigthOfAllContinousSubString("aaabbbbcccddd",a);
//         funnyString("bcxz");
//         gemstones(strings);
//         alternatingCharacters("AAABBB");
//         beautifulBinaryString("010");
//         theLoveLetterMystery("neeljain");
//         System.out.println(palindromeIndex("aaa"));
//         anagram("xaxbbbxx");
//         makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj","djfladfhiawasdkjvalskufhafablsdkashlahdfa");
//         gameOfThrones("aaabbbb");
//         stringConstruction("abab");
//         isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
//         System.out.println(highestValuePalindrome("932239",6,2));
         System.out.println(lcs("SHINCHAN".toCharArray(),"NOHARAAA".toCharArray(),2,2));
         
    }
}
