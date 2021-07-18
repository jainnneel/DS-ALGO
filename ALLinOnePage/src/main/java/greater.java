import java.math.BigInteger;

public class greater {
    static int[] arr = new int[100];
    static int mod = 1000000007;
    public static void main(String[] args) {
//       int a[] = {5,4,8,7,6};
//        nextge("54876");
        
//        findFact(500);
        powerArray(4);
        System.out.println();
    }
    public static void powerArray(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < 100; i++) {
            arr[i] = (arr[i-1] * 2) % mod;
        }
    }
    private static void findFact(int n) {
        
        
        
        BigInteger b1 = new BigInteger("1"); 
        for(int i = 1; i <= n ; i++) {
            b1 = b1.multiply(new BigInteger(i+""));
        }
        System.out.println(b1.toString());
    }

    private static void nextge(String num) {
        int[] a = new int[num.length()];
        int n = num.length();
        int k = 0;
        for (char i : num.toCharArray()) {
            a[k++] = i - 48;
        }
        int l = 0;
        boolean flag = false;
        for (int i = n-1; i >= 1; i--) {
            if (a[i] > a[i-1]) {
                l=i;
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println("-1");
            return;
        }
        int j = l;
        l--;
        int ele = a[l];
        int next = 0;
        int nextIn = 0;
        for (int i = l; i < a.length; i++) {
            if (ele < a[i]) {
                next = Math.max(ele,a[i]);
                nextIn = i;
            }
        }
       
        int temp = a[l];
        a[l] = a[nextIn];
        a[nextIn] = temp;
        
        reveseIt(a,l+1,a.length);
        
        for (int i : a) {
            System.out.println(i + " ");
            
        }
    }

    private static void reveseIt(int[] a, int i, int length) {
          for (int j = i,k=length-1; j < length - i; j++,k--) {
              int temp = a[j];
              a[j] = a[k];
              a[k] = temp;
            }
        }  
    }
