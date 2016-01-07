package n225_implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	Queue<Integer> pushQueue =  new LinkedList<>();
	Queue<Integer> popQueue = new LinkedList<>();
	Integer last = null;
    // Push element x onto stack.
    public void push(int x) {
        if(last != null)
        	pushQueue.offer(last);
        last = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue<Integer> tmp = pushQueue;
    	while(pushQueue.size() > 1)
    		popQueue.offer(pushQueue.poll());
    	last = pushQueue.poll();
    	pushQueue = popQueue;
    	popQueue = tmp;
    }

    // Get the top element.
    public int top() {
    	return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return pushQueue.isEmpty() && last == null;
    }
}