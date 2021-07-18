package tree;

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

import javax.persistence.criteria.Root;

public class ZigZag {

    public static void main(String[] args) throws UnknownHostException {
//        InetAddress ia = InetAddress.getByName(null);
//        System.out.println("Host Address: "+ ia.getHostAddress());
        Node node = new Node(7);
        
//        node.left =  new Node(6);
//        node.left.left =  new Node(8);
//        node.left.right =  new Node(10);
//        node.left.left.left =  new Node(4);
//        node.left.left.right = new Node(6);
        
//        node.right =  new Node(7);
//        node.right.left =  new Node(6);
//        node.right.left.left =  new Node(2);
//        node.right.left.left.right =  new Node(3);
//        node.right.left.left.right.right =  new Node(5);
//        node.right.left.left.right.right.left =  new Node(4);
//        
//        node.right.right =  new Node(10);
//        node.right.right.left =  new Node(9);
//        node.right.right.left.left =  new Node(8);
        
        node.left = new Node(1);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
//        node.left.right.left = new Node(1);
        
        node.right = new Node(10);
        node.right.left = new Node(9);
        node.right.right = new Node(11);
        node.right.left.left = new Node(1);
        node.right.left.right = new Node(2);
        node.right.right.right = new Node(5);
        
        
//        zigZagTraversal(node);
//        diagonal(node);
//        printBoundary(node);
//        buildTree("4(2(3)(1))(6(5))");
//        toSumTree(node);
        
//        System.out.println(check(node));
        int[] a = {1, 2, 1, 3};
        int[] b = {1, 2, 1, 3};
//        System.out.println(checkMirrorTree(3,2,a,b));
//        findpath(node);
        
//        sumOfLongRootToLeafPath1(node);
        
//        findLargestSubTree(node);
//        findSum(node,5);
        
//        System.out.println(lca(node,9,10).data);
        
       System.out.println( distance(node, 5));;
    }
    static boolean flg = false;
    
    static int distance(Node node,int val){
        
        if(node == null){
            return -1;
        }

        int dist = -1;
        
        if ((val == node.data) || (dist = distance(node.left, val)) >= 0 || (dist = distance(node.right, val)) >= 0) {
            return dist + 1;
        }
        
        return dist;
    }
    
    static Node lca(Node root, int n1,int n2)
    {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        findPath(root,l1,n1);
        flg = false;
        findPath(root,l2,n2);
        int i;
        if(l1.get(0) == l2.get(0)){
            for(i = 1; i < Math.min(l1.size(),l2.size()); i++){
               if(l1.get(i) != l2.get(i)){
                   break;
                }
             }
        }else{
            return root;
        }
        return findNode(root,l1.get(i-1));
    }
    
   static  Node findNode(Node node,int i){
        if(node == null){
            return null;
        }
        if(node.data == i){
            return node;
        }
        Node n1 = findNode(node.left,i);
        if(n1!=null) return n1;
        Node n2 = findNode(node.right,i);
        if(n2 != null) return n2;
        return null;
    }
    
   static void findPath(Node root,List<Integer> l1,int n1){
        if(root == null){
            return;
        }
        if(root.data == n1){
            l1.add(root.data);
            flg = true;
            return;
        }
        l1.add(root.data);
        
        findPath(root.left,l1,n1);
        if (flg) {
            return;
        }
        findPath(root.right,l1,n1);
        if (flg) {
            return;
        }
         
        l1.remove(l1.size()-1);
    }
    
    private static void ksumpaths(Node node,int k,String anf) {
        
        if (k < 0) {
            return;
        }
        
        if(k == 0) {
            System.out.println(anf);
            return;
        }
        
        if(node == null) {
            return;
        }
        
        ksumpaths(node.left, k-node.data, anf + " " + node.data +" ");
        ksumpaths(node.right, k-node.data, anf + " " + node.data +" ");
        
    }
    
    static void findSum(Node node,int k) {
        if(node == null) {
            return;
        }
        if(node.data == 5) {
//            System.out.println();
        }
        
        ksumpaths(node.left, k - node.data, "" + node.data);
        ksumpaths(node.right, k - node.data, "" + node.data);
        findSum(node.left, k);
        findSum(node.right, k);
    }

    static int ans = 0;
    
    private static void findLargestSubTree(Node node) {
        
        findMaxSum(node);
        System.out.println(ans);
        
    }


    
    private static int findMaxSum(Node node) {
       if(node == null) {
           return 0;
       }
      
       
       int val = node.data +  findMaxSum(node.left) + findMaxSum(node.right);
       
       ans = Math.max(ans, val);
       
       return val;
    }

    public static int sumOfLongRootToLeafPath1(Node root)
    {
        int hi = height1(root);
        findAns(root,hi,1,0);
        return ans;
    }
    
    static void  findAns(Node root,int hi,int curh,int curval){
        if(root == null){
            if(curh == hi){
                ans = Math.max(ans,curval);
            }
            return;
        }
        if(root.left == null && root.right == null){
            if(curh == hi){
                ans = Math.max(ans,curval);
            }
            return;
        }
        findAns(root.left,hi,curh+1,curval + root.data);
        findAns(root.right,hi,curh+1,curval + root.data);
        
    }
    
    static int  height1(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    
    public static int sumOfLongRootToLeafPath(Node root)
    {
        findAns(root,0);
        System.out.println(ans);
        return ans;
    }
    
    static void findAns(Node root,int val){
        if(root == null){
            ans = Math.max(ans,val);
            return;
        }
        if(root.left == null && root.right == null){
            ans = Math.max(ans,val);
            return;
        }
        
        val = val + root.data;
        findAns(root.left,val);
        findAns(root.right,val);
        val = val - root.data; 
        
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
        System.out.println(ans);
       return ans;       
}
}
