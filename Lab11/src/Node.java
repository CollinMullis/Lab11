/* Node:  a class to represent a node in a linked list
 * Jennifer Coy and Rob Deadman
 * Spring 2016
 */

 

public class Node {
	//// data members ////
	private int data;			// the data for this node
	private Node next;			// link to the next node
	public static final int DUMMY = 9999999;	// identifier for a dummy node
	
	//// Constructor ////
	public Node() {
		// initialize to a dummy node by default
		data = DUMMY;
		next = null;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/*
	 * deepCopy:  return a copy of this node
	 */
	public Node deepCopy() {
		Node copy = new Node();		// create the node to return
		
		// fill contents
		copy.setData(data);
		copy.setNext(null);  // set to null, this node is not in the list!
		
		// return the new node
		return copy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	//// main  ////
	public static void main(String[] args) {
		
		// create a Node object
		Node firstnode = new Node();
		System.out.println("The first node is: " + firstnode);
		
		// create a second node with some content
		Node secondnode = new Node();
		secondnode.setData(42);
		firstnode.setNext(secondnode);
		System.out.println("The first node is: " + firstnode);
		System.out.println("The second node is: " + secondnode);
		
	}
}
