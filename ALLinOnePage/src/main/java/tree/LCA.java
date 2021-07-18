package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class a{
    int i = 10;
}

class b extends a{
   int i = 20;
}

public class LCA {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        
//        Deque<Integer> deque = new LinkedList<>();
//        
//        a av =  new b();
//        System.out.println(av.i);
//        List<Integer> c = new ArrayList<Integer>();
//        Collections.unmodifiableCollection(c).add(4);
//        c.add(5);
//        c.remove(0);
        Node node = new Node(3);
        node.left = new Node(4);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
//        node.left.right = new Node(9);
//        node.left.left.left = new Node(10);
//        node.left.left.right = new Node(5);

        node.right = new Node(5);
        node.right.right = new Node(1);
//        node.right.right = new Node(4);
//        node.right.left.left = new Node(4);
//        dupSub(node);

//        findLca(node,5,7);
        
        int in[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        
//        printPostOrder(in,pre,0,in.length -1);
        
        System.out.println(rob(node));
        
    }
    
    public static int rob(Node root) {
        
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right==null){
            return root.data;
        }
        
        if(root.left != null || root.right == null){
            return 0;
        }
        
        int with = root.data +  rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
        int without = rob(root.left) + rob(root.right);
        
        return Math.max(with,without);
    }
    
    
    static int preIndex = 0;
    private static void printPostOrder(int[] in, int[] pre, int inStrt, int inEnd) {
        
        if (inStrt > inEnd)
            return;       
 
        int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);
 
        printPostOrder(in, pre, inStrt, inIndex - 1);
 
        printPostOrder(in, pre, inIndex + 1, inEnd);
 
        System.out.print(in[inIndex]);
        
    }

    static int search(int[] in, int startIn, int endIn, int data)
    {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)
                return i;           
        return i;
    }

    static int dupSub(Node root) {

        Map<String, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        fillMap(root, map);

        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getKey().length() > 1 && en.getValue() > 1) {
                list.add(findNode(root, en.getKey().charAt(0)));
            }
        }
        return 0;
    }

    private static Node findNode(Node root, char ch) {

        if (root == null) {
            return null;
        }

        Node leftNode = findNode(root.left, ch);

        if (leftNode != null) {
            return leftNode;
        }
        if (root.data == ch - 48) {
            return root;
        }

        Node rifNode = findNode(root.right, ch);

        if (rifNode != null) {
            return rifNode;
        }
        return null;
    }

    static String fillMap(Node root, Map<String, Integer> map) {
        if (root == null) {
            return "$";
        }

//        if (root.left == null && root.right == null) {
//            return root.data+"";
//        }

        String left = fillMap(root.left, map);
        String right = fillMap(root.right, map);

        String rootString = root.data + " " + left + right;

        map.put(rootString, map.getOrDefault(rootString, 0) + 1);

        return rootString;
    }

    private static Node findLca(Node node, int n1, int n2) {

        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node leftNode = findLca(node.left, n1, n2);
        Node rightNode = findLca(node.right, n1, n2);

        if (leftNode != null && rightNode != null) {
            return node;
        }

        return leftNode != null ? leftNode : rightNode;

    }
}
