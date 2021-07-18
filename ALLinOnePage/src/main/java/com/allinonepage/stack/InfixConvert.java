package com.allinonepage.stack;

import java.util.Stack;

public class InfixConvert {

    public static void main(String[] args) {
        convertInfixToPostfix("5*(6-7)/5+6");
    }

    private static void convertInfixToPostfix(String infix) {
        
        Stack<String> operator = new Stack<>();
        Stack<String> oprands = new Stack<>();
        
        
        for(Character ch : infix.toCharArray()) {
            if (ch == '(') {
                operator.push(String.valueOf(ch));
            }else if (Character.isDigit(ch)) {
                oprands.push(String.valueOf(ch));
            }else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while ( !operator.isEmpty() && precendence(ch+"") <= precendence(operator.peek()) && !operator.peek().equals("(")) {
                    String val2 = oprands.pop();
                    String val1 = oprands.pop();
                    oprands.push(String.valueOf(calculate(val1,val2,operator.peek().charAt(0))));
                    operator.pop();
                }
                operator.push(ch+"");
            }else if (ch == ')') {
                while (!operator.peek().equals("(")) {
                    String val2 = oprands.pop();
                    String val1 = oprands.pop();
                    oprands.push(String.valueOf(calculate(val1,val2,ch)));
                    operator.pop();
                }
                operator.pop();
            }
        }
        
        while (!operator.isEmpty()) {
            String val2 = oprands.pop();
            String val1 = oprands.pop();
            oprands.push(String.valueOf(calculate(val1,val2,operator.pop().charAt(0))));
        }
        
        
    }
    
   private static int calculate(String val1s, String val2s, Character ope) {
       int val1 = Integer.parseInt(val1s);
       int val2 = Integer.parseInt(val2s);
       if (ope == '/') {
           return val1/val2;
       }else if (ope == '*') {
           return val1*val2;
       }else if (ope == '+') {
           return val1+val2;
       }else {
           return val1-val2;
       }
        
    }

static int precendence(String ope) {
        if (ope.equals("/")) {
            return 2;
        }else if (ope.equals("*")) {
            return 2;
        }else if (ope.equals("+")) {
            return 1;
        }else {
            return 1;
        }
    }
    
}
