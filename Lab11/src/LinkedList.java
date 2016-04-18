/* LinkedList:  using book's implementation
 * NOTE:  all insertions are to the front of the list.
 * Jennifer Coy and Rob Deadman
 * Spring 2016
 */
public class LinkedList {
	
	//// data members ////
	private Node head;			// head of the list
	
	//// Constructor ////
	public LinkedList() {
		// create a dummy node for the list
		head = new Node();
		// Note that the Node class initializes this to a dummy node
	}
	
	//// toString ////
	public String toString() {
		String outString = new String("The linked list contains: ");
		
		// traverse the list
		Node temp;			// temporary pointer to a node
		
		// start at the beginning
		temp = head.getNext();		// skip the dummy node
		
		// run through every node in the list
		while (temp != null) {
			// "visit" each node
			outString = outString + temp.getData() + " ";
			// move temp to the next node
			temp = temp.getNext();
		}
		
		return outString;
	}
	
	//// insert ////
	//// NOTE: this inserts a new node as the first node in the list
	public boolean insert(int newData) {
		// create a new Node object
		Node newestNode = new Node();
		
		// error check -- if we can't get memory, newestNode will be null
		if (newestNode == null) {
			// out of memory
			System.out.println("Out of memory error.");
			return false;
		} else {
			// fill in the data for the newest node
			newestNode.setData(newData);
			// link the newest node to the old first node
			newestNode.setNext(head.getNext());
			// link the first (dummy) node to this newest node
			head.setNext(newestNode);
			return true;
		}
	}
	
	//// fetch ////
	//// traverse the list, from beginning to end.
	//// If the node is found, return a deep copy of it.
	//// If not, return null.
	public Node fetch(int targetKey) {
	
		// traverse the list
		Node temp;			// temporary pointer to a node
		
		// start at the beginning
		temp = head.getNext();		// skip the dummy node
		
		// run through every node in the list
		while (temp != null) {
			// "visit" each node, checking to see if we've found targetKey
			if (targetKey == temp.getData()) {
				// stop!  we've found it!
				break;  // temp is pointing to the node I want
			} else {
				// move temp to the next node
				temp = temp.getNext();
			}
		}
		
		// two possibilities:
		if (temp != null) {
			// temp is pointing to a node -- we found it!!
			return temp.deepCopy();
			// or, if we have an object, temp.deepCoy();
		} else {
		    // temp is null -- we didn't find it!
			return null;
		}
		
	}
	
	//// delete ////
	//// Perform a sequential search for a targetKey, then remove it from the list
	public boolean delete(int targetKey) {
		Node temp;		// a temporary reference node to move down the list
		Node previous;	// the node before this temp node
		
		// start at the beginning of the list
		temp = head.getNext();	// the first node that is not a dummy
		previous = head;		// at the dummy node (one before the first node)
		
		// search through each item, until we reach the end (or we find it!)
		while (temp != null) {
			// stop if we find the item
			if (temp.getData() == targetKey) {
				break;  // exit 
			} else {
				// otherwise, move to next Node in the list
				temp = temp.getNext();
				previous = previous.getNext();
			}
		}
		
		// done searching.  Did we find it?
		if (temp != null) {
			// if found it, delete it!
			// set the previous node's next pointer to be
			// the one AFTER temp
			previous.setNext(temp.getNext());
			// free up the memory used by the old node
			temp = null;
			return true;
		} else {
			// else, return false (not in the list)
			return false;
		}
	}
	
	//// update ////
	//// Look for a node, if we find it, delete it and add a updated node
	//// If we don't find it, return false.
	public boolean update(int targetKey, int newItem) {
		boolean success = false;		// was it deleted? or added?
		
		// first delete the old item
		success = delete(targetKey);
		
		// if it was found, add the new item
		if (success == true) {
			// add the modified version
			success = insert(newItem);
		} 
		
		// if it was found, and we added it successfully, return true
		if (success == true) {
			return true;
		} else {
			// else, return false.
			return false;
		}
	}
	
	//// main, for testing ////
	public static void main(String[] args) {
		boolean success = false;	// return value from delete function
		
		// create a LinkedList object
		LinkedList list = new LinkedList();
		System.out.println("The empty list looks like this: " + list);
		
		// test insert and toString
		list.insert(1);
		list.insert(2);
		list.insert(3);
		System.out.println(list);
		
		// test fetch
		System.out.println("looking for 2: " + list.fetch(2));  // list.fetch returns a Node, print it out!
		System.out.println("looking for 42: " + list.fetch(42));
		
		// test delete
		success = list.delete(2);
		System.out.println("Deleted 2.  Return value is " + success);
		System.out.println(list);
		success = list.delete(42);
		System.out.println("Deleted 42.  Return value is " + success);
		System.out.println(list);
		success = list.delete(1);
		System.out.println("Deleted 1.  Return value is " + success);
		System.out.println(list);
		success = list.delete(3);
		System.out.println("Deleted 3.  Return value is " + success);
		System.out.println(list);

		// test update...create a new list
		list.insert(1);
		list.insert(3);
		list.insert(4);
		list.insert(7);
		System.out.println(list);
		list.update(4, 5);
		System.out.println("Changed 4 to a 5");
		System.out.println(list);
		
		
	}

}
