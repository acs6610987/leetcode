package n225_implement_stack_using_queues;

public class Test {
	public static void main(String[] args){
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
	}
}
