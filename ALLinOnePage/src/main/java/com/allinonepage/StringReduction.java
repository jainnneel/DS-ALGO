package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class StringReduction {

    public static void main(String[] args) {
//        compress("neeljainnnnnn");
//        decompress("ab1bc8r8");
        String str[] = {"2","22","222", 
                "3","33","333", 
                "4","44","444", 
                "5","55","555", 
                "6","66","666", 
                "7","77","777","7777", 
                "8","88","888", 
                "9","99","999","9999"
               }; 
//        mobileConvert(str,"nee".toUpperCase());

        String words[] = { "may", "student", "students", "dog", 
                     "studentssess", "god", "cat", "act", "tab", 
                     "bat", "flow", "wolf", "lambs", "amy", "yam", 
                     "balms", "looped", "poodle"}; 
        int n = words.length; 
        wordsWithSameCharSet(words, n); 
    }
    
    static String getKey(String str) 
    { 
//        char[] charArray = str.toCharArray();
//        Arrays.sort(charArray);
        boolean[] visited = new boolean[128]; 
        Arrays.fill(visited, false); 
       
        // store all unique characters of current 
        // word in key 
        for (int j = 0; j < str.length(); j++) 
            visited[str.charAt(j) - 'a'] = true ; 
        String key = ""; 
        for (int j=0; j < 128; j++) 
            if (visited[j]) 
                key = key + (char)('a'+j); 
//        for (int i = 0; i < charArray.length; i++) {
//            key = key + charArray[i];
//        }
        return key; 
    } 
       
    // Print all words together with same character sets. 
    static void wordsWithSameCharSet(String words[], int n) 
    { 
        // Stores indexes of all words that have same 
        // set of unique characters. 
        //unordered_map <string, vector <int> > Hash; 
        HashMap<String, ArrayList<Integer>> Hash = new HashMap<>(); 
       
        // Traverse all words 
        for (int i=0; i<n; i++) 
        { 
            String key = getKey(words[i]); 
              
            // if the key is already in the map 
            // then get its corresponding value 
            // and update the list and put it in the map 
            if(Hash.containsKey(key)) 
            { 
                ArrayList<Integer> get_al = Hash.get(key); 
                get_al.add(i); 
                Hash.put(key, get_al); 
            } 
              
            // if key is not present in the map 
            // then create a new list and add 
            // both key and the list 
            else
            { 
                ArrayList<Integer> new_al = new ArrayList<>(); 
                new_al.add(i); 
                Hash.put(key, new_al); 
            } 
        } 
       
        // print all words that have the same unique character set 
        for (Entry<String, ArrayList<Integer>> it : Hash.entrySet()) 
        { 
            ArrayList<Integer> get =it.getValue(); 
            for (Integer v:get) 
                System.out.print( words[v] + ", "); 
            System.out.println(); 
        } 
    } 

    private static void mobileConvert(String[] str, String string) {
        for (int i = 0; i < string.length(); i++) {
                System.out.print(str[string.charAt(i)-65]);
        }
    }

    private static void decompress(String string) {
       
        for (int i = 0; i < string.length();) {
            
            String sub = "";
            int  fre = 0;
            
            while (string.charAt(i)>=65) {
                sub = sub + string.charAt(i);
                i++;
            }
            
            while (!(i==string.length()) && string.charAt(i)<=57) {
                fre = fre*10 + string.charAt(i) - 48;
                i++;
            }
            
            for (int j = 0; j < fre; j++) {
                System.out.print(sub);
            }
            
//            char charAt = string.charAt(i+1);
//            if (!(charAt<=57)) {
//                sub = sub + string.charAt(i) + string.charAt(i+1);
//                continue;
//            }else {
//                for (int j = 0; j < charAt-48; j++) {
//                    ans = ans + sub;
//                }
//                sub = "";
//            }
        }
    }

    private static void compress(String a) {
        
        String ans = "";
        int fre[] = new int[26];
        boolean che[] = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            fre[a.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < a.length(); i++) {
            if (i==a.length()-1 ) {
                if (!che[a.charAt(i)-'a']) {
                    ans = ans + a.charAt(i) + fre[a.charAt(i)-'a'];
                    che[a.charAt(i)-'a'] = true;
                }
            }else if(a.charAt(i)!=a.charAt(i+1) && !che[a.charAt(i)-'a'] ) {
                ans = ans + a.charAt(i) + fre[a.charAt(i)-'a'];
                che[a.charAt(i)-'a'] = true;
            }
        }
        System.out.println(ans.length() > a.length() ? a : ans); 
    }
}
