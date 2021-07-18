package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS {

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
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
//        sumEvenGrandparent(root);
//        System.out.println(deepestLeavesSum(root));
        int[][] val = new int[][] {
            new int[] {4,3,1},
            new int[] {3,2,4},
            new int[] {3},
            new int[] {4},
            new int[] {}
        };
        
//        allPathsSourceTarget(val);
        printRootToLeaf(root,"");
        
    }
    
    private static void printRootToLeaf(TreeNode root,String st) {
        if(root==null){
            return;
        }
        printRootToLeaf(root.left,st+""+root.val);
        if(root.left==null && root.right==null) {
            System.out.println(st+""+root.val);
        }
        printRootToLeaf(root.right,st+""+root.val);
    }

    static LinkedList<Integer> adj[] = null;
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        adj = new LinkedList[graph.length];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList();
        }
        for(int i = 0; i < graph.length; i++){
            int j = 0;
            while(j<graph[i].length) {
                addEdge(i, graph[i][j]);
                j++;
            }
        }
        
        boolean[] v = new boolean[graph.length]; 
        List<Integer> l = new ArrayList<>();
        l.add(0);
        printpath(0,graph.length-1,v,l);
       return ans;
    }
    
    static void printpath(int src,int dest,boolean[] visited,List<Integer> sub){
        if(src==dest){
            ans.add(sub);
            visited = new boolean[visited.length];
            return;
        }
        visited[src] = true;
        for (int b : adj[src]) {
            if (visited[b]==false) {
                sub.add(b);
                printpath(b, dest, visited, sub);
                sub.remove(sub.size()-1);
                sub = new ArrayList<>();
                sub.add(0);
            }
        }
        visited[src] = false;
    }
    
    
   public static void addEdge(int source,int desti) {
        adj[source].add(desti);
    }

    
    
    static Integer sum = 0;
    
    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        dfs(root, null, null);
        return sum;
    }
    public static void dfs (TreeNode root, TreeNode parent, TreeNode grandParent) {
        if (root == null) return;
        
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += root.val;
        }
        
        if (root.left != null) {
            dfs(root.left, root, parent);   
        }
        if (root.right != null) {
            dfs(root.right, root, parent);   
        }
    }
    public static int deepestLeavesSum(TreeNode root) {
        int height = ht(root);
        return sum(root,height-1,0);
    }
    
    static int  sum(TreeNode root,int h,int ch){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null && ch==h){
            return root.val;
        }
        return sum(root.left,h,ch+1) + sum(root.right,h,ch+1);
    }
    
    static int ht(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = 1 + ht(root.left);
        int right = 1 + ht(root.right);
        return Math.max(left,right);
    }
}
