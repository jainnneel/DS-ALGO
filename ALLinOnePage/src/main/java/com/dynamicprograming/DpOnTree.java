package com.dynamicprograming;

public class DpOnTree {
    
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
        @Override
        public String toString() {
            return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode cRoot = new TreeNode(1);
        cRoot.left = new TreeNode(2);
        cRoot.left.left = new TreeNode(4);
        cRoot.left.right = new TreeNode(5);
        
        cRoot.right = new TreeNode(3);
        cRoot.right.left = new TreeNode(6);
        cRoot.right.right = new TreeNode(7);
        System.out.println(diameterOfbinartTree(cRoot,0));
    }

    private static int diameterOfbinartTree(TreeNode cRoot, int res) {
        
        if (cRoot==null) {
            return 0;
        }
        int lh = height(cRoot.left);
        int rh = height(cRoot.right);
        
        int left = diameterOfbinartTree(cRoot.left,res);
        int right = diameterOfbinartTree(cRoot.right, res);
        
        int temp = Math.max(left, right);
        int ans = Math.max(temp,1+ lh+rh);
        res = Math.max(ans, res);
        
        return res;
    }
    
    private static int height(TreeNode node) {
        if (node==null) {
            return 0;
        }
        return  1 + Math.max(height(node.left),height(node.right));
        
    }
}









