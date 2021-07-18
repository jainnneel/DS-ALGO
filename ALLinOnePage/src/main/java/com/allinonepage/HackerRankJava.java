package com.allinonepage;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HackerRankJava {

    public static String findDay(int month, int day, int year) {
//        String ans = "" ;
//        DateFormatSymbols dfs = new DateFormatSymbols(Locale.getDefault());
//        String weekdays[] = dfs.getWeekdays();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
//         ans = weekdays[calendar.get(Calendar.DAY_OF_WEEK)-1];
        return LocalDate.of(year, month, day).getDayOfWeek().name();
    }
    
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = "";
        
        for (int i = 0; i <= s.length()-k; i++) {
            if (s.substring(i,i+k).compareTo(smallest)<0) {
                smallest = s.substring(i,i+k);
            }
            if(s.substring(i,i+k).compareTo(largest)>0){
                largest = s.substring(i,i+k);
            }
        }
            
        return smallest + "\n" + largest;
    }
     
    static boolean isAnagram(String a, String b) {
        
        int[] a1 =  new int[26];
        int[] b1 =  new int[26];
        String s1  = a.toLowerCase();
        String s2  = b.toLowerCase();
        
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            b1[s2.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < b1.length; i++) {
            if (a1[i]==b1[i]) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    static void primeOrNot(int[][] arr) {
//        
//        int j;
//        for (j = 2; j <= i; j++) {
//            if (i%j==0) {
//                break;
//            }
//           
//        }if (i==2 || i==j) {
//            System.out.println("prime");
//        }else {
//            System.out.println("Not prime");
//        }
        int max = Integer.MIN_VALUE;
       for (int i = 0; i <4; i++) {
           for (int j = 0; j < 4; j++) {
               int ans = 0;
             ans = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]+ arr[i+2][j+1]+ arr[i+2][j+2];
             if (ans > max) {
                max = ans;
            }
        }
           
    }
       System.out.println(max);
        
    }
    
    static void subArray(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int ans = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    ans = ans + a[j2];
                }
                if(ans<0) {
                    cnt++;
                }
                System.out.println(ans);
            }
        }
        System.out.println(cnt);
    }
    public static boolean canWin(int leap, int[] game) {
        
            int i = 0;
            int n = game.length-1;
            while (i<=n) {
                if (i+leap<=n && game[i+leap]==0) {
                    i= i+leap;
                }else if (i+1<n && game[i+1]==0) {
                    i = i+1;
                }else if (i==n-1 && game[n]==0) {
                    return true;
                }else if (i+leap>=n) {
                    return true;
                }else {
                    return false;
                }
            }
            
        return false;
    }
    
    
    public static void main(String[] args) {
        int[][] arr = new int[][] {
            new int[] {1,1,1,0,0,0},
            new int[] {0 ,1, 0 ,0 ,0 ,0},
            new int[] {1 ,1 ,1 ,0 ,0 ,0},
            new int[] {0 ,9 ,2, -4 ,-4 ,0},
            new int[] {0 ,0, 0, -2, 0, 0},
            new int[] {0 ,0 ,-1 ,-2 ,-4, 0},
            
        };
//        System.out.println(canWin(8,new int[]{0 ,1 ,1 ,0 ,0 ,1 ,0, 0, 0 ,1 ,0 ,1 ,1}));
//        subArray(new int[] {1 ,-2, 4 ,-5 ,1});
//        primeOrNot(arr);
//        primeOrNot(13);
//        String sq =  "He is a very very good boy, isn't he?";
//        String delims = "[ !,?._'@\\\\]+";
//        String[] ss = sq.split(delims);
//        System.out.println(ss.length-1);
//        for(String s:ss){
//            System.out.println(s);
//        }
////        findDay(8,05,2018);
////        Scanner scanner = new Scanner(System.in);
////        double payment = scanner.nextDouble();
////        scanner.close();
//
////        NumberFormat france = NumberFormat.getCurrencyInstance(new Locale("en","in"));
////        String format = france.format(payment);
////        System.out.println(format);
//        // Write your code here.
////        "neel".substring(0,0) ;
////        System.out.printf("neel".substring(0,1).toUpperCase());
//        getSmallestAndLargest("welcometojava",3);
//        String A =  "Neel";
//        for(int i = 0,j=A.length()-1;i<A.length();i++,j--){
//            if(A.charAt(i)==A.charAt(j)){
//                continue;
//            }else{
//                System.out.print("No");
//                return;
//            }
//        }
//        System.out.print("Yes");
//        Scanner scanner = new Scanner(System.in);
//        BigInteger n1 = scanner.nextBigInteger();
//        BigInteger n2 = scanner.nextBigInteger();
//        BigInteger sum = n1.add(n2);
//        BigInteger mul = n1.multiply(n2);
//        System.out.println(sum +" "+mul);
//        scanner.close();
//        Scanner sc = new Scanner(System.in);
//        
//        List<List<Integer>> llist = new ArrayList<>();
//        int n = Integer.parseInt(sc.nextLine());
//        
//        for(int j = 0;j < n;j++){
//            String[] ind = sc.nextLine().split(" ");
//            int d = Integer.parseInt(ind[0]);
//            List<Integer> list = new ArrayList<>();
//            for(int k=1;k<=d;k++){
//                list.add(Integer.parseInt(ind[k]));
//            }
//            llist.add(list);
//        }
//        int q = Integer.parseInt(sc.nextLine());
//        for(int i =0;i<q;i++){
//            String[] ind = sc.nextLine().split(" ");
//            try{
//                
//            int ans = llist.get(Integer.parseInt(ind[0])-1).get(Integer.parseInt(ind[1])-1);
//                            System.out.println(ans);
//
//            }catch(Exception e){
//                                System.out.println("ERROR!");
//
//            }
//        }
//        sc.close();
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//         int n = Integer.parseInt(sc.nextLine());
//           String[] ind = sc.nextLine().split(" ");
//           for(int k=0;k<ind.length;k++){
//               list.add(Integer.parseInt(ind[k]));
//           }
//          int y = Integer.parseInt(sc.nextLine());
//          for(int i = 0; i < y; i++){
//              if(sc.nextLine().trim().equals("Insert")){
//                  String[] inds = sc.nextLine().split(" ");
//                  if( Integer.parseInt(inds[0])<list.size()){
//                      list.set(Integer.parseInt(inds[0]),Integer.parseInt(inds[1]));
//                  }else{
//                      list.add(Integer.parseInt(inds[1]));
//                  }
//              }else{
//                  String[] inds = sc.nextLine().split(" ");
//                  if(Integer.parseInt(inds[0])<list.size()){
//                      list.remove(Integer.parseInt(inds[0]));
//                  }
//              }
//          }
//          for(Integer i : list){
//                 System.out.print(i+" ");
//
//          }  
        
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        String [] pair_left = new String[t];
//        String [] pair_right = new String[t];
//        
//        for (int i = 0; i < t; i++) {
//            pair_left[i] = s.next();
//            pair_right[i] = s.next();
//        }
//        Set<String> s1 = new HashSet<>();
//        
//        for(int i = 0; i < t; i++){
//            String string = pair_left[i].concat(pair_right[i]);
//            if (s1.add(string)) {
//                System.out.println(s1.size());
//            }else {
//                System.out.println(s1.size());
//            }
//            
//        } 
//        Scanner sc= new Scanner(System.in);
//        int n=sc.nextInt();
//        String []s=new String[n];
//        for(int i=0;i<n;i++){
//            s[i]=sc.next();
//        }
//        sc.close();
//        BigDecimal[] ba = new BigDecimal[n];
//        List<BigDecimal> bl = new ArrayList<>(); 
//        for (int i = 0; i < s.length; i++) {
//            ba[i] = new BigDecimal(s[i]);
//            bl.add(new BigDecimal(s[i]));
//        }
//        Arrays.sort(ba,Collections.reverseOrder());
//        
//        Collections.sort(bl,Collections.reverseOrder());
//        
//        for (int i = 0; i <s.length; i++) {
//            BigDecimal o = new BigDecimal(s[i]);
//            if (bl.contains(o)) {
////                s[i] = 
//            }
////            bl.indexOf(o);
//        }
//      
//        
//        //Output
//        for(int i=0;i<n;i++)
//        {
//            System.out.println(s[i]);
//        }
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }
        int[] a = new int[n];
        int j = 0;
        while(j<n){
         
         int ans = 0;   
         int i;
            for(i = 0;i<m-1;i++){
//              if(deque.getFirst()){
//                  ans++;
//              }   
            }if(i==m-1){
                deque.pop();
            }
            a[j] = ans;
            j++;
        }
    }
    
}
