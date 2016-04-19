public class LinkedQueue extends Node {
	
	public Node front;
	public Node rear;
	
	public Node DUMMY;
	
	public void enqueue(int newData) {
		
			Node newItem = new Node();
			newItem.setData(newData);
			newItem.setNext(null);
			
			if (isEmpty()) {
				this.front = newItem;
				this.rear = this.front;
			}
			else { 
				this.setNext(newItem);
				
			}
			
	}
	
	public void dequeue() {
		
		if (isEmpty()) {
			return;
			
		}else{
			
			if (this.front.getNext() == this.rear) {
				this.front = null;
				this.rear = null;
			}
			else { 
				this.front = this.front.getNext();
				
			}
			
			return;
		}
	}
	
	public int size() {
			int count = 0;
			
			for (Node node = front; node != null; node.getNext()) {
				count++;
			}
			return count;
	}
	
	public boolean isEmpty() {
		
		return (front == null);
	}
	
	public LinkedQueue() {
		
		this.front = null;
		this.rear = null;
	}
}