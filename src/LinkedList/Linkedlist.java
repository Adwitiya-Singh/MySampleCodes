package LinkedList;
// package io.github.githubname.projectname.Main
public class Linkedlist<T> {

	private class Node {
		T data;
		Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public Linkedlist() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println("END");
		System.out.println("******************");
	}

	public void addFirst(T data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (isEmpty()) {
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(T data) {
		Node node = new Node(data, null);
		if (isEmpty()) {
			addFirst(data);
		} else {
			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}

	public void addAt(T data, int index) throws Exception {
		if (index <= 0 || index > this.size + 1) {
			throw new Exception("Invalid Index");
		}
		if (index == 1) {
			addFirst(data);
		} else if (index == this.size + 1) {
			addLast(data);
		} else {
			Node before = getNodeAt(index - 1);
			Node now = before.next;
			Node node = new Node(data, now);
			before.next = node;
			this.size++;
		}
	}

	public T getFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is empty");
		}
		return this.head.data;
	}

	public T getLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is empty");
		}
		return this.tail.data;
	}

	public T getAt(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is empty");
		}
		if (index <= 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}
		Node node = getNodeAt(index);
		return node.data;
	}

	public T removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is already empty");
		}
		Node now = this.head;
		this.head = this.head.next;
		this.size--;
		if (isEmpty()) {
			this.tail = null;
		}
		return now.data;
	}

	public T removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is already empty");
		}

		if (size == 1) {
			return this.removeFirst();
		} else {
			Node now = this.tail;
			Node node = getNodeAt(size - 1);
			node.next = null;
			this.size--;
			this.tail = node;
			return now.data;
		}

	}

	public T removeAt(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("The LinkedList is empty");
		}
		if (index <= 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}
		if (index == 1) {
			return removeFirst();
		} else if (index == this.size) {
			return removeLast();
		} else {
			Node before = getNodeAt(index - 1);

			Node now = before.next;
			Node next = now.next;
			before.next = next;
			this.size--;
			return now.data;
		}
	}

	private Node getNodeAt(int index) {
		Node node = this.head;
		int counter = 1;
		while (counter < index) {
			node = node.next;
			counter++;
		}
		return node;
	}

	public void reverseDI() {
		for (int i = 1; i <= this.size / 2; i++) {
			Node first = getNodeAt(i);
			Node last = getNodeAt(this.size - i + 1);
			T temp = first.data;
			first.data = last.data;
			last.data = temp;
		}
	}

	public void reversePI() {
		Node previous = null;
		Node current = head;
		Node next = current.next;
		while (next != null) {
			current.next = previous;
			previous = current;
			current = next;
			next = next.next;

		}
		current.next = previous;
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	public void reverseDR() {
		Heapmover left = new Heapmover(this.head);
		reverseDR(left, this.head, 0);
	}

	private void reverseDR(Heapmover left, Node right, int now) {

		if (right == null) {

			return;
		}
		reverseDR(left, right.next, now + 1);
		if (now >= this.size / 2) {

			swapData(left.node, right);
			left.node = left.node.next;
		}
	}

	private class Heapmover {
		Node node;

		Heapmover(Node node) {
			this.node = node;
		}
	}

	public void swapData(Node first, Node second) {
		T temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	public void reversePR() {
		reversePR(head);
		this.head.next = null;
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	private void reversePR(Node now) {
		if (now.next == null) {
			return;
		}
		reversePR(now.next);
		now.next.next = now;
	}

	public void swap(int firstind, int secondind) {
		Node beforefirst;
		Node first;
		if (firstind == 1) {
			beforefirst = null;
			first = getNodeAt(1);
		} else {
			beforefirst = getNodeAt(firstind - 1);
			first = beforefirst.next;

		}
		Node afterfirst = first.next;

		Node beforesecond = getNodeAt(secondind - 1);
		Node second = beforesecond.next;
		Node aftersecond;
		if (secondind == this.size) {
			aftersecond = null;
		} else {
			aftersecond = second.next;
		}
		beforefirst.next = second;
		second.next = afterfirst;
		beforesecond.next = first;
		first.next = aftersecond;
	}

	public void removeduplicates() {
		Node now = this.head;
		while (now.next != null) {
			Node next = now.next;
			if (next.data == now.data) {
				now.next = next.next;
				this.size--;
			} else {
				now = now.next;
			}
		}
	}

	// public static Linkedlist mergeSorted(Linkedlist first, Linkedlist second)
	// {
	// Linkedlist retval = new Linkedlist();
	// Node firstPointer = first.head;
	// Node secondPointer = second.head;
	// while (firstPointer != null && secondPointer != null) {
	// if (firstPointer.data < secondPointer.data) {
	// retval.addLast(firstPointer.data);
	// firstPointer = firstPointer.next;
	// } else if (firstPointer.data > secondPointer.data) {
	// retval.addLast(secondPointer.data);
	// secondPointer = secondPointer.next;
	// } else {
	// retval.addLast(secondPointer.data);
	// retval.addLast(firstPointer.data);
	// secondPointer = secondPointer.next;
	// firstPointer = firstPointer.next;
	// }
	// }
	//
	// while (secondPointer != null) {
	// retval.addLast(secondPointer.data);
	// secondPointer = secondPointer.next;
	// }
	//
	// while (firstPointer != null) {
	// retval.addLast(firstPointer.data);
	// firstPointer = firstPointer.next;
	// }
	//
	// return retval;
	// }

	public void appendN(int n) throws Exception {
		if (n > this.size) {
			throw new Exception("Invalid Argument");
		}
		for (int i = 0; i < n; i++) {
			T toAppend = removeLast();
			addFirst(toAppend);
		}
	}

	public static boolean isPalindrome(Linkedlist li) throws Exception {
		for (int i = 1; i <= li.size / 2; i++) {
			if (li.getAt(i) != li.getAt(li.size - i + 1)) {
				return false;
			}
		}
		return true;
	}

	public void fold() {
		Heapmover left = new Heapmover(this.head);
		fold(left, this.head, 0);
	}

	private void fold(Heapmover left, Node right, int now) {

		if (right.next == null) {
			return;
		}
		fold(left, right.next, now + 1);
		if (now >= this.size / 2) {
			Node node = right.next;
			right.next = null;
			node.next = left.node.next;
			left.node.next = node;
			left.node = left.node.next.next;
		}
		if (now == size / 2) {
			this.tail = right;
		}
	}

	public T kthfromlastR(int n) {
		whichvalfromlast index = new whichvalfromlast(1);
		return kthfromlastR(n, this.head, index);

	}

	private T kthfromlastR(int n, Node now, whichvalfromlast i) {

		if (now.next == null) {
			if (i.val == n) {
				return now.data;
			}
			i.val++;
			return null;
		}
		T retval = null;
		retval = kthfromlastR(n, now.next, i);
		if (retval != null) {
			return retval;
		}
		if (i.val == n) {
			return now.data;

		}
		i.val++;

		return retval;
	}

	public class whichvalfromlast {
		int val;

		public whichvalfromlast(int i) {
			this.val = i;
		}
	}

	public T kthfromlastI(int n) {
		Node ahead = this.head;
		Node answer = this.head;
		for (int i = 0; i < n; i++) {
			ahead = ahead.next;
		}
		while (ahead != null) {
			ahead = ahead.next;
			answer = answer.next;
		}
		return answer.data;
	}

	public T mid() {
		return midnode().data;
	}

	public Node midnode() {
		Node last = this.head;
		Node mid = this.head;
		while (last.next != null && last.next.next != null) {
			last = last.next.next;
			mid = mid.next;
		}
		return mid;
	}

	// public void mergeSort() {
	// Linkedlist sorted = this.mergeSortHelper();
	// this.head = sorted.head;
	// this.tail = sorted.tail;
	// this.size = sorted.size;
	// }

	// private Linkedlist mergeSortHelper() {
	// if (this.size == 1) {
	// return this;
	// }
	// Node midNode = this.midnode();
	// Node midNext = midNode.next;
	//
	// Linkedlist fhalf = new Linkedlist();
	// fhalf.head = this.head;
	// fhalf.tail = midNode;
	// fhalf.tail.next = null;
	// fhalf.size = (this.size + 1) / 2;
	//
	// Linkedlist shalf = new Linkedlist();
	// shalf.head = midNext;
	// shalf.tail = this.tail;
	// shalf.size = this.size / 2;
	// fhalf = fhalf.mergeSortHelper();
	// shalf = shalf.mergeSortHelper();
	//
	// Linkedlist Final = mergeSorted(fhalf, shalf);
	// return Final;
	// }

	public int find(T data) {
		int index = 1;
		Node node = this.head;
		while (node != null) {
			if (node.data.equals(data)) {
				return index;
			}
			node = node.next;
			index++;
		}
		return -1;

	}
}
