package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
	
	public static void main(String[] args) {
		Student s = new Student ("Gen", "gab12@duke.edu", 100.00);
		
//		Student fromFile = (Student) deserializedObject();
//		System.out.println(fromFile);
		
	}
	
	static void serializedObject( Object o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))){
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializedObject( Object o) {
		
		Object obj = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/files/serial.txt"))){
			obj = ois.readObject();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
