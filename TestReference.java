package com.java.ReferenceTypes;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestReference {

	public static void main(String[] args) throws InterruptedException {
		//strongReference();
		weakReference();
		softReference();
	}

	private static void strongReference() {
		Employee emp = new Employee(1441, "KK");//Strong reference
		emp = null; // Eligible for GC
	}
	
	private static void weakReference() {
		Employee emp = new Employee(1441, "KK");
		WeakReference<Employee> weakReference = new WeakReference<Employee>(emp);
		System.out.println(weakReference.get());
		emp = null;
		System.gc();
		System.out.println(weakReference.get());
	}
	
	private static void softReference() {
		Employee emp = new Employee(1441, "KK");
		SoftReference<Employee> softReference = new SoftReference<Employee>(emp);
		System.out.println(softReference.get());
		emp = null;
		System.gc();
		System.out.println(softReference.get());
	}
	
	private static void phantomReference() throws InterruptedException {
		Employee emp = new Employee(1441, "KK");
		ReferenceQueue<Employee> referenceQueue = new ReferenceQueue<Employee>();
		PhantomReference<Employee> phantomReference = new PhantomReference<Employee>(emp, referenceQueue);
		System.out.println("Phantom reference deleted:");
		System.out.println(phantomReference.get());
		
	}
}