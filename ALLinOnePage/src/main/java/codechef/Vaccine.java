package codechef;

import java.util.Scanner;

public class Vaccine {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        
        while(tc-- > 0){
            
            int gn = sc.nextInt();
            int vc = sc.nextInt();
            
            int[] cap = new int[11];
            
            for(int i = 1; i <= 10; i++){
                cap[i] = sc.nextInt();
            }
            int min = 0;
            int count = 0;
            int gap = 0;
            for (int i = 10; i > gn; i--) {
                count = count + cap[i];
            }
            if (count%vc == 0) {
                min = (int)Math.ceil((double)count/(double)vc)+1; 
            }else {
                gap = count%vc;
                min = (int)Math.ceil((double)count/(double)vc);
            }
            int max = 0;
            if (cap[gn] + gap <= vc) {
                max = min;
            }else {
                max = min + (cap[gn]+gap)/vc;
            }
            
            System.out.println(min +" "+max);
            
//            int day = 0;
//            int re = 0;
//            int t = vc;
//            for(int i = 9; i >=0 ; i--){
//                if(i == gn-1){
//                    day++;
//                    if(cap[gn + 1] + re - vc > 0){
//                        System.out.println(day +" "+ ++day);
//                    }else{
//                        System.out.println(day +" "+day);
//                    }
//                    break;
//                }else if(cap[i] + re == t){
//                    re = 0;
//                    day++;
//                    t = vc;
//                }else if(cap[i] + re > t){
//                    re = cap[i] + re - vc;
//                    day++;
//                    t = vc;
//                }else if(cap[i] + re < t){
//                    i--;
//                    t = t - cap[i] + re;
//                } 
//            }
            
            
        }
        
    }
}
