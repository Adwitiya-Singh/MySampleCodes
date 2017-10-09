package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<Node>();
		}
	}

	private Node root;

	private int size;

	GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, 1);

	}

	private Node takeInput(Scanner scn, Node parent, int ith) {
		if (parent == null) {
			System.out.print("Enter data for root node : ");
		} else {
			System.out.print("Enter data for " + ith + "th child of " + parent.data + " : ");
		}
		Node child = new Node(scn.nextInt());
		this.size++;
		System.out.print("Enter the number of children for " + child.data + " : ");
		int children = scn.nextInt();
		for (int i = 1; i <= children; i++) {
			Node grandchildren = takeInput(scn, child, i);
			child.children.add(grandchildren);
		}
		return child;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println();
		this.display(this.root);
		System.out.println("******************************");
	}

	private void display(Node node) {
		System.out.print(node.data + " -> ");
		for (Node child : node.children) {
			System.out.print(child.data + ", ");
		}
		System.out.println("END");
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		int rv = 1;
		int sizebelow = 0;
		for (Node now : node.children) {
			sizebelow += size2(now);
		}
		return rv + sizebelow;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node now : node.children) {
			int cmax = max(now);
			max = Math.max(max, cmax);
		}
		return Math.max(max, node.data);
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		int maxchildheight = -1;
		for (Node now : node.children) {
			int hn = height(now);
			maxchildheight = Math.max(maxchildheight, hn);
		}
		return maxchildheight + 1;
	}

	public boolean find(int data) {
		return find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (node.data == data) {
			return true;
		}
		Boolean found;

		for (Node now : node.children) {
			found = find(data, now);

			if (found) {
				return true;
			}
		}
		return false;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		for (Node now : node.children) {
			this.mirror(now);
		}
		int left = 0;
		int right = node.children.size() - 1;
		while (right > left) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);

			left++;
			right--;
		}

	}

	public void linearise() {
		this.linearise(this.root);
	}

	private void linearise(Node node) {
		for (Node child : node.children) {
			this.linearise(child);
		}
		while (node.children.size() > 1) {

			Node now = getTail(node);

			now.children.add(node.children.remove(1));

		}

	}

	private Node getTail(Node now) {
		while (now.children.size() > 0) {
			now = now.children.get(0);
		}
		return now;
	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		System.out.print(node.data + ", ");
		for (Node child : node.children) {
			preOrder(child);
		}

	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println("END");

	}

	private void postOrder(Node node) {
		for (Node child : node.children) {
			postOrder(child);
		}
		System.out.print(node.data + ", ");

	}

	public void levelOrder() {
		System.out.println();
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node now = queue.removeFirst();
			System.out.print(now.data + ", ");
			for (int i = 0; i < now.children.size(); i++) {
				queue.addLast(now.children.get(i));

			}
		}
		System.out.println("END");
	}

	public void preOrderI() {
		System.out.println();
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			Node now = stack.removeFirst();
			System.out.print(now.data + ", ");
			for (int i = now.children.size() - 1; i >= 0; i--) {
				stack.addFirst(now.children.get(i));

			}
		}
		System.out.println("END");
	}

	public int justLarger(int data) {
		System.out.println();
		int retval = Integer.MIN_VALUE;
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			Node now = stack.removeFirst();
			if (now.data > data && retval == Integer.MIN_VALUE) {
				retval = now.data;
			}
			if (now.data > data && now.data < retval) {
				retval = now.data;
			}
			for (int i = now.children.size() - 1; i >= 0; i--) {
				stack.addFirst(now.children.get(i));

			}
		}
		return retval;

	}

	public int maxSONC() {
		return maxSONC(this.root).data;
	}

	private Node maxSONC(Node node) {
		Node rv = node;
		for (Node child : node.children) {
			int childSONC = getSONC(child);
			int rvSONC = getSONC(rv);
			if (rvSONC < childSONC) {
				rv = child;
			}

		}
		return rv;
	}

	private int getSONC(Node node) {
		int rv = node.data;
		for (Node child : node.children) {
			rv += child.data;
		}
		return rv;
	}

	public int maxSONC2() {
		return maxSONC2(this.root).node.data;
	}

	private Heapmover maxSONC2(Node node) {
		Heapmover rv = new Heapmover(node);
		for (Node child : node.children) {
			Heapmover childHM = new Heapmover(child);
			if (rv.SONC < childHM.SONC) {
				rv = childHM;
			}

		}
		return rv;
	}

	private class Heapmover {
		public int SONC;
		public Node node;

		Heapmover(Node node) {
			this.node = node;
			this.SONC = getSONC(node);
		}
	}

	private class Heapmover2 {
		Node head;
		Node tail;

		Heapmover2(Node node) {
			this.head = node;
			this.tail = getTail(head);
		}

	}

	public void linearise2() {
		Heapmover2 now = this.linearise2(this.root);
	}

	private Heapmover2 linearise2(Node node) {

		for (Node child : node.children) {

			this.linearise(child);
		}
		Heapmover2 tailof = new Heapmover2(node);
		while (tailof.head.children.size() > 1) {

			tailof.tail.children.add(tailof.head.children.remove(1));
		}

		return tailof;

	}

	public int leafnodes() {
		System.out.println();
		return leafnodes(this.root);
	}

	private int leafnodes(Node node) {
		if (node.children.isEmpty()) {
			return 1;
		}
		int rv = 0;
		for (Node child : node.children) {
			rv += leafnodes(child);
		}
		return rv;
	}

	public boolean isEqual(GenericTree gt) {
		System.out.println();
		LinkedList<Node> stackone = new LinkedList<>();
		LinkedList<Node> stacktwo = new LinkedList<>();
		stackone.addFirst(this.root);
		stacktwo.addFirst(gt.root);
		while (!stackone.isEmpty() && !stacktwo.isEmpty()) {
			Node now = stackone.removeFirst();
			Node otherNow = stacktwo.removeFirst();
			if (now.data != otherNow.data) {
				return false;
			}
			for (int i = now.children.size() - 1; i >= 0; i--) {
				stackone.addFirst(now.children.get(i));

			}
			for (int j = otherNow.children.size() - 1; j >= 0; j--) {
				stacktwo.addFirst(otherNow.children.get(j));

			}
		}
		return true;

	}
}
