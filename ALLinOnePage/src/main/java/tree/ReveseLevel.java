package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ReveseLevel {
    
    static class Node{
        int data;
        Node left;
        Node right;
    }
    
    
    static class lp{
        Node node;
        int level;
        
        lp(Node n,int l){
            node = n;
            level = l;
        }
    }
    
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        Queue<lp> qu = new LinkedList<>();
        
        if(node == null){
            return new ArrayList<>();
        }
        Map<Integer,List<Node>> map = new TreeMap<>(Collections.reverseOrder());
        qu.add(new lp(node,0));
        List<Node> l =  new ArrayList<>();
        l.add(node);
        map.put(0,l);
        while(!qu.isEmpty()){
            
            lp lr = qu.poll();
            
            if(map.containsKey(lr.level)){
                List<Node> lt =  map.get(lr.level);
                lt.add(lr.node);
                map.put(lr.level,lt);
            }else{
                 List<Node> lt =  new ArrayList<>();
                 lt.add(lr.node);
                 map.put(lr.level,lt);
            }
            
            if(lr.node.left != null) {
                qu.add(new lp(lr.node.left,lr.level+1));
            }
            if(lr.node.right != null) {
                qu.add(new lp(lr.node.right,lr.level+1));
            }
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,List<Node>> en : map.entrySet()){
            for(Node i : en.getValue()){
                ans.add(i.data);
            }
        }
        
        return ans;
    }
}
