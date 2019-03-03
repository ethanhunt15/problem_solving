package problemsolving;

public class DoubleLinkListNode {
	private int data;
	DoubleLinkListNode nextNode;
	DoubleLinkListNode prevNode;

	public void setNextNode(DoubleLinkListNode node)
	{
		nextNode = node;
	}

	public DoubleLinkListNode getNextNode()
	{
		return nextNode;
	}

	public void setPrevNode(DoubleLinkListNode node)
	{
		prevNode = node;
	}

	public DoubleLinkListNode getPrevNode()
	{
		return prevNode;
	}

	public void setData(int value)
	{
		data = value;
	}
	
	public int getData()
	{
		return data;
	}
}
