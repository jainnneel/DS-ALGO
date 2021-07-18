package leetcode;

public class MyCircularDeque {
   static int[] cq = null;
    static int f = 0;
    static int r = -1;
    static int size = 0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        cq = new int[k];
        r = k-1;
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (f==r) {
            return false;
        }
        cq[f++] = value;
        return true; 
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (f==r) {
            return false;
        }
        cq[r--] = value;
        return true; 
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(f==0  ) {
            return false;
        }
        f--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (r==size-1) {
            return false;
        }
        r++;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return cq[f];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return cq[r];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return f==0 && r==size-1 ? true : false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return f==r?true:false;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        circularDeque.insertLast(1);         // return true
        circularDeque.insertLast(2);            // return true
        circularDeque.insertFront(3);           // return true
        circularDeque.insertFront(4);           // return false, the queue is full
        circularDeque.getRear();            // return 2
        circularDeque.isFull();             // return true
        circularDeque.deleteLast();         // return true
        circularDeque.insertFront(4);           // return true
        circularDeque.getFront();           // return 4
    }
    
}










