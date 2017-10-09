package OOPs;

public class Stack {
	protected int[] data;
	private int tos;
	public static final int DEFAULT_CAPACITY = 10;

	public Stack(int Size) {
		data = new int[Size];
		tos = -1;
	}

	public Stack() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return tos + 1;
	}

	public boolean IsEmpty() {
		return this.size() == 0;
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is full");
		}
		this.tos++;
		this.data[this.tos] = item;
	}

	public int pop() throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Stack is empty");
		}
		int now = this.data[this.tos];
		tos--;
		return now;
	}

	public int top() throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Stack is empty");
		}
		int now = this.data[this.tos];
		return now;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + ",");
		}
		System.out.println("END");
		System.out.println("*********************");
	}
}
