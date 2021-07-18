package comm.recursion;

import java.util.Arrays;

public class CopyUsingRecursion {

    public static void main(String[] args) {
        
//        copy("jainneel".toCharArray(),new char[4],0);
        
        String string = "abc";
//        powersetInLaxicographic(string,string.length(),-1,"");
        powersetInLaxicographic2(string,"");
        
    }

    private static void powersetInLaxicographic2(String in, String out) {

            if (in.length()==0) {
                System.out.println(out);
                return;
            }
            
            String op1 = out;
            String op2 = out+in.charAt(0);
            
            powersetInLaxicographic2(in.substring(1), op1);
            powersetInLaxicographic2(in.substring(1), op2);
            
    }

    private static void powersetInLaxicographic(String string, int length, int i, String string2) {
        
        if (i==length) {
            return;
        }
        
        System.out.println(string2);
        
        for (int j = i+1; j < length; j++) {
            string2= string2.concat(String.valueOf(string.charAt(j))) ;
            
            powersetInLaxicographic(string, length, j, string2);
            
            string2 = string2.substring(0,string2.length()-1);
        }
        return;
    }

    private static void copy(char[] charArray, char[] cs, int i) {
        
         cs[i] =  charArray[i];
         
         if (i==charArray.length-1) {
            cs[i] =  charArray[i];
            return;
         }
         
         copy(charArray, cs, i+1);
    }
}
