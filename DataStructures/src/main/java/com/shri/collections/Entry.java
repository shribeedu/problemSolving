package com.shri.collections;

public class Entry<K,V> {

	 K key;
	 V value;
	 long hashCode;
	 Entry next;
	
	
	public Entry(K key,V value, Entry<K,V> entry) {
		this.key = key;
		this.value=value;
		this.next=entry;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
