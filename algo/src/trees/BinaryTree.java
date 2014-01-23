package trees;

//Node
//Lookup
//Insert
public class BinaryTree {
	private Node root;
	
	BinaryTree(){
		root = null;
	}
	private static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int ndata){
			data = ndata;
			left = null;
			right = null;
		}
	}
	
	public boolean lookup(int data){
		return lookup(root, data);
	}
	
	//required because the recursive function needs the 
	//reference node - the root
	public boolean lookup(Node node, int data){
		if(node==null) return false;

		if(node.data==data) return true;
		else if(data<node.data) lookup(node.left, data);
		else lookup(node.right, data);
		
		return false;
	}
	
	public void insert(int data){
		
		root=insert(root, data);
	}
	
	//insert always at leaf
	// THGHTS - see the interesting structure where existing nodes
	// are assigned to the recursive function. Now it is possible
	// that these nodes have child nodes, but the solution still 
	// works. Why? the idea is to treat the recursive function as 
	// its return type, Node, and then think that we are solving
	// just a root with right node, left node problem.
	private Node insert(Node node, int data){
		//Node current = root;
		if(node==null) node = new Node(data);
		
		else if(data<node.data) {
			//This causes reassignment, but the reassignment happens
			//to the right node.
			node.left=insert(node.left, data);
		}
		else{
			node.right=insert(node.right, data);
		}
			
		return node;
	}
	
	/**
	 * *************************** P R O B L E M S ***********************************
	 */
	/**
	 * NOTE the usage of two methods to calculate results - one regular, the other
	 * recursive. How would you display the results using only one method.
	 */
	//Problems
	//Problem 1a - calling Node constructor three time and using three pointers
	public void build123a(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		root = n2;
		root.left=n1;
		root.right=n3;
		
	}
	
	//Problem 1b - Use only one pointer variable
	public void build123b(){
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}
	
	//Problem 1c - Use insert
	public void build123c(){
		root = null;
		insert(root,2);
		insert(root,1);
		insert(root,3);
	}
	
	//Problem 2 - Given BT, calculate size
	public int size(){
		return size(root);
	}
	private int size(Node node){
		if (node == null) return (0);
		return size(node.left)+1+size(node.right);
		
	}
	
	//Problem 3 - calculate maxDepth
	public int maxDepth(){
		return maxDepth(root);
	}
	// Note - you can assume you are dealing with just one root and left, right node
	private int maxDepth(Node node){
		if(node==null) return 0;
		else{
			int ldepth = maxDepth(node.left);
			int rdepth = maxDepth(node.right);
			
			return 1+Math.max(ldepth, rdepth);
			
		}
		
	}
	
	//Problem 4 - min value in BST
	public int minValue(){
		return minValue(root);
	}
	
	private int minValue(Node node){
		if (node.left==null) return node.data;
		else{
			return minValue(node.left);
		}
	}
	
	//Problem 5 - print BST in increasing order
	public void printTree(){
		printTree(root);
	}
	
	private void printTree(Node node){
		//System.out.println(Integer.toString(node.data));
		if(node.left==null) {
			System.out.println(node.data);
			return;
		}
		else{
			System.out.println(node.data);
			printTree(node.left);
			
			printTree(node.right);
		}
	}
	
}
