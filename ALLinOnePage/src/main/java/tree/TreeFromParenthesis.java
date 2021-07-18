package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeFromParenthesis {

    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            super();
            this.left = null;
            this.right = null;
            this.data = data;
        }
        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }
        
    }
    
    public static void main(String[] args) {
        
        buildTree("1(2)(3)");
        
    }

    private static void buildTree(String s) {
       
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.contains(4);
        
        Node root = new Node(s.charAt(0)-48);
        int m = partition(s.substring(1));
        if(m==-1) {
            return;
        }
        buildL(root,s.substring(2,m));
        buildR(root,s.substring(m+2,s.length()-1));
        
        System.out.println();
    }

    private static void buildR(Node root, String s) {
        if (root==null || s.equals("")) {
            return;
        }
        
        root.right = new Node(s.charAt(0)-48);
        int m = partition(s.substring(1));
        if(m==-1) {
            return;
        }
        if (m <= s.length()) {
            buildL(root.right, s.substring(2,m));
        }
        if (m+2 <= s.length()-1) {
            buildR(root.right,s.substring(m+2,s.length()-1));
        }
    }

    private static void buildL(Node root, String s) {
        if (root==null || s.equals("")) {
            return;
        }
        
        root.left = new Node(s.charAt(0)-48);
        int m = partition(s.substring(1));
        if(m==-1) {
            return;
        }
        if (m <= s.length()) {
            buildL(root.left, s.substring(2,m));
        }
        if (m+2 <= s.length()-1) {
            buildR(root.left,s.substring(m+2,s.length()-1));
        }
    }

    private static int partition(String str) {
        if(str.equals("")) {
            return -1;
        }
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                st.push('(');
            }else if(!st.isEmpty() && str.charAt(i) == ')') {
                st.pop();
                if (st.isEmpty()) {
                    return i+1;
                }
            }
        }
        
        return 0;
    }
}

























