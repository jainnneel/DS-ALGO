package com.allinonepage;

public class StringsHacker {

    public static void main(String[] args) {
        palindromeIndex("aaa");
        highestValuePalindrome("932239",6,2);
    }
    static String highestValuePalindrome(String s, int n, int k) {
        char[] c = s.toCharArray();
        for(int i = 0,j=n-1;i<n/2;i++,j--){
            if(c[i]==c[j]){
                if(k>=2 && c[i]!=9){
                    c[i] = '9';
                    c[j] = '9';
                     k = k -2;
                }
                continue;
            }else{
                if(k>0){
                    if(k>=2){
                        c[i]='9';
                        c[j]='9';
                        k = k -2;
                    }else{
                       c[i] =  (char)Math.max(Integer.valueOf(c[i]),Integer.valueOf(c[j]));
                       c[j] =  (char)Math.max(Integer.valueOf(c[i]),Integer.valueOf(c[j]));
                       k = k-1;
                    }
                }else{
                    break;
                }
            }
        }
        if(isPali(0,n-1,String.valueOf(c))){
            return String.valueOf(c);
        }else{
            return "-1";
        }
        
        
}
    static int palindromeIndex(String s) {
        for(int st = 0,en = s.length()-1;st < s.length()/2; st++,en--){
            if(s.charAt(st)==s.charAt(en)){
                continue;
            }else{
               if(isPali(st+1,en,s)){
                   return st;
               }else{
                   return en;
               }
               
            }
        }
       
        return -1;
    }

     static boolean isPali(int st,int en,String s){
          for(int st1 = st,en1 = en;st1 < en+1/2; st1++,en1--){
            if(s.charAt(st1)!=s.charAt(en1)){
                return false;
            }
        }
        return true;
      }  
}
