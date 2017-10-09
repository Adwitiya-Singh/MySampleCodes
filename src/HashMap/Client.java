package HashMap;

import java.util.ArrayList;

import LinkedList.Linkedlist;

public class Client {

	public static void main(String[] args) throws Exception {
		HashTable<String, Integer> ht = new HashTable(2);
		ht.put("India", 10);
		ht.put("China", 20);
		ht.put("US", 5);
		ht.put("UK", 3);
		ht.display();
		ht.put("France", 3);
		ht.display();
		ht.remove("France");
		ht.display();
		System.out.println(ht.get("India"));
	}

}
