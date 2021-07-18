package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

     static class ListNode{
        int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static void main(String[] args) {
        ListNode node  = new ListNode(5);
        node.next = new ListNode(2);
        node.next.next =  new ListNode(4);
//        node.next.next.next =  new ListNode(4);
//        node.next.next.next.next =  new ListNode(5);
//        node.next.next.next.next.next =  new ListNode(6);
//        middleNode(node);
        
        ListNode node1  = new ListNode(1);
        node1.next = new ListNode(1);
//        node1.next.next =  new ListNode(2);
//        node1.next.next.next =  new ListNode(3);
//        node1.next.next.next.next =  new ListNode(4);
//        node1.next.next.next.next.next =  new ListNode(5);
//        node1.next.next.next.next.next.next =  new ListNode(6);
//        mergeTwoLists(node, node1);
//        deleteDuplicates(node1);
//        isPalindrome(node1);
        removeElements(node1, 1);
//        mergeInBetween(node1, 2,5,node);
    }
    
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1= list1;
        ListNode temp2= list2;
        ListNode temp3= list1;
        int count = 1;
        while(b-- >=0){
            temp3 = temp3.next;
        }
        int diff = b-a+1;
        while(temp1!=null){
            if(count == a){
                temp1.next = temp2;
                break;
            }else{
                temp1 = temp1.next;
                count++;
            }
        }
     
        while(temp1.next!=null){
            temp1= temp1.next;
        }
        temp1.next = temp3;
        return list1;
    }
    
    
    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode prev = null;
        
        if(head==null) return null;
        
        if(temp.val == val){
            if(temp.next == null){
                return null;
            }else {
                temp.next = temp.next.next;
                prev = null;
            }    
        } 
        
        while(temp.next!=null){
            if(temp.val==val){
                prev.next = temp.next;
                temp = temp.next;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        if (temp.val==val) {
            prev.next = null;
        }
         return head;   
    }
    
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        if(temp==null){
            return true;
        }
        List<Integer> ans = new ArrayList<>();
        while(temp!=null){
            ans.add(temp.val);
            temp = temp.next;
        }
        for(int i = 0,j=ans.size()-1;i<ans.size();i++,j--){
            if(Math.abs(ans.get(i)-ans.get(j))!=0) {
                return false;
            }
        }
        return true;
    }
    
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(temp==null){
           return null;
       }
       Set<Integer> set = new HashSet<>();
       set.add(temp.val);
       temp = temp.next;
       ListNode prev = head;
       
       while(temp!=null){
           if(!set.add(temp.val)){
               prev.next = temp.next;
               temp = temp.next;
           }else{
               prev = temp;
               temp = temp.next;
           }
       }
       return head;
   }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = null;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        if(temp1==null) {
            return temp2;
        }else if(temp2==null){
            return temp1;
        }
//        ans = temp1.val<=temp2.val?new ListNode(temp1.val):new ListNode(temp2.val);
        if (temp1.val<=temp2.val) {
            ans = new ListNode(temp1.val);
            temp1 = temp1.next;
        }else {
            ans = new ListNode(temp2.val);
            temp2 = temp2.next;
        }
        ListNode temp = ans;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = new ListNode(temp1.val);
                temp1 = temp1.next;
                temp = temp.next;
            }
            else if(temp1.val>=temp2.val){
                temp.next = new ListNode(temp2.val);
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        while(temp1!=null){
            temp.next = new ListNode(temp1.val);
            temp1= temp1.next;
            temp = temp.next;
        }
        while(temp2!=null){
            temp.next = new ListNode(temp2.val);
            temp2= temp2.next;
            temp = temp.next;
        }
        return ans;
    }
    
    public static ListNode middleNode(ListNode head) {
        
        ListNode temp  =  head;
        
        if(temp==null){
            return null;
        }
        
        int count = 0;
        
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int i  =0;
        while(temp!=null){
            if(count%2==0 && i == Math.ceil((double)count/2)){
                return temp;
            }
            if(count%2==1 && i == Math.ceil((double)count/2)-1){
                return temp;
            }
            i++;
            temp = temp.next;
        }
        return null;
        
    }
}
