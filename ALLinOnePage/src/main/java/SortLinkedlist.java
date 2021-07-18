import java.math.BigInteger;

public class SortLinkedlist {

    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    static class DoublyList
    {
        int data;
        DoublyList next;
        DoublyList prev;
        DoublyList(int key)
        {
            data = key;
            prev = null;
            next = null;
        }
    }
    
    
    public static void main(String[] args) {
        Node node1 = new Node(12);
        node1.next = new Node(15);
        node1.next.next = new Node(10);
        node1.next.next.next = new Node(11);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = new Node(6);
        node1.next.next.next.next.next.next = new Node(2);
        node1.next.next.next.next.next.next.next = new Node(3);
        
//        mergeSort(node1);
//        isPalindrome(node1);
        
        DoublyList d1 = new DoublyList(3);
        d1.next = new DoublyList(6);
        d1.next.prev = d1;
        d1.next.next = new DoublyList(2);
        d1.next.next.prev = d1.next;
        d1.next.next.next = new DoublyList(12);
        d1.next.next.next.prev = d1.next.next;
        d1.next.next.next.next = new DoublyList(56);
        d1.next.next.next.next.prev = d1.next.next.next;
        d1.next.next.next.next.next = new DoublyList(8);
        d1.next.next.next.next.next.prev = d1.next.next.next.next;
//        d1.next.next.next.next.next.next = new DoublyList(9);
//        d1.next.next.next.next.next.next.prev = d1.next.next.next.next.next;
        
//        doublyList(d1);
//        ksorted(d1);
//        rotateDoublyLinkedList(d1);
//          reverseInGroup(d1);
//        compute(node1);
        FirstNonRepeating("aabc");
          System.out.println();
    }
    
    public static Node reverse(Node node, int k)
    {
        if(node == null){
            return null;
        }
        
        int cnt = k;
        
        Node curr = node;
        Node prev = null;
        Node next = null;
        
        while(curr!=null && cnt-- > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if(prev!=null){
            node.next = reverse(curr,k);
        }
        
        return prev;
    }
    
    
    public static String FirstNonRepeating(String a)
    {
       StringBuilder sb = new StringBuilder();
       int[] fre = new int[26];
       char pre = 123;
       for(int i = 0; i < a.length(); i++){
           fre[a.charAt(i)-'a']++;
           int ch =  firstOneIn(fre,a,i,pre);
           if(ch != -1){
               pre = (char)(ch+'a');
               sb.append((char)(ch+'a'));
           }else{
               sb.append("#");
           }
       }
       return sb.toString();
    }
    
    static int firstOneIn(int[] arr,String a,int l,char pre){
        int ans = -1;
        
        for(int i = 0; i < arr.length; i++){
            System.out.println(a.indexOf((char)(i+97)));
            if( a.indexOf(pre) == -1 ||  arr[i] == 1 && a.indexOf(pre) > a.indexOf((char)(i+97))){
                return i;
            }
        }
        return ans;
    }
    
    static Node compute(Node node)
    {
        
        if (node==null) {
            return node;
        }
        Node rhead = reverse(node);
        Node temp = rhead.next;
        Node prev = rhead;
        Node rbig = rhead;
        while(temp!=null){
            if(temp.data < rbig.data){
                    prev.next = temp.next;
                    temp = temp.next;
                
            }else{
                prev = temp;
                rbig.next = temp;
                rbig = rbig.next;
                temp = temp.next;
            }
        }
        return reverse(rhead);
    }
    
    static Node reverse(Node head){
        
        if(head == null){
            return null;
        }
        
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if(prev!=null){
            head = prev;
        }
        
        return head;
    }


    public long multiplyTwoLists(Node l1,Node l2){
        
        StringBuilder s1 = new StringBuilder();
        Node temp1 = l1;
        StringBuilder s2 = new StringBuilder();
        Node temp2 = l2;
        while(temp1!=null){
            s1.append(temp1.data);
        }
        
        while(temp2!=null){
            s2.append(temp2.data);
        }
        
        BigInteger lb1 = new BigInteger(s1.toString());
        BigInteger lb2 = new BigInteger(s2.toString());
        BigInteger m = new BigInteger("1000000007");
        return Long.valueOf(lb1.multiply(lb2).mod(m).toString());
        
 }
    Node mergeKList(Node[]arr,int K)
    {
        Node temp = new Node(0);
        while(true){
            int minIn = arr[0].data;
            int j = 0;
            for(j = 0; j < arr.length; j++){
               if( arr[j]!=null && arr[j].data >= minIn){
                   minIn = j;
               }
            }
            arr[j] = arr[j].next;
            temp.data = arr[j].data;
            temp.next = new Node(0);
            temp = temp.next;
        }
    }
    
    
    private static DoublyList reverseInGroup(DoublyList d1) {
        int count = 3;
        if (d1 == null) {
            return d1;
        }
        DoublyList curr = d1;
        DoublyList prev = null;
        while (count-- > 0 && curr!=null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        if (prev!=null) {
            d1.next = reverseInGroup(curr);
        }
        return prev;
    }

    private static void rotateDoublyLinkedList(DoublyList d1) {
        if(d1== null) {
            return;
        }
        
        DoublyList first = d1;
        DoublyList end = d1;
        
        while (end.next!=null) {
            end = end.next;
        }
        int N = 2;
        while (N-- > 0) {
            DoublyList temp = first;
            first = first.next;
            first.prev = null;
            end.next = temp;
            temp.prev = end;
            end = end.next;
            end.next = null;
        }
    }

    private static void ksorted(DoublyList d1) {
        if(d1 == null) {
            return;
        }
        int k = 2;
        
        DoublyList first = d1;
        int count = 0;
        int min = Integer.MAX_VALUE;
        DoublyList endw = first.next;
        while (first.next!=null) {
            endw = first.next;
            while (count < k) {
                if (first.data  <= endw.data) {
                    endw = endw.next;
                    count++;
                }else {
                    swap(first,endw);
                    first = first.next;
                    count--;
//                    endw = endw.next;
//                    count++;
                }
            }
//            first = first.next;
//            count--;
        }
        System.out.println();
    }

    private static void swap(DoublyList first, DoublyList endw) {
//        DoublyList temppre = first.prev;
//        DoublyList tempnext = first.next;
        int tdata = first.data; 
//        first.prev = endw.prev;
//        first.next = endw.next;
        first.data = endw.data;
//        endw.prev = temppre;
//        endw.next = tempnext;
        endw.data = tdata;
    }


    private static void doublyList(DoublyList d1) {
        if (d1 == null) {
            return;
        }
        int k = 17;
        
       DoublyList temp = d1;
       DoublyList start = d1;
       DoublyList end = d1;
       while (end.next!=null) {
           end = end.next;
       }
       DoublyList endt = end;
       while (temp != null) {
            start = temp.next;
            endt = end; 
            int sum = 0;
            while (start != endt && start!=null && endt!=null) {
                
                sum = start.data + endt.data + temp.data;
                
                if (sum == k) {
                    System.out.println(start.data +" "  +endt.data + " " +temp.data);
                    start = start.next;
                    endt = endt.prev;
                }else if (sum > k) {
                    endt = endt.prev;
                }else {
                    start = start.next;
                }
                
            }
            temp = temp.next;
       }
        
        
    }
    static boolean isPalindrome(Node head) 
    {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp!=null){
            sb.append(temp.data);
            temp = temp.next;
        }
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }else{
            return false;
        }
    }
    
    static Node mergeSort(Node head)
    {
        
        if(head == null || head.next == null){
            return null;
        }
        
        Node middle = middle(head);
        
        Node afterMid = middle.next;
        
        middle.next = null;
        
        Node left  = mergeSort(head);
        
        Node right = mergeSort(afterMid);
        
        Node sorted = sortedList(left,right);
        
        return sorted;
               
    }
    
    
    static Node sortedList(Node left , Node right){
        
        Node res = null;
        
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        
        if(left.data <= right.data){
            res = left;
            res.next = sortedList(left.next,right);
        }else{
            res = right;
            res.next = sortedList(left,right.next);
        }
        return res;
    }
    
    
    static Node middle(Node head){
        if(head == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    
}
