package BST;

import java.util.LinkedList;

public class BST {
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

    public BST(int... arr) {
        this.root = construct(arr, 0, arr.length - 1);
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    private Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (hi + lo) / 2;
        Node node = new Node(null, null, arr[mid]);
        this.size++;
        node.left = construct(arr, lo, mid - 1);
        node.right = construct(arr, mid + 1, hi);
        return node;
    }

    public void add(int data) {
        Node node = new Node(null, null, data);
        if (this.root == null) {
            this.root = node;
            this.size++;
        } else {
            int put = 1;
            Node now = this.root;
            while (put == 1) {
                if (data < now.data) {
                    if (now.left == null) {
                        now.left = node;
                        put = 0;
                        this.size++;
                    } else {
                        now = now.left;
                    }

                } else {
                    if (now.right == null) {
                        now.right = node;
                        put = 0;
                        this.size++;
                    } else {
                        now = now.right;
                    }
                }
            }
        }
    }

    public void remove(int data) {
        this.root = remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                node.data = MinRight(node);
                node.right = remove(node.right, node.data);
            }
        }
        return node;
    }

    private int MinRight(Node node) {
        Node now = node.right;
        while (now.left != null) {
            now = now.left;
        }
        return now.data;
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
        Node now = this.root;
        while (now.left != null) {
            now = now.left;
        }
        return now.data;
    }

    public int max() {
        Node now = this.root;
        while (now.right != null) {
            now = now.right;
        }
        return now.data;
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
        Node now = this.root;
        while (now.left != null && now.right != null) {
            if (data > now.data) {
                now = now.right;
            }
            if (data < now.data) {
                now = now.left;
            }
            if (data == now.data) {
                return true;
            }
        }
        return false;
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

    private class linPair {
        Node head;
        Node tail;
    }

    public void linearise() {
        linPair Final = linearise(this.root);
        this.root = Final.head;
    }

    private linPair linearise(Node node) {
        if (node == null) {
            return null;
        }
        linPair left = linearise(node.left);
        linPair right = linearise(node.right);
        node.left = null;
        node.right = null;
        if (left != null) {
            left.tail.right = node;
        }
        if (right != null) {
            node.right = right.head;
        }
        linPair rv = new linPair();
        rv.head = left == null ? node : left.head;
        rv.tail = right == null ? node : right.tail;
        return rv;
    }

    public void printInRange(int min, int max) {
        printInRange(this.root, min, max);
    }

    private void printInRange(Node node, int min, int max) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (node.data > min && node.data < max) {
            System.out.print(node.data + ", ");
        }
        inorder(node.right);
    }

    private class stuff {
        int height;
        boolean isBalanced;
    }

    public boolean isBalanced() {
        stuff rv = isBalanced(this.root);
        return rv.isBalanced;
    }

    private stuff isBalanced(Node node) {
        if (node == null) {
            stuff base = new stuff();
            base.height = -1;
            base.isBalanced = true;
        }
        stuff left = isBalanced(node.left);
        stuff right = isBalanced(node.right);
        stuff rv = new stuff();

        if (left.isBalanced == false || right.isBalanced == false) {
            rv.isBalanced = false;
            return rv;
        }
        if (Math.abs(left.height - right.height) <= 1) {
            rv.isBalanced = true;
        } else {
            rv.isBalanced = false;
        }
        rv.height = left.height + 1;
        return rv;
    }

}
