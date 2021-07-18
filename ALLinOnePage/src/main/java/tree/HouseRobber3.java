package tree;

public class HouseRobber3 {

     static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
    
     }
     
     public static int rob(TreeNode root) {
         
         if(root == null){
             return 0;
         }
         
         if(root.left == null && root.right==null){
             return root.val;
         }
         
         if(root.left == null || root.right == null){
             return 0;
         }
         
         int with = root.val +  rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
         int without = rob(root.left) + rob(root.right);
         
         return Math.max(with,without);
     }
     
     
    public static void main(String[] args) {
        
        TreeNode node  = new TreeNode(3);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        
        node.right.right = new TreeNode(1);
        
        System.out.println(rob(node));
        
    }

}