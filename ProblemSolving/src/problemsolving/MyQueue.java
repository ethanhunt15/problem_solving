package problemsolving;

public class MyQueue<T> {

	private static class QueueNode<T>
	{
		T data;
		QueueNode<T> next;
		public QueueNode(T data)
		{
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item)
	{
		QueueNode<T> nextNode = new QueueNode<T>(item);
		if(last != null)
		{
			last.next = nextNode;	
		}
		last = nextNode;
		if(first == null)
		{
			first = last;
		}
	}

	//Removes the first item in the list
	public T remove()
	{
		if(first == null)
		{
			System.out.println("Empty Queue");
			return null;
		}
		T data = first.data;
		first = first.next;
		if(first == null)
		{
			last = null;
		}
		return data;
	}

	//Return top of the queue
	public T peek()
	{
		if(first == null)
		{
			System.out.println("Empty Queue");
			return null;
		}
		return first.data;
	}
	
	//Return true if the queue is empty
	public boolean isEmpty()
	{
		return first == null;
	}
}
