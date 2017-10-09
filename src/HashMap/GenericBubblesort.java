package HashMap;

public class GenericBubblesort {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		cars[0] = new Car(100, 1000);
		cars[1] = new Car(500, 100);
		cars[2] = new Car(200, 10000);
		cars[3] = new Car(70, 10);
		cars[4] = new Car(3, 1);
		for (Car car : cars) {
			System.out.println(car);
		}
		BubbleSort(cars);
		System.out.println("*****************");
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	public static <T extends Comparable<T>> void BubbleSort(T[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i].compareTo(arr[i + 1]) < 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}
				counter++;
			}
		}
	}
}
