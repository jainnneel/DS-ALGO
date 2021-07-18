package codechef;

import java.util.Scanner;

public class GOTHAM {

    public static void main(String[] args) {
        
        
//        Scanner sc = new Scanner(System.in); 
//        
//             int n = sc.nextInt();
//             int a[] = new int[n+1];
//             for(int i=1;i<=n;i++) a[i] = sc.nextInt();
//             int q = sc.nextInt();
//             int nxt[] = new int[n+1];
//             for(int i=1;i<=n;i++) nxt[i] = i;
//             while(q-->0) {
//              int x = sc.nextInt();
//              long k = sc.nextInt();
//              int i = nxt[x];
//              long ans = 0, v = i-x;
//              for(;i<=n;i++) {
//               if(a[i]>=k) {
//                a[i] -= k;
//                ans = ans + k*v;
//                break;
//               }
//               else {
//                k -= a[i];
//                ans = ans + a[i]*v;
//                v++;
//                a[i] = 0;
//               }
//              }
//              if(i!=n+1 && a[i]==0) i++;
//              x = nxt[x];
//              while(x<=n&&a[x]==0) {
//               nxt[x++] = i;
//              }
//              System.out.print(ans+"\n");
//      }
        
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] ar = new int[n];
        
        for(int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
        }
        
        int[] next = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            next[i] = i;
        }
        
        int q = sc.nextInt();
        
          while(q-- > 0){
            int ans = 0;
            int x = sc.nextInt();
            int k = sc.nextInt();
            int temp = k;
             int i;
            for(i = next[x]-1; i < n; i++){
                if(temp > 0 && ar[i] > 0){
                    temp = temp - ar[i]; 
                    if(temp >= 0){
                        ans = ans + ar[i] * ( i - (x-1));
                        ar[i] = 0;
                    }else{
                        ar[i] = -temp;
                        ans = ans + (-temp) * ( i - (x-1));
                        break;
                    }
                }else{
                    break;
                }
            }
            if(i!=n+1 && ar[i-1] == 0){
                i++;
            }
            
            x = next[x];
            while(x <= n && ar[x-1] == 0){
                next[x++] = i;
            }
            
            
           System.out.println(ans); 
          }
          }
}
