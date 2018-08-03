package com.revature.io;
import com.revature.helpers.HelperFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample extends HelperFunctions {

	public static void main(String[] args) {
		
//		Student s = new Student("Omar", "omar@mail.com", 68);
//		serializeObject(s);
		
		Student fromFile = (Student) deserializeObject();
		print(fromFile);
		
	}
	
	static void serializeObject(Object o) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))) {
			
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
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/files/serial.txt"))) {
			
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
