package problemsolving;

public class MyStack {
	
	int[] mStack = new int[10];
	int top = -1;
	
	public static void main(String[] args)
	{
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		System.out.println(stack.pop());
		stack.push(8);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	public void push(int i)
	{
		if(isFull())
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			top++;
			mStack[top] = i;	
		}
	}
	
	public int pop()
	{
		//Empty Stack
		if(!isEmpty())
		{
			return mStack[top--];
		}
		else
		{
			System.out.println("Empty Stack");
			return -1;	
		}
	}
	
	private boolean isEmpty()
	{
		if(top == -1)
			return true;
		
		return false;
	}
	
	private boolean isFull()
	{
		if(top >= mStack.length - 1)
			return true;
		
		return false;
	}

}
