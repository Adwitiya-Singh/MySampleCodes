package OOPs;

public class StackUsingQueuesPopE {
	private DynamicQueue one;
	private DynamicQueue two;
	public StackUsingQueuesPopE(){
		one = new DynamicQueue();
		two = new DynamicQueue();
	}

	public void push(int data) throws Exception {
		two.enqueue(data);

		pushhelper();

		DynamicQueue temp = one;
		one = two;
		two = temp;

	}

	private void pushhelper()throws Exception {
		if (one.size()==0) {
			return;
		}
		int ta = one.dequeue();
		two.enqueue(ta);
		pushhelper();
		
		return;
	}

	public int size() {
		return one.size();
	}

	public boolean isEmpty() {
		return one.size() == 0;
	}

	public int pop() throws Exception {
		return one.dequeue();
	}

	public int top() {
		return one.front;

	}

	public void display() {
		one.display();
	}
}
