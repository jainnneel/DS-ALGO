package com.allinonepage;

public class Dll {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }


    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode dll = new DoublyLinkedListNode(data);
        if(head==null){
            return dll;
        }
        if(head.next==null){
            if (data < head.data) {
                dll.prev = null;
                head.prev = dll;
                dll.next = head;
                dll = head;
                return head;
            }else {
                dll.next = null;
                head.next = dll;
                dll.prev = head;
                dll.next.prev = dll;
                return head;
            }
        }
       
        DoublyLinkedListNode temp = head;
        while(temp!=null){
            
            if(temp.data>data){
                DoublyLinkedListNode prevs = temp.prev;
                if(prevs == null) {
                    dll.next = temp;
                    temp.prev = dll;
                    head = dll;
                    return head;
                }
                dll.prev = prevs;
                prevs.next = dll;
                dll.next = temp;
                temp.prev = dll;
                return head;
            }
            if (temp.next==null) {
                temp.next = dll;
                dll.prev = temp;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        DoublyLinkedListNode pre = null;
        while(temp != null){
            pre = temp.prev;
            temp.prev = temp.next;
            temp.next = pre;
            temp = temp.prev;
        }
        if (pre != null) {
            head = pre.prev;
        }
        return head;
    }


    public static void main(String[] args) {
        DoublyLinkedList llist = new DoublyLinkedList();
        llist.insertNode(1);
        llist.insertNode(3);
        llist.insertNode(4);
        llist.insertNode(10);
        
        DoublyLinkedListNode sortedInsert = sortedInsert(llist.head,5);

//        DoublyLinkedListNode sortedInsert = reverse(llist.head);
        while (sortedInsert!=null) {
            System.out.println(sortedInsert.data);
            sortedInsert  = sortedInsert.next;
        }
    }
}
//static int height(Node root){
//    
//    if(root == null){
//        return 0;
//    }else{
//     int lh  =  height(root.left);
//      int rh =  height(root.right);
//       
//         if(lh > rh){
//             return (lh + 1);
//        }   else{
//            return (rh + 1);
//         }
//    }
//  
//}
//
//static void bfs(Node root,int l){
//    if(root==null){
//        return;
//    }
//    if(l==1){
//        System.out.print(root.data+" ");
//    }else{
//        bfs(root.left,l-1);
//        bfs(root.right,l-1);   
//    }
//}
//
//public static void levelOrder(Node root) {
//  
//  int h = height(root);
//  for(int i = 1;h<=h;i++){
//      bfs(root,i);
//  }
//    
//  
//}

//public static Node lca(Node node, int n1, int n2) {
//    if (node == null) 
//        return null; 
//
//  
//    if (node.data > n1 && node.data > n2) 
//        return lca(node.left, n1, n2); 
//
//
//    if (node.data < n1 && node.data < n2)  
//        return lca(node.right, n1, n2); 
//
//    return node;
//}
