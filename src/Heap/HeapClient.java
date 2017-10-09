package Heap;

import HashMap.Car;

public class HeapClient {

	public static void main(String[] args) {
		Integer[] arr = { 10,20,80,30,14,19,22 };
//		Heap hp = Heap.getKlargest(arr, 5);
//		hp.display();
		// Car[] cars = new Car[9];
		// cars[0] = new Car(900, 100);
		// cars[1] = new Car(500, 50);
		// cars[2] = new Car(700, 80);
		// cars[3] = new Car(300, 30);
		// cars[4] = new Car(100, 10);
		// cars[5] = new Car(800, 900);
		// cars[6] = new Car(400, 40);
		// cars[7] = new Car(200, 20);
		// cars[8] = new Car(600, 100);
		// Heap h = new Heap(cars, false);
		// h.display();
		HeapSort.heapsort(arr);
		for(int i: arr){
			System.out.println(i);
		}
	}

}
