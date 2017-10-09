package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

import LinkedList.Linkedlist;

public class BinaryTree {
	private class Node {
		Node left;
		Node right;
		int data;

		Node(Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}

	private int size;
	private Node root;

	BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, false);
	}

	BinaryTree(int[] pre, int[] in) {

		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}
	// }

	private Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		Node rv = new Node(null, null, pre[psi]);
		this.size++;
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (pre[psi] == in[i]) {
				si = i;
				break;
			}

		}
		int numvals = si - isi;
		rv.left = this.construct(pre, psi + 1, psi + numvals, in, isi, si - 1);
		rv.right = this.construct(pre, psi + numvals + 1, pei, in, si + 1, iei);
		return rv;
	}

	private Node takeInput(Scanner scn, Node parent, boolean isLeft) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else if (isLeft) {
			System.out.println("Enter the data for left child of " + parent.data);

		} else {
			System.out.println("Enter the data for right child of " + parent.data);

		}
		int now = scn.nextInt();
		Node child = new Node(null, null, now);
		this.size++;
		System.out.println("Does " + child.data + " have a left child?");
		Boolean hasLeft = scn.nextBoolean();
		if (hasLeft) {
			child.left = takeInput(scn, child, true);
		}
		System.out.println("Does " + child.data + " have a right child?");
		Boolean hasRight = scn.nextBoolean();
		if (hasRight) {
			child.right = takeInput(scn, child, false);
		}
		return child;

	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(this.root);
		System.out.println();
		System.out.print("*************************");
	}

	private void display(Node node) {
		System.out.println();
		if (node.left != null) {
			System.out.print(node.left.data + " -> ");
		} else {
			System.out.print("END -> ");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <- " + node.right.data);
		} else {
			System.out.print(" <- END");
		}
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);

		}

	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int retval = 1;
		retval += size2(node.left);
		retval += size2(node.right);
		return retval;

	}

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = min(node.left);
		int rightMin = min(node.right);
		int minChild = Math.min(leftMin, rightMin);
		return Math.min(minChild, node.data);
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int leftMax = max(node.left);
		int rightMax = max(node.right);
		int maxChild = Math.max(leftMax, rightMax);
		return Math.max(maxChild, node.data);
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int rv = 1;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return rv + Math.max(leftHeight, rightHeight);
	}

	public boolean find(int data) {
		return find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		Boolean foundleft;
		Boolean foundright;

		foundleft = find(data, node.left);
		foundright = find(data, node.right);
		if (foundleft || foundright) {
			return true;
		}
		return false;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		this.mirror(node.left);
		this.mirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDiameter = diameter(node.left);
		int rightDiameter = diameter(node.right);
		int nodeDiameter = this.height(node.left) + this.height(node.right) + 2;
		int maxChildDiameter = Math.max(rightDiameter, leftDiameter);
		return Math.max(nodeDiameter, maxChildDiameter);
	}

	public void prerder() {
		preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ", ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(this.root);
		System.out.println("END");
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + ", ");
	}

	public void inorder() {
		inorder(this.root);
		System.out.println("END");
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + ", ");
		inorder(node.right);
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node.data + ", ");
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {

				queue.addLast(node.right);
			}
		}
		System.out.println("END");

	}

	public void preorderI() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);

		while (!stack.isEmpty()) {
			Node node = stack.removeFirst();
			System.out.print(node.data + ", ");
			if (node.right != null) {

				stack.addFirst(node.right);
			}

			if (node.left != null) {
				stack.addFirst(node.left);
			}

		}
		System.out.println("END");

	}

	public Integer postOrderpre(int data) {
		HeapMover hm = new HeapMover();
		postOrderpresucc(this.root, data, hm);
		if (hm.pre == null) {
			return null;
		}
		return hm.pre.data;

	}

	public Integer postOrdersucc(int data) {
		HeapMover hm = new HeapMover();
		postOrderpresucc(this.root, data, hm);
		if (hm.succ == null) {
			return null;
		}
		return hm.succ.data;

	}

	private void postOrderpresucc(Node node, int data, HeapMover val) {
		if (node == null) {
			return;
		}
		postOrderpresucc(node.left, data, val);
		postOrderpresucc(node.right, data, val);
		if (val.now == null) {
			if (node.data == data) {
				val.now = node;

			} else {
				val.pre = node;
			}
		} else {
			if (val.succ == null) {
				val.succ = node;
			}
		}

	}

	private class HeapMover {
		Node pre;
		Node now;
		Node succ;

	}

	private class diaPair {
		int height;
		int diameter;
	}

	public int diaBtr() {
		diaPair root = diaBtr(this.root);
		return root.diameter;
	}

	private diaPair diaBtr(Node node) {
		if (node == null) {
			diaPair base = new diaPair();
			base.diameter = 0;
			base.height = -1;
			return base;
		}
		diaPair leftPair = diaBtr(node.left);
		diaPair rightPair = diaBtr(node.right);
		diaPair now = new diaPair();
		now.height = Math.max(leftPair.height, rightPair.height) + 1;
		now.diameter = 2 * now.height + 2;
		diaPair rv = new diaPair();
		rv.diameter = Math.max(leftPair.diameter, Math.max(rightPair.diameter, now.diameter));
		return rv;

	}

	private class BSTtrip {
		int max;
		int min;
		boolean IsBST;
	}

	public boolean IsBSTbtr() {
		BSTtrip Final = IsBSTbtr(this.root);
		return Final.IsBST;
	}

	private BSTtrip IsBSTbtr(Node node) {
		if (node == null) {
			BSTtrip base = new BSTtrip();
			base.max = Integer.MIN_VALUE;
			base.min = Integer.MAX_VALUE;
			base.IsBST = true;
			return base;
		}
		BSTtrip left = IsBSTbtr(node.left);

		BSTtrip right = IsBSTbtr(node.right);

		BSTtrip rv = new BSTtrip();

		if (!left.IsBST || !right.IsBST || left.max > node.data || right.min < node.data) {
			rv.IsBST = false;
		} else {
			rv.max = right.max == Integer.MIN_VALUE ? node.data : right.max;
			rv.min = left.min == Integer.MAX_VALUE ? node.data : left.min;
			rv.IsBST = true;
		}
		return rv;

	}

	public boolean IsBST3() {
		return IsBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean IsBST3(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data <= min || node.data >= max) {
			return false;
		}
		boolean IsLeft = IsBST3(node.left, min, node.data);
		boolean IsRight = IsBST3(node.right, node.data, max);
		return IsLeft && IsRight;
	}

	public int largestBSTsize() {
		something Final = largestBSTsize(this.root);
		return Final.size;
	}

	private something largestBSTsize(Node node) {
		if (node.left == null && node.right == null) {
			something base = new something();
			base.isBST = true;
			base.size = 1;
			int max = node.data;
			int min = node.data;
		}
		something left = largestBSTsize(node.left);
		something right = largestBSTsize(node.right);
		something rv = new something();
		if (left.isBST && right.isBST) {
			if (left.max < node.data && right.min > node.data) {
				rv.isBST = true;
				rv.size = left.size + right.size + 1;
				rv.max=Math.max(node.data, right.max);
				return rv;
			} else {
				rv.isBST = false;
				rv.size = Math.max(left.size, right.size);
				return rv;
			}
		} else if (left.isBST) {
			rv.isBST = false;
			rv.size = left.size;
			return rv;
		} else if (right.isBST) {
			rv.isBST = false;
			rv.size = right.size;
			return rv;
		} else {
			rv.isBST = false;
			rv.size = Math.max(left.size, right.size);
			return rv;
		}
	}

	private class something {
		boolean isBST;
		int size;
		int max; 
		int min;
	}
}
