package codechef;

import java.util.Scanner;

public class OROFAND {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while(n-- > 0){
            
            int size = sc.nextInt();
            int query = sc.nextInt();
            int[] arr = new int[size];
            
            for(int i = 0; i < size; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(find(arr));
//            for(int i = 0; i < query; i++){
//                
//                arr[sc.nextInt()-1] = sc.nextInt();
////                print(arr);
//                System.out.println(find(arr));
//                
//            }
        }
        
    }
    static void print(int arr[]){
        for (int i : arr){
            System.out.print(i+" ");
        } 
        System.out.println();
    }
    static int find(int arr[]){
         int ans = 0;
            
            for(int i = 0; i < arr.length; i++){
                for(int j = i; j < arr.length; j++){
                    int sub = arr[i];
                    for(int k = i+1; k <= j ; k++){
//                        System.out.print(arr[k]+" ");
                        sub = (sub & arr[k]);
                    }
                    System.out.print(sub + " ");
                    ans = (ans | sub);
                }
            }
            return  ans;
    }
    
}
