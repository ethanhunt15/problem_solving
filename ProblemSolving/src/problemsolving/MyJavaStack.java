package problemsolving;
/*
 * pop(): Remove the top item from the Stack
 * push(item): Add an item to the top of the Stack
 * peek() : return top of the stack
 * isEmpty() : Return true if and only if the stack is empty
 * */

public class MyJavaStack<T> {
	private static class StackNode<T>
	{
		private T data;
		private StackNode<T> next;

		public StackNode(T data)
		{
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop()
	{
		//if(top == null) throw new EmptyStackException();
		T poppedData = top.data;
		top = top.next;
		return poppedData;
	}

	public void push(T data)
	{
		StackNode<T> item = new StackNode<T>(data);
		item.next = top;
		top = item;
	}

	public T peek()
	{
		//if(top == null) throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty()
	{
		return top == null;
	}
}

