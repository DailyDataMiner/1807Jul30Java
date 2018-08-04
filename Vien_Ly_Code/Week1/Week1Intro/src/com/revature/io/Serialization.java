package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	/*
	 * to serialize an object means to convert its states into
	 * a byte stream so that the stream can be reverted back
	 * into a copy of the object A Java object
	 * is serializable if its class or any of its superclasess implement either
	 * Serializable or its subinterface Externalizable
	 * 
	 * state of the object means instance variables
	 * transient - 
	 */
	
	public static void main(String[] args) {
		Student s = new Student("Gingami", "gin@mail.com", 100.00);
		//serializeObject(s);
		Student fromFile = (Student) deserializeObject();
		System.out.println(fromFile);
	}
	
	static void serializeObject(Object o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))) {
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static Object deserializeObject() {
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/files/serial.txt"))) {
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
