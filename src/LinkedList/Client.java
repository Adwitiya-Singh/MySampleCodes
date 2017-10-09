package LinkedList;

public class Client {

	public static void main(String[] args) {
		try {
			Linkedlist list = new Linkedlist();
			// Linkedlist list2 = new Linkedlist();
			// list.addLast(10);
			// list.addLast(20);
			// list.addLast(30);
			// list.addLast(40);
			// list.addLast(50);
			// list.addLast(60);

			list.addFirst(10);
			list.addFirst(20);
			list.addFirst(30);
			list.addFirst(40);
			list.addFirst(10);
			list.addFirst(50);
			list.addFirst(50);
			list.addFirst(50);
			// list.display();
			// System.out.println(list.size);
			// list.removeduplicates();
			// list.display();
			// System.out.println(list.size);
			// list.display();
			// list.reverseDI();
			// list.display();
			// list.reversePI();
			// list.display();
			// list.reversePR();
			// list.display();
			// list.reverseDR();
			// list.display();
			// list.reversePR();
			// list.display();
			// list.fold();
			// list.display();
			// System.out.println(list.kthfromlastR(3));
			// System.out.println(list.kthfromlastI(3));
			// System.out.println(list.mid());
			// list.reverseDR();
			// list.display();
			// list.addLast(10);
			// list.addLast(30);
			//
			// list.addLast(50);
			//
			// list.addLast(70);
			//
			// list.addLast(90);
			// list2.addLast(5);
			// list2.addLast(15);
			// list2.addLast(20);
			// list2.addLast(25);
			// list2.addLast(30);
			// list2.addLast(35);
			// list.display();
			// list2.display();
			// Linkedlist merged = Linkedlist.mergeSorted(list, list2);
			// merged.display();
			list.display();
//			list.mergeSort();
//			list.display();
//			System.out.println(list.find(40));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
