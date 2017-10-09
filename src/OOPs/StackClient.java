package OOPs;

public class StackClient {
	public static void main(String[] args) {
		try {
			Stack st = new Stack();
			for (int i = 0; i < 5; i++) {
				st.push(5 - i);
				displayStackInfo(st);
			}
			System.out.println("Point 1");
			st.push(100);
			displayStackInfo(st);
			System.out.println("Point 2");
			while (!st.IsEmpty()) {
				// System.out.println(st.top());
				System.out.println(st.pop());
				displayStackInfo(st);
			}
			System.out.println("Point 3");
			st.pop();
			System.out.println("Point 4");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("Still Running");
		}

	}

	public static void displayStackInfo(Stack st) {
		System.out.println("Size = " + st.size());
		System.out.println("Empty = " + st.IsEmpty());
		st.display();
	}

	public static void ReverseStack(Stack st, Stack helper) throws Exception {
		while (!st.IsEmpty()) {
			helper.push(st.pop());
		}
		

	}
}
