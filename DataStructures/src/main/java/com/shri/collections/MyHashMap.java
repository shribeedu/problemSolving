package com.shri.collections;

public class MyHashMap<K,V> {
	
	private Entry<K,V>[] hashTable;
	
	private static final int INITIAL_CAPACITY = 16;

	private int size =0;
	
	
	public MyHashMap() {
		hashTable = new Entry[INITIAL_CAPACITY];
	}
	
	public void put(K key,V value) {
		Entry<K,V> entry = new Entry(key,value,null);	
		int hashCode = getHash(key) % INITIAL_CAPACITY;
		Entry<K, V> existing = hashTable[hashCode];
		if( existing == null) {
			hashTable[hashCode] = entry;
			size++;
		}else {
			while(existing.next != null) {
				if(existing.key.equals(key)) {
					existing.value = value;
					return;
				}
				existing = existing.next;
			}
			if(existing.key.equals(key)) {
				existing.value=value;
			} else {
				existing.next = entry;
				size++;
			}
			
		}
		
		
	}
	
	public V get(K key) {
		int hashIndex = this.getHash(key) % INITIAL_CAPACITY;
		Entry<K,V> entry = this.hashTable[hashIndex];
		V value = null;
		if(entry.next == null){
			return entry.value;
		}else {
			while(entry.next!=null) {
				if(entry.key.equals(key)) {
					value = entry.value;
				}
				entry = entry.next;
			}
		}
		return value;
	}
	
	public int getHash(K key) {
		return key==null? 0:Math.abs(key.hashCode());
	}
	
}
