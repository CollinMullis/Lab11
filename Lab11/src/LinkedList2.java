public class LinkedList2 {
	
	private Node front = null;
	private Node rear = null;
	
	public LinkedList2() {
		
		front = new Node();
		rear = Node.getNext();
		
	}
	
	public String toString() {
		String outString = new String("The linked list contains: ");
		
		// traverse the list
		Node temp;			// temporary pointer to a node
		
		// start at the beginning
		temp = front.getNext();		// skip the dummy node
		
		// run through every node in the list
		while (temp != null) {
			// "visit" each node
			outString = outString + temp.getData() + " ";
			// move temp to the next node
			temp = temp.getNext();
		}
		
		return outString;
	}
	
	public static void main(String[] args) {
		
	}
	
	public static boolean enqueue(int newData) {
		Node newestNode = new Node();
		
		if(newestNode == null) {
			System.out.println("Out of memory");
			return false;
		}else {
			newestNode.setData(newData);
			
			newestNode.setNext(.getNext());
		}
	}
}
