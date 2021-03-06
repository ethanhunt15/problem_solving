package problemsolving;

//Java program to convert a given Binary Tree to 
//Doubly Linked List

/* Structure for tree and Linked List */
class Node 
{
 int data;
 Node left, right;

 public Node(int data) 
 {
     this.data = data;
     left = right = null;
 }
}

public class TreeToDLL 
{
 // 'root' - root of binary tree
 Node root;
  
 // 'head' - reference to head node of created
 //double linked list
 Node head;
 Node prev = null;

 // A simple recursive function to convert a given
 // Binary tree to Doubly Linked List
 void BToDLL(Node root) 
 {
     // Base cases
     if (root == null)
         return;

     // Recursively convert right subtree
     BToDLL(root.right);

     // insert root into DLL
     root.right = head;

     // Change left pointer of previous head
     if (head != null)
         (head).left = root;

     // Change head of Doubly linked list
     head = root;

     // Recursively convert left subtree
     BToDLL(root.left);
 }

 // Utility function for printing double linked list.
 void printList(Node head) 
 {
     System.out.println("Extracted Double Linked List is : ");
     while (head != null) 
     {
         System.out.print(head.data + " ");
         head = head.right;
     }
 }
 
 /*Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
  * The left and right pointers in nodes are to be used as previous and next pointers 
  * respectively in converted DLL. 
  * The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
  * The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
  * */
 void newBtToDll(Node node)
 {
	 if(node == null)
		 return;
	 
	 newBtToDll(node.left);
	 
	 //prev == null means this is the first node
	 if(prev == null)
	 {
		 head = node;
	 }
	 else
	 {
		 //Connect prev to left pointer
		 node.left = prev;
		 prev.right = node;
	 }
	 prev = node;
	newBtToDll(node.right);
 }

 // Driver program to test the above functions
 public static void main(String[] args) 
 {
     /* Constructing below tree
            5
          /   \
         3     6
        / \     \
       1   4     8
      / \       / \
     0   2     7   9  */
      
	 TreeToDLL tree = new TreeToDLL();
     tree.root = new Node(5);
     tree.root.left = new Node(3);
     tree.root.right = new Node(6);
     tree.root.left.right = new Node(4);
     tree.root.left.left = new Node(1);
     tree.root.right.right = new Node(8);
     tree.root.left.left.right = new Node(2);
     tree.root.left.left.left = new Node(0);
     tree.root.right.right.left = new Node(7);
     tree.root.right.right.right = new Node(9);

     //tree.BToDLL(tree.root);
     tree.newBtToDll(tree.root);
     tree.printList(tree.head);
 }
}
