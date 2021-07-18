package codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuildTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
       
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1 ,4 ,2 ,3};
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cm = arr[i];
            ans++;
            for(int j = i+1; j < n; j++){
                if(arr[j] > cm){
                    ans++;
                    cm = arr[j];
                }else{
                    break;                      
                }
            }
        }
        System.out.println(ans);
        
        
//        String s = "xyxxy";
//        
//        int ans = 0;
//        boolean[] st = new boolean[s.length()];
//        for(int i = 0; i < s.length()-1; i++){
//            if(!st[i] && !st[i+1] && ((s.charAt(i) == 'x' && s.charAt(i+1)=='y') || (s.charAt(i) == 'y' && s.charAt(i+1)=='x'))){
//                st[i] = true;
//                st[i+1] = true;
//                ans++;
//            }
//        }
//        
//        System.out.println(ans);
        
//            Scanner sc = new Scanner(System.in);
//            Map<Integer,List<Integer>> map = new HashMap<>();
//            int t = sc.nextInt();
//            for(int i = 1;i<=t;i++) {
//                map.put(i,  new ArrayList<>());
//            }
//            map.put(sc.nextInt()+1, new ArrayList<>());
//            for (int i = 1; i < t; i++) {
//                    int in = sc.nextInt();
//                    map.get(in).add(i+1);
//            }
//            for (Map.Entry<Integer,List<Integer>> en : map.entrySet()) {
//                    if (en.getValue().size()==0) {
//                        System.out.print(en.getKey()+" ");
//                    }
//            }
//            System.out.println();
        }
         
    }
