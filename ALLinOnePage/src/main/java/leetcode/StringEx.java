package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringEx {
    
    public static void main(String[] args) {
//     defangIPaddr("1.1.1.1");
//        interpret("G()(al)");
//        String[] strings = {"ad","bd","aaab","baa","badab"};
//        countConsistentStrings("ab",strings);
//        balancedStringSplit("RLRRLLRLRL");
//        maxDepth("(1+(2*3)+((8)/4))+1");
//        freqAlphabets("jkab");
//        maximum69Number(9669);
//        selfDividingNumbers(1,22);
//        diStringMatch("DDI");
        int[] a = {2,2,2,3,3};
//        minCostToMoveChips(a);
//        totalMoney(10);
//        System.out.println(complexNumberMultiply("1+-1i","0+0i"));
        countAndSay(4);
      }
    
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
         String ans = helper(countAndSay(n-1));
        return  ans;  
     }
     
    static String helper(String s){
          int count = 1;
         StringBuilder sb = new StringBuilder();
         char[] c = s.toCharArray();    
         for(int i = 0; i < c.length; i++){
             if( i < c.length-1 && c[i] == c[i+1]) {
                 count++;
             } else if(i == c.length){
                 if(c[i] == c[i-1]){
                     count++;
                 }
                 sb.append(count+""+c[i]);
             } else{
                 sb.append(count+""+c[i]);
                 count = 1;
             }           
         }
         return sb.toString();
     }
    
    public static String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int a1 = Integer.parseInt(as[0])*Integer.parseInt(bs[0]);
        int b1 = Integer.parseInt(as[1].substring(0,as[1].length()-1))*Integer.parseInt(bs[1].substring(0,bs[1].length()-1));
        b1 = -b1;
        a1 = a1+b1;
        int m = (Integer.parseInt(as[0])*Integer.parseInt(bs[1].substring(0,bs[1].length()-1))) + 
                (Integer.parseInt(bs[0])*Integer.parseInt(as[1].substring(0,as[1].length()-1)));
        return a1+"+"+m+"i";
    }
    public static int totalMoney(int n) {
        int k = 1;
        int ans = 0;
        int m = 0;
        for(int i = 1;i<=n;i++){
            if(i%7==1){
                m = k;
                ans += k++;
            }else{
                m = m + 1;
                ans = ans + m;
            }            
        }
        return ans;
    }
    
    public static int minCostToMoveChips(int[] position) {
        int ansO = 0;
        int ansE = 0; 
         for(int i = 1;i<=position.length;i++){
             if(position[i-1]%2==1){
                 ansO++;
             }else{
                  ansE++;
             }
         }
        
         return Math.min(ansE,ansO);
     }
    
    public static int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];
        int k = 0;
         int fi = 0;
         int li = s.length();
         
        for (char i : s.toCharArray()) {
            if (i=='I') {
                    ans[k++] = fi++;
            }else {
                ans[k++] = li--;
            }
        }
        if (s.charAt(s.length()-1)=='I') {
            ans[k] = fi++;
        }else {
            ans[k] = li--;
        }
        return ans;
    }
    
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ll = new ArrayList<>();
         for(int i = left;i<=right;i++){
            int num = i;
            boolean d = true;
            while(num>0){
                int l = num%10;
                if(l==0){
                    d=false;
                    break;
                }
                if(i%l!=0){
                    d = false;
                    break;
                }
                num = num/10;
            }
            if(d){
                ll.add(i);
            }
        }
         return ll;
     }
    
    public static int maximum69Number (int num) {
        StringBuilder s = new StringBuilder();
        boolean d = true;
        for(char c : String.valueOf(num).toCharArray()){
            if(c=='6' && d){
                s.append(9);
                d = !d;
            }else{
                s.append(c);
            }
        }
        return Integer.valueOf(s.toString());
    }
    
    public static String freqAlphabets(String st) {
        StringBuilder s = new StringBuilder();
        for(char a : st.toCharArray()){
            if(a>=97 && a<=105){
                s.append(String.valueOf((int)a-96));
            }else if(a>=106 && a<=122){
                s.append(String.valueOf((int)a-96));
                s.append("#");
            }
        }
        return String.valueOf(s);
    }
    
    public static int maxDepth(String s) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> characters  = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<String> ans = new HashSet<>();   
        ans.add("dd");
        int max = 0;
        int l = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
                if(l>max){
                    max = l;
                }
            }else if(s.charAt(i)==')'){
                l--;
            }
        }
        if(l==0){
            return max;
        }else{
            return 0;
        }
    }
    public static int balancedStringSplit(String s) {
        int countl = 0;
        int countr = 0;
        int ans = 0;
        for(int i = 0; i < s.length() ; i++) {
            if(s.charAt(i)=='L'){
                countl++;
            }else if(s.charAt(i)=='R'){
                countr++;
            }
           if(countl==countr)  {
               ans++;
               countr = 0;
               countl = 0;
           }  
        }
        return ans;
        }
    
    public static int countConsistentStrings(String allowed, String[] words) {
        
        int ans = 0;
        for(int i=0;i<words.length;i++){
            int k = 0;
            int size = words[i].length();
            while(k<size){
                if(!allowed.contains(words[i].charAt(k)+"")){
                    ans--;
                    break;
                }
                k++;
            }
            ans++;
        }
        return ans;
//        int count = 0;
//        int[] arr = new int[26];
//        for(int itr = 0; itr < allowed.length(); itr++){
//             arr[allowed.charAt(itr)-'a']++;
//         }           
//         for(int itr = 0; itr < words.length; itr++){
//             String str = words[itr];            
//             int flag = 0;
//             for(int ktr = 0; ktr < str.length(); ktr++){
//                 if(arr[str.charAt(ktr)-'a'] == 0){
//                     flag = 1;
//                     break;
//                 }
//             }
//             if(flag == 0) count++;        
//         }
//         return count;
    }
    
    public static String defangIPaddr(String string) {
        StringBuilder builder  = new StringBuilder(string);
        String ans = string.replace(".","[.]");
//        String[] s = string.split("\\.");
//        
//       
//        for (int i = 0; i < s.length; i++) {
//            if (i==s.length-1) {
//                builder.append(s[i]);
//            }else {
//                builder.append(s[i]+"[.]");
//            }
//        }
        StringBuilder s = new StringBuilder();
        Integer.valueOf(s.toString());
        return ans;
    }
    public static String interpret(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='G'){
                sb.append("G");
            }else if(i<s.length()-1 && s.charAt(i+1)==')'){
                 sb.append("o");
                 i++;
            }else if(i<s.length()-1 && s.charAt(i+1)=='a') {
                sb.append("al");
                i=i+2;                
            }
        }
        return String.valueOf(sb);
    }
}
