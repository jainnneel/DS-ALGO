package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.BFS.Node;

public class NaryTree {
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        
        n1.children =  new ArrayList<>(Arrays.asList(n3,n2,n4));
        n3.children =  new ArrayList<>(Arrays.asList(n5,n6));
        n4.children =  new ArrayList<>();
        n5.children =  new ArrayList<>();
        n2.children =  new ArrayList<>();
        n6.children =  new ArrayList<>();
//        System.out.println(maxDepth(n1));
//        nAryPostOrder(n1);
        levelOrder(n1);
    }

    private static List<List<Integer>> levelOrder(Node root) {
        // 1. initialise our result holding variable
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        // 2. Initialize queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); //start by adding the root
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>(); // inorder to store the current level items
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node temp = queue.poll(); // pop out the first element from the queue.
                current.add(temp.val);   // add the element into current list.
                queue.addAll(temp.children); // add all the children of the node to the queue.
            }
            result.add(current);  // we have all the elements of current level and add it into the final result
        }
        return result;        
    }

    private static int maxDepth(Node n1) {
        if(n1.children==null && n1.children.size()==0) {
            return 0;
        }
        int max = 0;
        for (Node node : n1.children) {
            max = Math.max(max,maxDepth(node));
        }
        return max+1;
    }
    
    private static void nAryPreOrder(Node n1) {
        if(n1==null) {
            return;
        }
        System.out.println(n1.val);
        for (Node  node : n1.children) {
            nAryPreOrder(node);
        }
    }
    private static void nAryPostOrder(Node n1) {
        if(n1==null) {
            return;
        }
        for (Node  node : n1.children) {
            nAryPostOrder(node);
        }
        System.out.println(n1.val);
    }
    
}
