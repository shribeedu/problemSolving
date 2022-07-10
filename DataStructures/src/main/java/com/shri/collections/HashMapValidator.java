package com.shri.collections;

public class HashMapValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyHashMap<String,String> hashMap = new MyHashMap<String,String>();
		hashMap.put("one", "ValueOne");
		hashMap.put("two", "ValueTwo");
		
		System.out.println("Vlaue from Hash map is: "+hashMap.get("one"));
		
	}

}
