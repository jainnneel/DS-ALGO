package leetcode;

import java.util.HashMap;

import leetcode.Tree.TreeNode;

public class FindElements {
    
     public static class TreeNode {
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
        

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElements elements = new FindElements(root);
    }
    
    HashMap<Integer,Boolean> map = new HashMap<>();

    public FindElements(TreeNode root) {
        if(root!=null){
            root.val = 0;
            setvalues(root,0);
        }
    }
    
    public void setvalues(TreeNode root,int val){
        if(root.left==null && root.right==null){
            return;
        }
        
        int leftval = 0,rightval = 0;
        
        if(root.left!=null){
            leftval = 2*val + 1;
            this.map.put(leftval,true);
            root.left.val = leftval;
        }
        if(root.right!=null){
            rightval = 2*val + 2;
            this.map.put(rightval,true);
            root.right.val = rightval;
        }
        
        if(root.left!=null){
            setvalues(root.left,leftval);
        }
        if(root.right!=null){
             setvalues(root.right,rightval);
        }
        
    }
    
    public boolean find(int target) {
        return this.map.containsKey(target);
    }
}
