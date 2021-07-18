package com.allinonepage.stack;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class ZigZag {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName(null);
        System.out.println("Host Address: "+ ia.getHostAddress());
        Node node = new Node(5);
        
        node.left =  new Node(6);
        node.left.left =  new Node(8);
        node.left.right =  new Node(10);
//        node.left.left.left =  new Node(4);
//        node.left.left.right = new Node(6);
        
        node.right =  new Node(7);
//        node.right.left =  new Node(1);
        node.right.right =  new Node(9);
//        node.right.left.left =  new Node(1);
//        node.right.left.right =  new Node(1);
        
//        zigZagTraversal(node);
//        diagonal(node);
//        printBoundary(node);
//        buildTree("4(2(3)(1))(6(5))");
//        toSumTree(node);
        
//        System.out.println(check(node));
        int[] a = {1, 2, 1, 3};
        int[] b = {1, 2, 1, 3};
//        System.out.println(checkMirrorTree(3,2,a,b));
        findpath(node);
    }
    
    private static void findpath(Node node) {
        
        List<Integer> n1list = new ArrayList<>();
        List<Integer> n2list = new ArrayList<>();
        
        findpathn1(node,n1list,10);
        
       System.out.println(n1list); 
    }


    private static boolean findpathn1(Node node, List<Integer> n1list, int i) {
        
        if (node == null) {
            return false;
        }
        
        if (i==node.data) {
            return true;
        }
        n1list.add(node.data);
        if (findpathn1(node.left, n1list, i)) {
            return true;
        }
        if (findpathn1(node.right, n1list, i)) {
            return true;
        }
        if (n1list.size()>0) {
            n1list.remove(n1list.size()-1);
        }
        return false;
    }

    static int checkMirrorTree(int n, int e, int[] a, int[] b) {
        Map<Integer,List<Integer>> mapa = new HashMap<>(); 
        Map<Integer,List<Integer>> mapb = new HashMap<>(); 
        
        for(int i = 0; i < a.length; i++){
            if(i%2==0){
                mapa.put(a[i],new ArrayList<Integer>());
            }
        }
        for(int i = 0; i < a.length; i++){
            if(i%2==0){
                mapb.put(b[i],new ArrayList<Integer>());
            }
        }
        for(int i = 0; i < a.length; i++){
            if(i%2==1){
                List<Integer> ll = mapa.get(a[i-1]);
                ll.add(a[i]);
                mapa.put(a[i-1],ll);
            }
        }
        for(int i = 0; i < a.length; i++){
            if(i%2==1){
                List<Integer> ll = mapb.get(b[i-1]);
                ll.add(b[i]);
                mapb.put(b[i-1],ll);
            }
        }
        
        for(Map.Entry<Integer,List<Integer>> en : mapa.entrySet()){
            List<Integer> ll1 = en.getValue();
            List<Integer> ll2 = null;
            if(mapb.containsKey(en.getKey())) {
                ll2 = mapb.get(en.getKey());
            }else{
                ll2 = new ArrayList<>();
            }
            Collections.reverse(ll2);
            if(!ll1.equals(ll2)){
                return 0;
            }
            
        }
        return 1;    
        
    }
    
    
    
   static boolean check(Node root)
    {
        if(root == null || (root.left == null && root.right==null)){
            return true;
        }
        
        int height = height(root);
        
        return checkleaf(root,height-1,0);
            
    }
    
   static boolean checkleaf(Node root, int h , int curr){
        if(root==null){
            return true;
        }
        if(root.left == null && root.right==null){
            if(curr != h){
                return false;
            }
            return true;
        }
       return checkleaf(root.left , h , curr+1) && checkleaf(root.right,h , curr+1);
        
    }
    
   static int height(Node root){
        if(root == null){
            return 0;
        }
        
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    
    private static Node buildTree(String s) {
        
        if (s.length() == 0) {
            return null;
        }
        
        Node root = new Node(s.charAt(0)-'0');
        
          int in =  findLeftChieldStartAndEnd(s.substring(1));
          
          if(s.length() > 2) root.left = buildTree(s.substring(2,in+1));
          if(s.length() > 2) root.right = buildTree(s.substring(in+2,s.length()));
          
        return root;
    }

    public static void toSumTree(Node root){
        
        if(root==null){
            return;
        }
         int[] sum = new int[2];
         int left = giveSum(root.left,sum);
         int right = giveSumR(root.right,sum);
         
         root.data = left + right;
         
         toSumTree(root.left);
         toSumTree(root.right);
        
    }
    static int giveSumR(Node root,int[] sum){
        
        if(root == null){
             return 0;
         }
         sum[1] = sum[1] + root.data;
         giveSumR(root.left,sum);
         giveSumR(root.right,sum);
         return sum[1];
     }
   static int giveSum(Node root,int[] sum){
        
       if(root == null){
            return 0;
        }
        sum[0] = sum[0] + root.data;
        giveSum(root.left,sum);
        giveSum(root.right,sum);
        return sum[0];
    }


    private static int findLeftChieldStartAndEnd(String substring) {
        int ans = 0;
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < substring.length(); i++) {
            
            if (substring.charAt(i) == '(') {
                characters.push(substring.charAt(i));
            }else if (substring.charAt(i) == ')') {
                characters.pop();
                if (characters.isEmpty()) {
                    ans = i;
                    break;
                }
            }
            
        }
        return ans;
    }

    static ArrayList <Integer> printBoundary(Node node)
    {
        ArrayList <Integer> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        boundryUtil(node,0,map);
        
        for(Map.Entry<Integer,List<Integer>> en : map.entrySet()){
            if(en.getValue()!=null){
                ans.add(en.getValue().get(0));
            }
        }
        map.get(map.size()-1).remove(0);
            if(map.get(map.size()-1)!=null){
                for(Integer in : map.get(map.size()-1)){
                    ans.add(in);
                }
            }
            ArrayList <Integer> ans1 = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> en : map.entrySet()){
            if(en.getValue()!=null && en.getValue().size()>0){
                ans1.add(en.getValue().get(en.getValue().size()-1));
            }
        }
          Collections.reverse(ans1); 
          ans1.remove(0);
          ans.addAll(ans1);
          ans.remove(ans.size()-1);
        return ans;
    }
    
    static void boundryUtil(Node root, int lvl, Map<Integer,List<Integer>> map){
        
        
        if(root == null){
            return;
        }
        
        List<Integer> ll = map.get(lvl);
        
        if(ll == null){
            ll  = new ArrayList<>();
            ll.add(root.data);          
        }else{
            ll.add(root.data);
        }
        
        map.put(lvl,ll);
        
        boundryUtil(root.left,lvl+1,map);
        boundryUtil(root.right,lvl+1,map);
        
    }
    
    
    
    
    
    
    
    public static ArrayList<Integer> diagonal(Node node){
        ArrayList<Integer> ans = new ArrayList<>();
       Map<Integer,List<Integer>> map = new TreeMap<>();
       diaUtil(node,0,map);
       for(Map.Entry<Integer,List<Integer>> en : map.entrySet()){
           for(Integer in : en.getValue()){
               ans.add(in);
           }
       }
       return ans;
     }
     
    static void diaUtil(Node root,int lvl, Map<Integer,List<Integer>> map){
         
         if(root == null){
             return;
         }
         
         List<Integer> ll = map.get(lvl);
         
         if(ll == null){
             ll = new ArrayList<>();
             ll.add(root.data);
         }else{
             ll.add(root.data);
         }
         
         map.put(lvl, ll);
         
         diaUtil(root.left,lvl+1,map);
         diaUtil(root.right,lvl,map);
         
     }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            super();
            this.data = data;
        }
        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }
    }
    
    static class lp{
        Node node;
        int level;
        lp(Node n,int l){
            node = n;
            level = l;
        }
        @Override
        public String toString() {
            return "lp [node=" + node + ", level=" + level + "]";
        }
    }

static ArrayList<Integer> zigZagTraversal(Node node)
{
     Queue<lp> qu = new LinkedList<>();
        
        if(node == null){
            return new ArrayList<>();
        }
        Map<Integer,List<Node>> map = new TreeMap<>();
        qu.add(new lp(node,0));
        List<Node> l =  new ArrayList<>();
        l.add(node);
        map.put(0,l);
        while(!qu.isEmpty()){
            
            lp lr = qu.poll();
            
            if(map.containsKey(lr.level)){
                List<Node> lt =  map.get(lr.level);
                lt.add(lr.node);
                map.put(lr.level,lt);
            }else{
                 List<Node> lt =  new ArrayList<>();
                 lt.add(lr.node);
                 map.put(lr.level,lt);
            }
            
            if(lr.node.left != null) {
                qu.add(new lp(lr.node.left,lr.level+1));
            }
            if(lr.node.right != null) {
                qu.add(new lp(lr.node.right,lr.level+1));
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean f = true;
         for(Map.Entry<Integer,List<Node>> en : map.entrySet()){
           
             if(f){
                 List<Node> ll = en.getValue();
                 for(Node n : ll){
                     ans.add(n.data);
                 }
                 f = !f;
             }else{
                 List<Node> ll = en.getValue();
                 Collections.reverse(ll);
                 for(Node n : ll){
                     ans.add(n.data);
                 }
                 f = !f;                        
             }
        }
        ans.remove(0);
       return ans;       
}
}
