package com.backtraking;

public class PrintAbbr {

    public static void main(String[] args) {
        printabbr("pep","",0);
    }

    private static void printabbr(String in,String out,int count) {
            
        if(in.length() == 0 || out.length()==3) {
            if (count == 0) {
                System.out.println(out);
            }else {
                System.out.println(out+""+count);
            }
            return;
        }
        
        String out1 = out;
        String out2  =  "";
        if (count == 0) {
            out2 = out+in.charAt(0);
        }else {
            out2 = out+count+in.charAt(0);
        }
        
        
        printabbr(in.substring(1), out2, 0);
        printabbr(in.substring(1), out1, count+1);
    }
}
