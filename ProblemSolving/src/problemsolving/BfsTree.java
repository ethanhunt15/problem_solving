package problemsolving;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class BfsTree {
	TreeNode mTreeRoot;
	
	
	public TreeNode getRootNode()
	{
     return mTreeRoot;
	}
	
	public void createTree()
	{

		mTreeRoot = insertNode(5,mTreeRoot);
		insertNode(3,mTreeRoot);
		insertNode(9,mTreeRoot);
		insertNode(1,mTreeRoot);
		insertNode(4,mTreeRoot);
		insertNode(6,mTreeRoot);
	}

	public TreeNode newNode(int data)
	{
		TreeNode node = new TreeNode();
		node.setData(data);
		node.setLeftNode(null);
		node.setRightNode(null);
		return node;
	}

	public TreeNode insertNode(int data,TreeNode node)
	{
		if(node ==  null)
		{
			node = newNode(data);
		}
		else if (node.getData() < data)
		{
			node.setRightNode(insertNode(data,node.getRightNode()));	
		}
		else
		{
			node.setLeftNode(insertNode(data,node.getLeftNode()));
		}

		return node;
	}
	
	public void printBfs()
	{
		if(mTreeRoot == null)
			return;
		ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
		queue.add(mTreeRoot);
		
		while(!queue.isEmpty())
		{
			TreeNode tn = queue.poll();
			System.out.println(tn.getData());
			
			if(tn.getLeftNode() != null)
			{
				queue.add(tn.getLeftNode());
			}
			
			if(tn.getRightNode() != null)
			{
				queue.add(tn.getRightNode());
			}
		}
	}
	
	public void printTree(TreeNode node)
	{
		if(node != null)
		{
			printTree(node.getLeftNode());
			System.out.println(" " + node.getData());
			printTree(node.getRightNode());
		}
		else
		{
			return;
		}
	}

	public void printTree()
	{
		printTree(mTreeRoot);
	}
	
	
	public static void main(String[] args) 
	 {
		BfsTree tree = new BfsTree();
		tree.createTree();
		System.out.println("======PRINTING TREE INORDER========");
		tree.printTree();
		System.out.println("======PRINTING TREE IN SHAPE========");
		BTreePrinter.printNode(tree.getRootNode());
		System.out.println("======PRINTING TREE BFS========");
		tree.printBfs();
	 }
}
