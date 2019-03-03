package problemsolving;

/*
 * Write a sample code to reverse Singly Linked List by iterating through it only once.
 * http://www.java2novice.com/java-interview-programs/revese-singly-linked-list/
 */

public class LinkedList {

	private Node head;
	private Node tail;

	public LinkedList(){
		this.head = new Node(1);
		tail = head;
	}

	public Node head(){
		return head;
	}

	public void add(Node node){
		tail.next = node;
		tail = node;
	}
	
	public void deleteMiddleNode(int data)
	{
		/*
		 * Test case
		 * First Node 
		 * Last Node
		 * Duplicate data
		 * Empty list
		 * */
		
		if(head == null || head.data() == data)
			return;
		Node temp = head;
		Node prev = head;
		while(temp.getNext() != null  )
		{
			if(temp.data() == data)
			{
				prev.setNext(temp.getNext());
				break;
			}
			else
			{
				prev = temp;
				temp = temp.getNext();
			}
		}
	}

	public static class Node{
		private Node next;
		private int data;

		public Node(int data){
			this.data = data;
		}

		public int data() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public static void main(String args[]) {
		//creating LinkedList with 5 elements including head
		LinkedList linkedList = new LinkedList();
		LinkedList.Node head = linkedList.head();
		linkedList.add( new LinkedList.Node(2));
		linkedList.add( new LinkedList.Node(3));
		linkedList.add( new LinkedList.Node(3));
		linkedList.add( new LinkedList.Node(4));
		printList(linkedList);
		reverseList(linkedList);
		System.out.println("Reversed List: ");
		printList(linkedList);
		linkedList.deleteMiddleNode(1);
		System.out.println("After deleting 1 from List: ");
		printList(linkedList);
	}

	public static void printList(LinkedList linkedList)
	{
		Node node = linkedList.head();
		while(node != null)
		{
			System.out.print(" " + node.data());
			node = node.getNext();
		}
		System.out.println(" ");
	}

	public static void reverseList(LinkedList linkedList)
	{
		Node prev = null;
		Node current = linkedList.head();
		Node next = linkedList.head().getNext();
		while(next != null)
		{
			next = current.getNext();
			current.next = prev;
			prev = current;
			current = next;
		}
		linkedList.head = prev;
	}

}//end class
