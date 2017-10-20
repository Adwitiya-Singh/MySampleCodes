package BST;

public class Client {

	public static void main(String[] args) {
		BST bt = new BST();
		// bt.add(75);
		bt.add(50);
		bt.add(30);
		bt.add(20);
		bt.add(40);
		bt.add(35);
		bt.add(32);
		bt.add(38);
		bt.add(47);
		bt.add(49);
		bt.add(70);
		bt.add(60);
		bt.add(65);
		bt.add(80);
		bt.add(75);
		bt.add(74);
        bt.add(85);
        bt.add(49);
        bt.display();
        System.out.println(bt.diaBtr());
        bt.linearise();
        bt.display();


		// bt.remove(50);
		// bt.display();
		// System.out.println(bt.min());
		// System.out.println(bt.max());
		// System.out.println(bt.find(62));
		// System.out.println(bt.find(61));

	}

}
