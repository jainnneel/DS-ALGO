package com.allinonepage.stack;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1 =null;
    Queue<Integer> q2 =null;
    
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(this.q1.isEmpty()){
            this.q1.offer(x);
        }else{
            while(!this.q1.isEmpty()){
                this.q2.offer(this.q1.poll());
            }
            this.q1.offer(x);
            while(!this.q2.isEmpty()){
                this.q1.offer(this.q2.poll());
            }
        } 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()) return true;
        else return false;
    }

}