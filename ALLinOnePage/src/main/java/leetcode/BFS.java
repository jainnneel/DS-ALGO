package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFS {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        
        n1.children =  new ArrayList<>(Arrays.asList(n2,n3,n4));
        n3.children =  new ArrayList<>(Arrays.asList(n5,n6));
        n4.children =  new ArrayList<>();
        n5.children =  new ArrayList<>();
        n2.children =  new ArrayList<>();
        n6.children =  new ArrayList<>();
        System.out.println(maxDepth(n1));
        
    }
    
    public static int maxDepth(Node root) {
        int max = 1;
         max  = maxDepthTree(root,max);
        return max;
    }
     static int maxDepthTree(Node root,int max){
         if(root.children == null && root.children.size()==0) {
             return max;
         }
         
         int h = max; 
         for(Node node : root.children){
             
             h = Math.max(h,maxDepthTree(node,max+1));
             
         }        
         return h;
    }
   
}






