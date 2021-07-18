package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.ItretiveTraveral.TreeNode;

public class CheckAnagramByLevel {

    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data) {
            super();
            this.data = data;
        }
        @Override
        public String toString() {
            return "Node [left=" + left + ", right=" + right + ", data=" + data + "]";
        }
    }
    
    public static void main(String[] args) {
        
        Node node1 = new Node(1);
        node1.left= new Node(3);
        node1.right = new Node(2);
        node1.right.left = new Node(5);
        node1.right.right = new Node(4);
        
        Node node2 = new Node(1);
        node2.left =new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        
//        System.out.println(checkAnagram(node1,node2));
//        
        iterative(node1);
        
//        postorderItretive(node1);
        
    }

    static void postorderItretive(Node root) {
        
        Stack<Node> stack = new Stack<>();
        Stack<Node> out = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if(pop.left!=null) stack.add(pop.left);
            if(pop.right!=null) stack.add(pop.right);
            out.add(pop);
        }
        
        while(!out.isEmpty()){
            System.out.println(out.pop().data);
        }
    }
    
    private static void iterative(Node root) {
        
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        
//        stack.push(root);
        
        while (currNode!=null || stack.size() > 0) {
            
            while (currNode != null) {
                stack.add(currNode);
                currNode = currNode.left;
            }
            Node eleNode = stack.pop();
            System.out.println(eleNode.data);
            
            currNode = eleNode.right;
        }
        
    }

    private static boolean checkAnagram(Node node1, Node node2) {
        
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        
        queue1.add(node1);
        queue2.add(node2);
        
        while (true) {
            
            if (queue1.size() != queue2.size()) {
                return false;
            }
            
            if (queue1.size() == 0) {
                break;
            }
            
            List<Integer> curr1 = new ArrayList<>();
            List<Integer> curr2 = new ArrayList<>();
            int n = queue1.size();
            while (n-- > 0) {
                
                Node q1 = queue1.poll();
                
                Node q2 = queue2.poll();
                
                if(q1.left!=null) {
                    queue1.add(q1.left);
                }
                if (q2.left!=null) {
                    queue2.add(q2.left);
                }
                if(q1.right!=null) {
                    queue1.add(q1.right);
                }
                if (q2.right!=null) {
                    queue2.add(q2.right);
                }
                curr1.add(q1.data);
                curr2.add(q2.data);
            }
            
            Collections.sort(curr1);
            Collections.sort(curr2);
            System.out.print(curr1);
            System.out.print(curr2);
            System.out.println();
            if (!curr1.equals(curr2)) {
                return false;
            }
            
        }
        return true;
    }
    
    
}





















