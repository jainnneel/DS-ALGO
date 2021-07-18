package com.allinonepage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

    public static void main(String[] args) {
        password("Ab1sssss");
    }

    private static void password(String string) {
        int ans = 0;
        
//        Pattern pattern = Pattern.compile("(\\d)");
//        Pattern pattern2 = Pattern.compile("[A-Z]");
//        Pattern pattern3 = Pattern.compile("[a-z]");
//        Pattern pattern4 = Pattern.compile("(\\w)");
//        
//        Matcher matcher = pattern.matcher(".*[a-z].*");
//        Matcher matcher1 = pattern2.matcher(".*[A-Z].*");
//        Matcher matcher2 = pattern3.matcher(".*[0-9].*");
//        Matcher matcher3 = pattern4.matcher("[a-zA-Z0-9]*");
        
        if (!string.matches(".*[a-z].*")) {
            ans++;
        }
        if (!string.matches(".*[A-Z].*")) {
            ans++;
        }if (!string.matches(".*[0-9].*")) {
            ans++;
        }if (string.matches("[a-zA-Z0-9]*")) {
            ans++;
        }
        int lengthDiff = 6 - string.length();
        if (lengthDiff>0 && ans<=lengthDiff) {
            ans = lengthDiff;
        }
        
        System.out.println(ans);
    }
}
