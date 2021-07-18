package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrder {

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
    
    static class obj{
        int hd;
        TreeNode treeNode;
        public obj() {
            super();
            // TODO Auto-generated constructor stub
        }
        public obj(int hd, TreeNode treeNode) {
            super();
            this.hd = hd;
            this.treeNode = treeNode;
        }
        public int getHd() {
            return hd;
        }
        public void setHd(int hd) {
            this.hd = hd;
        }
        public TreeNode getTreeNode() {
            return treeNode;
        }
        public void setTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
        @Override
        public String toString() {
            return "obj [hd=" + hd + ", treeNode=" + treeNode + "]";
        }
        
    }
    
    static void vertical(TreeNode root) {
//        Map<TreeNode, Integer> map = new HashMap<>();
//        map.put(root, 0);
//        printVertical(map,root);
        
        if (root==null) {
            return;
        }
        
        Queue<obj> objs = new LinkedList<>();
        Map<Integer,List<TreeNode>> map = new TreeMap<>();
        objs.add(new obj(0,root));
        ArrayList<TreeNode> value = new ArrayList<>();
        value.add(root);
        map.put(0,value);
        while (!objs.isEmpty()) {
            
            obj ele = objs.poll();
            
            if (map.containsKey(ele.hd)) {
                map.get(ele.hd).add(ele.treeNode); 
            }else {
                ArrayList<TreeNode> value1 = new ArrayList<>();
                value1.add(ele.treeNode);
                map.put(ele.hd,value1);
            }
            if (ele.treeNode.left!=null) {
                objs.add(new obj(ele.hd-1,ele.treeNode.left));
            }
            
            if (ele.treeNode.right!=null) {
                objs.add(new obj(ele.hd+1,ele.treeNode.right));
            }
        }
        for (List<TreeNode> object : map.values()) {
            for (TreeNode object2 : object) {
                System.out.println(object2.val);
            }
        }
    }
    
    private static void topView(TreeNode root) {
        Queue<obj> objs = new LinkedList<>();
        Map<Integer,TreeNode> map = new TreeMap<>();
        objs.add(new obj(0,root));
        map.put(0,root);
        while (!objs.isEmpty()) {
            
            obj ele = objs.poll();
            
            if (!map.containsKey(ele.hd)) {
                map.put(ele.hd,ele.treeNode);
            }
            if (ele.treeNode.left!=null) {
                objs.add(new obj(ele.hd-1,ele.treeNode.left));
            }
            
            if (ele.treeNode.right!=null) {
                objs.add(new obj(ele.hd+1,ele.treeNode.right));
            }
        }
        for (TreeNode object : map.values()) {
                System.out.println(object.val);
        }
        for(Map.Entry<Integer,TreeNode> e: map.entrySet()){
           
        }
    }
    private static void leftView(TreeNode root) {
        Queue<obj> objs = new LinkedList<>();
        Map<Integer,TreeNode> map = new TreeMap<>();
        objs.add(new obj(0,root));
        map.put(0,root);
        while (!objs.isEmpty()) {
            
            obj ele = objs.poll();
            
            if (!map.containsKey(ele.hd)) {
                map.put(ele.hd,ele.treeNode);
            }
            if (ele.treeNode.left!=null) {
                objs.add(new obj(ele.hd+1,ele.treeNode.left));
            }
            
            if (ele.treeNode.right!=null) {
                objs.add(new obj(ele.hd+1,ele.treeNode.right));
            }
        }
        for (TreeNode object : map.values()) {
                System.out.println(object.val);
        }
        
    }

    private static void rightView(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int count = 1;
       
       while (!queue.isEmpty()) {
           TreeNode node = queue.poll();
           count--;
          
           if(node.left!=null) {
               queue.add(node.left);
           }
           if(node.right!=null) {
               queue.add(node.right);
           }
           
           if (count==0) {
               System.out.println(node.val);
               count = queue.size();
           }

       }
    }


    private static void bottomView(TreeNode root) {
        Queue<obj> objs = new LinkedList<>();
        Map<Integer,TreeNode> map = new TreeMap<>();
        objs.add(new obj(0,root));
        map.put(0,root);
        while (!objs.isEmpty()) {
            
            obj ele = objs.poll();
            
            map.put(ele.hd,ele.treeNode);
            
            if (ele.treeNode.left!=null) {
                objs.add(new obj(ele.hd-1,ele.treeNode.left));
            }
            
            if (ele.treeNode.right!=null) {
                objs.add(new obj(ele.hd+1,ele.treeNode.right));
            }
        }
        for (TreeNode object : map.values()) {
                System.out.println(object.val);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
//        vertical(root);
//        topView(root);
        rightView(root);
//        leftView(root);
//        bottomView(root);
    }


    

    
//    private static void printVertical(Map<TreeNode, Integer> map, TreeNode root) {
//      if (root==null) {
//          return;
//      }
//      map.put(root.left, map.get(root)-1);
//      printVertical(map, root.left);
//      map.put(root.right, map.get(root)+1);
//      printVertical(map, root.right);
//      Map<TreeNode, Integer> sortedMap = 
//              map.entrySet().stream()
//             .sorted(Entry.comparingByValue())
//             .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
//                                       (e1, e2) -> e1, LinkedHashMap::new));
//      System.out.println(sortedMap);
//  }
}
