package com.allinonepage.stack;

public class StackUsingMiddle {

    static class Doubly{
        int data;
        Doubly prev;
        Doubly next;
        
        public Doubly(int data) {
            super();
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Doubly(int data, Doubly prev, Doubly next) {
            super();
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    
    static class MiddleStack{
        Doubly top;
        Doubly middle;
        int counter;
        public MiddleStack(Doubly top, Doubly middle,int counter) {
            super();
            this.top = top;
            this.middle = middle;
            this.counter = counter;
        }
       
        public void push(MiddleStack middleStack, int i) {
            
            if (middleStack.counter == 0) {
                Doubly doubly = new Doubly(i);
                middleStack.middle = doubly;
                middleStack.top = doubly;
            }else {
                if (middleStack.counter%2==0) {
                    Doubly doubly = new Doubly(i);
                    middleStack.middle = middleStack.middle.next;
                    Doubly topDoubly = middleStack.top;
                    topDoubly.next = doubly;
                    doubly.prev = topDoubly;
                    middleStack.top = doubly;
                }else {
                    Doubly doubly = new Doubly(i);
                    Doubly topDoubly = middleStack.top;
                    topDoubly.next = doubly;
                    doubly.prev = topDoubly;
                    middleStack.top = doubly;
                }
            }
            middleStack.counter++;
        }

        public int pop(MiddleStack middleStack) {
            if (middleStack.counter%2==1) {
                if (middleStack.top!=null) {
                    int data = middleStack.top.data;
                    Doubly prev = middleStack.top.prev;
                    middleStack.middle = middleStack.middle.prev;
                    prev.next = null;
                    middleStack.top = prev;
                    middleStack.counter--;
                    return data;
                }else {
                    return -1;
                }
            }else {
                if (middleStack.top!=null) {
                    int data = middleStack.top.data;
                    Doubly prev = middleStack.top.prev;
                    prev.next = null;
                    middleStack.top = prev;
                    middleStack.counter--;
                    return data;
                }else {
                    return -1;
                }
            }
        }

        public void deletemiddle(MiddleStack middleStack) {
            
            if (middleStack.counter%2 == 0) {
                Doubly pre = middleStack.middle.prev;
                Doubly next = middleStack.middle.next;
                middleStack.middle.prev.next = middleStack.middle.next;
                middleStack.middle.next = pre;
                middleStack.middle = next;
            }else {
                Doubly pre = middleStack.middle.prev;
                middleStack.middle.prev.next = middleStack.middle.next;
                middleStack.middle.next.prev = pre;
                middleStack.middle = pre;
            }
            
        }
    }        
    
    public static void main(String[] args) {
        MiddleStack middleStack = new MiddleStack(null,null,0);
        middleStack.push(middleStack , 5);
        middleStack.push(middleStack , 10);
        middleStack.push(middleStack , 7);
        middleStack.push(middleStack , 93);
        middleStack.pop(middleStack);
        System.out.println(middleStack.middle.data);
        middleStack.deletemiddle(middleStack);
        System.out.println(middleStack.middle.data);
    }
}




















