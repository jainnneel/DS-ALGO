package codechef;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Birthday {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            String s = sc.next();
            int[] ansa =  new int[k];
            int tmp = 0;
            int aa = 0;
            for(int i = 0; i < n - 1; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    aa = aa + 2;
                }else {
                    aa = aa + 1;
                }
            }
//            ansa[0] = aa;
            while(k-- > 0){
                int ans = 0;
                int pos = sc.nextInt();
                String added = "";
                if(s.charAt(pos - 1) == '0'){
                    added = "1";
                }else{
                    added = "0";
                }
                String s1 = s.substring(0,pos - 1) + added + s.substring(pos,n);
                if(pos - 1 > 0 && pos - 1 < n-1){
                    if(s1.charAt(pos - 1) == s1.charAt(pos - 2) && s.charAt(pos - 1) != s.charAt(pos - 2)){
                        ans = ans + 1;
                    }
                    if(s1.charAt(pos - 1) == s1.charAt(pos) && s.charAt(pos - 1) != s.charAt(pos)){
                        ans = ans + 1;
                    }
                    if(s1.charAt(pos - 1) != s1.charAt(pos - 2) && s.charAt(pos - 1) == s.charAt(pos - 2)){
                        ans = ans - 1;
                    }
                    if(s1.charAt(pos - 1) != s1.charAt(pos) && s.charAt(pos - 1) == s.charAt(pos)){
                        ans = ans - 1;
                    }
//                    if(s.charAt(pos - 1) != s.charAt(pos - 2)){
//                        ans--;
//                    }
//                    if(s.charAt(pos - 1) != s.charAt(pos)){
//                        ans--;
//                    }
                }else if(pos - 1 == 0){
                    if(s1.charAt(pos - 1) == s1.charAt(pos) && s.charAt(pos - 1) != s.charAt(pos)){
                        ans = ans + 1;
                    }
                    if(s1.charAt(pos - 1) != s1.charAt(pos) && s.charAt(pos - 1) == s.charAt(pos)){
                        ans = ans - 1;
                    }
                }else if(pos - 1 == n - 1){
                    if(s1.charAt(pos - 1) == s1.charAt(pos - 2) && s.charAt(pos - 1) != s.charAt(pos - 2)){
                        ans = ans + 1;
                    }
                    if(s1.charAt(pos - 1) != s1.charAt(pos - 2) && s.charAt(pos - 1) == s.charAt(pos - 2)){
                        ans = ans - 1;
                    }
                }
                if(tmp > 0){
                    ansa[tmp] = ansa[tmp - 1] + ans;
                }else if(tmp == 0) {
                    ansa[tmp] = aa + ans;
                }
              
                tmp++;
                s = s1;
            }
            
            for(int i : ansa){
                System.out.println(i);
            }
            
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-- > 0){
//            
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//            
//          //  int[] arr = new int[n];
//            
//            PriorityQueue<Integer> qu1 = new PriorityQueue<>(Collections.reverseOrder());
//            PriorityQueue<Integer> qu2 = new PriorityQueue<>(Collections.reverseOrder());
//            
//            for(int i = 0; i < n; i++){
//              //  arr[i] = sc.nextInt();
//                int j = sc.nextInt();
//                  qu1.offer(j);
//                  qu2.offer(j);
//            }
//            
//            int ans1 = 0;
//            
//            int ans2 = 0;
//            
//            int tmp = k;
//            while(tmp-- > 0 && !qu1.isEmpty()){
//                ans1 = ans1 + qu1.poll();
//                qu1.poll();
//            }
//            
//            tmp = k;
//            while(tmp-- > 0 && !qu2.isEmpty()){
//                qu2.poll();
//                ans2 = ans2 + qu2.poll();
//            }
//            ans2 = ans2 + qu2.poll();
//            
//            int ans = Math.max(ans1,ans2);
//            System.out.println(ans);
//        }
//        
    }
}
