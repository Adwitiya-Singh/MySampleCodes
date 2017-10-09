package HashMap;

import LinkedList.Linkedlist;

public class HashTable<K, V> {

	private class HTPair {
		K Key;
		V Value;

		public HTPair(K key, V value) {
			this.Key = key;
			this.Value = value;
		}

		@Override
		public boolean equals(Object o) {
			HTPair now = (HTPair) o;
			return this.Key.equals(now.Key);
		}
		@Override 
		public String toString(){
			return this.Key+" : "+this.Value;
		}

	}

	private Linkedlist<HTPair>[] bucketArray;
	private int Size;
	public static final int DEFAULT_CAPACITY = 10;

	public HashTable() {
		this.bucketArray = (Linkedlist<HTPair>[]) new Linkedlist[DEFAULT_CAPACITY];
		this.Size = 0;
	}

	public HashTable(int capacity) {
		this.bucketArray = (Linkedlist<HTPair>[]) new Linkedlist[capacity];
		this.Size = 0;
	}

	private int Hash(K key) {
		int hashVal = key.hashCode();
		hashVal = Math.abs(hashVal);
		int bi = hashVal % this.bucketArray.length;
		return bi;
	}

	public V get(K key) throws Exception {
		int bi = this.Hash(key);
		Linkedlist<HTPair> bucket = this.bucketArray[bi];
		HTPair ptg = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int found = bucket.find(ptg);
			if (found == -1) {
				return null;
			} else {
				HTPair rv = bucket.getAt(found);
				return rv.Value;
			}
		}
	}

	public V remove(K key) throws Exception {
		int bi = this.Hash(key);
		Linkedlist<HTPair> bucket = this.bucketArray[bi];
		HTPair ptr = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int found = bucket.find(ptr);
			if (found == -1) {
				return null;
			} else {
				HTPair rv = bucket.getAt(found);
				bucket.removeAt(found);
				this.Size--;
				if (bucket.size() == 0) {
					bucket = null;
				}
				return rv.Value;
			}
		}
	}

	public void put(K key, V value) throws Exception {
		int bi = this.Hash(key);
		Linkedlist<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new Linkedlist<HTPair>();
			bucket.addFirst(pta);
			this.Size++;
		} else {
			int found = bucket.find(pta);
			if (found == -1) {
				bucket.addFirst(pta);
				this.Size++;

			} else {
				HTPair pair = bucket.getAt(found);
				pair.Value = value;
			}
		}
		this.bucketArray[bi]=bucket;
		double lambda = (this.Size * 1.0) / this.bucketArray.length;
		if (lambda > 2) {
			this.reHash();
		}
	}

	private void reHash() throws Exception {
		Linkedlist<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (Linkedlist<HTPair>[]) new Linkedlist[this.bucketArray.length * 2];
		this.Size = 0;
		for (Linkedlist<HTPair> ob : oba) {
			while (ob != null && !ob.isEmpty()) {
				HTPair tp = ob.removeFirst();
				this.put(tp.Key, tp.Value);
			}
		}
	}

	public void display() {
		for (Linkedlist<HTPair> bucket : this.bucketArray) {
			if (bucket != null) {
				bucket.display();
			} else {
				System.out.println("null");
				System.out.println("*************************");
			}
		}
		System.out.println("++++++++++++++++++++++");

	}
}
