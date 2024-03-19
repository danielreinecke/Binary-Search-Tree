package project;

import java.util.ArrayList;
/**
 * The Class BinarySearchTree.
 */
public class BinarySearchTree
{

	/** The root. */
	private Node root;
	
	/** The list. */
	private Node[] list;

	/**
	 * Instantiates a new binary search tree.
	 */
	public BinarySearchTree()
	{
		root = null;//set root
	}
	
	/**
	 * Inserts a new node into the tree
	 *
	 * @param name the name
	 * @param happiness the happiness
	 */
	public void insert(String name, double happiness)
	{
		Node newNode = new Node(name,happiness);
		
		if(root == null)//sets root node
		{
			root = newNode;
		}
		else
		{
			Node currentNode = root;
			Node parent;
			while(true)//loops until insert
			{
				parent = currentNode;
				int result = currentNode.name.compareToIgnoreCase(name);
				if(0 < result)//goes to the left
				{
					currentNode = currentNode.leftChild;
					if(currentNode == null)//inserts
					{
						parent.leftChild = newNode;
						break;
					}
				}
				else//goes to the right
				{
					currentNode = currentNode.rightChild;
					if(currentNode == null)// inserts
					{
						parent.rightChild = newNode;
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Finds a node in the tree and gives it's path
	 *
	 * @param name the name
	 * @return the double
	 */
	public double find(String name)//check
	{
		ArrayList<String> path = new ArrayList<String>();//check for path
		Node current = root;
		
		while(!current.name.equals(name))//check if node is found
		{
			path.add(current.name);
			int result = current.name.compareToIgnoreCase(name);
			if(0 < result)//goes left
			{
				current = current.leftChild;
			}
			
			else//goes right
			{
				current = current.rightChild;
			}
			
			if(current == null)// node was not found
			{
				System.out.println(name + " is not found");
				return -1;
			}
		}
			System.out.print("Path to " + name + " is ");
			for(int i = 0; i < path.size(); i++)
			{
				System.out.print(path.get(i) + " -> ");
			}
			System.out.println(name);
			System.out.println( name + " is found with a happiness index of " + current.happinessIndex);
		
		return current.happinessIndex;
	}

	/**
	 * Deletes a node in the tree
	 *
	 * @param name the name
	 */
	public void delete(String name)
	{
		Node current = root;
		Node parent = root;
		
		boolean leftChild = true;
		
		while(!current.name.equals(name))//finds node
		{
			parent = current;
			int result = current.name.compareToIgnoreCase(name);
			
			if(result > 0)//goes left
			{
				leftChild = true;
				current = current.leftChild;
			}
			else//goes right
			{
				leftChild = false;
				current = current.rightChild;
			}
			
			if(current == null)//node not found
			{
				System.out.println("Node not found");
				return;
			}
		}
			
			if(current.leftChild == null && current.rightChild == null)//no children
			{
				if(current == root)
				{
					root = null;
				}
				else if(leftChild)
				{
					parent.leftChild = null;
				}
				else
				{
					parent.rightChild = null;
				}
			}
			
			else if(current.rightChild == null)//no right child
			{
				if(current == root)
				{
					root = current.leftChild;
				}
				else if(leftChild)
				{
					parent.leftChild = current.leftChild;
				}
				else
				{
					parent.rightChild = current.leftChild;
				}
			}
			
			else if(current.leftChild == null)//no left child
			{
				if(current == root)
				{
					root = current.rightChild;
				}
				else if(leftChild)
				{
					parent.leftChild = current.rightChild;
				}
				else
				{
					parent.rightChild = current.rightChild;
				}
			}
			
			else//has both children
			{
				Node successor = getSuccessor(current);
				
				if(current == root)
				{
					root = successor;
				}
				else if(leftChild)
				{
					parent.leftChild = successor;
				}
				else
				{
					parent.rightChild = successor;
				}
				
				successor.leftChild = current.leftChild;
				
			}
			
			System.out.println("Deleted " + name + "\n");
		}
	
	/**
	 * Find the successor of a node that is being deleted
	 *
	 * @param node the node
	 * @return the successor
	 */
	private Node getSuccessor(Node node)
	{
		Node succParent = node;
		Node successor = node;
		Node current = node.rightChild;
		
		while(current != null)
		{
			succParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != node.rightChild)
		{
			succParent.leftChild = successor.rightChild;
			successor.rightChild = node.rightChild;
		}
		
		return successor;
	}
	
	/**
	 * Sets up and calls the printInorder method
	 */
	public void printInorder()
	{
		System.out.println("\nInorder:");
		System.out.println("Country Name                    |   Happiness Index |");
		printInorder(root);
	}
	
	/**
	 * Sets up and calls the printPreorder method
	 */
	public void printPreorder()
	{
		System.out.println("\nPreorder:");
		System.out.println("Country Name                    |   Happiness Index |");
		printPreorder(root);
	}
	
	/**
	 * Sets up and calls the printPostorder method
	 */
	public void printPostorder()
	{
		System.out.println("\nPostorder:");
		System.out.println("Country Name                    |   Happiness Index |");
		printPostorder(root);
	}
	
	/**
	 * Prints the tree in-order
	 *
	 * @param node the node
	 */
	private void printInorder(Node node)//check
	{
		if(node == null)//goes to next step when null
		{
			return;
		}
			printInorder(node.leftChild);
			node.printNodeInfo();//prints between left and right
			printInorder(node.rightChild);
	}
	
	/**
	 * Prints the tree in pre-order.
	 *
	 * @param node the node
	 */
	private void printPreorder(Node node)//check
	{
		if(node == null)//goes to next step when null
		{
			return;
		}
		node.printNodeInfo();//prints before going left or right
		printPreorder(node.leftChild);
		printPreorder(node.rightChild);
	}
	
	/**
	 * Prints the tree in post-order.
	 *
	 * @param node the node
	 */
	private void printPostorder(Node node)//check
	{
		if(node == null)//goes to next step when null
		{
			return;
		}
		printPostorder(node.leftChild);
		printPostorder(node.rightChild);
		node.printNodeInfo();//prints after going as far to the left and then right as possible
	}
	
	/**
	 * Prints the bottom c countries based on happiness index
	 *
	 * @param c the c
	 */
	public void printBottomCountries(int c)//check
	{
		System.out.println("\nBottom " + c + " countries regarding happiness:\n");
		System.out.println("Country Name                    |   Happiness Index |");
		list = new Node[c];
		
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = new Node(null,1000000000);
			findSmall(root,i);
		}
		
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].name == null)
			{
				break;
			}
			list[i].printNodeInfo();
		}
		
		
	}
	
	/**
	 * Finds the next smallest happiness index value in the nodes
	 *
	 * @param node the node
	 * @param i the i
	 */
	private void findSmall(Node node,int i)//check
	{
		if(node == null)//goes to next step when null
		{
			return;
		}
		
		findSmall(node.leftChild,i);
		if(i != 0)
		{
			if(list[i].happinessIndex > node.happinessIndex && list[i-1].happinessIndex < node.happinessIndex)
			{
				list[i] = node;
			}
		}
		else
		{
			if(list[i].happinessIndex > node.happinessIndex)
			{
				list[i] = node;
			}
		}
		findSmall(node.rightChild,i);
	}
	
	/**
	 * Prints the top c countries based on happiness index
	 *
	 * @param c the c
	 */
	public void printTopCountries(int c)
	{
		System.out.println("\nTop " + c + " countries regarding happiness:\n");
		System.out.println("Country Name                    |   Happiness Index |");
		list = new Node[c];
		
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = new Node(null,0);
			findLarge(root,i);
		}
		
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].name == null)
			{
				break;
			}
			list[i].printNodeInfo();
		}
	}
	
	/**
	 * Finds the next largest happiness index value in the nodes
	 *
	 * @param node the node
	 * @param i the i
	 */
	private void findLarge(Node node,int i)
	{
		if(node == null)//goes to next step when null
		{
			return;
		}
		
		findLarge(node.leftChild,i);
		if(i != 0)
		{
			if(list[i].happinessIndex < node.happinessIndex && list[i-1].happinessIndex > node.happinessIndex)
			{
				list[i] = node;
			}
		}
		else
		{
			if(list[i].happinessIndex < node.happinessIndex)
			{
				list[i] = node;
			}
		}
		findLarge(node.rightChild,i);
	}
}
