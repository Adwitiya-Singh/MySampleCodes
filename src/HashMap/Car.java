package HashMap;

public class Car implements Comparable<Car> {
	int price;
	int speed;

	public Car(int price, int speed) {
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Car c) {
		return this.speed - c.speed;
	}

	@Override
	public String toString() {
		return "{ Speed = " + this.speed + " Price = " + this.price+" }";
	}
}
