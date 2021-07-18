package com.allinonepage;

import java.util.Scanner;

public  class tree {
   static  class Node {
        int data;
        Node left;
        Node right;
        public Node( Node left, Node right,int data) {
            super();
            this.left = left;
            this.right = right;
            this.data = data;
        }
        public Node() {
            super();
            // TODO Auto-generated constructor stub
        }
        public Node(int data) {
            super();
            this.data = data;
        }
   }

   static boolean helper(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return helper(root.left, min, max - 1) && helper(root.right, min + 1, max);
    }

   static boolean checkBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        Node node = new Node(7);
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(null,null,4);
        Node node4 = new Node(null,null,6);
        Node node5 = new Node(null,null,8);
        Node node6 = new Node(null,null,11);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        checkBST(node);
//        scanner.close();
        
    }
}



//void decode(String s, Node root) {
//    // 1001011
//    if(s == null){
//        return;
//    }else{
//        Node temp = root;
//        char[] ch = s.toCharArray();
//        for(int i = 0;i<ch.length;i++){
//            if(ch[i] == '1'){
//               temp = temp.right; 
//               
//            }else{
//                temp = temp.left;
//            }
//            if(temp.left == null && temp.right == null){
//                System.out.print(temp.data); 
//                temp = root;
//            }
//        }
//    }

//public static void main(String[] args) {
//    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//    
//    Scanner sc = new Scanner(System.in);
//    
//    String f = sc.nextLine();
//    String[] fs = f.split(" ");
//    
//    int N = fs[0];
//    int M = fs[1];
//    
//    int arr[] = new int[N];
//    
//    for(int i = 1; i <= N; i++ ){
//        arr[i] = sc.nextInt();
//    }
//    
//    int query[][] = new int[M][2];
//    
//    for(int i = 0; i<M ; i++){
//        for(int j = 0 ; j<N ; j++){
//            query[i][j] = sc.nextInt();
//        }
//    }
//    
//    int ans[] = manu(a,q);
//    
//    for(int i:ans){
//        System.out.print(i+" ");
//    }
//    
//}