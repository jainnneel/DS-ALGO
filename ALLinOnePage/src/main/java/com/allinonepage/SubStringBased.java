package com.allinonepage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringBased {

    public static void main(String[] args) {
//        countEvenNumber("154");
//        generateAllCharSequence("abcd");
//        findsubsequences("abcd");
        findsubsequences("abcd","");
    }
    static Set<String> set = new HashSet<>();
    static List<String> al = new ArrayList<>();
    private static void generateAllCharSequence(String string) {
        for (int i = 0; i < string.length(); i++) {
                for (int j = string.length(); j >= 0; j--) {
                        String subString = string.substring(i,j);
                        if (!set.contains(subString)) {
                            set.add(subString);
                        }
                        
                        for (int k = 0; k < subString.length(); k++) {
                            StringBuffer sfBuffer = new StringBuffer(subString);
                            sfBuffer.deleteCharAt(k);
                            if (!set.contains(sfBuffer)) {
                                generateAllCharSequence(sfBuffer.toString());
                            }
                        }
                }
        }
        System.out.println(set);
            
    }
        private static String[] findsubsequences(String s){
                    if (s.length()==0) {
                        String ans[] = {""};
                        return ans ;
                    }
                    
                    String smallAns[] = findsubsequences(s.substring(1));
                    String ans[] = new String[2 * smallAns.length];
                    
                    int k = 0;
                    for (int i = 0; i < smallAns.length; i++) {
                         ans[k] = smallAns[i];
                         k++;
                    }
                    
                    for (int i = 0; i < smallAns.length; i++) {
                        ans[k] = s.charAt(0) + smallAns[i];
                        k++;
                    }
                    return ans;
        }
        
     private static void findsubsequences(String s,String ans) {
            if (s.length()==0) {
                System.out.println(ans);
                return;
            }
            
            findsubsequences(s.substring(1),ans + s.charAt(0));
            
            findsubsequences(s.substring(1),ans);
             
     }
    private static void countEvenNumber(String string) {
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j <= string.length(); j++) {
                if (!string.substring(i, j).equals("")) {
                    int parseInt = Integer.parseInt(string.substring(i, j));
                    System.out.println(parseInt);
                    if (parseInt%2==0) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
