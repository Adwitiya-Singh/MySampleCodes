package Heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	private ArrayList<T> data;
	private boolean isMin;

	public Heap() {
		this(false);
	}

	public Heap(boolean isMin) {
		this.data = new ArrayList<>();
		this.isMin = isMin;
		;
	}

	public Heap(T[] items, boolean isMin) {
		this(isMin);
		for (T item : items) {
			this.data.add(item);
		}
		for (int i = this.data.size() / 2 - 1; i >= 0; i--) {
			this.downHeapify(i);
		}
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		this.displayNode(0);
	}

	private void displayNode(int pos) {
		int lci = 2 * pos + 1;
		int rci = 2 * pos + 2;
		String TP = "";
		T node = this.data.get(pos);

		if (lci < this.data.size()) {
			TP += this.data.get(lci) + " -> ";
		} else {
			TP += "END -> ";
		}
		TP += node;
		if (rci < this.data.size()) {
			TP += " <- " + this.data.get(rci);
		} else {
			TP += " <- END";
		}
		System.out.println(TP);
		if (lci < this.data.size()) {
			this.displayNode(lci);
		}
		if (rci < this.data.size()) {
			this.displayNode(rci);
		}
	}

	public T getHP() {
		return this.data.get(0);
	}

	public void add(T item) {
		this.data.add(item);
		this.upHeapify(this.data.size() - 1);
	}

	private void upHeapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;

		if (!isLarger(pi, ci)) {
			swap(pi, ci);
			this.upHeapify(pi);
		}
	}

	public T remove() {
		T rv = this.data.get(0);

		swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		this.downHeapify(0);

		return rv;
	}

	private void downHeapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < this.data.size() && this.isLarger(lci, mi)) {
			mi = lci;
		}

		if (rci < this.data.size() && this.isLarger(rci, mi)) {
			mi = rci;
		}

		if (mi != pi) {
			this.swap(mi, pi);
			this.downHeapify(mi);
		}
	}

	private void swap(int i, int j) {
		T temp = this.data.get(i);
		this.data.set(i, this.data.get(j));
		this.data.set(j, temp);
	}

	private boolean isLarger(int i, int j) {
		T ithItem = this.data.get(i);
		T jthItem = this.data.get(j);

		if (this.isMin) {
			return ithItem.compareTo(jthItem) < 0;
		} else {
			return ithItem.compareTo(jthItem) > 0;
		}
	}

	public static Heap<Integer> getKlargest(Integer[] arr, Integer k) {
		Heap<Integer> now = new Heap<Integer>(true);
		for (int i = 0; i < arr.length; i++) {
			if (now.size() == k) {
				if (arr[i] > (Integer) now.getHP()) {
					now.remove();
					now.add(arr[i]);
				}
			} else {
				now.add(arr[i]);
			}
		}
		return now;
	}

	public static ArrayList<Integer> mergeKSorted(ArrayList<ArrayList<Integer>> sortedLists) {
		ArrayList<Integer> rv = new ArrayList<>();
		Heap<Integer> now = new Heap<Integer>();
		while (!sortedLists.isEmpty()) {
			for (int i = 0; i < sortedLists.size() - 1; i++) {
				if (sortedLists.get(i).isEmpty()) {
					sortedLists.remove(i);
				} else {
					now.add(sortedLists.get(i).remove(1));
				}
				for (i = 0; i < sortedLists.size(); i++) {
					rv.add(now.remove());
				}
			}
		}
		return rv;
	}

}
