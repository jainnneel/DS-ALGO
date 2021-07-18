package codechef;

import java.util.Scanner;

public class SpecialFruit {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

        int lv = 6;
        int pos = 13;
        if (lv == 2) {
            if (pos == 1) {
                System.out.println("Apple");
            } else {
                System.out.println("Banana");
            }
            return;
        }
        int tl = (int) Math.pow(2, lv - 1);

        boolean l = true;
        int l1 = 0;
        int i  = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= tl && i <= pos) {
            i= i + 2;
           if (l1 == 0) {
               if(l) {
                   sb.append("ab");
               }else {
                   sb.append("ba");
               }
               l=!l;
               count++;
               if(count == 2) {
                   l1 = 1;
                   count = 0;
               }
           }else if(l1 == 1){
               if(l) {
                   sb.append("ba");
               }else {
                   sb.append("ab");
               }
               l=!l;
               count++;
               if(count == 2) {
                   l1 = 0;
                   count = 0;
               }
           }
        }
            char ch = sb.toString().charAt(pos-1);
            if (ch == 'a') {
                System.out.println("Apple");
            } else {
                System.out.println("Banana");
            }
    }
}
