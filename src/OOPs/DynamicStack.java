package OOPs;

public class DynamicStack extends Stack {
	public DynamicStack(int Capacity) {
		super(Capacity);
	}

	public DynamicStack() {
		this(DEFAULT_CAPACITY);
	}

	public void push(int item) {

		if (this.size() == super.data.length) {
			int[] temp = super.data;
			super.data = new int[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				super.data[i] = temp[i];
			}
		}

		try {
			super.push(item);

		} catch (Exception ex) {
			// AINT NOONE GETTING HERE MATE
		}
	}

	public int pop() {
		int retval=0;
		try {
			if (this.size() == super.data.length / 4) {
				int[] temp = super.data;
				super.data = new int[temp.length / 2];
				for (int i = 0; i < super.data.length; i++) {
					super.data[i] = temp[i];
				}
			}

		 retval=super.pop();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return retval;

	}
}
