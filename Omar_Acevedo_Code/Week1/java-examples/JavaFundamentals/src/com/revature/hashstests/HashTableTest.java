package com.revature.hashstests;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import com.revature.helpers.HelperFunctions;

public class HashTableTest extends HelperFunctions {

	public static void myTest() {
		print("hey");
	}
	
	public static void main(String[] args) {

		Enumeration names;
		String key;
		
		Hashtable<String, String> myHT = new Hashtable<String, String>();
		myHT.put("k1", "v1");
		myHT.put("k2", "v2");
		myHT.put("k3", "v3");
		myHT.put("k4", "v4");
		
//		ArrayList al = new ArrayList();
//		Iterator i = al.iterator();
		
		names = myHT.keys();
		
		while (names.hasMoreElements()) {
			key = (String) names.nextElement();
			print("Key -> " + key + ", Value -> " + myHT.get(key));
		}
		
	}

}
