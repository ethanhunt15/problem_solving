package problemsolving;

public class TreeNode  implements Comparable{

	private int mData;
	private TreeNode mLeftNode;
	private TreeNode mRightNode;
	
	
	public TreeNode()
	{
		mData = -1;
		mLeftNode = null;
		mRightNode = null;
	}

	public TreeNode(int data)
	{
		mData = data;
		mLeftNode = null;
		mRightNode = null;
	}
	
	public TreeNode(int data, TreeNode left, TreeNode right)
	{
		mData = data;
		mLeftNode = left;
		mRightNode = right;
	}
	
	public TreeNode getLeftNode()
	{
		return mLeftNode;
	}

	public TreeNode getRightNode()
	{
		return mRightNode;
	}

	public int getData()
	{
		return mData;
	}

	public void setData(int data)
	{
		mData = data;
	}

	public void setLeftNode(TreeNode leftNode)
	{
		mLeftNode = leftNode;
	}

	public void setRightNode(TreeNode rightNode)
	{
		mRightNode = rightNode;
	}
	
	public int compareTo(Object o)
	{
	
	    if(this.mData == ((TreeNode)o).getData())
	        return 0;
	    else if (this.mData <((TreeNode)o).getData())
	        return 1;
	    else 
	        return -1;
	}
}// end class
