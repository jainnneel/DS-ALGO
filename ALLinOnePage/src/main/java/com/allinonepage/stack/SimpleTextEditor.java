package com.allinonepage.stack;

import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {
        String[][] foo = new String[][] {
            new String[] { "1","abc" },
            new String[] { "3","3"},
            new String[] { "2","3"},
            new String[] { "1","xy"},
            new String[] { "3","2"},
            new String[] { "4"},
            new String[] { "4"},
            new String[] { "3","1"},
        };
        editor(foo);
    }

    private static void editor(String[][] foo) {
        
        Stack<Character> main = new Stack<>();
        Stack<Integer> po = new Stack<>();
        Stack<Integer> pi = new Stack<>();
        Stack<Character> main1 = new Stack<>();
        for (String[] object : foo) {
            if (object[0].equals("1")) {
                char[] a = object[1].toCharArray();
                for (int i = 0; i < a.length; i++) {
                    main.push(a[i]);
                }
                po.push(1);
                pi.push(a.length);
            }else if (object[0].equals("2")) {
                Integer integer = Integer.valueOf(object[1]);
                for (int i = 0; i < integer; i++) {
                  if(main.size()>0)   main1.push(main.pop());
                }
                po.push(2);
                pi.push(integer);
            }else if (object[0].equals("3")) {
                if(main.size()>=Integer.valueOf(object[1])-1) System.out.println(main.get(Integer.valueOf(object[1])-1));
            }else {
                if (po.pop()==1) {
                    Integer integer = pi.pop();
                    for (int i = 0; i < integer; i++) {
                        main.pop();
                    }
                }else {
                    Integer integer = pi.pop();
                    for (int i = 0; i < integer; i++) {
                        main.push(main1.pop());
                    }
                }
            }
        }
    }

    
}
// class Solution {
//    public static void main(String[] args) {
//          Scanner in=new Scanner(System.in);
//          int n=in.nextInt();
//          String s = "";
//         Stack<String> st =new Stack<String>();
//         st.push(s);
//           for(int i=0;i<n;i++){
//                int t=in.nextInt();
//               if(t==1){ s = s+in.next();st.push(s);
//                  }
//               else if(t==2){s=s.substring(0,s.length()-in.nextInt());st.push(s);}
//               else if(t==3){System.out.println(s.charAt(in.nextInt()-1)); }
//               else{st.pop();s=st.peek();}}}}

