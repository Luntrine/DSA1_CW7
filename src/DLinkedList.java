public class DLinkedList {

	private class Node {
		private int value;
		private Node nextNode;
		private Node prevNode;

		public Node(int v) {
			value = v;
			nextNode = null;
			prevNode = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int v) {
			value = v;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node n) {
			nextNode = n;
		}

		public Node getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node n) {
			prevNode = n;
		}

	}

	// Holds a reference to the head and tail of the list
	private Node headNode;
	private Node tailNode;

	public DLinkedList() {
		headNode = null;
		tailNode = null;
	}

	public Object getHeadValue() {
		if (headNode == null)
			return null;
		return headNode.value;
	}

	public Object getTailValue() {
		if (tailNode == null)
			return null;
		return tailNode.value;
	}

	public void addAtHead(int o) {
		Node newNode = new Node(o);
		newNode.setNextNode(headNode);
		if (headNode != null)
			headNode.setPrevNode(newNode);
		headNode = newNode;
		// special case for empty list
		if (tailNode == null)
			tailNode = newNode;
	}

	public void addAtTail(int o) {
		Node newNode = new Node(o);
		// this means that headNode == null too!
		if (tailNode == null) {
			tailNode = newNode;
			headNode = newNode;
		} else {
			newNode.setPrevNode(tailNode);
			tailNode.setNextNode(newNode);
			tailNode = newNode;
		}
	}

	public int deleteAtHead() {
		// list is empty
		if (headNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = headNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}

		int res = headNode.getValue();
		headNode = headNode.getNextNode();
		headNode.setPrevNode(null);
		return res;
	}

	public int deleteAtTail() {
		// list is empty
		if (tailNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = tailNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		int res = tailNode.getValue();
		tailNode = tailNode.getPrevNode();
		tailNode.setNextNode(null);
		return res;
	}

	public int delete(Node n) {
		if (n == null)
			return -1;
		Node next = n.getNextNode();
		Node prev = n.getPrevNode();
		int val = n.getValue();
		if (prev != null)
			prev.setNextNode(next);
		if (next != null)
			next.setPrevNode(prev);
		// deleting at the end
		if (n == tailNode)
			tailNode = prev;
		// deleteing at beginning
		if (n == headNode)
			headNode = next;
		return val;
	}

	public void insertAfter(Node n, int val) {
		if (n == null) { // this is the headNode
			addAtHead(val);
			return;
		}
		Node next = n.getNextNode();
		Node newNode = new Node(val);
		newNode.setPrevNode(n);
		newNode.setNextNode(next);
		n.setNextNode(newNode);
		if (next == null) { // insert at tail
			tailNode = newNode;
		} else {
			next.setPrevNode(newNode);
		}
	}

	// computes the size of the list
	public int size() {
		if (headNode == null)
			return 0;
		Node n = headNode;
		int size = 0;
		while (n != null) {
			size++;
			n = n.getNextNode();
		}
		return size;
	}

	// Predicate to check if the linked list is sorted
	public boolean isSorted() {
		if (headNode == null || headNode.nextNode == null)
			return true;
		Node i = headNode.nextNode;
		while (i != null) {
			if (i.getValue() < i.getPrevNode().getValue())
				return false;
			i = i.nextNode;
		}
		return true;
	}

	// toString methods to override printing of object
	public String toString() {
		Node n = headNode;
		StringBuffer buf = new StringBuffer();
		while (n != null) {
			buf.append(n.getValue());
			buf.append(" ");
			n = n.getNextNode();
		}
		return buf.toString();
	}

	/**
	 * This method sorts the doubly linked list using the insertion-sort algorithm.
	 * 
	 * This method has a complexity of O(N^2)
	 */
	public void insertionSort() {
		
		Node index; 
		
		// The following code checks whether the doubly linked list is empty.
		if(this.headNode != null) {
			index = headNode;
		}
		else{
			return;
		}
		
		// The following code goes through the doubly linked list one-by-one and
		// sorts them. 
		while(index.getNextNode() != null) {
			
			// This while loop takes the current index and makes sure all elements
			// leading up to it are in order (only if they are out of order).
			while(index.getValue() > index.getNextNode().getValue()) {
				
				// The following code swaps the current value with the one ahead of it.
				insertAfter(index.getNextNode(), index.getValue());
				index = index.getNextNode();
				delete(index.getPrevNode());
				
				// This makes the index equal to the headNode until all elements leading
				// up to the current one are sorted.
				index = headNode;
			}
			
			// This increments to the next element of the doubly linked list.
			index = index.getNextNode();
			
		}

	}

	public static void main(String[] args) {
		DLinkedList d = new DLinkedList();
		d.addAtHead(4);
		d.addAtHead(1);
		d.addAtHead(7);
		d.addAtHead(10);
		System.out.println("Before sorting: " + d); // this will call the toString method
		d.insertionSort();
		System.out.println("After sorting: " + d);
	}

}
