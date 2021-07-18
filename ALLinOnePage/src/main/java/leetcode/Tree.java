package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    
    static class Node {
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
    };
    
    
    
    
    
    
    public static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xParent = parent(root,x);
        TreeNode yParent = parent(root,y);
        if(xParent == yParent){
            return false;
        }else{
            return true;
        }
    }
    static TreeNode parent(TreeNode root, int x){
        if(root==null){
            return null;
        }
        
        if((root.left!=null && root.left.val==x)||(root.right!=null && root.right.val==x)){
            return root;
        }
        TreeNode parent = null;
      parent =   parent(root.left,x);
      if (parent!=null) {
        return parent;
    }
     parent =   parent(root.right,x); 
     if (parent!=null) {
         return parent;
     } 
        return parent;
    }
    
    public static void levelordertravel(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        
        treeNodes.add(root);
        
        printlevel(treeNodes);
        
    }
    
    private static void printlevel(Queue<TreeNode> treeNodes) {
        if (treeNodes.isEmpty()) {
            return;
        }
        TreeNode node = treeNodes.poll();
        System.out.println(node.val);
        
        if(node.left!=null) treeNodes.add(node.left);
        
        if(node.right!=null) treeNodes.add(node.right);
        
        printlevel(treeNodes);
    }

    public static int rangeSumBST(TreeNode root, int low, int high,int ans) {
        
//        if (root == null) {
//            return ans;
//        }
//        if (root.val<=high && root.val>=low) {
//            ans = ans + root.val;
//        }
//         rangeSumBST(root.left, low, high,ans);
//       
//        rangeSumBST(root.right, low, high,ans);
//        return ans;
        
        if(root == null) return ans;
        
        if(root.val<=high && root.val>=low) ans = ans + root.val;
        
        if(root.val < high) rangeSumBST(root.left, low, high,ans);
        else if(root.val > low) rangeSumBST(root.left, low, high,ans);
        
        return ans;
    }
    
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    
//        if (t1==null && t2==null) {
//            return null;
//        }
//        
//        if(t1!=null && t2!=null) {
//            t1.val = t1.val+t2.val;
//            mergeTrees(t1.left, t2.left);
//            mergeTrees(t1.right, t2.right);
//        }
//        if(t2==null) {
//            t1.val = t1.val;
//            mergeTrees(t1.left, t2);
//            mergeTrees(t1.right, t2);
//        }
//        if(t1==null) {
//            t1 = new TreeNode(t2.val);
//            mergeTrees(t1.left, t2.left);
//            mergeTrees(t1.right, t2.right);
//        }
//       
//        return t1;
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        int rootVal = t1.val + t2.val;
        TreeNode root = new TreeNode(rootVal);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root; 
        
    }
   
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        
        if(root.val==val){
            return root;
        }else if(root.val>val){
           TreeNode node = searchBST(root.left,val);
           return node;
        }else{
            TreeNode node = searchBST(root.right,val);
            return node;
        }
    }   
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
      Deque<Node> deque = new LinkedList<>();
      if (root == null) return list;
      
      deque.add(root);
      while(!deque.isEmpty()) {
          Node node = deque.removeLast();
          list.addFirst(node.val);
          for (Node child : node.children) {
              deque.add(child);
          }
      }
      return list;
  }
    public static int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        List<String> list = new ArrayList<>();
        list = getvalueList(root,"",list);
        for (String string : list) {
            ans = ans + Integer.parseInt(string, 2);
        }
        ans = getSum(root,new StringBuilder());
        return ans;
    }
        
    
    private static List<String> getvalueList(TreeNode root, String ans, List<String> list) {
        
        if (root==null) {
            list.add(ans);
            return list;
        }
        ans = ans + root.val;
        getvalueList(root.left, ans, list);
        getvalueList(root.right, ans, list);
        return list;
    }

    private static int getSum(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right == null){
            sb.append(root.val);
            int sum = Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length()-1);
            return sum;
        }
        
        sb.append(root.val);
        int left = 0, right = 0;
        if(root.left != null){
            left = getSum(root.left, sb);
        }
        if(root.right != null){
            right = getSum(root.right, sb);
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        
        return left+right;
    }
    public static int maxDepth(Node root) {
        int ans = 0;
        return ans;
    }
  
    public static boolean isUnivalTree(TreeNode root) {
        return uniOrNot(root,root.val);
    }
    public static boolean uniOrNot(TreeNode root,int val){
        if(root==null) return true;
        
        if(root.val != val) {
            return false;
        }else {
           if (!uniOrNot(root.left,val)) return false;
           if (!uniOrNot(root.right,val)) return false ;
            return true;
        }
    }
    static TreeNode prev=null;
    static TreeNode head=null;
 public static TreeNode increasingBST(TreeNode root) {
     if(root==null) return null;   
     increasingBST(root.left);  
     if(prev!=null) { 
         root.left=null; 
         prev.right=root; 
     }
     if(head==null) head=root; 
     prev=root; 
     increasingBST(root.right); 
     return head;
    }
 
     
 public static int maxDepth1(Node root) {
      
     
     
//   if(root==null) return 0;
//  
//  int left = 1 + maxDepth(root.left);
//  int right = 1 + maxDepth(root.right);
//  
//  return Math.max(left,right);
           int max = 1;
           max  = maxDepthTree(root,max);
          return max;
        }
        static int maxDepthTree(Node root,int max){
          if(root == null) return 0;
          
          for(Node node : root.children){
            int ans = 1 + maxDepthTree(node,max);
            if(ans > max) max = ans;  
          }        
          return max;
        }
         
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(5);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(9);
       
        isCousins(root,2,3);
        
//        TreeNode node =  increasingBST(root);
        System.out.println();
//        root.left = new TreeNode(0);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);
////        root.right.left.right = new TreeNode(8);
//        root.right.right = new TreeNode(1);
////        sumRootToLeaf(root);
//        TreeNode root1 = new TreeNode(2);
//        root1.left = new TreeNode(1);
////        root1.left.left = new TreeNode(3);
//        root1.left.right = new TreeNode(4);
//        root1.right = new TreeNode(3);
////        root1.right.left = new TreeNode();
////        root1.right.left.right = new TreeNode(8);
//        root1.right.right = new TreeNode(7);
////        System.out.println(rangeSumBST(root,6,10,0));
////        levelordertravel(root);
////       TreeNode ansNode =  mergeTrees(root,root1);
////        TreeNode increasingBST = increasingBST(root);
////        TreeNode searchBST = searchBST(root,2);
        Node node1 = new Node(1,Arrays.asList(new Node(3,Arrays.asList(new Node(5,null),new Node(6,null))),new Node(2,null
                ),new Node(4,null)));
       maxDepth1(node1);
//      System.out.println(  isUnivalTree(root));
        System.out.println();
       
        
    }
}


