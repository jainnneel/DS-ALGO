package comm.recursion;

import java.util.HashSet;
import java.util.Set;

public class Powerset {
    
    public static void main(String[] args) {
        String string = "abc";
        printpowerset(string,"");
        Set<String> set = new HashSet<>();
//        uniquesubset(set,string,"");
//        System.out.println(set);
//        printAllSubString(string,"");
//        permutationWithSpaces(set,string.substring(1),"a");
        
//        permutationWithCaseChange(set,string.toLowerCase(),"");
//        System.out.println(set);
//        permutationWithLatterCase(set,string,"");
//        generateBalancedParanthesis(3,3,3,"");
//        nbitBinaryNumberOneMorethanZero(3,1,0,"1");
        System.out.println(set);
    }

    private static void nbitBinaryNumberOneMorethanZero(int n, int ones, int zeros,String out) {
        if (n==0) {
            System.out.println(out);
            return;
        }
        
        if (ones!=0) {
            String out1 = out + "1";
            nbitBinaryNumberOneMorethanZero(n-1, ones+1, zeros, out1);
        }
        if (ones>zeros) {
            String out1 = out + "0";
            nbitBinaryNumberOneMorethanZero(n-1, ones, zeros+1, out1);
       
        }
        return;
    }

    private static void generateBalancedParanthesis(int i, int open, int close,String out) {
        
        if (open == 0 && close == 0) {
            System.out.println(out);
            return;
        }
        
        if (open!=0) {
            String op1 = out + "(";
            generateBalancedParanthesis(i, open-1, close, op1);
        }
        if (close>open) {
            String op1 = out + ")";
            generateBalancedParanthesis(i, open, close-1, op1);
        }
        return;
        
    }

    private static void permutationWithLatterCase(Set<String> set,String in,String out) {
            
        if (in.length()==0) {
            set.add(out);
            return;
         }
        String out2 = "";
        String out1 = "";
        if (in.charAt(0)>=48 && in.charAt(0)<=57) {
            out2 = out+in.charAt(0);
            out1 = out+in.charAt(0);
        }else {
            if (in.charAt(0)>=65 && in.charAt(0)<=92) {
                out2 = out+(char)(in.charAt(0)+32);
                out1 = out+(char)(in.charAt(0));
            }else {
                out2 = out+(char)(in.charAt(0)-32);
                out1 = out+(char)(in.charAt(0));

            }
     
        }
         permutationWithLatterCase(set, in.substring(1), out1);
         permutationWithLatterCase(set, in.substring(1), out2);


    }

    private static void permutationWithCaseChange(Set<String> set,  String in,String out) {
        
        if (in.length()==0) {
           System.out.println(out);
            return;
        }
        String out2 = out+in.charAt(0);
        String out1 = out+(char)(in.charAt(0)-32);
        
        permutationWithCaseChange(set, in.substring(1), out1);
        permutationWithCaseChange(set, in.substring(1), out2);

    }

    private static void permutationWithSpaces(Set<String> set, String in,String out) {
        if (in.length()==0) {
            set.add(out);
            return;
        }
        String out1 = out+in.charAt(0);
        String out2 = out+" "+in.charAt(0);
        
        permutationWithSpaces(set, in.substring(1), out1);
        permutationWithSpaces(set, in.substring(1), out2);
        
    }

    private static void printAllSubString(String in,String out) {
       for (int i = 0; i < in.length(); i++) {
           for (int j = i+1; j <= in.length(); j++) {
               System.out.println(in.substring(i, j));
        }
       }        
    }

    private static void uniquesubset(Set<String> set, String in,String out) {
        if (in.length()==0) {
            set.add(out);
//            System.out.println(out);
            return;
        }
        
        String out1 = out;
        String out2 = out + in.charAt(0);
        
        uniquesubset(set,in.substring(1), out1);
        uniquesubset(set,in.substring(1), out2);
        
    }

    private static void printpowerset(String in,String out) {
        if (in.length()==0) {
            System.out.println(out);
            return;
        }
        
        String out1 = out;
        String out2 = out + in.charAt(0);
        
        printpowerset(in.substring(1), out1);
        printpowerset(in.substring(1), out2);
    }
}
