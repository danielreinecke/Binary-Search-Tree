package project;
/**
 * The Class Node.
 */
public class Node {
	
	/** The left child. */
	public Node leftChild;
	
	/** The right child. */
	public Node rightChild;
	
	/** The name. */
	public String name;
	
	/** The happiness index. */
	public Double happinessIndex;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param name the name
	 * @param happy the happy
	 */
	public Node(String name, double happy)
	{
		this.name = name;
		this.happinessIndex = happy;
	}
	
	/**
	 * Prints information about to the node
	 */
	public void  printNodeInfo()
	{
		System.out.printf("%-35s %-10.3f\n", name,happinessIndex);
	}
	
}   