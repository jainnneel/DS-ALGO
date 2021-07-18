package com.allinonepage;

public class LinkedList {
    static Node head;
    
    static class Node {
 
        int data;
        Node next;
 
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    static Node reveseRecursive(Node node,Node prev,Node next,Node head) {
        if(node ==  null) {
            head = prev;
            return head;
        }
        next = node.next;
        node.next = prev;
        prev = node;
        node = next;
        
        return reveseRecursive(node, prev, next,head);
    }
    
    /* Function to reverse the linked list */
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
 
    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    static Node deletenode(int i,Node root) {
        
        Node temp = root;
        Node preNode = null;
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        if(i==0){
            head = head.next;
            return head;
        }
        int n = 0;
        while (i!=n) {
            n++;
            preNode = temp;
            temp = temp.next;
        }
        preNode.next = temp.next;
        return root;
    }
    static int findMergeNode(Node head1, Node head2) {
//        if(head1==null || head2==null){
//            return 0;
//        }
//        if(head1.next==null || head2.next==null){
//            return 0;
//        }
//        Node temp1 = head1;
//        Node temp2 = head2;
//        
//        while(temp1!=null && temp2!=null){
//            if(temp1.next.hashCode() == temp2.next.hashCode()){
//                return temp1.next.data;
//            }else{
//                temp1 = temp1.next;
//                temp2 = temp2.next;
//            }
//        }
//        if(temp1.hashCode() == temp2.hashCode()){
//            return temp1.data;
//        }
        while(head1!=null || head2!=null){
            if(head1==head2){
                if(head1!=null){
                    return head1.data;
                }else{
                    return head2.data;
                }
            }
            if(head1!=null){
                head1 = head1.next;
            }
            if(head2!=null){
                head2= head2.next;
            }           
        }
        return 0;    
//        Node currentA = headA;
//        Node currentB = headB;
//
//        //Do till the two nodes are the same
//        while(currentA != currentB){
//            //If you reached the end of one list start at the beginning of the other one
//            //currentA
//            if(currentA.next == null){
//                currentA = headB;
//            }else{
//                currentA = currentA.next;
//            }
//            //currentB
//            if(currentB.next == null){
//                currentB = headA;
//            }else{
//                currentB = currentB.next;
//            }
//        }
//        return currentB.data;
    }
    // Driver Code
    public static void main(String[] args)
    {
//        LinkedList list2 = new LinkedList();
//        list2.head = new Node(1);
//        LinkedList list = new LinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4); 
        
       Node reNode =  reveseRecursive(head,null,head.next,head);
        
        System.out.println();
//        findMergeNode(list.head,list2.head);
        
//        list.head.next = new Node(15);
//        list.head.next.next = new Node(4);
//        list.head.next.next.next = new Node(20);
//        deletenode(0,head);
        
//        System.out.println("Given Linked list");
//        list.printList(head);
//        head = list.reverse(head);
//        System.out.println("");
//        System.out.println("Reversed linked list ");
//        list.printList(head);
    }
}

//static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
//    SinglyLinkedListNode tempw = head;
//    if(head==null){
//        return null;
//    }
//    if(head.next==null){
//        return head;
//    }
//    while(tempw.next!=null){
//        SinglyLinkedListNode nextTemp = tempw.next;
//        if(tempw.data == nextTemp.data){
//            // SinglyLinkedListNode mTemp = tempw;
//            tempw.next = nextTemp.next;
//        }else{
//            tempw = tempw.next;
//        }
//    }
//    return head;
//}
