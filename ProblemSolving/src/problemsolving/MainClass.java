package problemsolving;

public class MainClass {

	private TreeNode mTreeRoot = null;

	public static void main(String[] args) {
		MainClass m = new MainClass();
		m.createTree();

		// if(m.isBst(treeRoot))
		// {
		// System.out.println("VALID BST");
		// }
		// else
		// {
		// System.out.println("INVALID BST");
		// }

		System.out.println("MIN: " + m.getMin());
		System.out.println("MAX: " + m.getMax());
		System.out.println("Tree Size: " + m.getTreeSize());
		System.out.println("Tree Depth: " + m.maxDepth());
		System.out.println("Inorder Tree:");
		m.printTree();
		System.out.println("Pre order Tree:");
		m.printPreOrder();
		System.out.println("Post order Tree:");
		m.printPostOrder();

	}

	public int getMin() {
		if (mTreeRoot != null) {
			TreeNode node = mTreeRoot;
			while (node.getLeftNode() != null) {
				node = node.getLeftNode();
			}
			return node.getData();
		} else
			return -1;

	}

	public int getMax() {
		if (mTreeRoot != null) {
			TreeNode node = mTreeRoot;
			while (node.getRightNode() != null) {
				node = node.getRightNode();
			}
			return node.getData();
		} else
			return -1;
	}

	public boolean isBst(TreeNode node) {
		int rootData = mTreeRoot.getData();
		if (node == null) {
			System.out.println("Node == null");
			return true;
		} else {
			TreeNode leftNode = node.getLeftNode();
			TreeNode rightNode = node.getRightNode();
			boolean isValidLeft = leftNode != null
					? leftNode.getData() < node.getData() && leftNode.getData() < rootData : true;
			System.out.println("Left: " + String.valueOf(isValidLeft));
			boolean isValidRight = rightNode != null
					? rightNode.getData() > node.getData() && rightNode.getData() > rootData : true;
			System.out.println("Right: " + String.valueOf(isValidRight));
			if (!isValidRight) {
				System.out.println("Node = " + node.getData() + " Right data = " + rightNode.getData());
			}
			if (isValidLeft && isValidRight) {
				return isBst(rightNode) && isBst(leftNode);
			} else {
				System.out.println("Either left or right invalid");
				return false;
			}
		}
	}

	public void createTree() {

		mTreeRoot = insertNode(5, mTreeRoot);
		insertNode(3, mTreeRoot);
		insertNode(9, mTreeRoot);
		insertNode(1, mTreeRoot);
		insertNode(4, mTreeRoot);
		insertNode(6, mTreeRoot);
	}

	public TreeNode newNode(int data) {
		TreeNode node = new TreeNode();
		node.setData(data);
		node.setLeftNode(null);
		node.setRightNode(null);
		return node;
	}

	public TreeNode insertNode(int data, TreeNode node) {
		if (node == null) {
			node = newNode(data);
		} else if (node.getData() < data) {
			node.setRightNode(insertNode(data, node.getRightNode()));
		} else {
			node.setLeftNode(insertNode(data, node.getLeftNode()));
		}

		return node;
	}

	public int getSize(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return getSize(node.getLeftNode()) + 1 + getSize(node.getRightNode());
		}
	}

	public int getTreeSize() {
		return getSize(mTreeRoot);
	}

	public int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int lDepth = maxDepth(node.getLeftNode());
			int rDepth = maxDepth(node.getRightNode());
			return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
		}
	}

	public int maxDepth() {
		return maxDepth(mTreeRoot);
	}

	public void printTree(TreeNode node) {
		if (node != null) {
			printTree(node.getLeftNode());
			System.out.println(" " + node.getData());
			printTree(node.getRightNode());
		} else {
			return;
		}
	}

	public void printTree() {
		printTree(mTreeRoot);
	}

	public void printPostOrder(TreeNode node) {
		if (node == null)
			return;
		printPostOrder(node.getLeftNode());
		printPostOrder(node.getRightNode());
		System.out.println(node.getData());
	}

	public void printPreOrder(TreeNode node) {
		if (node == null)
			return;
		printPreOrder(node.getRightNode());
		printPreOrder(node.getLeftNode());
		System.out.println(node.getData());
	}

	public void printPostOrder() {
		printPostOrder(mTreeRoot);
	}

	public void printPreOrder() {
		printPreOrder(mTreeRoot);
	}

	public void hasPathSum() {

	}

	public TreeNode nextSuccessor(TreeNode node) {
		if (node != null) {
			while (node.getLeftNode() != null)
				node = node.getLeftNode();
		}
		return node;
	}

	public void deleteKey(int key) {
		mTreeRoot = deleteNode(mTreeRoot, key);
	}
	
	
	
	public TreeNode deleteNode(TreeNode node, int key) {
		if (node == null) {
			return node;
		}

		if (key < node.getData()) {
			node.setLeftNode(deleteNode(node.getLeftNode(), key));
		} else if (key > node.getData()) {
			node.setRightNode(deleteNode(node.getRightNode(), key));
		} else {
			// node with only one child or no child
			if (node.getLeftNode() == null) {
				return node.getRightNode();
			} else if (node.getRightNode() == null) {
				return node.getLeftNode();
			}

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			TreeNode nextSuccesor = nextSuccessor(node.getRightNode());

			// Copy the inorder successor's content to this node
			node.setData(nextSuccesor.getData());
			// Delete the inorder successor
			node.setRightNode(deleteNode(node.getRightNode(), nextSuccesor.getData()));
		}
		return node;
	}
}// end Class
