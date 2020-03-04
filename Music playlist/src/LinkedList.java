public class LinkedList{

	private static class Node{

		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	private Node header, tail;
	private int size;

	public LinkedList() {
		this.header = new Node(null);
		this.tail = header;
		this.size = 0;
	}

	public String first() {
		if (this.isEmpty()) return null;
		return this.header.next.data;
	}

	public String last() {
		if (this.isEmpty()) return null;
		return this.tail.data;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.header.next == null;
	}

	public void addFirst(String e) {
		Node newNode = new Node(e, this.header.next);
		this.header.next = newNode;
		this.size++;
	}

	public void addLast(String e) {
		Node newNode = new Node(e);
		this.tail.next = newNode;
		this.tail = newNode;
		this.size++;
	}

	public String removeFirst() {
		if (this.isEmpty()) return null;
		String val = this.header.next.data;
		this.header.next = this.header.next.next;
		this.size--;
		return val;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		Node current = this.header;

		while(current.next != null) {
			current = current.next;
			sb.append(String.format("%s \n ", current.data));
		}

		return sb.toString();
	}

	//find if string exists already in list
	public boolean findElement(String e) {
		Node current = this.header.next;

		boolean flag = false; //does not exist in list

		while(current != null) {

			if(current.data.compareToIgnoreCase(e) == 0){
				flag = true; //exists in list
				break;
			}

			current = current.next;
		}

		return flag;
	}

	public void sortList() {
			//Node current will point to head next (skipping csv title)
			Node current = this.header.next;
			Node index = null;
			String temp;

			if(header == null) {
					return;
			}
			else {
					while(current != null) {
							//Node index will point to node next to current
							index = current.next;

							while(index != null) {
									//If current node's data is greater than index's node data, swap the data between them
									String str_current = current.data;
									String str_index = index.data;

									// bigger than zero means current.data word is before index.data
									if( str_current.compareToIgnoreCase(str_index) > 0) {
											temp = current.data;
											current.data = index.data;
											index.data = temp;
									}
									index = index.next;
							}
							current = current.next;
					}
			}
	}

}
