package com.ex.exercises;

public class ThreadProblems {
public static Object obj1 = new Object();
public static Object obj2 = new Object();

public static void main(String[] args) {
	Thread1 T1 = new Thread1();
	Thread2 T2 = new Thread2();
	T1.Start();
	T2.Start();
}
public static class Thread1 extends Thread {
	public void run() { synchronized (Lock1) {
		System.out.println("Thread 1 locked");
	}
}
public static class Thread2 extends Thread {
	
}
}
