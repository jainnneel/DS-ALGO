package tree;

import java.util.Arrays;

public class SortedToBinarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28};
//        Node ansNode =  buildBalancedTree(arr,0,arr.length);   
        
        nextGreaterElement(arr);
        System.out.println();
    }
    
    
    private static void nextGreaterElement(int[] arr) {
        int[] cpy =  Arrays.copyOf(arr, arr.length);  
        Arrays.sort(arr);
        Node rootNode = buildBalancedTree(arr,0,arr.length);
        int[] ans = new int[arr.length];
        int in = 0;
        for(int i : cpy) {
            Node preNode = null;
            ans[in++] = fillNextGreater(rootNode,i,preNode);
        }
        
        System.out.println();
    }

    private static int fillNextGreater(Node rootNode, int i, Node preNode) {
        if(rootNode == null) {
            return -1;
        }
        if(rootNode.data == i) {
            if (preNode == null) {
               if (rootNode.right!=null) {
                   return rootNode.right.data;
                }  
            }
            if(rootNode.right!=null) {
                return Math.min(rootNode.right.data, preNode.data);
            }else {
                if (preNode!=null) {
                   return preNode.data;
                }
            }
        }
        int val = -1;
        if (rootNode.data > i) {
            preNode = rootNode;
           val =  fillNextGreater(rootNode.left, i, preNode);
        }else {
            preNode = rootNode;
           val =  fillNextGreater(rootNode.right, i, preNode);
        }
        
        return val;
    }


    private static Node buildBalancedTree(int[] arr,int st,int end) {
        
        if(st >= end) {
            return null;
        }
        
        int i = arr[(st + end)/2];
        
        Node firstNode =  new Node(i);
        
        firstNode.left = buildBalancedTree(arr,st,(st + end)/2);
        firstNode.right = buildBalancedTree(arr,((st + end)/2)+1,end);
        
        return firstNode;
        
    }
    
}




























