package BST;

public class Client {

	public static void main(String[] args) {
		BST bt = new BST();
		// bt.add(75);
		bt.add(12);
		bt.add(25);
		bt.add(11);
		bt.add(11);
		bt.add(37);
		bt.add(50);
		bt.add(62);
		bt.add(87);
		bt.remove(11);
		bt.remove(11);

		bt.display();
		// bt.remove(50);
		// bt.display();
		// System.out.println(bt.min());
		// System.out.println(bt.max());
		// System.out.println(bt.find(62));
		// System.out.println(bt.find(61));

	}

}
